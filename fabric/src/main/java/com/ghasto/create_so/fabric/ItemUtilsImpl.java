package com.ghasto.create_so.fabric;

import io.github.fabricators_of_create.porting_lib.util.ItemGroupUtil;
@SuppressWarnings("unused")
public class ItemUtilsImpl {
    public static int nextTabId() {
        return ItemGroupUtil.expandArrayAndGetId();
    }
}
