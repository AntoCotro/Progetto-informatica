package Controller;

import Model.Ball;
import Model.Paddle;
import View.GameView;

public class GameController {
    private final Ball ball;
    private final Paddle paddle1;
    private final Paddle paddle2;
    private final GameView view;
    private int remainingTime = 60; // Tempo rimanente in secondi

    public GameController(Ball ball, Paddle paddle1, Paddle paddle2, GameView view) {
        this.ball = ball;
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.view = view;
  
    }

   /* private void startGameTimer() {
        timerThread = new Thread(() -> {
            try {
                while (remainingTime > 0) {
                    Thread.sleep(1000); 
                    remainingTime--;
                    view.updateTimer(remainingTime);
                    if (remainingTime == 0) {
                        endGame();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        timerThread.start();
    }*/

   /* private void endGame() {
        System.out.println("Game Over! Final Score - Player 1: " + scorePlayer1 + ", Player 2: " + scorePlayer2);
    }*/

    public void updateGame() {
        if (remainingTime <= 0) return; // Non aggiornare il gioco se il tempo è scaduto

        ball.move();
        ball.checkCollisionWithPaddle(paddle1, paddle2);
        ball.checkCollisionWithWall();

        
        if (paddle1.isMovingUp()) {
            paddle1.moveUp();
        } else if (paddle1.isMovingDown()) {
            paddle1.moveDown();
        }
        
        if (paddle2.isMovingUp()) {
            paddle2.moveUp();
        } else if (paddle2.isMovingDown()) {
            paddle2.moveDown();
        }

        view.repaint();
    }
}
