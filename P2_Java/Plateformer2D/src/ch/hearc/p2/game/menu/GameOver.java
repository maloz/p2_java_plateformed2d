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

public class GameOver extends BasicGameState {

    public static final int ID = 40;
    private Image background;
    private Image quitter;
    private StateBasedGame game;
    private Image cursor;
    private Music deadMusic;

    // Pour les clicks
    private Sound click;
    private Sound rollover;
    private Input i;
    private boolean in;

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

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	if (!deadMusic.playing())
	    deadMusic.loop(1, 0.4f);
	container.setMouseCursor(cursor, cursor.getWidth() / 2, cursor.getHeight() / 2);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	background.draw(0, 0, container.getWidth(), container.getHeight());
	g.drawImage(quitter, container.getWidth() / 2 - 200, 500);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	if (i.getMouseX() > this.game.getContainer().getWidth() / 2 - 200
		&& i.getMouseX() < this.game.getContainer().getWidth() / 2 + 200 && i.getMouseY() > 500
		&& i.getMouseY() < 590) {
	    if (in == false)
		rollover.play();
	    in = true;
	} else
	    in = false;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	click.play();
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 500 && y < 590) {
	    game.enterState(0);
	}
    }

    @Override
    public int getID() {
	return ID;
    }
}