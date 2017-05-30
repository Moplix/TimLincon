package minecraft.timLincon.mod_handler.mods;


import org.lwjgl.input.Keyboard;

import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.MathHelper;

public class SmoothAim extends Mod_handler{

	public SmoothAim() {
		super("SmoothAim", "Funkar Ej", Keyboard.KEY_NONE, Category.GHOST);	
		}
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	 
	  public static float maximumRotation = 1.0F;
	  public static float minimumRotation = 1.0E-4F;
	  public static float aimFov = 90.0F;
	  
	  
	  
	  public boolean canBeHit(Entity entity)
	  {
	    if (!(entity instanceof EntityLivingBase)) {
	      return false;
	    }
	    float[] yawAndPitch = getRotationsNeeded((EntityLivingBase)entity);
	    float yaw = yawAndPitch[0];
	    float pitch = yawAndPitch[1];
	    
	    if (getDistanceBetweenAngles(mc.thePlayer.rotationYaw, yaw) < aimFov)
	    {
	      if (getDistanceBetweenAngles(mc.thePlayer.rotationPitch, pitch) < aimFov) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  public float getDistanceBetweenAngles(float angle1, float angle2)
	  {
	    return Math.abs(angle1 % 360.0F - angle2 % 360.0F) % 360.0F;
	  }
	  
	  public void onRender()
	  {
	    try
	    {
	      double dist = 0.0D;
	      double ang = 0.0D;
	      for (Object ob : this.mc.theWorld.loadedEntityList) {
	        if ((ob instanceof EntityPlayer))
	        {
	          Entity entity = (Entity)ob;
	          if ((!(this.mc.currentScreen instanceof GuiContainer)) && (!(this.mc.currentScreen instanceof GuiChat)) && (!(this.mc.currentScreen instanceof GuiScreen)) && (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock)) && 
	            (!(entity instanceof EntityPlayerSP)) && (!mc.thePlayer.isDead) && (mc.thePlayer.canEntityBeSeen(entity)) && 
	            (canBeHit(entity)) && (mc.thePlayer.getDistanceToEntity(entity) <= 4.0F) && (!entity.isDead) && 
	            ((mc.thePlayer.getCurrentEquippedItem().getItem() instanceof Item))) {
	            faceEntity(entity, maximumRotation / 10.0F, minimumRotation);
	          }
	        }
	      }
	    }
	    catch (Exception localException) {}
	  }
	  
	  public void faceEntity(Entity entity, float yaw, float pitch)
	  {
	    if (entity == null) {
	      return;
	    }
	    double diffX = entity.posX - mc.thePlayer.posX;
	    double diffZ = entity.posZ - mc.thePlayer.posZ;
	    double yDifference;
	    if ((entity instanceof EntityLivingBase))
	    {
	      EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
	      yDifference = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (
	        mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
	    }
	    else
	    {
	      yDifference = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (
	        mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
	    }
	    double var14 = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
	    float var12 = (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
	    float var13 = (float)-(Math.atan2(yDifference, var14) * 180.0D / 3.141592653589793D);
	    mc.thePlayer.rotationYaw = updateRotation(mc.thePlayer.rotationYaw, var12, yaw);
	  }
	  
	  public static float[] getRotationsNeeded(Entity entity)
	  {
	    if (entity == null) {
	      return null;
	    }
	    double diffX = entity.posX - mc.thePlayer.posX;
	    double diffZ = entity.posZ - mc.thePlayer.posZ;
	    double diffY;
	    if ((entity instanceof EntityLivingBase))
	    {
	      EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
	      diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
	    }
	    else
	    {
	      diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
	    }
	    double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
	    float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
	    float pitch = (float)-(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D);
	    return new float[] { mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - mc.thePlayer.rotationYaw), mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - mc.thePlayer.rotationPitch) };
	  }
	  
	  private float updateRotation(float p_70663_1_, float p_70663_2_, float p_70663_3_)
	  {
	    float var4 = MathHelper.wrapAngleTo180_float(p_70663_2_ - p_70663_1_);
	    if (var4 > p_70663_3_) {
	      var4 = p_70663_3_;
	    }
	    if (var4 < -p_70663_3_) {
	      var4 = -p_70663_3_;
	    }
	    return p_70663_1_ + var4;
	  }
	}
