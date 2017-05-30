package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import net.minecraft.tileentity.TileEntityChest;

public class Flight extends Mod_handler {

	public Flight() {
		super("Flight", "", Piggy.Client_keys_data[2], Category.MOVEMENT);
		this.setState(Piggy.getDataLine("Flight") != 0.0);
	}
	
	public void onTick() {
		if(!this.getState())
			return;
		mc.thePlayer.capabilities.isFlying = true;
	}
	
	public void onDisable() {
		if(mc.thePlayer != null)
			mc.thePlayer.capabilities.isFlying = false;
	}
}
