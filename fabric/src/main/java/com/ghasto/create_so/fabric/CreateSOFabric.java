package com.ghasto.create_so.fabric;

import com.ghasto.create_so.CreateSO;

import net.fabricmc.api.ModInitializer;

public class CreateSOFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateSO.init();
        SOBlocksFabric.register();
        SOTileEntitiesFabric.register();
        SORecipeTypesFabric.register();
        CreateSO.REGISTRATE.register();
    }
}
