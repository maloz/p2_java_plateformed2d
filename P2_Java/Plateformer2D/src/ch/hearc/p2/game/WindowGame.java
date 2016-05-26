package ch.hearc.p2.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ch.hearc.p2.game.menu.GameOver;
import ch.hearc.p2.game.menu.LevelScreenGameState;
import ch.hearc.p2.game.menu.MainScreenGameState;
import ch.hearc.p2.game.menu.PauseGameState;
import ch.hearc.p2.game.state.Level1;
import ch.hearc.p2.game.state.Level2;
import ch.hearc.p2.game.state.Level3;
import ch.hearc.p2.game.state.Level4;
import ch.hearc.p2.game.state.Level5;
import ch.hearc.p2.game.state.Level6;

public class WindowGame extends StateBasedGame {

    public static final int TILE_SIZE = 70;

    public static final int BASE_WINDOW_WIDTH = 1920;
    public static final int BASE_WINDOW_HEIGTH = 1080;

    public static final float CAMERA_TILES_W = BASE_WINDOW_WIDTH / (float) TILE_SIZE;
    public static final float CAMERA_TILES_H = BASE_WINDOW_HEIGTH / (float) TILE_SIZE;

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGTH = 1080;
    public static final boolean FULLSCREEN = true;

    // 1280x720 is our base, we use 70x70
    public static final float SCALE_W = 1 / ((CAMERA_TILES_W * TILE_SIZE) / WINDOW_WIDTH);
    public static final float SCALE_H = 1 / ((CAMERA_TILES_H * TILE_SIZE) / WINDOW_HEIGTH);

    public static final String GAME_NAME = "Platformer 2D";

    public WindowGame() {
	super(GAME_NAME);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {

	// create a level state, this state will do the whole logic and
	// rendering for individual levels
	addState(new MainScreenGameState());
	addState(new Level1("lvl1"));
	addState(new Level2("lvl2"));
	addState(new Level3("lvl3"));
	addState(new Level4("lvl4"));
	addState(new Level5("lvl5"));
	addState(new Level6("lvl6"));
	addState(new PauseGameState());
	addState(new GameOver());
	addState(new LevelScreenGameState());
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