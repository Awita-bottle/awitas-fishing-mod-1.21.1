package net.awita.awitafm.Item;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.Item.custom.CustomFishingRodBaseItem;

import net.awita.awitafm.Item.custom.ROD_TYPE;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item WORM_BAIT = registerItem("worm_bait", new Item(new Item.Settings()));
    public static final Item IRON_REEL = registerItem("iron_reel", new Item(new Item.Settings()));
    public static final Item STRING_LINE = registerItem("string_line", new Item(new Item.Settings()));
    public static final Item DEFAULT_BOBBER = registerItem("default_bobber", new Item(new Item.Settings()));
    public static final Item FLY_LURE = registerItem("fly_lure", new Item(new Item.Settings()));
    public static final Item IRON_ROD = registerItem("iron_rod", new CustomFishingRodBaseItem(new Item.Settings(), ROD_TYPE.IRON));

    private static Item registerItem(String name, Item item){
      return Registry.register(Registries.ITEM, Identifier.of(AwitasFishingMod.MOD_ID, name),item);
    };


    public static void registerModItems(){
        AwitasFishingMod.LOGGER.info("Registering Mod items for " + AwitasFishingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(WORM_BAIT);
        });
    }
}
