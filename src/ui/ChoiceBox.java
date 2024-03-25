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
    private Rectangle choice1Rect;
    private Rectangle choice2Rect;

    public ChoiceBox(int x, int y, int width, int height, Color backgroundColor, Color outlineColor, String message, String choice1, String choice2) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.outlineColor = outlineColor;
        this.message = message;
        this.choice1 = choice1;
        this.choice2 = choice2;
        //choice1Rect = new Rectangle(0,0,0,0);
        //choice2Rect = new Rectangle(0,0,0,0);
    }

    public void drawChoiceBox(Graphics2D g2D) {
        if (getClickable().isEmpty()) {
            int stringWidth = (int) g2D.getFontMetrics().getStringBounds(choice1, g2D).getWidth();
            int stringHeight = (int) g2D.getFontMetrics().getStringBounds(choice1, g2D).getHeight();
            choice1Rect = new Rectangle(x + 35, y, stringWidth, stringHeight);
            getClickable().add(choice1Rect);

            stringWidth = (int) g2D.getFontMetrics().getStringBounds(choice2, g2D).getWidth();
            stringHeight = (int) g2D.getFontMetrics().getStringBounds(choice2, g2D).getHeight();
            choice2Rect = new Rectangle(x + 35, y + 35, stringWidth, stringHeight);
            getClickable().add(choice2Rect);
        }
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);

        g2D.fillRect(choice1Rect.x, choice1Rect.y, choice1Rect.width, choice1Rect.height);
        g2D.drawString(choice1, width, height);
        //Rectangle rect1 =
//        rect1.x = width;
//        rect1.y = height;
//        g2D.drawRect(rect1.x,rect1.y,rect1.width,rect1.height);
        g2D.fillRect(choice2Rect.x, choice2Rect.y, choice2Rect.width, choice2Rect.height);
        g2D.drawString(choice2, width, height + 35);
    }
}
