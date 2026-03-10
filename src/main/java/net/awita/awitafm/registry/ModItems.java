package net.awita.awitafm.registry;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.Item.custom.FishingRod;
import net.awita.awitafm.Item.custom.FishingBait;
import net.awita.awitafm.Item.custom.FishingBobber;
import net.awita.awitafm.Item.custom.FishingHook;
import net.awita.awitafm.Item.custom.FishingLegendaryItem;
import net.awita.awitafm.Item.custom.FishingLine;
import net.awita.awitafm.Item.custom.FishingLure;
import net.awita.awitafm.Item.custom.FishingReel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems
{
    public static final FishingBait WORM_BAIT = registerItem("default_bait", new FishingBait(new Item.Settings(), FishingBait.TYPE.DEFAULT));
    public static final FishingReel IRON_REEL = registerItem("default_reel", new FishingReel(new Item.Settings(), FishingReel.TYPE.DEFAULT));
    public static final FishingLine STRING_LINE = registerItem("default_line", new FishingLine(new Item.Settings(), FishingLine.TYPE.DEFAULT));
    public static final FishingBobber DEFAULT_BOBBER = registerItem("default_bobber", new FishingBobber(new Item.Settings(), FishingBobber.TYPE.DEFAULT));
    public static final FishingLure FLY_LURE = registerItem("default_lure", new FishingLure(new Item.Settings(), FishingLure.TYPE.DEFAULT));
    public static final FishingHook IRON_HOOK = registerItem("default_hook", new FishingHook(new Item.Settings(), FishingHook.TYPE.DEFAULT));
    public static final FishingRod OAK_ROD = registerItem("default_rod", new FishingRod(new Item.Settings(), FishingRod.TYPE.DEFAULT));
    public static final FishingLegendaryItem LEGENDARY = registerItem("legendary_rod", new FishingLegendaryItem(new Item.Settings()));

    private static <T extends Item> T registerItem(String name, T item)
    {
        return Registry.register(
            Registries.ITEM,
            Identifier.of(AwitasFishingMod.MOD_ID, name),
            item
        );
    }

    public static void registerModItems()
    {
        AwitasFishingMod.LOGGER.info("Registering Mod items for " + AwitasFishingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(WORM_BAIT);
        });
    }
}
