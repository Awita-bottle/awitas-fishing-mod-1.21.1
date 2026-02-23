package net.awita.awitafm.block;

import net.awita.awitafm.AwitasFishingMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FISH_BASKET_BLOCK = registerBlock("fish_basket_block",
            new Block(AbstractBlock.Settings.create().strength(0f).sounds(BlockSoundGroup.WET_GRASS)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AwitasFishingMod.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(AwitasFishingMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        AwitasFishingMod.LOGGER.info("Registering Mod Blocks for "+ AwitasFishingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->{
            entries.add(ModBlocks.FISH_BASKET_BLOCK);
        });
    }
}
