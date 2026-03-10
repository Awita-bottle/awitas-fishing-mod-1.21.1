package net.awita.awitafm.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RodScreen extends HandledScreen<RodScreenHandler>
{

    private static final Identifier TEXTURE =
        Identifier.of("minecraft", "textures/gui/container/generic_54.png");

    private PlayerInventory playerInventory;
        
    public RodScreen(RodScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        playerInventory = inventory;

        // Adjust width and height to match the texture (9x1 chest = 9 slots)
        this.backgroundWidth = 176; // standard width
        this.backgroundHeight = 86; // 1 row container + player inventory + padding
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        // Draw the GUI background
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Draw the rod in the center
        ItemStack rodStack = this.handler.getHeldRod();
        if (!rodStack.isEmpty()) {
            int rodX = x + backgroundWidth / 2 - 8;  // center X, assuming 16px item width
            int rodY = y + 50;                        // center Y
            context.drawItem(rodStack, rodX, rodY);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(textRenderer, Text.literal("Reel"), 8, 8, 0x404040, false);
        context.drawText(textRenderer, Text.literal("Line"), 26, 8, 0x404040, false);
        context.drawText(textRenderer, Text.literal("Bobber"), 44, 8, 0x404040, false);
        context.drawText(textRenderer, Text.literal("Lure"), 62, 8, 0x404040, false);
        context.drawText(textRenderer, Text.literal("Hook"), 80, 8, 0x404040, false);

        // Player inventory label
        context.drawText(textRenderer, this.playerInventory.getDisplayName(), 8, backgroundHeight - 94, 0x404040, false);
    }
}