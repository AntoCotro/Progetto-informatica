package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Model.Ball;
import Model.Paddle;

public class GameView extends JPanel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private final Ball ball;
	private final Paddle paddle1;
	private final Paddle paddle2;

	public GameView(Ball ball, Paddle paddle1, Paddle paddle2) {
		this.ball = ball;
		this.paddle1 = paddle1;
		this.paddle2 = paddle2;
		setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		int midX = getWidth() / 2;
		int margin = 10; 
		int lineLength = 10;
		int spaceLength = 5;
		for (int y = 0; y < getHeight(); y += lineLength + spaceLength) {
			g.fillRect(midX - 2, y, 4, lineLength);
		}
		g.fillRect(margin, margin, getWidth() - 2 * margin, 4); 
		g.fillRect(margin, getHeight() - margin - 4, getWidth() - 2 * margin, 4); 
		g.fillOval(ball.getX(), ball.getY(), 20, 20);
		g.fillRect(paddle1.getX(), paddle1.getY(), 20, 80);
		g.fillRect(paddle2.getX(), paddle2.getY(), 20, 80);
		//SCORE
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("Player 1: " + ball.getScore1(), 20, 30);
		g.drawString("Player 2: " + ball.getScore2(), 300, 30);
	}

	
	public void updateTimer(int remainingTime) {
	    SwingUtilities.invokeLater(() -> {
	        // Qui puoi aggiungere un'area di testo o un label per visualizzare il timer
	    	
	        repaint();
	    });
	}


}
