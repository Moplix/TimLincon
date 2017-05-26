package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class Auto_Clicker extends Mod_handler{

	public Auto_Clicker() {
		super("Auto-Clicker", Keyboard.KEY_X, Category.GHOST);
	}
	public void onTick() {
		if(this.getState()) {
			if(Mouse.isButtonDown(2))  {
				mc.thePlayer.swingItem();
			}
		}
	}
}
