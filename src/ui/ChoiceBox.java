package ui;

import main.GamePanel;
import main.MouseHandler;
import java.awt.*;
import java.util.HashMap;

public class ChoiceBox extends BaseUI {
    private static final int SELECTOR_BOX_WIDTH = 111, SELECTOR_BOX_HEIGHT = 90;
    private final int SELECTOR_BOX_X, SELECTOR_BOX_Y;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color backgroundColor;
    private Color outlineColor;
    private String message;
    private String choices;
    private Rectangle choice1Rect;
    private Rectangle choice2Rect;
    private HashMap<Rectangle, Integer> whichRectangleHighlighted;

    public ChoiceBox(Color backgroundColor, Color outlineColor, String message, String choice1, String choice2) {
        // default size for a choice box
        x = GamePanel.TILE_SIZE / 2;
        y = GamePanel.TILE_SIZE / 2;
        width = GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_COL - (2 * GamePanel.TILE_SIZE / 2);
        height = GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_ROW / 2;

        // colors of the choice box
        this.backgroundColor = backgroundColor;
        this.outlineColor = outlineColor;

        // displayed message and choices
        this.message = message;
        choices = choice1 + "\n" + choice2;

        // default size for selectors
        SELECTOR_BOX_X = width - SELECTOR_BOX_WIDTH;
        SELECTOR_BOX_Y = height + (GamePanel.TILE_SIZE / 5 * 3);

        // hitboxes for the buttons
        choice1Rect = new Rectangle(SELECTOR_BOX_X + 6,SELECTOR_BOX_Y + 10, SELECTOR_BOX_WIDTH - 10,(SELECTOR_BOX_HEIGHT - 10) / 3 + 5);
        choice2Rect = new Rectangle(SELECTOR_BOX_X + 6,(SELECTOR_BOX_Y + 10) + ((SELECTOR_BOX_HEIGHT - 10) / 3) + 10, SELECTOR_BOX_WIDTH - 10,(SELECTOR_BOX_HEIGHT - 10) / 3 + 5) ;
        getClickable().add(choice1Rect);
        getClickable().add(choice2Rect);

        whichRectangleHighlighted = new HashMap<>();
        whichRectangleHighlighted.put(choice1Rect, 1);
        whichRectangleHighlighted.put(choice2Rect, 2);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setFont(CAVE_STORY);
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);
        drawBoxWithMessage(g2D, SELECTOR_BOX_X, SELECTOR_BOX_Y, SELECTOR_BOX_WIDTH, SELECTOR_BOX_HEIGHT, backgroundColor, outlineColor, choices);
        g2D.setColor(Color.BLUE);
        g2D.fillRect(choice1Rect.x, choice1Rect.y, choice1Rect.width, choice1Rect.height);
        g2D.fillRect(choice2Rect.x, choice2Rect.y, choice2Rect.width, choice2Rect.height);
        g2D.setColor(Color.WHITE);
    }

    @Override
    public void process(Rectangle rect) {
        highlightArea(rect);
    }

    private void highlightArea(Rectangle highlighted) {
        //todo finsh method
        System.out.println("haha i am " + whichRectangleHighlighted.get(highlighted));
    }
}
