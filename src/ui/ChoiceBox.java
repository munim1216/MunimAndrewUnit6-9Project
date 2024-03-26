package ui;

import main.GamePanel;

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

    public ChoiceBox(Color backgroundColor, Color outlineColor, String message, String choice1, String choice2) {
        // default size for a choice box
        x = GamePanel.TILE_SIZE / 2;
        y = GamePanel.TILE_SIZE / 2;
        width = GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_COL - (2 * GamePanel.TILE_SIZE / 2);
        height = GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_ROW / 2;

        this.backgroundColor = backgroundColor;
        this.outlineColor = outlineColor;
        this.message = message;
        this.choice1 = choice1;
        this.choice2 = choice2;

        // hitboxes for the buttons
        choice1Rect = new Rectangle(width - 20,height - 20, 50,20);
        choice2Rect = new Rectangle(width - 20,height - TEXT_SPACING,50,20);
    }

    public void drawChoiceBox(Graphics2D g2D) {
        g2D.setFont(CAVE_STORY);
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);

        // todo figure out how to make a separating line for the choices
        //g2D.drawLine((width / 3) * 2, height, (width / 3) * 2, y);
        //g2D.drawRect((width / 3) * 2, y, 1, height);

        g2D.setColor(Color.BLUE);
        g2D.fillRect(choice1Rect.x, choice1Rect.y, choice1Rect.width, choice1Rect.height);
        g2D.fillRect(choice2Rect.x, choice2Rect.y, choice2Rect.width, choice2Rect.height);
        g2D.setColor(Color.WHITE);
        g2D.drawString(choice1, width, height);
        g2D.drawString(choice2, width, height + TEXT_SPACING);
    }
}
