package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class Reach extends Mod_handler{
	
	public static boolean Reach;

	public Reach() {
		super("Reach", "", Keyboard.KEY_NONE, Category.COMBAT);
	}

	public void onEnable(){
		Reach = true;
	}

	public void onDisable(){
		Reach = false;
	}
}
