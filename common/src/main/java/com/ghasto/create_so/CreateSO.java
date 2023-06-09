package com.ghasto.create_so;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CreateSO {
    public static final String MOD_ID = "create_so";
    public static final String NAME = "Create: Sandpaper Overhaul";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreativeModeTab itemGroup = new CreativeModeTab(ItemUtils.nextTabId(), MOD_ID) {
        @Override
        @Nonnull
        public ItemStack makeIcon() { return SOItems.OBSIDIAN_SANDPAPER.asStack(); }
    };
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateSO.MOD_ID).creativeModeTab(() -> itemGroup, "Create: Sandpaper Overhaul");

    public static void init() {
        SOItems.register();
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName());
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
