package net.awita.awitafm.Item.custom;

import net.awita.awitafm.entity.custom.FishingHookEntity;
import net.awita.awitafm.registry.ModEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FishingRod extends BaseModItem<FishingRod.TYPE>
{

    public enum TYPE
    {
        DEFAULT,
        DIAMOND,
        NETHERITE
    }

    public FishingRod(Settings settings, TYPE type)
    {
        super(settings, type);
    }

    @Override
    public Text getName(ItemStack stack)
    {
        switch (getType()) {
            case DEFAULT:
                return Text.translatable("item.awitafm.rod_default");
            default:
                return super.getName(stack);
        }
    }
    
    @Override
    protected Identifier setTexture()
    {
        if (getType() == null) return null;
        return switch (getType()) {
            case DEFAULT -> Identifier.of("awitafm", "reels/default_rod.png");
            default -> Identifier.of("", "");
        };
    }
    
    private int tensionCap = 100;
    public int getTensionCap() { return tensionCap; }
    public void setTensionCap(int v) { tensionCap=v; }

    private FishingReel reel;
    public void setReel(FishingReel r) { reel=r; }

    private FishingLine line;
    public void setLine(FishingLine l) { line=l; }

    private FishingBobber bobber;
    public void setBobber(FishingBobber b){ bobber=b; }

    private FishingLure lure;
    public void setLure(FishingLure l) { lure=l; }

    private FishingHook hook;
    public void setHook(FishingHook h) { hook=h; }

    private FishingBait bait;
    public void setBait(FishingBait b) { bait=b; }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            FishingHookEntity hook = new FishingHookEntity(ModEntities.CUSTOM_FISHING_HOOK, world);

            hook.setOwner(player);

            // Spawn the hook at the player's eye level
            hook.updatePosition(player.getX(), player.getEyeY() - 0.1, player.getZ());

            // Set velocity like vanilla
            float velocity = 1.5f;
            float yaw = player.getYaw();
            float pitch = player.getPitch();
            double dx = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
            double dy = -Math.sin(Math.toRadians(pitch));
            double dz = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
            hook.setVelocity(dx * velocity, dy * velocity, dz * velocity);

            while (hook.getOwner() != player) {hook.setOwner(player); try { wait();} catch (InterruptedException e) {}};
            world.spawnEntity(hook);
        }

        player.swingHand(hand);
        return TypedActionResult.success(stack, world.isClient());
    }
}

