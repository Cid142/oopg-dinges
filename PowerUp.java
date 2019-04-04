package OOPG_Tank_game_Rein;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class PowerUp extends AnimatedSpriteObject  implements ICollidableWithGameObjects{
	public World world;
	private int value;
	public PowerUp(World world) {
		super(new Sprite(World.MEDIA_URL.concat("Tank_blue_heavy_strip60.png")), 60);
		this.world = world;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	
}
