package ui;

import java.awt.*;

public class choiceBox extends BaseUI {
    public choiceBox() {}

    public void drawChoiceBox(Graphics2D g2D, int x, int y, int width, int height, Color backgroundColor, Color outlineColor, String message, String choices) {
        drawBoxWithMessage(g2D, x, y, width, height, backgroundColor, outlineColor, message);
        // create method to create a rectangle the size of the text pritned around the printed choice
    }
}
