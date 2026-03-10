package net.awita.awitafm.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static net.awita.awitafm.AwitasFishingMod.MOD_ID;

public class awitafmTags
{
    public static final TagKey<Item> FISHING_RODS =
        TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "tools/fishing_rod"));
}
