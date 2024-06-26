package ui;

public class ExitGameBox extends ChoiceBox {
    private static String message = "Are you sure you want to close the game?\nRenee will miss you. :(";
    private static String choice1 = "Yes", choice2 = "No";

    public ExitGameBox() {
        super(OPAQUE_BLACK, WHITE, message, choice1, choice2, 2);
    }

    @Override
    protected void clickedBox1() {
        switch (getCurrentText()) {
            case 1 -> System.exit(0);
            case 2 -> removeSelf();
            default -> throw new RuntimeException("error");
        }
    }

    @Override
    protected void clickedBox2() {
        System.out.println(getCurrentText());
        switch (getCurrentText()) {
            case 1 -> updateMessage("Thank you dude! Do you want me to go?");
            case 2 -> updateMessage("No? Well I'll be here until you click yes! Have fun!");
            default -> throw new RuntimeException("error");
        }
        super.clickedBox2();
    }
}
