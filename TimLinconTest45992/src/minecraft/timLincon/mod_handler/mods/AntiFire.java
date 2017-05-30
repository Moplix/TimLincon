package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiFire extends Mod_handler{

	public AntiFire() {
		super("AntiFire", "", Keyboard.KEY_NONE, Category.PLAYER);
	}

	public void onUpdate(){
		if((getState()) && (!mc.thePlayer.capabilities.isCreativeMode) && (mc.thePlayer.onGround) && (mc.thePlayer.isBurning())){
			for (int i = 0; i < 100; i++){
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
			}
		}
	}
}
