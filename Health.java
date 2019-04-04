package OOPG_Tank_game_Rein;

import java.util.List;

import nl.han.ica.oopg.objects.GameObject;

public class Health extends PowerUp {
	private int value;
	public Health(World world, int value) {
		super(world);
		this.value = value;
	}
	
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		for (GameObject g : collidedGameObjects) {
        	if (g instanceof Player) {
        		((Player) g).health = ((Player) g).health + value;
        		world.deleteGameObject(this);
        		world.spawner.placedObjects = 0;
            }
		}
	}
}
