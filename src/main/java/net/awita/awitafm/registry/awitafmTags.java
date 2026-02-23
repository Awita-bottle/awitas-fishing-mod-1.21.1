package net.awita.awitafm.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import static net.awita.awitafm.AwitasFishingMod.MOD_ID;

public class awitafmTags {
    public static final TagKey<Item> FISHING_RODS = itemTagKey("c", "tools/fishing_rod");

    public static TagKey<Item> itemTagKey(String id) {
        return itemTagKey(MOD_ID, id);
    }
}
