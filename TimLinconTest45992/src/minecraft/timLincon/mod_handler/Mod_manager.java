package minecraft.timLincon.mod_handler;

import java.util.ArrayList;

import minecraft.timLincon.mod_handler.mods.*;

public class Mod_manager {
	
	public static ArrayList<Mod_handler> activeMod_handlers = new ArrayList<Mod_handler>();
	
	public Mod_manager() {
		this.activeMod_handlers.add(new Auto_Sprint());
		this.activeMod_handlers.add(new Auto_Clicker());
		this.activeMod_handlers.add(new Full_Bright());
		this.activeMod_handlers.add(new Flight());
		this.activeMod_handlers.add(new Kill_Aura());
		this.activeMod_handlers.add(new ESPPlayer());
		this.activeMod_handlers.add(new ESPMobs());
		this.activeMod_handlers.add(new TracerPlayer());
		this.activeMod_handlers.add(new TracerMobs());
		this.activeMod_handlers.add(new No_Fall());
		this.activeMod_handlers.add(new ChestESP());
		this.activeMod_handlers.add(new KeepSprint());
		this.activeMod_handlers.add(new HitBox());
		this.activeMod_handlers.add(new Reach());
		this.activeMod_handlers.add(new AntiFire());
		this.activeMod_handlers.add(new MegaHitBox());
		this.activeMod_handlers.add(new Criticals());
		this.activeMod_handlers.add(new TriggerBot());
		this.activeMod_handlers.add(new SmoothAim());
		
		
		
		
		 
		
		this.activeMod_handlers.add(new Gui());
	}

	public static ArrayList<Mod_handler> getModules(){
		return activeMod_handlers;
	}
	
	public static Mod_handler getModule(Class <? extends Mod_handler> clazz){
		for(Mod_handler mod: getModules()){
			if(mod.getClass() == clazz){
				return mod;
			}
		}
		return null;
		
	}
	
}
