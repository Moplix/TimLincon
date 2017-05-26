package minecraft.timLincon;

import minecraft.timLincon.mod_handler.Mod_manager;
import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.Display;

public class TimLincon {
	
	public static String Client_name = "No name";
	public static double Client_version = 1.0;
	
	public static final TimLincon timLincon_client = new TimLincon();
	public static Mod_manager mod_manager;
	
	
	public static void StartClient() {
		System.out.println("[TimLincon] Initializing..");
		mod_manager = new Mod_manager();
		Display.setTitle(Client_name);
		System.out.println("[TimLincon] Done!");
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
