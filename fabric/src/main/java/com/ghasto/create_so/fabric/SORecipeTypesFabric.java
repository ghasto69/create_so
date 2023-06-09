package com.ghasto.create_so.fabric;
import java.util.Optional;

import java.util.function.Supplier;

import com.ghasto.create_so.CreateSO;


import org.jetbrains.annotations.Nullable;


import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeFactory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.utility.Lang;

import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.ghasto.create_so.fabric.sanding_wheel.SandingRecipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
@SuppressWarnings("all")

public enum SORecipeTypesFabric implements IRecipeTypeInfo {

    Sanding(SandingRecipe::new);

    private final ResourceLocation id;
    private final RecipeSerializer<?> serializerObject;
    @Nullable
    private final RecipeType<?> typeObject;
    private final Supplier<RecipeType<?>> type;

    SORecipeTypesFabric(Supplier<RecipeSerializer<?>> serializerSupplier, Supplier<RecipeType<?>> typeSupplier, boolean registerType) {
        String name = Lang.asId(name());
        id = CreateSO.id(name);
        serializerObject = Registry.register(Registry.RECIPE_SERIALIZER, id, serializerSupplier.get());
        if (registerType) {
            typeObject = typeSupplier.get();
            Registry.register(Registry.RECIPE_TYPE, id, typeObject);
            type = typeSupplier;
        } else {
            typeObject = null;
            type = typeSupplier;
        }
    }

    SORecipeTypesFabric(Supplier<RecipeSerializer<?>> serializerSupplier) {
        String name = Lang.asId(name());
        id = CreateSO.id(name);
        serializerObject = Registry.register(Registry.RECIPE_SERIALIZER, id, serializerSupplier.get());
        typeObject = simpleType(id);
        Registry.register(Registry.RECIPE_TYPE, id, typeObject);
        type = () -> typeObject;
    }

    SORecipeTypesFabric(ProcessingRecipeFactory<?> processingFactory) {
        this(() -> new ProcessingRecipeSerializer<>(processingFactory));
    }

    public static <T extends Recipe<?>> RecipeType<T> simpleType(ResourceLocation id) {
        String stringId = id.toString();
        return new RecipeType<T>() {
            @Override
            public String toString() {
                return stringId;
            }
        };
    }

    public static void register() {
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeType<?>> T getType() {
        return (T) type.get();
    }

    public <C extends Container, T extends Recipe<C>> Optional<T> find(C inv, Level world) {
        return world.getRecipeManager()
                .getRecipeFor(getType(), inv, world);
    }


}
