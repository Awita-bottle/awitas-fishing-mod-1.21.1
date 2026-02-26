package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;

enum BAIT_TYPE{
    WORM,
    LEECH,
    GRUB};

public class Bait extends Item {
    public Bait(Item.Settings settings) {
        super(settings);
    }
    public Bait getBait(){
        return this;
    }
}
