package ui;

import java.awt.*;

public class SelectionBox extends Rectangle {
    public final int intRep;

    public SelectionBox(int x, int y, int width, int height, int rep) {
        super(x, y, width, height);
        intRep = rep;
    }
}
