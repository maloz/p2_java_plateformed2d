package ch.hearc.p2.game.state;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import ch.hearc.p2.game.WindowGame;
import ch.hearc.p2.game.character.Abeille;
import ch.hearc.p2.game.character.Character;
import ch.hearc.p2.game.character.Ennemie;
import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.controller.MouseAndKeyBoardPlayerController;
import ch.hearc.p2.game.controller.PlayerController;
import ch.hearc.p2.game.hud.Hud;
import ch.hearc.p2.game.level.Level;
import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.level.object.Objective;
import ch.hearc.p2.game.menu.PauseGameState;
import ch.hearc.p2.game.physics.Physics;
import ch.hearc.p2.game.weapon.Weapon;

public class Level2 extends BasicGameState {

    private Level level;
    private String startinglevel;
    private Player player;
    private PlayerController playerController;
    private Physics physics;
    private StateBasedGame sbg;
    private Hud hud;
    private int timer; //DEBUG

    ArrayList<Ennemie> ennemies;
    ArrayList<Objective> objectives;

    private Weapon weapon;

    public static final int ID = 102;

    public Level2(String startingLevel) {
	this.startinglevel = startingLevel;
    }

    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {

	this.sbg = sbg;
	initialisation();

    }

    public void initialisation() throws SlickException {

	ennemies = new ArrayList<Ennemie>();
	objectives = new ArrayList<Objective>();
	player = new Player(128, 650);
	/*
	 * Ici, ajout des ennemies et objectifs. Ex: 
	 * ennemies.add(new Abeille(1800, 200));
	 * objectives.add(new Objective(150, 150));
	 */
	
	hud = new Hud();
	weapon = player.getWeapon();

	level = new Level(startinglevel, player);

	playerController = new MouseAndKeyBoardPlayerController(player, level);

	physics = new Physics(startinglevel);

	for (Ennemie e : ennemies) {
	    level.addCharacter(e);
	}
	for (Objective o : objectives) {
	    level.addLevelObject(o);
	}

	level.addLevelObject(weapon);

	hud.init();
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
	// Pour g�rer les entr�es clavier
	playerController.handleInput(container.getInput(), delta);

	// Pour g�rer la physique
	physics.handlePhysics(level, delta);

	// Pour que l'arme suive le perso
	weapon.setX(player.getX() + 80);
	weapon.setY(player.getY() + 165);

	// Pour voir si le player a tir� (donc si l'arme doit tirer) et ajouter les projectiles au niveau
	List<LevelObject> toAdd = weapon.getToAddList();
	for (LevelObject obj : toAdd) {
	    level.addLevelObject(obj);
	}
	weapon.clearList();

	// Pour g�rer les ennemies
	for (Ennemie e : ennemies) {
	    List<LevelObject> toAddList = e.getToAddList();
	    for (LevelObject obj : toAddList) {
		level.addLevelObject(obj);
	    }
	    e.clearList();

	    if (e instanceof Abeille) {
		if (timer % 4000 == 0) {
		    ((Abeille) e).moveRandom();
		    e.shoot();
		}
	    }
	}

	// Pour voir si le player est pas mort
	if (player.getLife() <= 0) {
	    initialisation();
	    sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
	}

	// Pour enlever les ennemies morts
	ArrayList<Character> removeQueueC = new ArrayList<Character>();
	for (Ennemie e : ennemies) {

	    if (e.getLife() <= 0) {
		removeQueueC.add(e);
	    }
	}
	ennemies.removeAll(removeQueueC);
	level.removeCharacter(removeQueueC);

	// Pour voir si le niveau est fini
	if (physics.isOver() == true) {
	    // System.out.println("Level finished, loading lvl2");
	    sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
	    initialisation();
	}

	timer++;

    }

    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE, WindowGame.SCALE);
	// render the level

	level.render();
	hud.render(g, player);

	/*
	 * for(Tile t :
	 * player.getBoundingShape().getGroundTiles(level.getTiles())){
	 * g.setColor(new Color(255,130,90,200)); g.drawRect(t.getX()*128,
	 * t.getY()*128, 128, 128); }
	 */
    }

    // this method is overriden from basicgamestate and will trigger once you
    // press any key on your keyboard
    public void keyPressed(int key, char code) {
	// if the key is escape, close our application

    }

    public void keyReleased(int key, char code) {
	if (key == Input.KEY_ESCAPE) {
	    PauseGameState.setID(ID);
	    sbg.enterState(50);
	}
    }

    public int getID() {
	// this is the id for changing states
	return ID;
    }

}