package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

import org.lwjgl.input.Keyboard;

public class Full_Bright extends Mod_handler {
	
	public Full_Bright() {
		super("Full-bright", Keyboard.KEY_F, Category.WORLD);
	}
	
	public void onTick() {
		if(this.getState())
			Wrapper.mc.gameSettings.gammaSetting = 10f;
		else
			Wrapper.mc.gameSettings.gammaSetting = 1f;
	}
}
