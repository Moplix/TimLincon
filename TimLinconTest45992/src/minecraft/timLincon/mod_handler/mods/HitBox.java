package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;

public class HitBox extends Mod_handler{

	public HitBox() {
		super("HitBox", "", Keyboard.KEY_NONE, Category.GHOST);
	}

}
