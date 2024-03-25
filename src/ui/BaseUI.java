package ui;

import java.awt.*;
import java.util.ArrayList;

public class BaseUI {

    private ArrayList<Rectangle> clickable; // this array list will contain all the clickable areas for buttons and the like

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
            g2D.drawString(line, x + 20, y + 24);
            y += 35;
        }
    }

    protected ArrayList<Rectangle> getClickable() {
        return clickable;
    }
}
