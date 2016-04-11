package ch.hearc.p2.game.level;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ch.hearc.p2.game.character.Character;

public class Level {

	private TiledMap map;

	// a list of all characters present somewhere on this map
	private ArrayList<Character> characters;

	public Level(String level) throws SlickException {
		map = new TiledMap("dataTuto/img/levels/" + level + ".tmx");
		characters = new ArrayList<Character>();
	}

	public void addCharacter(Character c) {
		characters.add(c);
	}

	public void render() {
		map.render(0, 0, 0, 0, 32, 18);

		// and then render the characters on top of the map
		for (Character c : characters) {
			c.render();
		}
	}

}