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

    public boolean isCurrentUIEmpty() {
        return currentUI.isEmpty();
    }

    public void drawUI(Graphics2D g2D) {
        for (BaseUI ui : currentUI) {
            ui.draw(g2D);
        }
    }

    public void processUI(){
        boolean clicked = mouseH.isClicked();
        for (int i = 0; i < currentUI.size(); i++) {
            BaseUI ui = currentUI.get(i);
            if (ui.isDeleteNow()) {
                currentUI.remove(i);
                i--;
                continue;
            }
            for (SelectionBox rect : ui.getClickable()) {
                boolean hovering = rect.contains(mouseH.getMouseLocation());
                ui.process(rect, hovering, clicked);

                if (hovering) {
                    break;
                }
            }
        }
    }

    public void remove(BaseUI ui) {
        for (int i = 0; i < currentUI.size(); i++) {
            if (ui == currentUI.get(i)) {
                currentUI.remove(ui);
                break;
            }
        }
    }
}
