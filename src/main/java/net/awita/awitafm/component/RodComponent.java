// RodComponent.java
package net.awita.awitafm.component;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import org.ladysnake.cca.api.v3.component.Component;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;

public class RodComponent implements Component
{

    // Component Key for ItemStack
    public static final ComponentKey<RodComponent> KEY =
        ComponentRegistryV3.INSTANCE.getOrCreate(Identifier.of("awitafm", "rod_component"), RodComponent.class);

    private ItemStack reel;
    private ItemStack line;
    private ItemStack bobber;
    private ItemStack lure;
    private ItemStack hook;

    private int durability;
    private int quality;

    public RodComponent()
    {
        this.durability = 100;
        this.quality = 0;
    }


    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        if (tag.contains("Reel"))
            this.reel = ItemStack.fromNbtOrEmpty(lookup, tag.getCompound("Reel"));
        if (tag.contains("Line"))
            this.line = ItemStack.fromNbtOrEmpty(lookup, tag.getCompound("Line"));
        if (tag.contains("Bobber"))
            this.bobber = ItemStack.fromNbtOrEmpty(lookup, tag.getCompound("Bobber"));
        if (tag.contains("Lure"))
            this.lure = ItemStack.fromNbtOrEmpty(lookup, tag.getCompound("Lure"));
        if (tag.contains("Hook"))
            this.hook = ItemStack.fromNbtOrEmpty(lookup, tag.getCompound("Hook"));

        this.durability = tag.getInt("Durability");
        this.quality = tag.getInt("Quality");
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        if (reel != null && !reel.isEmpty())
            tag.put("Reel", reel.encodeAllowEmpty(lookup));
        if (line != null && !line.isEmpty())
            tag.put("Line", line.encodeAllowEmpty(lookup));
        if (bobber != null && !bobber.isEmpty())
            tag.put("Bobber", bobber.encodeAllowEmpty(lookup));
        if (lure != null && !lure.isEmpty())
            tag.put("Lure", lure.encodeAllowEmpty(lookup));
        if (hook != null && !hook.isEmpty())
            tag.put("Hook", hook.encodeAllowEmpty(lookup));

        tag.putInt("Durability", durability);
        tag.putInt("Quality", quality);
    }

    // Functional check
    public boolean canCast()
    {
        return this.line != null && this.hook != null && this.durability > 0;
    }

    // Attachments
    public boolean attachReel(ItemStack reel) { if (reel == null) return false; this.reel = reel; return true; }
    public boolean attachLine(ItemStack line) { if (line == null) return false; this.line = line; return true; }
    public boolean attachBobber(ItemStack bobber) { if (bobber == null || line == null) return false; this.bobber = bobber; return true; }
    public boolean attachLure(ItemStack lure) { if (lure == null) return false; this.lure = lure; return true; }
    public boolean attachHook(ItemStack hook) { if (hook == null || line == null) return false; this.hook = hook; return true; }

    // Detachments
    public ItemStack detachReel() { ItemStack tmp = reel; reel = null; return tmp; }
    public ItemStack detachLine() { ItemStack tmp = line; line = null; return tmp; }
    public ItemStack detachBobber() { ItemStack tmp = bobber; bobber = null; return tmp; }
    public ItemStack detachLure() { ItemStack tmp = lure; lure = null; return tmp; }
    public ItemStack detachHook() { ItemStack tmp = hook; hook = null; return tmp; }

    // Tooltip
    public String getTooltipInfo()
    {
        StringBuilder sb = new StringBuilder();
        if (reel != null) sb.append("Reel: ").append(reel.getName().getString()).append("\n");
        if (line != null) sb.append("Line: ").append(line.getName().getString()).append("\n");
        if (bobber != null) sb.append("Bobber: ").append(bobber.getName().getString()).append("\n");
        if (lure != null) sb.append("Lure: ").append(lure.getName().getString()).append("\n");
        if (hook != null) sb.append("Hook: ").append(hook.getName().getString()).append("\n");
        sb.append("Durability: ").append(durability);
        return sb.toString();
    }

    // Getters
    public ItemStack getLine() { return line; }
    public ItemStack getHook() { return hook; }
    public ItemStack getBobber() { return bobber; }
    public ItemStack getReel() { return reel; }
    public ItemStack getLure() { return lure; }
}