import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player, player1, player2;
	public static BufferedImage asphalt, grass, flowers, cobble;

	
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/charSprites.png"));
		
		player = sheet.crop(0, 0, width, height);
		player1 = sheet.crop(width, 0, width, height);
		player2 = sheet.crop(width*2, 0, width, height);
		
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/tileset1.png"));
		
		asphalt = sheet1.crop(0, 0, width, height);
		grass = sheet1.crop(width*5, 0, width, height);
		flowers = sheet1.crop(width*3, 0, width, height);
		cobble = sheet1.crop(width*7, 0, width, height);
	}

}
