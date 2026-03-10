package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FishingHook extends BaseModItem<FishingHook.TYPE>
{

    public enum TYPE
    {
        DEFAULT
    }

    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.hook_default");
            default:
                return super.getName(stack);
        }
    }

    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "hooks/default_hook.png");
            default -> Identifier.of("", "");
        };
    }

    public FishingHook(Item.Settings settings, TYPE type)
    {
        super(settings, type);
    }

    public FishingHook getHook() { return this; }
}
