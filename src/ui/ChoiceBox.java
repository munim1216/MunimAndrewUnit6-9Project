package ui;

import java.awt.*;

public class ChoiceBox extends BaseUI {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color backgroundColor;
    private Color outlineColor;
    private String message;
    private String choice1;
    private String choice2;
    public ChoiceBox(int x, int y, int width, int height, Color backgroundColor, Color outlineColor, String message, String choice1, String choice2) {

    }

    public void drawChoiceBox(Graphics2D g2D, ) {
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);
        g2D.drawString(choice1, width, height);
        Rectangle a = (Rectangle) g2D.getFontMetrics().getStringBounds(choice1, g2D);
        //Rectangle rect1 =
//        rect1.x = width;
//        rect1.y = height;
//        g2D.drawRect(rect1.x,rect1.y,rect1.width,rect1.height);
        g2D.drawString(choice2, width, height + 30);
    }
}
