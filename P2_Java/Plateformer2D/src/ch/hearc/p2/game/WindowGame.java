package ch.hearc.p2.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ch.hearc.p2.game.menu.GameOver;
import ch.hearc.p2.game.menu.LevelScreen1GameState;
import ch.hearc.p2.game.menu.LevelScreen2GameState;
import ch.hearc.p2.game.menu.MainScreenGameState;
import ch.hearc.p2.game.menu.PauseGameState;
import ch.hearc.p2.game.state.Level1;
import ch.hearc.p2.game.state.Level10;
import ch.hearc.p2.game.state.Level2;
import ch.hearc.p2.game.state.Level3;
import ch.hearc.p2.game.state.Level4;
import ch.hearc.p2.game.state.Level5;
import ch.hearc.p2.game.state.Level6;
import ch.hearc.p2.game.state.Level7;
import ch.hearc.p2.game.state.Level8;
import ch.hearc.p2.game.state.Level9;

public class WindowGame extends StateBasedGame {

    // set the window width and then the height according to a aspect ratio
    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGTH = 1080;
    public static final boolean FULLSCREEN = true;

    // 1280x720 is our base, we use 32x32 tiles but we want it to be 40x40 at
    // 1280x720
    // so our base scale is not 1 but 1.25 actually
    public static final float SCALE = (float) 1;
    public static final String GAME_NAME = "Gravity Platformer";

    public WindowGame() {
	super(GAME_NAME);
    }

    public void initStatesList(GameContainer gc) throws SlickException {

	// create a level state, this state will do the whole logic and
	// rendering for individual levels
	addState(new MainScreenGameState());
	addState(new Level1("lvl1"));
	addState(new Level2("lvl2"));
	addState(new PauseGameState());
	addState(new GameOver());
	// addState(new Level3("lvl3"));
	// addState(new Level4("lvl4"));
	// addState(new Level5("lvl5"));
	// addState(new Level6("lvl6"));
	// addState(new Level7("lvl7"));
	// addState(new Level8("lvl8"));
	// addState(new Level9("lvl9"));
	// addState(new Level10("lvl10"));
	addState(new LevelScreen1GameState());
	addState(new LevelScreen2GameState());
    }

    public static void main(String[] args) throws SlickException {
	AppGameContainer app = new AppGameContainer(new WindowGame());

	// set the size of the display to the width and height and fullscreen or
	// not
	app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGTH, FULLSCREEN);
	app.setShowFPS(true);
	// this will attempt to create a framerate of approximately 60 frames
	// per second
	// app.setTargetFrameRate(100);

	app.start();
    }

}