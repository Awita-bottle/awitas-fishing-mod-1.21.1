package net.awita.awitafm;

import net.awita.awitafm.Item.ModItemGroups;
import net.awita.awitafm.component.ModComponents;
import net.awita.awitafm.registry.ModBlocks;
import net.awita.awitafm.registry.ModEntities;
import net.awita.awitafm.registry.ModItems;
import net.awita.awitafm.screen.RodScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import static net.minecraft.server.command.CommandManager.literal;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AwitasFishingMod implements ModInitializer
{
	public static final String MOD_ID = "awitafm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItemGroups.registerItemGroups();
		ModComponents.initialize();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(literal("openrodgui")
				.executes(ctx -> {
					ServerPlayerEntity player = ctx.getSource().getPlayer();
					player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
							(syncId, inv, p) -> new RodScreenHandler(syncId, inv, player),
							Text.literal("Fishing Rod Configuration")
					));
					return 1;
				})
			);
		});

	}
}