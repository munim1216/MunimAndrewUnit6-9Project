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
        choice1Rect = new Rectangle(width - 20,height - 20, 50,20);
        choice2Rect = new Rectangle(width - 20,height - TEXT_SPACING,50,20);
    }

    public void drawChoiceBox(Graphics2D g2D) {
        g2D.setFont(CAVE_STORY);
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);
        g2D.setColor(Color.BLUE);
        g2D.fillRect(choice1Rect.x, choice1Rect.y, choice1Rect.width, choice1Rect.height);
        g2D.fillRect(choice2Rect.x, choice2Rect.y, choice2Rect.width, choice2Rect.height);
        g2D.setColor(Color.WHITE);
        g2D.drawString(choice1, width, height);
        g2D.drawString(choice2, width, height + TEXT_SPACING);
    }
}
