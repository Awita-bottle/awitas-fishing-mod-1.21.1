package net.awita.awitafm.Item.custom;

import net.awita.awitafm.Item.custom.FishingBait.TYPE;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FishingLegendaryItem extends BaseModItem<TYPE>
{
    public FishingLegendaryItem(Item.Settings settings)
    {
        super(settings, TYPE.DEFAULT);
    }
    
    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.legendary_rod");
            default:
                return super.getName(stack);
        }
    }

    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "loot/legendary_rod.png");
            default -> Identifier.of("", "");
        };
    }

}
