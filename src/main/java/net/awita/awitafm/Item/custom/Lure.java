package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;

enum LURE_TYPE{
    DULL,
    SPARKLY
}

public class Lure extends Item{
    public Lure(Item.Settings settings) {
        super(settings);
    }
    public Lure getLure(){
        return this;
    }
}
