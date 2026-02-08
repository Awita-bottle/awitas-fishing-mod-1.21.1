package net.awita.awitafm.entity.custom;

import net.awita.awitafm.FishingState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CustomFishingHookEntity extends Entity {

    private PlayerEntity owner;
    private FishEntity hookedFish;
    private FishingState state = FishingState.WAITING;
    private float tension = 0.0f;

    public CustomFishingHookEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    public CustomFishingHookEntity(PlayerEntity owner, World world) {
        this(ModEntities.CUSTOM_FISHING_HOOK, world);
        this.owner = owner;
        this.setPosition(owner.getX(), owner.getEyeY(), owner.getZ());
    }

    private void trySpawnFish() {
        if (random.nextFloat() < 0.01f) {
            FishEntity fish = ModEntities.spawnFish(world, getPos());
            this.hookedFish = fish;
            this.state = FishingState.SCOUTING;
        }
    }

    private void handleScouting() {
        if (hookedFish.isInterested()) {
            state = FishingState.HOOKED;
            hookedFish.setHooked(this);
        } else if (hookedFish.isLeaving()) {
            cleanup();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (world.isClient) return;

        switch (state) {
            case WAITING -> trySpawnFish();
            case SCOUTING -> handleScouting();
            case HOOKED, FIGHTING -> handleFight();
        }
    }
}
