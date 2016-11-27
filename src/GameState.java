import java.awt.Graphics;

public class GameState extends State {

	
	private Player player;
	private World world;
	
	public GameState(Game game){
		
	super(game);
		player = new Player(game, 100, 100);
		world = new World("res/worlds/world1.lvl");
	}
	
	public void tick() {
		
		world.tick();
		player.tick();
	
		
	}

	public void render(Graphics g) {
	
	world.render(g);
	player.render(g);
	
		
	}
	
	

}
