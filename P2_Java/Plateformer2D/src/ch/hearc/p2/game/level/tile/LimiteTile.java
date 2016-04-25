package ch.hearc.p2.game.level.tile;

import ch.hearc.p2.game.physics.AABoundingRect;

public class LimiteTile extends Tile {

	public LimiteTile(int x, int y, String type) {
		super(x, y, type);
		boundingShape = new AABoundingRect(x * 128, y * 128, 128, 128);
	}

}