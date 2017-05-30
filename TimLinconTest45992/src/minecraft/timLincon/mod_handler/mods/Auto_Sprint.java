package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class Auto_Sprint extends Mod_handler{

	public Auto_Sprint() {
		super("Auto-Sprint", "", Piggy.Client_keys_data[1], Category.MOVEMENT);
		this.setState(Piggy.getDataLine("Auto-Sprint") != 0.0);
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
