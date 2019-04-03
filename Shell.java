package OOPG_Tank_game_Rein;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;

public class Shell extends AnimatedSpriteObject implements ICollidableWithTiles {
	final int size= 10;
	
	public int shell_velocity;
	public int playerNumber;
	public float direction;
	private final World world;
	public Shell(World world, int number, float direction, int speed) {
    	//super(new Sprite(HelloWorld.MEDIA_URL.concat("Tank1-R.png"));
    	super(new Sprite(World.MEDIA_URL.concat("Shell_strip4.png")), 4);
        this.world = world;
        this.playerNumber = number;
        this.direction = direction;
        this.shell_velocity = speed;
        setCurrentFrameIndex(0);
    }
	
	@Override
    public void update() {
		if (getX() <= 0) {
            setxSpeed(0);
        }
        if (getY() <= 0) {
            setySpeed(0);
        }
        if (getX() >= world.width - size) {
            setxSpeed(0);
        }
        if (getY() >= world.height - size) {
            setySpeed(0);
        }
		this.fly();
    }
	
	private void fly() {
		if (direction == 270) {       					
            setDirectionSpeed(270, shell_velocity);
            setCurrentFrameIndex(0);}
        
        if (direction == 0) {
            setDirectionSpeed(0, shell_velocity);
            setCurrentFrameIndex(1);
        }
        if (direction == 90) {
            setDirectionSpeed(90, shell_velocity);
            setCurrentFrameIndex(2);
        }
        if (direction == 180) {
            setDirectionSpeed(180, shell_velocity);
            setCurrentFrameIndex(3);
        }
	}
	
	
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
	}
	/*
        PVector vector;
        for (CollidedTile ct : collidedTiles) {
            if (ct.getTile() instanceof BoardsTile) {
                if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
                    try {
                        world.deleteGameObject(this);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.BOTTOM.equals(ct.getCollisionSide())) {
                    try {
                        world.deleteGameObject(this);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.LEFT.equals(ct.getCollisionSide())) {
                    try {
                        world.deleteGameObject(this);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
                    try {
                        world.deleteGameObject(this);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    */
}




