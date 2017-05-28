package minecraft.timLincon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import minecraft.timLincon.managers.GuiManager;
import minecraft.timLincon.mod_handler.Mod_manager;
import net.minecraft.client.Minecraft;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Piggy {
	
	public static String Client_name = "Piggy";
	public static double Client_version = 1.1;
	public static float[] Client_settings_data = new float[11];
	public static int[] Client_keys_data = new int[10];
	
	public static final Piggy piggy_client = new Piggy();
	private static Minecraft mc = Minecraft.getMinecraft();
	public static Mod_manager mod_manager;
	
	private GuiManagerDisplayScreen gui;
	private GuiManager guiManager;
	
	
	public static void StartClient() {
		//finns en risk att den skriver ut "Initializing" efter "Found settings data file".
		//men det är inget att stressa över. ^^ 
		System.err.println("[Piggy_client] Initializing.."); 
		LoadData();
		Display.setTitle(Client_name);
		
		mod_manager = new Mod_manager();
		mc.gameSettings.viewBobbing = false;
		
		System.err.println("[Piggy_client] Done initializing!");
	}
	
	public static void LoadData() {
		//TODO: default data_options
		Client_settings_data[0] = 0; //Auto_sprint
		Client_settings_data[1] = 0; //Auto_clicker
		Client_settings_data[2] = 3; //Auto_clicker_delay
		Client_settings_data[3] = 0; //Flight
		Client_settings_data[4] = 0; //Full_Bright
		Client_settings_data[5] = 0; //GUI
		Client_settings_data[6] = 0; //Kill_Aura
		Client_settings_data[7] = 0; //PlayerESP
		Client_settings_data[8] = 0; //MobESP
		Client_settings_data[9] = 0; //PlayerTracer
		Client_settings_data[10] = 0; //MobTracer
		
		//TODO: default data_keys
		Client_keys_data[0] = Keyboard.KEY_X; //Auto_Clicker
		Client_keys_data[1] = Keyboard.KEY_G; //Auto_Sprint
		Client_keys_data[2] = Keyboard.KEY_F; //Flight
		Client_keys_data[3] = Keyboard.KEY_V; //Full_Bright
		Client_keys_data[4] = Keyboard.KEY_RSHIFT; //GUI
		Client_keys_data[5] = Keyboard.KEY_R; //Kill_Aura
		Client_keys_data[6] = Keyboard.KEY_NONE; //PlayerESP
		Client_keys_data[7] = Keyboard.KEY_NONE; //MobESP
		Client_keys_data[8] = Keyboard.KEY_NONE; //PlayerTracer
		Client_keys_data[9] = Keyboard.KEY_NONE; //MobTracer
		
		try(BufferedReader br = new BufferedReader(new FileReader("Piggy_settings.txt"))) {
			System.out.println("[Piggy_client] Found settings data file, reading..");
			
			int count = 0;
			for(String data; (data = br.readLine()) != null;) {
				Client_settings_data[count] = Float.parseFloat(data);
				count++;
			}			

			System.out.println("[Piggy_client] Done reading settings!");
		} catch(Exception e) {
			System.err.println("[Piggy_client] Couln't load settings data file..");
			System.err.println("[Piggy_client] Creating new settings data file..");
			try {
				PrintWriter writer = new PrintWriter("Piggy_settings.txt", "UTF-8");
				for(int i = 0; i < Client_settings_data.length; i++) {
					writer.println(Client_settings_data[i]);
				}	
				writer.close();
			} catch (Exception f) {
				System.err.println("[Piggy_client] Failed to even create the file.. ");
				System.err.println("[Piggy_client] Reason: ");
				f.printStackTrace();
			}
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("Piggy_keys.txt"))) {
			System.out.println("[Piggy_client] Found keys data file, reading..");
			
			int count = 0;
			for(String data; (data = br.readLine()) != null;) {
				Client_keys_data[count] = Integer.parseInt(data);
				count++;
			}			

			System.out.println("[Piggy_client] Done reading keys!");
		} catch(Exception e) {
			System.err.println("[Piggy_client] Couln't load keys data file..");
			System.err.println("[Piggy_client] Creating new keys data file..");
			try {
				PrintWriter writer = new PrintWriter("Piggy_keys.txt", "UTF-8");
				for(int i = 0; i < Client_keys_data.length; i++) {
					writer.println(Client_keys_data[i]);
				}	
				writer.close();
			} catch (Exception f) {
				System.err.println("[Piggy_client] Failed to even create the file.. ");
				System.err.println("[Piggy_client] Reason: ");
				f.printStackTrace();
			}
		}
	}
	
	public static void setDataLine(String data_index, float data) {
		try {			
			System.out.println("[Piggy_client] Making a save, piggy_settings.txt");
			PrintWriter wr = new PrintWriter("Piggy_settings.txt", "UTF-8");
			
			if(!data_index.isEmpty())
				System.err.println("[Piggy_client] " + data_index + ", " + data);
			else
				System.err.println("[Piggy_client] No-name, " + data);
				
				
			switch (data_index) {
			case "Auto-Sprint":
				Client_settings_data[0] = data; //Auto_sprint
				break;
			case "Auto-Clicker":
				Client_settings_data[1] = data; //Auto_clicker
				break;
			case "Auto-Clicker_delay":
				Client_settings_data[2] = data; //Auto_clicker_delay
				break;
			case "Flight":
				Client_settings_data[3] = data; //Flight
				break;
			case "Full-bright":
				Client_settings_data[4] = data; //Full_bright
				break;
			case "Kill Aura":
				Client_settings_data[5] = data; //Kill_aura
				break;
			case "PlayerESP":
				Client_settings_data[6] = data; //PlayerESP
				break;
			case "MobESP":
				Client_settings_data[7] = data; //MobESP
				break;
			case "PlayerTracer":
				Client_settings_data[8] = data; //PlayerTracer
				break;
			case "MobTracer":
				Client_settings_data[9] = data; //MobTracer
				break;
			
			default:
				break;
			}
			
			for(int i = 0; i < Client_settings_data.length; i++) {
				wr.println(Client_settings_data[i]);
			}
			wr.close();
			System.out.println("[Piggy_client] Done saving, piggy_settings.txt!");
		} catch (Exception e) {
			System.out.println("[Piggy_client] Couln't find, piggy_settings.txt");
			System.out.println("[Piggy_client] Reason: ");
			e.printStackTrace();
		}
	}
	
	//På dom här måste namnet stämma in på mod:ets ingame namn.
	public static float getDataLine(String data_index) {
		switch (data_index) {
		case "Auto-Sprint":
			return Client_settings_data[0];
		case "Auto-Clicker":
			return Client_settings_data[1];
		case "Auto-Clicker_delay":
			return Client_settings_data[2];
		case "Flight":
			return Client_settings_data[3];
		case "Full-bright":
			return Client_settings_data[4];
		case "Kill Aura":
			return Client_settings_data[5];
		case "PlayerESP":
			return Client_settings_data[6];
		case "MobESP":
			return Client_settings_data[7];
		case "PlayerTracer":
			return Client_settings_data[8];
		case "MobTracer":
			return Client_settings_data[9];

		default:
			return 0;
		}
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
