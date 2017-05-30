package minecraft.timLincon.utils;

public class TimeHelper {
	private long lastMS = 0;
	
	public boolean isDelayComplete(long delay){
		if(System.currentTimeMillis() - lastMS >= delay){
			return true;
		}
		
		return false;
	}
	
	public void setLastMS(long lastMS){
		this.lastMS = lastMS;
	}
	
	public void setLastMS(){
		this.lastMS = System.currentTimeMillis();
	}
	
	public int convertToMS(int perSecond){
		return 1000 / perSecond;
	}

}
