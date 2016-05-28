package ch.hearc.p2.game.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ch.hearc.p2.game.WindowGame;
import ch.hearc.p2.game.state.LevelState;

public class PauseGameState extends BasicGameState {

    public static final int ID = 50;
    public static int ID_Last;
    private Image background;
    private Image quitter;
    private Image reprendre;
    private StateBasedGame game;
    private Image cursor;

    // Pour les clicks
    private Sound click;
    private Sound rollover;
    private Input i;
    private boolean in;

    public PauseGameState() {
	super();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");
	quitter = new Image("ressources/menu/quitter.png");
	reprendre = new Image("ressources/menu/reprendre.png");

	// Pour les clics
	i = container.getInput();
	in = false;
	click = new Sound("ressources/audio/sound/click.ogg");
	rollover = new Sound("ressources/audio/sound/rollover.ogg");

    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	g.drawImage(quitter, WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2, 250);
	g.drawImage(reprendre, WindowGame.BASE_WINDOW_WIDTH / 2 - reprendre.getWidth() / 2, 400);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	int x = (int) (i.getMouseX() * (1 / WindowGame.SCALE_W));
	int y = (int) (i.getMouseY() * (1 / WindowGame.SCALE_H));

	// Bouton quitter
	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 250
		&& y < 250 + quitter.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	}
	// Bouton reprendre
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - reprendre.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + reprendre.getWidth() / 2 && y > 400
		&& y < 400 + reprendre.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else
	    in = false;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();

	x *= 1 / WindowGame.SCALE_W;
	y *= 1 / WindowGame.SCALE_H;

	// Bouton quitter
	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 250
		&& y < 250 + quitter.getHeight()) {
	    try {
		((LevelState) game.getState(ID_Last)).initialisation();
	    } catch (SlickException e) {
		System.err.println("Problème pour quitter le level.");
		e.printStackTrace();
	    }
	    game.enterState(0);
	}
	// Bouton reprendre
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - reprendre.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + reprendre.getWidth() / 2 && y > 400
		&& y < 400 + reprendre.getHeight()) {
	    game.enterState(ID_Last);
	}
    }

    @Override
    public int getID() {
	return ID;
    }

    public static void setID_Last(int id) {
	ID_Last = id;
    }

}