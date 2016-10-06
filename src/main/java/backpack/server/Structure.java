package backpack.server;

public class Structure {

	public String allow;
	public String nextThrottleResetAt;
	public String cart;

	public String getOpen() {
		return allow;
	}

	public void setOpen(String open) {
		this.allow = open;
	}

	public String getOpenTime() {
		return nextThrottleResetAt;
	}

	public void setOpenTime(String openTime) {
		this.nextThrottleResetAt = openTime;
	}

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(allow.equals("true")){
			cart = "is open";			
		}
		else if(allow.equals("false")){
			cart = "is not open";
			
		}
		sb.append("Cart " + cart);
		
		return sb.toString();
	}

}
