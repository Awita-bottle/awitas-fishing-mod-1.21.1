package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;

enum REEL_TYPE{
    IRON,
    DIAMOND
}

public class Reel extends Item{
    public Reel(Item.Settings settings) {
        super(settings);
    }
    public Reel getReel(){
        return this;
    }
}
