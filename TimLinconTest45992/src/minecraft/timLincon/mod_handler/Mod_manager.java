package minecraft.timLincon.mod_handler;

import java.util.ArrayList;

import minecraft.timLincon.mod_handler.mods.*;

public class Mod_manager {
	
	public static ArrayList<Mod_handler> activeMod_handlers = new ArrayList<Mod_handler>();
	
	public Mod_manager() {
		this.activeMod_handlers.add(new Auto_Sprint());
		this.activeMod_handlers.add(new Full_Bright());
		this.activeMod_handlers.add(new Flight());
		this.activeMod_handlers.add(new Kill_Aura());
	}
}
