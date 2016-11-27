
public abstract class Creature extends Entity {

	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
						    DEFAULT_CREATURE_HEIGHT = 32;
	
	
	protected int health;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}


	public void move(){
		
		x += xMove;
		y += yMove;
		
	}
	
	
	//GETTERS AND SETTERS ONLY
	
	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}


	public static float getDefaultSpeed() {
		return DEFAULT_SPEED;
	}


	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	
	
	
}
