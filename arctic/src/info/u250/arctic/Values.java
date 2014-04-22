package info.u250.arctic;

public class Values {
	public static void setSpeed(int x){
		X = x;
		Umbrella_Speed = 10*X;
		Plane_Speed = 15*X;
		Speed = 35*X;
	}
	static{
		setSpeed(2);
	}
	static float X = 2f;
	public static float Umbrella_Speed = 0;
	public static float Plane_Speed = 0;
	public static float Speed = 0;
}
