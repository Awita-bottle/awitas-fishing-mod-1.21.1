package net.awita.awitafm.entity.custom;

import net.awita.awitafm.FishingState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class CustomFishEntity extends PathAwareEntity {

    private FishBehavior behavior;
    private FishingState state = FishingState.SCOUTING;

    public CustomFishEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void tick() {
        super.tick();

        switch (state) {
            case SCOUTING -> circleHook();
            case HOOKED -> pullHook();
            case FIGHTING -> fightPlayer();
        }
    }

    private void fightPlayer() {
    }

    private void pullHook() {
    }

    private void circleHook() {
    }
}
