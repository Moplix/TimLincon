package minecraft.timLincon.mod_handler;

import minecraft.timLincon.Piggy;
import net.minecraft.client.Minecraft;

public class Mod_handler {
	
	//TODO: Imports
	public static Minecraft mc = Minecraft.getMinecraft();
	
	//TODO: Values
	private String name;
	private String desc;
	private int bind;
	private Category category;
	public boolean isEnabled;
	
	public Mod_handler(String name, String desc, int bind, Category cate) {
		this.name = name;
		this.desc = desc;
		this.bind = bind;
		this.category = cate;
	}

	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void updateDesc(String desc) {
		this.desc = desc;
	}


	public int getBind() {
		return bind;
	}

	public Category getCategory() {
		return category;
	}
	
	public boolean getState() {
		return isEnabled;
	}
	
	public void setState(boolean data) {
		this.onToggle();
		if(data) {
			this.onEnable();
			this.isEnabled = true; 
			Piggy.setDataLine(this.getName(), 1);
		} else {
			this.onDisable();
			this.isEnabled = false;
			Piggy.setDataLine(this.getName(), 0);
		}
	}
	
	public void toggleHandler() {
		this.setState(!this.getState());
	}
	
	public void onToggle() {}
	public void onEnable() {}
	public void onDisable() {}
	public void onTick() {}
	public void onRender() {}

	public final boolean isCategory(Category s) {
		if (s == category)
			return true;
		return false;
	}
	
}
