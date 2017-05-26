package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class AutoClicker extends Mod_handler{

	public AutoClicker() {
		super("Auto-Clicker", Keyboard.KEY_X, Category.GHOST);
	}
	public void onTick() {
		
	}
}
