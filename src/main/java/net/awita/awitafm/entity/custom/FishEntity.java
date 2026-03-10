package net.awita.awitafm.entity.custom;

import net.awita.awitafm.FishingState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class FishEntity extends PathAwareEntity {

    protected FishEntity(EntityType<? extends PathAwareEntity> entityType, World world)
    {
        super(entityType, world);
    }
}
