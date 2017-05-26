package minecraft.timLincon;

import minecraft.timLincon.managers.GuiManager;
import minecraft.timLincon.mod_handler.Mod_manager;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.opengl.Display;

public class TimLincon {
	
	public static String Client_name = "Lincon";
	public static double Client_version = 1.0;
	
	public static final TimLincon timLincon_client = new TimLincon();
	public static Mod_manager mod_manager;
	
	private GuiManagerDisplayScreen gui;
	private GuiManager guiManager;
	
	
	public static void StartClient() {
		System.out.println("[TimLincon] Initializing..");
		mod_manager = new Mod_manager();
		Display.setTitle(Client_name);
		System.out.println("[TimLincon] Done!");
	}
	
	public GuiManager getGuiManager(){
		if(guiManager == null){
			guiManager = new GuiManager();
			guiManager.setTheme(new SimpleTheme());
			guiManager.setup();
		}
		return guiManager;
	}
	
	public GuiManagerDisplayScreen getGui(){
		if(gui == null){
			gui = new GuiManagerDisplayScreen(getGuiManager());
		}
		return gui;
	}


	public static String getClient_name() {
		return Client_name;
	}

	public static void setClient_name(String client_name) {
		Client_name = client_name;
	}

	public static double getClient_version() {
		return Client_version;
	}

	public static void setClient_version(double client_version) {
		Client_version = client_version;
	}
	
	
}
