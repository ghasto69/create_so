package com.ghasto.create_so;

import com.simibubi.create.content.equipment.sandPaper.SandPaperItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.ghasto.create_so.CreateSO.REGISTRATE;

@SuppressWarnings("all")
public class SOItems {
    public static final ItemEntry<SandPaperItem> DIAMOND_SANDPAPER = REGISTRATE.item("crushed_diamond_sandpaper", SandPaperItem::new)
            .properties(p -> p.stacksTo(1).defaultDurability(256))
            .register();
    public static final ItemEntry<SandPaperItem> IRON_SANDPAPER = REGISTRATE.item("crushed_iron_sandpaper", SandPaperItem::new)
            .properties(p -> p.stacksTo(1).defaultDurability(32))
            .register();
    public static final ItemEntry<SandPaperItem> OBSIDIAN_SANDPAPER = REGISTRATE.item("crushed_obsidian_sandpaper", SandPaperItem::new)
            .properties(p -> p.stacksTo(1).defaultDurability(512))
            .register();


    public static final ItemEntry<Item> CRUSHED_IRON = REGISTRATE.item("crushed_iron", Item::new).register();
    public static final ItemEntry<Item> CRUSHED_DIAMOND = REGISTRATE.item("crushed_diamonds", Item::new).register();
    public static final ItemEntry<Item> CRUMBLED_COOKIES = REGISTRATE.item("crumbled_cookies", Item::new).properties(p -> p.tab(null)).register();
    public static void register() {}
}
