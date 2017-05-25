package me.lordethan.cryton;

import me.lordethan.cryton.managers.GuiManager;
import me.lordethan.cryton.module.ModuleManager;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.opengl.Display;

public class Cryton {

	private static String Client_Name = "HEj tim";
	private static double Client_Vesion = 1.0;

	public static final Cryton theClient = new Cryton();

	public static ModuleManager moduleManager;
	
	private GuiManagerDisplayScreen gui;
	private GuiManager guiManager;

	public static void StartClient() {
		moduleManager = new ModuleManager();
		Display.setTitle(getClient_Name() + " (rel-" + getClient_Vesion() + ")");
	}
	
	public GuiManager getGuiManager(){
		if(guiManager == null){
			guiManager = new GuiManager();
			guiManager.setTheme(new SimpleTheme());
			guiManager.setup();
			guiManager.update();
		}
		return guiManager;
	}
	
	public GuiManagerDisplayScreen getGui(){
		if(gui == null){
			gui = new GuiManagerDisplayScreen(getGuiManager());
		}
		return gui;
	}

	public static String getClient_Name() {
		return Client_Name;
	}

	public static void setClient_Name(String client_Name) {
		Client_Name = client_Name;
	}

	public static double getClient_Vesion() {
		return Client_Vesion;
	}

	public static void setClient_Vesion(double client_Vesion) {
		Client_Vesion = client_Vesion;
	}
	
	

}
