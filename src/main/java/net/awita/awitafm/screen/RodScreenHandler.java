package net.awita.awitafm.screen;

import net.awita.awitafm.Item.custom.FishingRod;
import net.awita.awitafm.registry.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class RodScreenHandler extends ScreenHandler {

    private final ItemStack heldRod;
    private final SimpleInventory inventory;

    public RodScreenHandler(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModScreenHandlers.ROD_SCREEN, syncId);

        // Store the rod if the player is holding one
        ItemStack mainHand = player.getMainHandStack();
        if (mainHand.getItem() instanceof FishingRod) {
            heldRod = mainHand.copy();
        } else {
            heldRod = ItemStack.EMPTY;
        }

        // 5 modular slots
        this.inventory = new SimpleInventory(5);
        this.addSlot(new Slot(inventory, 0, 8, 18));   // Reel
        this.addSlot(new Slot(inventory, 1, 26, 18));  // Line
        this.addSlot(new Slot(inventory, 2, 44, 18));  // Bobber
        this.addSlot(new Slot(inventory, 3, 62, 18));  // Lure
        this.addSlot(new Slot(inventory, 4, 80, 18));  // Hook

        // Player inventory
        for (int m = 0; m < 3; ++m) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 51 + m * 18));
            }
        }

        // Hotbar
        for (int m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 109));
        }
    }
    
    public RodScreenHandler(int syncId, PlayerInventory playerInventory)
    {
        this(syncId, playerInventory, playerInventory.player);
    }
    
    public ItemStack getHeldRod() {
        return heldRod;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (index < 5) { // modular slots
                if (!this.insertItem(originalStack, 5, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else { // player inventory
                if (!this.insertItem(originalStack, 0, 5, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

}