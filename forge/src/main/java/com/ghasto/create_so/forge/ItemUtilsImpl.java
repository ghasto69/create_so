package com.ghasto.create_so.forge;

import net.minecraft.world.item.CreativeModeTab;
@SuppressWarnings("unused")
public class ItemUtilsImpl {
    public static int nextTabId() {
        return CreativeModeTab.getGroupCountSafe();
    }
}
