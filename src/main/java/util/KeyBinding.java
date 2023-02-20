package util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBinding {
	public static final String KEY_CATEGORY_TUTORIAL = "key.category.co.mod";
	public static final String KEY_DRINK_WATER = "key.co.drink_water";
	
	public static final KeyMapping DRINKING_KEY = new KeyMapping(KEY_DRINK_WATER, KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_0, KEY_CATEGORY_TUTORIAL);
}
