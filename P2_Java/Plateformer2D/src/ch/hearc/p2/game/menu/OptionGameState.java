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

public class OptionGameState extends BasicGameState {

    public static final int ID = 60;
    private Image res1920x1080;
    private Image res1280x720;
    private Image res1024x768;
    private Image res800x600;
    private Image fullscreen;
    private Image fenetre;
    private Image quitter;
    private Image retour;
    private Image selected;
    private Image background;
    private StateBasedGame game;
    private Image cursor;
    private boolean isResoltionChanged;

    private int y1Selected;
    private int y2Selected;

    // Pour les clicks
    private Sound click;
    private Sound rollover;
    private Input i;
    private boolean in;

    /*------------------------------------------------------------------*\
    |*				Constructeurs			    	*|
    \*------------------------------------------------------------------*/

    public OptionGameState() {
	super();
    }

    /*------------------------------------------------------------------*\
    |*				Methodes Public		 	    	*|
    \*------------------------------------------------------------------*/

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;

	this.background = new Image("ressources/background/background.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");

	res1920x1080 = new Image("ressources/menu/1920_1080.png");
	res1280x720 = new Image("ressources/menu/1280_720.png");
	res1024x768 = new Image("ressources/menu/1024_768.png");
	res800x600 = new Image("ressources/menu/800_600.png");

	fullscreen = new Image("ressources/menu/fullscreen.png");
	fenetre = new Image("ressources/menu/fenetre.png");

	quitter = new Image("ressources/menu/exit.png");
	retour = new Image("ressources/menu/retour.jpg");

	selected = new Image("ressources/menu/selected.gif");

	// Pour les clics
	i = container.getInput();
	in = false;
	click = new Sound("ressources/audio/sound/click.ogg");
	rollover = new Sound("ressources/audio/sound/rollover.ogg");

	isResoltionChanged = false;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);
	placeSelectedIcon();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	g.drawImage(res1920x1080, WindowGame.BASE_WINDOW_WIDTH / 2 - res1920x1080.getWidth() / 2, 25);
	g.drawImage(res1280x720, WindowGame.BASE_WINDOW_WIDTH / 2 - res1280x720.getWidth() / 2, 125);
	g.drawImage(res1024x768, WindowGame.BASE_WINDOW_WIDTH / 2 - res1024x768.getWidth() / 2, 225);
	g.drawImage(res800x600, WindowGame.BASE_WINDOW_WIDTH / 2 - res800x600.getWidth() / 2, 325);

	g.drawImage(fullscreen, WindowGame.BASE_WINDOW_WIDTH / 2 - fullscreen.getWidth() / 2, 425);
	g.drawImage(fenetre, WindowGame.BASE_WINDOW_WIDTH / 2 - fenetre.getWidth() / 2, 525);

	g.drawImage(retour, WindowGame.BASE_WINDOW_WIDTH / 2 - retour.getWidth() / 2, 625);
	if (isResoltionChanged)
	    g.drawImage(quitter, WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2, 725);

	g.drawImage(selected, WindowGame.BASE_WINDOW_WIDTH / 2 + 220, y1Selected);
	g.drawImage(selected, WindowGame.BASE_WINDOW_WIDTH / 2 + 220, y2Selected);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	int x = (int) (i.getMouseX() * (1 / WindowGame.SCALE_W));
	int y = (int) (i.getMouseY() * (1 / WindowGame.SCALE_H));

	// Bouton quitter
	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1920x1080.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1920x1080.getWidth() / 2 && y > 25
		&& y < 25 + res1920x1080.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	}
	// Bouton reprendre
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1280x720.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1280x720.getWidth() / 2 && y > 125
		&& y < 125 + res1280x720.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1024x768.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1024x768.getWidth() / 2 && y > 225
		&& y < 225 + res1024x768.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res800x600.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res800x600.getWidth() / 2 && y > 325
		&& y < 325 + res800x600.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - fullscreen.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + fullscreen.getWidth() / 2 && y > 425
		&& y < 425 + fullscreen.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - fenetre.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + fenetre.getWidth() / 2 && y > 525
		&& y < 525 + fenetre.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - retour.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + retour.getWidth() / 2 && y > 625
		&& y < 625 + retour.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;

	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 725
		&& y < 725 + quitter.getHeight()) {
	    if (isResoltionChanged) {
		if (in == false)
		    rollover.play();
		in = true;
	    }

	} else {
	    in = false;
	}
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();

	x *= 1 / WindowGame.SCALE_W;
	y *= 1 / WindowGame.SCALE_H;

	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1920x1080.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1920x1080.getWidth() / 2 && y > 25
		&& y < 25 + res1920x1080.getHeight()) {
	    changeResolution(1920, 1080);
	    isResoltionChanged = true;
	    y1Selected = 25;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1280x720.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1280x720.getWidth() / 2 && y > 125
		&& y < 125 + res1280x720.getHeight()) {
	    changeResolution(1280, 720);
	    isResoltionChanged = true;
	    y1Selected = 125;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res1024x768.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res1024x768.getWidth() / 2 && y > 225
		&& y < 225 + res1024x768.getHeight()) {
	    changeResolution(1024, 768);
	    isResoltionChanged = true;
	    y1Selected = 225;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - res800x600.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + res800x600.getWidth() / 2 && y > 325
		&& y < 325 + res800x600.getHeight()) {
	    changeResolution(800, 600);
	    isResoltionChanged = true;
	    y1Selected = 325;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - fullscreen.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + fullscreen.getWidth() / 2 && y > 425
		&& y < 425 + fullscreen.getHeight()) {
	    changeADisplay(true);
	    y2Selected = 425;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - fenetre.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + fenetre.getWidth() / 2 && y > 525
		&& y < 525 + fenetre.getHeight()) {
	    changeADisplay(false);
	    y2Selected = 525;
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - retour.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + retour.getWidth() / 2 && y > 625
		&& y < 625 + retour.getHeight()) {
	    game.enterState(0);
	} else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 725
		&& y < 725 + quitter.getHeight()) {
	    if (isResoltionChanged)
		System.exit(0);
	}
    }

    /*------------------------------*\
    |*		Get		    *|
    \*------------------------------*/

    @Override
    public int getID() {
	return ID;
    }

    /*------------------------------------------------------------------*\
    |*				Methodes Private		   	*|
    \*------------------------------------------------------------------*/

    private void placeSelectedIcon() {
	switch (WindowGame.WINDOW_WIDTH) {
	case 1920:
	    y1Selected = 25;
	    break;
	case 1280:
	    y1Selected = 125;
	    break;
	case 1024:
	    y1Selected = 225;
	    break;
	case 800:
	    y1Selected = 325;
	    break;

	default:
	    y1Selected = 25;
	    break;
	}

	if (WindowGame.FULLSCREEN)
	    y2Selected = 425;
	else
	    y2Selected = 525;
    }

    private void changeADisplay(Boolean b) {
	WindowGame.PREFERENCES.putBoolean("fullscreen", b);
    }

    private void changeResolution(int w, int h) {
	WindowGame.PREFERENCES.putInt("width", w);
	WindowGame.PREFERENCES.putInt("height", h);
    }
}