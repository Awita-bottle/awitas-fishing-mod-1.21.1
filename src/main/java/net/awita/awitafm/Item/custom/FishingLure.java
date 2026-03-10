package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FishingLure extends BaseModItem<FishingLure.TYPE>
{
    public enum TYPE
    {
        DEFAULT,
        SPARKLY
    }

    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.lure_default");
            default:
                return super.getName(stack);
        }
    }

    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "lures/default_lure.png");
            default -> Identifier.of("", "");
        };
    }
    
    public FishingLure(Item.Settings settings, TYPE type)
    {
        super(settings, type);
    }

    public FishingLure getLure() { return this; }
}
