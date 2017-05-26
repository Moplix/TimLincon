package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class Flight extends Mod_handler {

	public Flight() {
		super("Flight", "", Keyboard.KEY_H, Category.PLAYER);
	}
	
	public void onTick() {
		if(!this.getState())
			return;
		mc.thePlayer.capabilities.isFlying = true;
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}
}
