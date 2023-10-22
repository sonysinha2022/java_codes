package assign;

public class Point {
	private int X;
	private int Y;
	Point(){}
	Point(int X, int Y){
	this.X=X;
	this.Y=Y;
	}
	public int getX(){
	return X;
	}
	public int getY(){
	return Y;
	}
	public void setX(int X1){
	X=X1;
	}
	public void setY(int Y1){
	Y=Y1;
	}
	public void Display()
	{
	System.out.println("the cordinate of X:"+X+"the cordinate of Y:"+Y);
	}

}
