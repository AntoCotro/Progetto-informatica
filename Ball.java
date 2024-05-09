package Model;

public class Ball {
	private int x, y; // posizione della pallina
	private int speedX, speedY; // velocità della pallina
	private int score1,score2;
	public Ball() {
		x = 250;
		y = 250;
		speedX = 9;
		speedY = 9;
		score1=0;
		score2=0;
	}

	public void move() {
		// muove la pallina
		x += speedX;
		y += speedY;
	}

	public void checkCollisionWithPaddle(Paddle paddle1, Paddle paddle2) {
		if (x <= 20 && y >= paddle1.getY() && y <= paddle1.getY() + 80) {
			speedX = -speedX; // cambia direzione se colpisce la racchetta sinistra
		} else if (x >= 460 && y >= paddle2.getY() && y <= paddle2.getY() + 80) {
			speedX = -speedX; // cambia direzione se colpisce la racchetta destra
		}
	}

	public void checkCollisionWithWall() {
		if (y <= 0 || y >= 480) {
			speedY = -speedY; 
			
		}
		if (x < -10 || x >= 500) {
			speedX = -speedX; 
			if(x < -10) {
				score2++;
			}
			if(x >= 500) {
				score1++;
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isOutOfBounds(int width) {
		return (x < 0 || x > width);
	}


	public int getScore2() {
		return score2;
	}


	public int getScore1() {
		return score1;
	}


}
