package ui;

import main.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class GameUIManager {
    private ArrayList<BaseUI> currentUI;
    private MouseHandler mouseH;

    public GameUIManager(MouseHandler mouseH) {
        currentUI = new ArrayList<>();
        this.mouseH = mouseH;
    }

    void add(BaseUI ui) {
        currentUI.add(ui);
    }

    public void drawUI(Graphics2D g2D) {
        for (BaseUI ui : currentUI) {
            ui.draw(g2D);
        }
    }

    public void processUI(){
        for (BaseUI ui : currentUI) {
            for (Rectangle rect : ui.getClickable()) {
                boolean hovering = rect.contains(mouseH.getMouseLocation());
                boolean clicked = hovering && mouseH.isPressed();
                ui.process(rect, hovering, clicked);

                if (hovering) {
                    break;
                }
            }
        }
    }
}
