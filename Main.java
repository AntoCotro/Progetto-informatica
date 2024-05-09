package Main;

import Controller.GameController;
import Model.Ball;
import Model.Paddle;
import View.Frame;


import javax.swing.*;

// test 
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Ball ball = new Ball();
			Paddle paddle1 = new Paddle(20);
			Paddle paddle2 = new Paddle(460);
			Frame frame=new Frame(ball, paddle1, paddle2);
			GameController controller = new GameController(ball, paddle1, paddle2, frame.getContentPane());
			Thread gameThread = new Thread(() -> {
				while (true) {
					controller.updateGame();
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			});
			gameThread.start();
		});
	}

	
}
