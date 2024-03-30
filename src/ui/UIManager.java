package ui;

import main.MouseHandler;

import java.util.ArrayList;

public class UIManager {
    private ArrayList<BaseUI> currentUI;
    private MouseHandler mouseH;

    public UIManager(MouseHandler mouseH) {
        currentUI = new ArrayList<>();
        this.mouseH = mouseH;
    }
}
