package OOPG_Tank_game_Rein;

public class Tank extends Player {

	public int color;
	public int x;
	public int y;
	public int tank_speed;
	public Shell shell;
	public Tank(int color, int x, int y, int tank_speed, World world) {
		super(world, tank_speed);
		// TODO Auto-generated constructor stub
		this.color = color;
		this.x = x;
		this.y = y;
		this.tank_speed = 5;
		
	}

}
