package net.awita.awitafm.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Base class for all modded items in AwitaFM.
 * Provides a default getTexture() method.
 */
public abstract class BaseModItem<TYPE extends Enum<TYPE>> extends Item
{
    public BaseModItem(Settings settings, TYPE type) {
        super(settings);
        this.type = type;
        this.texture = setTexture();
    }

    private final TYPE type;
    
    public TYPE getType() { return this.type; }

    @Override
    public Text getName(ItemStack stack) {
        // Default: use the enum name in lowercase
        String typeName = type.name().toLowerCase(); 
        return Text.translatable("item.awitafm." + typeName);
    }

    private final Identifier texture;
    
    protected Identifier setTexture() { return null; }
    public Identifier getTexture() { return this.texture; }

}