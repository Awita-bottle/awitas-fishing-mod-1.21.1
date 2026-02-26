package net.awita.awitafm;

import net.awita.awitafm.Item.ModItemGroups;
import net.awita.awitafm.Item.ModItems;
import net.awita.awitafm.block.ModBlocks;
import net.awita.awitafm.component.ModComponents;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AwitasFishingMod implements ModInitializer {
	public static final String MOD_ID = "awitafm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModComponents.initialize();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}