package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

import org.lwjgl.input.Keyboard;

public class Gui extends Mod_handler{

	public Gui() {
		super("", "", Piggy.Client_keys_data[4], Category.GUI);
	}
	
	public void onToggle(){
		Wrapper.mc.displayGuiScreen(Piggy.piggy_client.getGui());
	}

}
