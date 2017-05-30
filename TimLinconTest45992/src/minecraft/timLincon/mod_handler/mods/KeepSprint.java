package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class KeepSprint extends Mod_handler{
	
	public static boolean toggle = false;
	public static boolean keepsprinttoggle;

	public KeepSprint() {
		super("Keep-Sprint", " ", Keyboard.KEY_NONE, Category.MOVEMENT);
	}

	public void onEnable(){
		toggle = true;
	}
	
	public void onDisable(){
		toggle = false;
	}
}