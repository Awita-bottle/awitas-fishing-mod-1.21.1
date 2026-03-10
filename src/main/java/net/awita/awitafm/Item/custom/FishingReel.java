package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FishingReel extends BaseModItem<FishingReel.TYPE>
{

    public enum TYPE
    {
        DEFAULT,
        DIAMOND
    }

    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.reel_default");
            default:
                return super.getName(stack);
        }
    }
    
    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "reels/default_reel.png");
            default -> Identifier.of("", "");
        };
    }

    public FishingReel(Item.Settings settings, TYPE type)
    {
        super(settings, type);
    }

    public FishingReel getReel() { return this; }
}
