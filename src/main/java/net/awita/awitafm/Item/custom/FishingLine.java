package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;

enum FISHINGLINE_TYPE {
    STRING,
    CHAIN,
    DIAMOND
};

public class FishingLine extends Item {
    public FishingLine(Item.Settings settings) {
        super(settings);
    }
    public FishingLine getLine(){
        return this;
    }
}
