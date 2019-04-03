package OOPG_Tank_game_Rein;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Player extends AnimatedSpriteObject  implements ICollidableWithTiles, ICollidableWithGameObjects    {

    final int size= 60;
    private int playerNumber;
    private final World world;
    private int xSpawnShell1;
    private int ySpawnShell1;
    private int xSpawnShell2;
    private int ySpawnShell2;
    public int health;
    /**
     * Constructor
     *
     * @param world Referentie naar de wereld
     */
    public Player(World world, int number) {
    	//super(new Sprite(HelloWorld.MEDIA_URL.concat("Tank1-R.png"));
    	super(new Sprite(World.MEDIA_URL.concat("Tank_blue_heavy_strip60.png")), 60);
        this.world = world;
        this.playerNumber = number;
        this.xSpawnShell1 = 66;
        this.ySpawnShell1 = 20;
        this.xSpawnShell2 = 66;
        this.ySpawnShell2 = 20;
        this.health = 10;
        setCurrentFrameIndex(0);
        setFriction(0.1F);
    }

    @Override
    public void update() {
        if (getX() <= 0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY() <= 0) {
            setySpeed(0);
            setY(0);
        }
        if (getX() >= world.width - size) {
            setxSpeed(0);
            setX(world.width - size);
        }
        if (getY() >= world.height - size) {
            setySpeed(0);
            setY(world.height - size);
        }
        if (this.health < 1) {
        	world.deleteGameObject(this);
        }
    }
// test
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if(this.playerNumber == 1) {
        	 if (keyCode == world.LEFT) {       					
                 setDirectionSpeed(270, speed);
                 setCurrentFrameIndex(30);
                 this.xSpawnShell1 = -26;
                 this.ySpawnShell1 = 20;
             }             
             if (keyCode == world.UP) {
                 setDirectionSpeed(0, speed);
                 setCurrentFrameIndex(15);
                 this.xSpawnShell1 = 20;
                 this.ySpawnShell1 = -26;
             }
             if (keyCode == world.RIGHT) {
                 setDirectionSpeed(90, speed);
                 setCurrentFrameIndex(0);
                 this.xSpawnShell1 = 66;
                 this.ySpawnShell1 = 20;
             }
             if (keyCode == world.DOWN) {
                 setDirectionSpeed(180, speed);
                 setCurrentFrameIndex(45);
                 this.xSpawnShell1 = 20;
                 this.ySpawnShell1 = 66;
             }
             if (key == ' ') {
                 System.out.println("Spatie!"+getX()+getY());
                 world.shell1 = new Shell(world, 1, getDirection(), 7);
                 world.addGameObject(world.shell1, getX()+this.xSpawnShell1, getY()+this.ySpawnShell1);
             }
        } else if(this.playerNumber == 2) {
        	if (key == 'a') {       					
                setDirectionSpeed(270, speed);
                setCurrentFrameIndex(30);
                this.xSpawnShell2 = -26;
                this.ySpawnShell2 = 20;
        	}
            if (key == 'w') {
                setDirectionSpeed(0, speed);
                setCurrentFrameIndex(15);
                this.xSpawnShell2 = 20;
                this.ySpawnShell2 = -26;
            }
            if (key == 'd') {
                setDirectionSpeed(90, speed);
                setCurrentFrameIndex(0);
                this.xSpawnShell2 = 66;
                this.ySpawnShell2 = 20;
            }
            if (key == 's') {
                setDirectionSpeed(180, speed);
                setCurrentFrameIndex(45);
                this.xSpawnShell2 = 20;
                this.ySpawnShell2 = 66;
            }
            if (key == 'z') {
                System.out.println("Spatie!");
                world.shell2 = new Shell(world, 2, getDirection(), 15);
                world.addGameObject(world.shell2, getX()+this.xSpawnShell2, getY()+this.ySpawnShell2);
            }
        }
    }


	

	@Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        PVector vector;

        for (CollidedTile ct : collidedTiles) {
            if (ct.getTile() instanceof BoardsTile) {
                if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.getTile());
                        setY(vector.y - getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.BOTTOM.equals(ct.getCollisionSide())) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.getTile());
                        setY(vector.y + getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.LEFT.equals(ct.getCollisionSide())) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.getTile());
                        setX(vector.x - getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.getTile());
                        setX(vector.x + getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
	}
	
	@Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g : collidedGameObjects) {
        	if (g instanceof Player) {
            }
        	
        	if(g instanceof Shell) {
	            if (((Shell) g).playerNumber != this.playerNumber) {
	            	this.health--;
	            	System.out.println("hit health(speler"+playerNumber+"): "+health);
	            	world.deleteGameObject(g);
	            }				
        	}
        }
	}
}
