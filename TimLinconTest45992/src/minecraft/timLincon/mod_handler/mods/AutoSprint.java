package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class AutoSprint extends Mod_handler{

	public AutoSprint() {
		super("Auto-Sprint", Keyboard.KEY_R, Category.PLAYER);
	}
	
	public void onTick() {
		if(!this.getState()) {
			return;
		}
		if(!(Wrapper.mc.thePlayer.isCollidedHorizontally) && Wrapper.mc.thePlayer.moveForward > 0.0f) {
			Wrapper.mc.thePlayer.setSprinting(true);
		} else {
			Wrapper.mc.thePlayer.setSprinting(false);
		}
	}
}
