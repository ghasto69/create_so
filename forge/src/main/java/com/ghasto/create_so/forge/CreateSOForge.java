package com.ghasto.create_so.forge;

import com.ghasto.create_so.CreateSO;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateSO.MOD_ID)
public class CreateSOForge {
    public CreateSOForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateSO.REGISTRATE.registerEventListeners(eventBus);
        SOBlocksForge.register();
        SOTileEntitiesForge.register();
        SORecipeTypesForge.register(eventBus);
        CreateSO.init();
    }
}
