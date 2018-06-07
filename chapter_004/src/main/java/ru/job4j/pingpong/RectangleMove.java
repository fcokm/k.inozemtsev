package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int x = 1;
        int y = 1;
        while (true) {
            if ((this.rect.getY() == 290)) y--;
            if ((this.rect.getY() == 0)) y++;
            if ((this.rect.getX() == 290)) x--;
            if ((this.rect.getX() == 0)) x++;
            this.rect.setX(this.rect.getX() + x);
            this.rect.setY(this.rect.getY() + y);
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}