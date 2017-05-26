package minecraft.timLincon.mod_handler;

public class Mod_handler {
	
	private String name;
	private int bind;
	private Category category;
	private boolean isEnabled;
	
	public Mod_handler(String name, int bind, Category cate) {
		this.name = name;
		this.bind = bind;
		this.category = cate;
	}

	public String getName() {
		return name;
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
		} else {
			this.onDisable();
			this.isEnabled = false;
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
	
}
