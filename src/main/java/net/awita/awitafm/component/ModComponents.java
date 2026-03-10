package net.awita.awitafm.component;

import net.awita.awitafm.AwitasFishingMod;
import net.awita.awitafm.Item.custom.FishingBait;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {

    public static final ComponentType<FishingBait.TYPE> BAIT_COMPONENT_TYPE =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    Identifier.of(AwitasFishingMod.MOD_ID, "bait_type"),
                    ComponentType.<FishingBait.TYPE>builder()
                            .codec(FishingBait.CODEC)
                            .build()    
            );

    public static void initialize() {
        AwitasFishingMod.LOGGER.info("Registering {} components", AwitasFishingMod.MOD_ID);
    }
}