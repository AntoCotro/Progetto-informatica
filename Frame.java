package View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Model.Ball;
import Model.Paddle;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GameView contentPane;

	public Frame(Ball ball, Paddle paddle1, Paddle paddle2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new GameView(ball, paddle1, paddle2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JFrame frame = new JFrame("Ping Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(contentPane);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				handleKeyPress(e, paddle1, paddle2);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				handleKeyRelease(e, paddle1, paddle2);
			}
		});
	}
	private static void handleKeyPress(KeyEvent e, Paddle paddle1, Paddle paddle2) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			paddle1.setMovingUp(true);
			break;
		case KeyEvent.VK_S:
			paddle1.setMovingDown(true);
			break;
		case KeyEvent.VK_UP:
			paddle2.setMovingUp(true);
			break;
		case KeyEvent.VK_DOWN:
			paddle2.setMovingDown(true);
			break;
		}
	}

	private static void handleKeyRelease(KeyEvent e, Paddle paddle1, Paddle paddle2) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			paddle1.setMovingUp(false);
			break;
		case KeyEvent.VK_S:
			paddle1.setMovingDown(false);
			break;
		case KeyEvent.VK_UP:
			paddle2.setMovingUp(false);
			break;
		case KeyEvent.VK_DOWN: 
			paddle2.setMovingDown(false);
			break;
		}
	}
	
	public GameView getContentPane() {
		return contentPane;
	}
}

