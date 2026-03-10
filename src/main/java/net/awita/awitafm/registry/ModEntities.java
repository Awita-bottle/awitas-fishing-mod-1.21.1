package net.awita.awitafm.registry;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.entity.custom.CustomFishingHookEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities
{
    public static final EntityType<CustomFishingHookEntity> CUSTOM_FISHING_HOOK =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    Identifier.of(AwitasFishingMod.MOD_ID, "custom_fishing_hook"),
                    EntityType.Builder
                            .<CustomFishingHookEntity>create(CustomFishingHookEntity::new, SpawnGroup.MISC)
                            .dimensions(0.25f, 0.25f)
                            .build()
            );

    public static void registerModEntities() {
        // Just forces class loading
    }
}