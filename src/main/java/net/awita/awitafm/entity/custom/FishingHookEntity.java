package net.awita.awitafm.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FishingHookEntity extends Entity {

    private PlayerEntity owner;
    private int ticksInAir;

    // Extra rod data
    private int tensionCap = 100;
    private int reelId = 0;
    private int lineId = 0;

    public FishingHookEntity(EntityType<? extends FishingHookEntity> type, World world, PlayerEntity owner) {
        super(type, world);
        this.owner = owner;

        // Spawn at the player's eye level
        Vec3d pos = owner.getPos().add(0, owner.getEyeHeight() - 0.1, 0);
        this.setPosition(pos.x, pos.y, pos.z);
    }

    public PlayerEntity getOwner() {
        return owner;
    }

    public void setOwner(PlayerEntity owner) {
        this.owner = owner;
    }

    @Override
    public void tick() {
        super.tick();

        if (owner == null || !owner.isAlive()) {
            this.discard(); // safely remove if owner dies
            return;
        }

        ticksInAir++;

        // Simple bobber physics example
        Vec3d velocity = this.getVelocity();
        this.setPosition(this.getX() + velocity.x, this.getY() + velocity.y, this.getZ() + velocity.z);

        // Here you can implement collision with water, fish hook logic, etc.
    }

    @Override
    protected void initDataTracker() {
        // No vanilla tracked data needed
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        tensionCap = nbt.getInt("TensionCap");
        reelId = nbt.getInt("ReelId");
        lineId = nbt.getInt("LineId");
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt("TensionCap", tensionCap);
        nbt.putInt("ReelId", reelId);
        nbt.putInt("LineId", lineId);
    }

    // Rod accessor methods
    public int getTensionCap() { return tensionCap; }
    public void setTensionCap(int v) { tensionCap = v; }

    public int getReelId() { return reelId; }
    public void setReelId(int r) { reelId = r; }

    public int getLineId() { return lineId; }
    public void setLineId(int l) { lineId = l; }
}