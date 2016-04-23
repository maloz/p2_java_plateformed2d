package ch.hearc.p2.game.level.object;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;

public class Objective extends LevelObject {

	protected Animation animation;

	public Objective(float x, float y) throws SlickException {
		super(x, y);

		// add the right animation for this objective
		animation = new Animation(new Image[] { new Image("data/img/objects/scrap_part/scrap_part_1.png"),
				new Image("data/img/objects/scrap_part/scrap_part_2.png"),
				new Image("data/img/objects/scrap_part/scrap_part_3.png"),
				new Image("data/img/objects/scrap_part/scrap_part_4.png") }, new int[] { 200, 125, 125, 200 });
		animation.setPingPong(true);

		// we will just keep the default boundingrect of 32x32 for the objective
	}

	public void render(float offset_x, float offset_y) {
		animation.draw(x - 2 - offset_x, y - 2 - offset_y);
	}

}