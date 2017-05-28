package minecraft.timLincon.ui;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.Wrapper;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import minecraft.timLincon.mod_handler.Mod_manager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class Gui_ingame extends GuiIngame{

	public Gui_ingame(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void func_175180_a(float p_175180_1_) {
		super.func_175180_a(p_175180_1_);
		
		Wrapper.fu_default.drawString(Piggy.getClient_name() + Piggy.getClient_version(), 0, 0, 0xffffffff);
		renderArrayList();
		Piggy.piggy_client.getGuiManager().renderPinned();
	}

	private void renderArrayList() {
		int yCount = 10;
		for(Mod_handler m : Piggy.piggy_client.mod_manager.activeMod_handlers) {
			m.onRender();
			
			if(m.getState() && !m.isCategory(Category.GUI)){
				Wrapper.fu_default.drawString(m.getName(), 2, yCount, 0x00ff7f);
				Wrapper.fu_default.drawString(m.getDesc(), (m.getName().length() * 5) + 7, yCount, 0x7f7f7f);
				yCount += 10;
			}
		}
	}
}
