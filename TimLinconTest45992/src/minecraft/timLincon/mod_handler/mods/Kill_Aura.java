package minecraft.timLincon.mod_handler.mods;

import java.util.List;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import org.lwjgl.input.Keyboard;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class Kill_Aura extends Mod_handler{

	private int kill_aura_delay;

	public Kill_Aura() {
		super("Kill Aura", "", Piggy.Client_keys_data[5], Category.COMBAT);
		this.setState(Piggy.getDataLine("Kill Aura") != 0.0);
	}

	public void onTick() {
		if(this.getState()) {
			this.brain_killAura();
		}
	}
	
	
	public void brain_killAura() {
		List player_world_entites = mc.theWorld.playerEntities;	
		kill_aura_delay++;
		
		for(int i = 0; i < player_world_entites.size(); i++) {
			if(((EntityPlayer)player_world_entites.get(i)).getName() == mc.thePlayer.getName())
				continue;
			
			EntityPlayer entityPlayer = (EntityPlayer)player_world_entites.get(i);
			
			if(mc.thePlayer.getDistanceToEntity(entityPlayer) > mc.thePlayer.getDistanceToEntity((Entity)player_world_entites.get(i))) {
				entityPlayer = (EntityPlayer)player_world_entites.get(i);
			}
			
			float f = mc.thePlayer.getDistanceToEntity(entityPlayer);
			
			if(f < 4f && mc.thePlayer.canEntityBeSeen(entityPlayer) && kill_aura_delay > 7) {
				this.faceEntity(entityPlayer);
				mc.playerController.attackEntity(mc.thePlayer, entityPlayer);
				mc.thePlayer.swingItem();
				continue;
			}
		}
	}
	
	public static synchronized void faceEntity(EntityLivingBase entity) {
		final float[] rotations = getRotationsNeeded(entity);
		if(rotations != null) {
			mc.thePlayer.rotationYaw = rotations[0];
			mc.thePlayer.rotationYaw = rotations[1] + 1f;
		}
	}
	
	public static float[] getRotationsNeeded(Entity entity) {
		if(entity == null) 
			return null;
		final double diff_x = entity.posX - mc.thePlayer.posX;
		final double diff_z = entity.posZ - mc.thePlayer.posZ;
		double diff_y;
		if(entity instanceof EntityLivingBase) {
			final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			diff_y = entity.posY + entityLivingBase.getEyeHeight() - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		} else {
			diff_y = (entity.getBoundingBox().minY + entity.getBoundingBox().maxY / 2f - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight()));
		}
		final double distance = MathHelper.sqrt_double(diff_x * diff_x + diff_z * diff_z);
		final float yaw = (float) (Math.atan2(diff_z, diff_x) * 180 / 3.1415926535897930) - 90;
		final float pitch = (float) -(Math.atan2(diff_y, distance) * 180 / 3.1415926535897930);
		return new float[] {
				mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - mc.thePlayer.rotationYaw),
				mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - mc.thePlayer.rotationPitch)
		};
	}
}
