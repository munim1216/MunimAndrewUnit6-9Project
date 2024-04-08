package ui;

import main.GamePanel;

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
    private static GameUIManager uiManager;
    private static GamePanel gp;
    protected static final int TEXT_SPACING = 35;
    public static final Color OPAQUE_BLACK = new Color(40,40,40,225);
    public static final Color HIGHLIGHT = new Color(74,84,87, 200);
    public static final Color WHITE = new Color(255,247,228);
    public static final Color BEIGE = new Color(173, 167, 151);
    private ArrayList<SelectionBox> clickable; // this array list will contain all the clickable areas for buttons and the like
    protected boolean deleteNow;
    public BaseUI(){
        clickable = new ArrayList<>();
        uiManager.add(this);
        deleteNow = false;
    }
    protected ArrayList<SelectionBox> getClickable() {
        return clickable;
    }
    public void removeSelf() {
        deleteNow = true;
    }
    public boolean isDeleteNow() {
        return deleteNow;
    }
    public static void setUIManager(GameUIManager uiManager) {
        BaseUI.uiManager = uiManager;
    }
    abstract void draw(Graphics2D g2D);

    abstract void process(SelectionBox rect, boolean hovering, boolean clicked);

    abstract void process();

    abstract void processClick();

    public static void setGP(GamePanel gp) {
        BaseUI.gp = gp;
    }

    public static GamePanel getGP() {
        return gp;
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
}
