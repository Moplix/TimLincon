package minecraft.timLincon.mod_handler.mods;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;

public class Auto_Clicker extends Mod_handler{

	public static int Attack_Delay = 3;
	private int Attack_Delay_Counter = 0;
	private Entity selected_entity;
	
	public Auto_Clicker() {
		super("Auto-Clicker", "", Keyboard.KEY_X, Category.GHOST);
	}
	
	public void onTick() {
		if(this.getState()) {
			if(Mouse.isButtonDown(2))  {
				List world_entites = mc.theWorld.loadedEntityList;			
				Attack_Delay_Counter++;
				
				for(int i = 0; i < world_entites.size(); i++) {
					if(world_entites.get(i) instanceof AbstractClientPlayer && world_entites.get(i) != mc.thePlayer || world_entites.get(i) instanceof EntityAnimal) {
			
						
						Entity entity = (Entity) world_entites.get(i);
						float f = mc.thePlayer.getDistanceToEntity(entity);
						
						if(f < 4f && mc.thePlayer.canEntityBeSeen(entity) && Attack_Delay_Counter >= Attack_Delay){
							System.out.println("ATTACKING ENTITY: " + entity);
							mc.playerController.attackEntity(mc.thePlayer, entity);
							mc.thePlayer.swingItem();
							Attack_Delay_Counter = 0;
							continue;
						}
					}
				}
			}
		}
	}
	
	public void onEnable() {
		this.updateDesc("Delay: " + Attack_Delay);
	}
}
