package ui;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends BaseUI{

    private static final BufferedImage TITLE_IMAGE;

    static {
        try {
            TITLE_IMAGE = ImageIO.read(new File("resources/characters/title_image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private SelectionBox begin;
    private boolean hoveredOver;

    public MainMenu() {
        getClickable().add(new SelectionBox(((GamePanel.MAX_SCREEN_COL * 48) - 256) / 2, 425,256,100,1));
        begin = getClickable().get(0);
        hoveredOver = false;
    }


    @Override
    void draw(Graphics2D g2D) {
        g2D.setFont(CAVE_STORY.deriveFont(100f));
        g2D.setColor(BaseUI.WHITE);

        String text = "Dragoon*s Defense";

        int textX = (GamePanel.MAX_SCREEN_COL * 48 / 2) - (((int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth()) / 2);
        drawText(g2D, textX, 100, WHITE, text);

        g2D.drawImage(TITLE_IMAGE, begin.x,150, 256, 256, null);

        drawBox(g2D,begin.x, 425, 256, 100, BaseUI.OPAQUE_BLACK);
        if (hoveredOver) {
            drawBox(g2D, begin.x + 5, begin.y + 5, begin.width - 10, begin.height - 10, HIGHLIGHT);
        }
        drawText(g2D,begin.x, begin.y + 35, WHITE, "BEGIN");
    }

    @Override
    void process(SelectionBox rect, boolean hovering, boolean clicked) {
        hoveredOver = hovering;
        if (clicked && hoveredOver) {
            processClick();
        }
    }

    @Override
    void process() {

    }

    @Override
    void processClick() {
        getGP().startGame();
        removeSelf();
    }
}
