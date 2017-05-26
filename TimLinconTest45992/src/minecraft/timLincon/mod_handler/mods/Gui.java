package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.TimLincon;
import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class Gui extends Mod_handler{

	public Gui() {
		super("", Keyboard.KEY_RSHIFT, Category.GUI);
	}
	
	public void onToggle(){
		Wrapper.mc.displayGuiScreen(TimLincon.timLincon_client.getGui());
	}

}
