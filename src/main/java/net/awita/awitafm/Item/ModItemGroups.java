package net.awita.awitafm.Item;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup AWITAS_FISHING_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(
                    AwitasFishingMod.MOD_ID,
                    "awitas_fishing_overhaul"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WORM_BAIT))
                    .displayName(Text.translatable("itemgroup.awitafm.awitas_fishing_overhaul"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WORM_BAIT);
                        entries.add(ModBlocks.FISH_BASKET_BLOCK);
                        entries.add(ModItems.IRON_ROD);
                        entries.add(ModItems.DEFAULT_BOBBER);
                        entries.add(ModItems.STRING_LINE);
                        entries.add(ModItems.FLY_LURE);
                        entries.add(ModItems.IRON_REEL);


                    }).build());

    public static void registerItemGroups(){
        AwitasFishingMod.LOGGER.info("Registering Item Groups for " + AwitasFishingMod.MOD_ID);
    }
}
