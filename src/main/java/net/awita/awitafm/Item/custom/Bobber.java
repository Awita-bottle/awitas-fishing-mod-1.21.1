package net.awita.awitafm.Item.custom;


import net.minecraft.item.Item;

enum BOBBER_TYPE {
    NORMAL,
    SEA_MINE,
    LILY_PAD,
    RUBBER_DUCK
    };


public class Bobber extends Item {
    public Bobber(Item.Settings settings) {
        super(settings);
    }
    public Bobber getBobber(){
        return this;
    }

}
