package net.awita.awitafm.entity.custom;

import net.awita.awitafm.FishingState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class CustomFishingHookEntity extends FishingBobberEntity {

    public CustomFishingHookEntity(EntityType<?> type, World world) {
        super(type, world);
    }
    private static final TrackedData<Integer> HOOK_ENTITY_ID = DataTracker.registerData(FishingBobberEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> CAUGHT_FISH = DataTracker.registerData(FishingBobberEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(HOOK_ENTITY_ID, 0);
        builder.add(CAUGHT_FISH, false);
    }
    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }
}
