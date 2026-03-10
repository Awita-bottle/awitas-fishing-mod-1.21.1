package net.awita.awitafm;

import net.awita.awitafm.client.ModKeybindings;
import net.awita.awitafm.client.renderer.FishingHookRenderer;
import net.awita.awitafm.registry.ModEntities;
import net.awita.awitafm.registry.ModScreenHandlers;
import net.awita.awitafm.screen.RodScreen;
import net.awita.awitafm.screen.RodScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.ItemStack;
import net.awita.awitafm.Item.custom.FishingRod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AwitasFishingModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {

        ModKeybindings.register();

        // Register Screen mapping
        HandledScreens.register(ModScreenHandlers.ROD_SCREEN, RodScreen::new);

        // Client tick keybinding
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (ModKeybindings.OPEN_ROD_GUI.wasPressed() && client.player != null) {
                ItemStack mainHand = client.player.getMainHandStack();

                if (!mainHand.isEmpty() && mainHand.getItem() instanceof FishingRod) {
                    // Open GUI
                    client.setScreen(new RodScreen(
                            new RodScreenHandler(0, client.player.getInventory(), client.player),
                            client.player.getInventory(),
                            Text.literal("Rod GUI")
                    ));
                } else {
                    client.player.sendMessage(Text.literal("You must hold a fishing rod to open this GUI"), false);
                }
            }
        });
        
        EntityRendererRegistry.register(ModEntities.CUSTOM_FISHING_HOOK, FishingHookRenderer::new);

    }
}