package net.awita.awitafm.Item;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.Item.custom.StickFishingRodItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item WORM_BAIT = registerItem("worm_bait", new Item(new Item.Settings()));
    public static final Item AWITAROD = registerItem("awita_rod", new StickFishingRodItem(new Item.Settings().maxDamage(64)));

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
