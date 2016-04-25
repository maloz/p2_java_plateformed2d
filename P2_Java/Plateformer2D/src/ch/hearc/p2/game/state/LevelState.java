package ch.hearc.p2.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ch.hearc.p2.game.WindowGame;
import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.controller.MouseAndKeyBoardPlayerController;
import ch.hearc.p2.game.controller.PlayerController;
import ch.hearc.p2.game.hud.Hud;
import ch.hearc.p2.game.level.Level;
import ch.hearc.p2.game.level.object.Objective;
import ch.hearc.p2.game.physics.Physics;

public class LevelState extends BasicGameState {

    private Level level;
    private String startinglevel;
    private Player player;
    private PlayerController playerController;
    private Physics physics;
    private StateBasedGame sbg;
    private Hud hud;
    
    public LevelState(String startingLevel){
        this.startinglevel = startingLevel;
    }
    
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        
        this.sbg = sbg;
        
        initialisation();        

    }
    
    public void initialisation() throws SlickException 
    {
	 hud = new Hud();
         //at the start of the game we don't have a player yet
         player = new Player(128,200);
        
       //once we initialize our level, we want to load the right level
         level = new Level(startinglevel, player);
         
         //and we create a controller, for now we use the MouseAndKeyBoardPlayerController
         playerController = new MouseAndKeyBoardPlayerController(player);
         
         physics = new Physics(startinglevel);
         
         level.addLevelObject(new Objective(400,70));
         level.addLevelObject(new Objective(500,70));
         level.addLevelObject(new Objective(600,70));
         level.addLevelObject(new Objective(700,70));
         level.addLevelObject(new Objective(800,70));
         level.addLevelObject(new Objective(1200,70));
         
         hud.init();
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        //every update we have to handle the input from the player
        playerController.handleInput(container.getInput(), delta);
        physics.handlePhysics(level, delta);
    }
    
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        g.scale(WindowGame.SCALE, WindowGame.SCALE);
        //render the level
        level.render();
        hud.render(g, player);
        if(player.getLife() == 0)
        {
        	g.drawString("TU AS PERDU", 950, 500);
        	initialisation();                
                sbg.enterState(1); 
        }
        
        /*for(Tile t : player.getBoundingShape().getGroundTiles(level.getTiles())){
            g.setColor(new Color(255,130,90,200));
            g.drawRect(t.getX()*128, t.getY()*128, 128, 128);
        }*/
    }
    
    //this method is overriden from basicgamestate and will trigger once you press any key on your keyboard
    public void keyPressed(int key, char code){
        //if the key is escape, close our application
      
    }
    public void keyReleased(int key, char code)
    {
    	  if(key == Input.KEY_ESCAPE){
          	sbg.enterState(1);   
          }
    }

    public int getID() {
        //this is the id for changing states
        return 0;
    }

}