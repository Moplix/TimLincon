package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

import org.lwjgl.input.Keyboard;

public class Full_Bright extends Mod_handler {
	
	public Full_Bright() {
		super("Full-bright", "", Piggy.Client_keys_data[3], Category.WORLD);
		this.setState(Piggy.getDataLine("Full-bright") != 0.0);
	}
	
	public void onTick() {
		if(this.getState())
			Wrapper.mc.gameSettings.gammaSetting = 10f;
		else
			Wrapper.mc.gameSettings.gammaSetting = 1f;
	}
}
