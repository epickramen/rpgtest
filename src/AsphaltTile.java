import java.awt.image.BufferedImage;

public class AsphaltTile extends Tile {

	public AsphaltTile(int id) {
		super(Assets.asphalt, id);
	
	}
	
	@Override
	public boolean isSolid(){
		
		return true;
	}

}
