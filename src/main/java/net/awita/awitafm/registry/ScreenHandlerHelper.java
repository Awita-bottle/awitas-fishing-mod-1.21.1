package net.awita.awitafm.registry;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ScreenHandlerHelper {

    @SuppressWarnings("unchecked")
    public static <T extends ScreenHandler> ScreenHandlerType<T> register(
            Identifier id,
            ScreenHandlerType.Factory<T> factory
    ) {
        try {
            // Get private constructor ScreenHandlerType(Factory)
            Constructor<ScreenHandlerType> ctor = ScreenHandlerType.class.getDeclaredConstructor(ScreenHandlerType.Factory.class);
            ctor.setAccessible(true);

            // Create the type via the private constructor
            ScreenHandlerType<T> type = (ScreenHandlerType<T>) ctor.newInstance(factory);

            // Now register using Registry.register
            return Registry.register(
                    Registries.SCREEN_HANDLER,
                    id,
                    type
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to register screen handler type " + id, e);
        }
    }
}