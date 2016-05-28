package ch.hearc.p2.game.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import ch.hearc.p2.game.WindowGame;

public class MainScreenGameState extends BasicGameState {

    public static final int ID = 0;
    private Image background;
    private Image jouer;
    private Image niveaux;
    private Image options;
    private Image credits;
    private Image quitter;
    private Image cursor;
    private StateBasedGame game;
    private Music sound;

    // Pour les clicks
    private Sound click;
    private Sound rollover;
    private Input i;
    private boolean in;

    public MainScreenGameState() {
	super();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");
	jouer = new Image("ressources/menu/jouer.png");
	niveaux = new Image("ressources/menu/niveaux.png");
	options = new Image("ressources/menu/options.png");
	credits = new Image("ressources/menu/credits.png");
	quitter = new Image("ressources/menu/quitter.png");

	// Pour les clics
	i = container.getInput();
	in = false;
	sound = new Music("ressources/audio/music/home.ogg");
	click = new Sound("ressources/audio/sound/click.ogg");
	rollover = new Sound("ressources/audio/sound/rollover.ogg");

    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);

	if (sound.playing() == false)
	    sound.loop(1, 0.4f);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	int x = (int) (i.getMouseX() * (1 / WindowGame.SCALE_W));
	int y = (int) (i.getMouseY() * (1 / WindowGame.SCALE_H));

	// Menu - jouer
	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - jouer.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + jouer.getWidth() / 2 && y > 250
		&& y < 250 + jouer.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	}

	// Menu - niveau
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - niveaux.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + niveaux.getWidth() / 2 && y > 400
		&& y < 400 + niveaux.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	}

	// Menu - options
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - options.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + options.getWidth() / 2 && y > 550
		&& y < 550 + options.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	}

	// Menu - quitter
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 700
		&& y < 700 + quitter.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	} else
	    in = false;
    }

    /**
     * Contenons nous d'afficher l'image de fond. Le text est placé
     * approximativement au centre.
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	g.drawImage(jouer, WindowGame.BASE_WINDOW_WIDTH / 2 - jouer.getWidth() / 2, 250);
	g.drawImage(niveaux, WindowGame.BASE_WINDOW_WIDTH / 2 - niveaux.getWidth() / 2, 400);
	g.drawImage(options, WindowGame.BASE_WINDOW_WIDTH / 2 - options.getWidth() / 2, 550);
	g.drawImage(quitter, WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2, 700);

    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();

	x *= 1 / WindowGame.SCALE_W;
	y *= 1 / WindowGame.SCALE_H;

	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - jouer.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + jouer.getWidth() / 2 && y > 250
		&& y < 250 + jouer.getHeight()) {

	    game.enterState(101, new FadeOutTransition(), new FadeInTransition());
	    // game.enterState(101, new FadeOutTransition(), new
	    // BlobbyTransition(new Color(255,255,255)));
	    // Remove l'ancien state et le replace pour un nouveau pour reset
	    // l'état du lvl
	}

	// Menu - niveau
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - niveaux.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + niveaux.getWidth() / 2 && y > 400
		&& y < 400 + niveaux.getHeight()) {
	    game.enterState(11);
	}

	// Menu - options
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - options.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + options.getWidth() / 2 && y > 550
		&& y < 550 + options.getHeight()) {
	    game.enterState(60);
	}

	// Menu - quitter
	else if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 700
		&& y < 700 + quitter.getHeight()) {
	    System.exit(0);
	}
    }

    /**
     * L'identifiant permet d'identifier les différentes boucles. Pour passer de
     * l'une à l'autre.
     */
    @Override
    public int getID() {
	return ID;
    }

}