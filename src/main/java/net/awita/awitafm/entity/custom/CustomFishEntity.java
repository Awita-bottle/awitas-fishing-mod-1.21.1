package net.awita.awitafm.entity.custom;

import net.awita.awitafm.FishingState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class CustomFishEntity extends PathAwareEntity {

    protected CustomFishEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
