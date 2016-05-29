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

import ch.hearc.p2.game.WindowGame;

public class GameOver extends BasicGameState {

    public static final int ID = 40;

    private Image background;
    private Image quitter;

    private StateBasedGame game;

    private Image cursor;

    private Music deadMusic;

    private Sound click;
    private Sound rollover;

    private Input i;

    private boolean in;

    /*------------------------------------------------------------------*\
    |*				Constructeurs			    	*|
    \*------------------------------------------------------------------*/

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");
	quitter = new Image("ressources/menu/quitter.png");
	deadMusic = new Music("ressources/audio/music/gameover.ogg");

	// Pour les clics
	i = container.getInput();
	in = false;
	click = new Sound("ressources/audio/sound/click.ogg");
	rollover = new Sound("ressources/audio/sound/rollover.ogg");

    }

    /*------------------------------------------------------------------*\
    |*				Methodes Public		 	    	*|
    \*------------------------------------------------------------------*/

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	if (!deadMusic.playing())
	    deadMusic.loop(1, 0.4f);
	container.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	g.drawImage(quitter, WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2, 500);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	int x = (int) (i.getMouseX() * (1 / WindowGame.SCALE_W));
	int y = (int) (i.getMouseY() * (1 / WindowGame.SCALE_H));

	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 500
		&& y < 500 + quitter.getHeight()) {
	    if (in == false)
		rollover.play();
	    in = true;
	} else {
	    in = false;
	}
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();

	x *= 1 / WindowGame.SCALE_W;
	y *= 1 / WindowGame.SCALE_H;

	if (x > WindowGame.BASE_WINDOW_WIDTH / 2 - quitter.getWidth() / 2
		&& x < WindowGame.BASE_WINDOW_WIDTH / 2 + quitter.getWidth() / 2 && y > 500
		&& y < 500 + quitter.getHeight()) {
	    game.enterState(0);
	}
    }

    @Override
    public int getID() {
	return ID;
    }
}