import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	private BufferedImage sheet1;
	
	public SpriteSheet(BufferedImage sheet){
		
		this.sheet = sheet;
	}
	
	
	public BufferedImage crop(int x, int y, int width, int height) {
		
		return sheet.getSubimage(x, y, width, height);
		
	}

}
