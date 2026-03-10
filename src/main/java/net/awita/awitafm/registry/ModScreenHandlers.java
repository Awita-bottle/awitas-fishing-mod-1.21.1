package net.awita.awitafm.registry;

import net.awita.awitafm.screen.RodScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static ScreenHandlerType<RodScreenHandler> ROD_SCREEN;

    public static void register() {
        ROD_SCREEN = ScreenHandlerHelper.register(
                Identifier.of("awitafm", "rod_screen"),
                RodScreenHandler::new
        );
    }
}