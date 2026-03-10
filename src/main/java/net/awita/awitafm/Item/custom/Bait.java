package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import com.mojang.serialization.Codec;

public class Bait extends Item
{
    public enum BAIT_TYPE
    {
        WORM,
        LEECH,
        GRUB
    }

    public static final Codec<BAIT_TYPE> CODEC =
            Codec.STRING.xmap(BAIT_TYPE::valueOf, BAIT_TYPE::name);

    public Bait(Item.Settings settings) {
        super(settings);
    }
    public Bait getBait(){
        return this;
    }
}
