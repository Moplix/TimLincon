package minecraft.timLincon.mod_handler.mods;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import minecraft.timLincon.utils.TimeHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;

public class TriggerBot extends Mod_handler{

	public TriggerBot() {
		super("TriggerBot", "Funkar Ej", Keyboard.KEY_NONE, Category.GHOST);
	}
	
	TimeHelper delay = new TimeHelper();
	Random r = new Random();
	
	public void onEnable(){
		boolean wassprint = mc.thePlayer.isSprinting();
		if(mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY){
			if(delay.isDelayComplete(51 + r.nextInt(80))){
				delay.setLastMS();
				Entity entity = mc.objectMouseOver.entityHit;
				mc.thePlayer.setSprinting(true);
				if(entity instanceof EntityPlayer && entity.isEntityAlive() && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isDead){
					mc.clickMouse();
					mc.thePlayer.setSprinting(wassprint);
				}
				
			}
		}
	}

}
