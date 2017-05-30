package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import minecraft.timLincon.utils.TimeHelper2;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.MovingObjectPosition;

public class Criticals extends Mod_handler{

	public Criticals() {
		super("Criticals", "Funkar Ej", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	TimeHelper2 timer = new TimeHelper2();
	
	public void onUpdate(){
		boolean wassprint = mc.thePlayer.isSprinting();
		if(mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY){
			Entity entity = mc.objectMouseOver.entityHit;
			mc.thePlayer.setSprinting(true);
		}
		if(mc.thePlayer.onGround){
			mc.thePlayer.onGround = false;
			mc.thePlayer.motionY = 0.1000000014901161D;
			mc.thePlayer.onGround = true;
			mc.thePlayer.setSprinting(wassprint);
		if((mc.thePlayer.onGround) && (mc.gameSettings.keyBindAttack.isPressed())){
			C03PacketPlayer packet = new C03PacketPlayer();
			packet.y += 0.2D;
			Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
			if(timer.hasReached(100L)){
				mc.thePlayer.onGround = true;
				C03PacketPlayer pack = new C03PacketPlayer();
				pack.y -= 0.1D;
				Minecraft.getMinecraft().getNetHandler().addToSendQueue(pack);
				mc.thePlayer.motionY -= 0.1D;
				mc.thePlayer.setSprinting(wassprint);
				}
			timer.reset();
			}
		}
	}
}
