import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager(){
	
		keys = new boolean[256];
		
	}
	

	public void tick(){
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		keys[arg0.getKeyCode()] = true;
		//System.out.println("pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		keys[arg0.getKeyCode()] = false;
		//System.out.println("released");
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
	
	
	
	

}
