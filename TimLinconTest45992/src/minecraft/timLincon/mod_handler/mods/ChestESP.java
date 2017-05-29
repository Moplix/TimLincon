package minecraft.timLincon.mod_handler.mods;

import minecraft.timLincon.Piggy;
import minecraft.timLincon.mod_handler.Category;
import minecraft.timLincon.mod_handler.Mod_handler;
import minecraft.timLincon.utils.RenderUtils;
import net.minecraft.tileentity.TileEntityChest;

public class ChestESP extends Mod_handler {

	public ChestESP() {
		super("ChestESP", "", Piggy.Client_keys_data[6], Category.RENDER);
		this.setState(Piggy.getDataLine("ChestESP") != 0.0);
	}
	
	@Override
	public void onRender() {
		
		if(!this.getState())
			return;
		
		for(Object theObject : mc.theWorld.loadedTileEntityList) {
			System.out.println(theObject);
			if(theObject.getClass() == TileEntityChest.class) 
				chest((TileEntityChest)theObject);
		}
		
		super.onRender();
	}
	
	public void chest(TileEntityChest entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = entity.getPos().getX() - mc.getRenderManager().renderPosX;
		double yPos = entity.getPos().getY() - mc.getRenderManager().renderPosY;
		double zPos = entity.getPos().getZ() - mc.getRenderManager().renderPosZ;
		
		System.out.println(
				entity.getPos().getX() + ", " + xPos + "|" +
				entity.getPos().getY() + ", " + yPos + "|" +
				entity.getPos().getZ() + ", " + zPos );
		render(red, green, blue, xPos, yPos, zPos, 10, 10);
	}
	
	
	public void render(float red, float green, float blue, double x, double y, double z, float width, float height) {
		RenderUtils.drawBlockESP(x, y, z, red, green, blue, 0.45f, 0f, 0f, 0f, 1f, 1f);
	}
	
	
}