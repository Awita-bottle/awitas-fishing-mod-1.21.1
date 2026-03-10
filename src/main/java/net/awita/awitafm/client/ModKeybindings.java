package net.awita.awitafm.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class ModKeybindings
{

    public static KeyBinding OPEN_ROD_GUI;

    public static void register()
    {
        OPEN_ROD_GUI = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.awitafm.open_rod_gui",
                        GLFW.GLFW_KEY_R,
                        "category.awitafm"
                )
        );
    }
}