package ui;

public class ExitGameBox extends ChoiceBox {
    private static String message = "Are you sure you want to close the game?\nRenee will miss you. :(";
    private static String choice1 = "Yes", choice2 = "No";

    public ExitGameBox() {
        super(OPAQUE_BLACK, WHITE, message, choice1, choice2);
    }

    @Override
    protected void clickedBox1() {
        System.exit(0);
    }

    @Override
    protected void clickedBox2() {
        updateMessage("Thank you dude!");
    }
}
