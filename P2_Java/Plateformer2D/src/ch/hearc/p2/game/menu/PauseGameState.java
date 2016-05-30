package ch.hearc.p2.game.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ch.hearc.p2.game.WindowGame;
import ch.hearc.p2.game.state.LevelState;

public class PauseGameState extends BasicGameState {

    public static final int ID = 50;
    public static int ID_Last;

    private SlickButton quitter;
    private SlickButton reprendre;

    private Image background;
    private Image cursor;

    private Sound rollover;

    /*------------------------------------------------------------------*\
    |*				Constructeurs			    	*|
    \*------------------------------------------------------------------*/

    public PauseGameState() {
	super();
    }

    /*------------------------------------------------------------------*\
    |*				Methodes Public		 	    	*|
    \*------------------------------------------------------------------*/

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	// Sound
	rollover = new Sound("ressources/audio/sound/rollover.ogg");

	// Background image
	background = new Image("ressources/background/background.jpg");

	// Cursor image
	cursor = new Image("ressources/cursor/hand_cursor.png");

	// Color for button when mous is over
	Color color = new Color(255, 157, 67, 180);

	// Button "Quitter"
	Image quitterImage = new Image("ressources/menu/quitter.png");

	quitter = new SlickButton(container, quitterImage,
		WindowGame.BASE_WINDOW_WIDTH / 2 - quitterImage.getWidth() / 2, 250, quitterImage.getWidth(),
		quitterImage.getHeight(), new ComponentListener() {

		    @Override
		    public void componentActivated(AbstractComponent arg0) {
			try {
			    ((LevelState) game.getState(ID_Last)).initialisation();
			} catch (SlickException e) {
			    System.err.println("Probl�me pour quitter le level.");
			    e.printStackTrace();
			}
			game.enterState(0);
		    }
		});

	quitter.setMouseOverColor(color);
	quitter.setMouseDownSound(rollover);

	// Button "Reprendre"
	Image reprendreImage = new Image("ressources/menu/reprendre.png");

	reprendre = new SlickButton(container, reprendreImage,
		WindowGame.BASE_WINDOW_WIDTH / 2 - reprendreImage.getWidth() / 2, 400, reprendreImage.getWidth(),
		reprendreImage.getHeight(), new ComponentListener() {

		    @Override
		    public void componentActivated(AbstractComponent arg0) {
			game.enterState(ID_Last);
		    }
		});

	reprendre.setMouseOverColor(color);
	reprendre.setMouseDownSound(rollover);

    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	quitter.render(container, g);
	reprendre.render(container, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	// empty
    }

    /*------------------------------*\
    |*		Get		    *|
    \*------------------------------*/

    @Override
    public int getID() {
	return ID;
    }

    /*------------------------------*\
    |*		Set		    *|
    \*------------------------------*/

    public static void setID_Last(int id) {
	ID_Last = id;
    }

}