package ui;

import java.awt.*;

public class GameLossBox extends ChoiceBox {
    private static final String CHOICE_1 = "Yes", CHOICE_2 = "No";
    private static String text = "Oh no! You have lost :(\nWould you like to play again!";
    public GameLossBox() {
        super(OPAQUE_BLACK, WHITE, text , CHOICE_1, CHOICE_2, 3);
    }

    @Override
    protected void clickedBox1() {
        switch (getCurrentText()) {
            case 1 ->  {
                getGP().restartGame();
                removeSelf();
            }
            case 2,3 -> System.exit(0);
        }
    }

    @Override
    protected void clickedBox2() {
        switch (getCurrentText()) {
            case 1 -> { updateMessage("Then would you like to close the game?");}
            case 2 -> { updateMessage("Click yes whenever you feel like it to close \nthe game!");}
        }
        super.clickedBox2();
    }
}
