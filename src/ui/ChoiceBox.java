package ui;

import main.GamePanel;

import java.awt.*;
import java.util.HashMap;

public class ChoiceBox extends BaseUI {
    private static final int SELECTOR_BOX_WIDTH = 111, SELECTOR_BOX_HEIGHT = 90;
    private final int SELECTOR_BOX_X, SELECTOR_BOX_Y;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean hoveredOver;
    private int finalText;
    private int currentText;
    private Rectangle hoveredOverRect;
    private Color backgroundColor;
    private Color outlineColor;
    private String message;
    private String choices;
    private Rectangle choice1Rect;
    private Rectangle choice2Rect;
    private HashMap<Rectangle, Integer> rectangleIntRep;

    public ChoiceBox(Color backgroundColor, Color outlineColor, String message, String choice1, String choice2, int finalText) {
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

        rectangleIntRep = new HashMap<>();
        rectangleIntRep.put(choice1Rect, 1);
        rectangleIntRep.put(choice2Rect, 2);

        // to allow for the code to change what is displayed
        currentText = 1;
        this.finalText = finalText;
    }
    protected int getFinalText() {
        return finalText;
    }
    protected void updateMessage (String newMessage) {
        message = newMessage;
    }

    protected void updateMessage (String newMessage, String choice1, String choice2) {
        message = newMessage;
        this.choices = choice1 + "\n" + choice2;
    }
    @Override
    void draw(Graphics2D g2D) {
        g2D.setFont(CAVE_STORY);
        drawBox(g2D, x, y, width, height, backgroundColor, outlineColor);
        drawText(g2D, x, y, outlineColor, message);

        drawBox(g2D, SELECTOR_BOX_X, SELECTOR_BOX_Y, SELECTOR_BOX_WIDTH, SELECTOR_BOX_HEIGHT, backgroundColor, outlineColor);

        if (hoveredOver) {
            drawBox(g2D, hoveredOverRect.x, hoveredOverRect.y, hoveredOverRect.width, hoveredOverRect.height, HIGHLIGHT);
        }
        drawText(g2D, SELECTOR_BOX_X, SELECTOR_BOX_Y, outlineColor, choices);
    }

    @Override
    void process(Rectangle rect, boolean hovering, boolean clicked) {
        hoveredOverRect = rect;
        hoveredOver = hovering;
        if (clicked) {
            processClick();
        }
    }

    @Override
    protected void processClick() {
        switch (rectangleIntRep.get(hoveredOverRect)) {
            case 1 -> clickedBox1();
            case 2 -> clickedBox2();
            default -> throw new RuntimeException("Unsupported Input");
        }
    }

    protected void clickedBox1() {

    }

    protected void clickedBox2() {

    }
}
