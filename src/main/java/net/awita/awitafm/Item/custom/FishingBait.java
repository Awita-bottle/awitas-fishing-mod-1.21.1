package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import com.mojang.serialization.Codec;

public class FishingBait extends BaseModItem<FishingBait.TYPE>
{
    public enum TYPE
    {
        DEFAULT,
        LEECH,
        GRUB
    }

    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.bait_default");
            default:
                return super.getName(stack);
            //case SEA_MINE:
                //return Text.translatable("item.awitafm.bobber_seamine");
            //case LILY_PAD:
                //return Text.translatable("item.awitafm.bobber_lilypad");
            //case RUBBER_DUCK:
                //return Text.translatable("item.awitafm.bobber_rubberduck");
        }
    }

    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "baits/default_bait.png");
            default -> Identifier.of("", "");
            //case SEA_MINE -> Identifier.of("awitafm", "textures/item/bobber_sea_mine.png");
            //case LILY_PAD -> Identifier.of("awitafm", "textures/item/bobber_lily_pad.png");
            //case RUBBER_DUCK -> Identifier.of("awitafm", "textures/item/bobber_rubber_duck.png");
        };
    }

    public static final Codec<TYPE> CODEC =
            Codec.STRING.xmap(TYPE::valueOf, TYPE::name);

    public FishingBait(Item.Settings settings, TYPE type)
    {
        super(settings, type);
    }
    
    public FishingBait getBait() { return this; }
}
