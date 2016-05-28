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

public class LevelScreenGameState extends BasicGameState {

    public static final int ID = 11;
    private Image background;
    private Image niveau1;
    private Image niveau2;
    private Image niveau3;
    private Image niveau4;
    private Image niveau5;
    private Image niveau6;
    private Image retour;
    private Image cursor;

    // Pour les clicks
    private Sound click;
    private Sound rollover;
    private Input i;
    private boolean in;

    private StateBasedGame game;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	retour = new Image("ressources/menu/retour.jpg");
	niveau1 = new Image("ressources/menu/niveaux/niveau1.jpg");
	niveau2 = new Image("ressources/menu/niveaux/niveau2.jpg");
	niveau3 = new Image("ressources/menu/niveaux/niveau3.jpg");
	niveau4 = new Image("ressources/menu/niveaux/niveau4.jpg");
	niveau5 = new Image("ressources/menu/niveaux/niveau5.jpg");
	niveau6 = new Image("ressources/menu/niveaux/niveau6.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");

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
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	int x = (int) (i.getMouseX() * (1 / WindowGame.SCALE_W));
	int y = (int) (i.getMouseY() * (1 / WindowGame.SCALE_H));

	if (x > 550 && x < 550 + niveau1.getWidth() && y > 300 && y < 300 + niveau1.getHeight()) { // Lvl1
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 750 && x < 750 + niveau2.getWidth() && y > 300 && y < 300 + niveau2.getHeight()) { // Lvl2
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 950 && x < 950 + niveau3.getWidth() && y > 300 && y < 300 + niveau3.getHeight()) { // Lvl3
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 1150 && x < 1150 + niveau4.getWidth() && y > 300 && y < 300 + niveau4.getHeight()) { // Lvl4
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 1350 && x < 1350 + niveau5.getWidth() && y > 300 && y < 300 + niveau5.getHeight()) { // Lvl5
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 550 && x < 550 + niveau6.getWidth() && y > 480 && y < 300 + niveau6.getHeight()) { // Lvl6
	    if (in == false)
		rollover.play();
	    in = true;
	} else if (x > 550 && x < 550 + retour.getWidth() && y > 750 && y < 750 + retour.getHeight()) { // RetourAuHome
	    if (in == false)
		rollover.play();
	    in = true;
	} else {
	    in = false;
	}
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	g.scale(WindowGame.SCALE_W, WindowGame.SCALE_H);

	background.draw(0, 0, WindowGame.BASE_WINDOW_WIDTH, WindowGame.BASE_WINDOW_HEIGHT);

	g.drawImage(niveau1, 550, 300);
	g.drawImage(niveau2, 750, 300);
	g.drawImage(niveau3, 950, 300);
	g.drawImage(niveau4, 1150, 300);
	g.drawImage(niveau5, 1350, 300);
	g.drawImage(niveau6, 550, 480);

	g.drawImage(retour, 550, 750);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();

	x *= 1 / WindowGame.SCALE_W;
	y *= 1 / WindowGame.SCALE_H;

	if (x > 550 && x < 550 + niveau1.getWidth() && y > 300 && y < 300 + niveau1.getHeight()) { // Lvl1
	    game.enterState(101);
	} else if (x > 750 && x < 750 + niveau2.getWidth() && y > 300 && y < 300 + niveau2.getHeight()) { // Lvl2
	    game.enterState(102);
	} else if (x > 950 && x < 950 + niveau3.getWidth() && y > 300 && y < 300 + niveau3.getHeight()) { // Lvl3
	    game.enterState(103);
	} else if (x > 1150 && x < 1150 + niveau4.getWidth() && y > 300 && y < 300 + niveau4.getHeight()) { // Lvl4
	    game.enterState(104);
	} else if (x > 1350 && x < 1350 + niveau5.getWidth() && y > 300 && y < 300 + niveau5.getHeight()) { // Lvl5
	    game.enterState(105);
	} else if (x > 550 && x < 550 + niveau6.getWidth() && y > 480 && y < 300 + niveau6.getHeight()) { // Lvl6
	    game.enterState(106);
	} else if (x > 550 && x < 550 + retour.getWidth() && y > 750 && y < 750 + retour.getHeight()) { // RetourAuHome
	    game.enterState(0);
	}
    }

    @Override
    public int getID() {
	return ID;
    }

}