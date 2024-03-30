package ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseUI {
    protected static final Font CAVE_STORY;

    static {
        try {
            CAVE_STORY = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Cave-Story.ttf")).deriveFont(40f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Rectangle> clickable; // this array list will contain all the clickable areas for buttons and the like
    private static GameUIManager uiManager;
    protected static final int TEXT_SPACING = 35;
    public BaseUI(){
        clickable = new ArrayList<>();
        uiManager.add(this);
    }
    public static final Color OPAQUE_BLACK = new Color(40,40,40,225);
    public static final Color HIGHLIGHT = new Color(74,84,87, 200);
    public static final Color WHITE = new Color(255,247,228);

    protected ArrayList<Rectangle> getClickable() {
        return clickable;
    }

    void draw(Graphics2D g2D) {

    }

    void process(Rectangle rect, boolean hovering, boolean clicked) {

    }

    void process() {

    }

    protected void processClick() {

    }

    protected void drawBox(Graphics2D g2D, int x, int y, int width, int height, Color backgroundColor, Color outlineColor) {
        // background rectangle
        g2D.setColor(backgroundColor);
        g2D.fillRoundRect(x, y, width, height, 25, 25);

        // outline of rectangle
        g2D.setColor(outlineColor);
        g2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25) ;
    }
    protected void drawBox(Graphics2D g2D, int x, int y, int width, int height, Color backgroundColor) {
        // background rectangle
        g2D.setColor(backgroundColor);
        g2D.fillRoundRect(x, y, width, height, 25, 25);
    }


    protected void drawText(Graphics2D g2D, int x, int y, Color textColor, String message) {
        g2D.setColor(textColor);
        for (String line : message.split("\n")) {
            y += TEXT_SPACING;
            g2D.drawString(line, x + 20, y);
        }
    }

    public static void setUIManager(GameUIManager uiM) {
        BaseUI.uiManager = uiM;
    }


    protected void highlightArea(Graphics2D g2D, Rectangle rect) {
        g2D.setColor(HIGHLIGHT);
        g2D.fillRoundRect(rect.x, rect.y, rect.width, rect.height, 25,25);
    }

}
