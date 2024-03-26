package ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BaseUI {
    protected static final Font CAVE_STORY;

    static {
        try {
            CAVE_STORY = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Cave-Story.ttf")).deriveFont(40f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Rectangle> clickable; // this array list will contain all the clickable areas for buttons and the like
    protected static final int TEXT_SPACING = 35;
    public BaseUI(){
        clickable = new ArrayList<>();
    }
    public static final Color opaqueBlack = new Color(0,0,0,200);

    public void drawBoxWithMessage(Graphics2D g2D, int x, int y, int width, int height, Color backgroundColor, Color outlineColor, String message) {
        g2D.setColor(backgroundColor);
        g2D.fillRoundRect(x,y,width,height,25,25);

        g2D.setColor(outlineColor);
        g2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25) ;

        for (String line : message.split("\n")) {
            y += TEXT_SPACING;
            g2D.drawString(line, x + 20, y);
        }
    }

    protected ArrayList<Rectangle> getClickable() {
        return clickable;
    }
    

}
