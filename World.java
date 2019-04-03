package OOPG_Tank_game_Rein;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.View;

public class World extends GameEngine {
    public Player player1;
    public Player player2;
    public Shell shell1;
    public Shell shell2;
    // Deze regel maakt het makkelijker om te refereren naar je plaatjes.
    public static String MEDIA_URL = "src/main/java/OOPG_Tank_game_Rein/media/";
    
    public static void main(String[] args) {
    	World tw = new World();
        tw.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1000;
        int worldHeight = 1000;
        initializeTileMap();
        // uiteraard kan je het toevoegen van
        // nieuwe game objects misschien het beste
        // in een aparte methode doen
        // i.p.v. de update zo groot te maken.
        player1 = new Player(this, 1);
        player2 = new Player(this, 2);     
       
        addGameObject(player1, 200, 200);
        addGameObject(player2, 400, 400);
        View view = new View(worldWidth, worldHeight);

        setView(view);
        size(worldWidth, worldHeight);
       // view.setBackground(loadImage(HelloWorld.MEDIA_URL.concat("Background1.bmp")));
      
    }

    private void initializeTileMap() {
        /* TILES */
        Sprite boardsSprite = new Sprite (World.MEDIA_URL.concat("Wall2.png"));
       
        TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);

        TileType[] tileTypes = {boardTileType};
        int tileSize = 50;
        int tilesMap[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0, 0, 0, 0, 0 , 0, 0,0 },
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1,-1, -1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1,-1, -1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1,-1, -1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1,-1,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0, 0, 0, 0, 0, 0, 0,0  }
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }

    @Override
    public void update() {
    }

    /**
     * Vernieuwt het dashboard
     */
    private void refreshDasboardText() {
       // dashboardText.setText("Bubbles popped: " + bubblesPopped);
    }


}