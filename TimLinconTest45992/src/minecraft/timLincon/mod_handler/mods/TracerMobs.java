package minecraft.timLincon.mod_handler.mods;

import org.lwjgl.input.Keyboard;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import minecraft.timLincon.utils.RenderUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;

public class TracerMobs extends Mod_handler{

	public TracerMobs() {
		super("MobTracer", "Shows A Line To Mobs And Animals", Piggy.Client_keys_data[9], Category.RENDER);
		this.setState(Piggy.getDataLine("MobTracer") != 0.0);
	}
	
	public void onRender() {
		
		if (!this.getState()) {
			return;
		}
		
		for(Object theObject : mc.theWorld.loadedEntityList) {
			if(!(theObject instanceof EntityLivingBase))
				continue;
			
			EntityLivingBase entity = (EntityLivingBase) theObject;
			
			
			if(entity instanceof EntityMob) {
				mob(entity);
				continue;
			}
			
			if(entity instanceof EntityAnimal) {
				animal(entity);
				continue;
			}
			
		}
		
		super.onRender();
		
	}
	
	public void mob(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void animal(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 1F;
		float blue = 0.5F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	
	public void render(float red, float green, float blue, double x, double y, double z) {
		RenderUtils.drawTracerLine(x, y, z, red, green, blue, 0.45F, 1F);
	}
}