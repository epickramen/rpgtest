

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;   

public class Game implements Runnable {
	
	private Window window;
	private int width;
	private int height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage mapImg;
	
	
	//states
	private State gameState;
	private State menuState;
	
	//Key input
	private KeyManager keyManager;
	
	public Game(String title, int width, int height){
	
	
	
	this.width = width;
	this.height = height;
	this.title= title;
	keyManager = new KeyManager();

	
	}
	
	private void init(){
		
		window = new Window(title, width, height);
		window.getFrame().addKeyListener(keyManager);
		
		mapImg = ImageLoader.loadImage("/textures/map.png");
		Assets.init();		
	
		
		//State manager//
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		
	}
	
	
	
	private void tick() {
		
		//key manager tick
		keyManager.tick();
		
		//state tick
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	private void render(){
		
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null){
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//drawing begins
		
		//g.fillRect(0, 0, width, height);
		
		
		/*g.drawImage(mapImg, 0, 0, null);
		g.drawImage(Assets.player, 0, 10, null);*/
		
		if(State.getState() != null)
			State.getState().render(g);
		
		
		//drawing ends
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
	
		init();
		
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("FPS : " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
		
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop(){
		
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
