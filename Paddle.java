package Model;

public class Paddle {
	private int y; // posizione del pannello
	private final int x; // posizione fissa del pannello
	private boolean movingUp;
	private boolean movingDown;

	public Paddle(int x) {
		this.x = x;
		y = 200;
	}

	public void moveUp() {
		if (y > 0) {
			y -= 5;
		}
	}

	public void moveDown() {
		if (y < 420) {
			y += 5;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}
}
