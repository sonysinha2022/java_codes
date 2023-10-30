package comm;

public enum Plan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private int planCost;
	
	private Plan(int planCost)
	{
		this.planCost=planCost;
	}
	//getter
	public int getPlanCost()
	{
		return planCost;
	}
	
	//toString
	public String toString()
	{
		return "Plan:"+name().toUpperCase()+" Cost:"+planCost;
	}
}