import java.util.Scanner;
import java.text.DecimalFormat;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        DecimalFormat dfix = new DecimalFormat("0.00");
        int firstMenuInput;
        int shoppingMenuInput;
        double userBudget = 100.00;
        double transactionTotal = 0.00;
        int ITEM_NUM = 5;
        final double[] ITEM_PRICES = new double[ITEM_NUM];
        ITEM_PRICES[0] = 19.99;
        ITEM_PRICES[1] = 29.49;
        ITEM_PRICES[2] = 15.79;
        ITEM_PRICES[3] = 24.99;
        ITEM_PRICES[4] = 24.99;
        final String[] ITEM_NAMES = new String[ITEM_NUM];
        ITEM_NAMES[0] = "Toaster";
        ITEM_NAMES[1] = "Coffee Maker";
        ITEM_NAMES[2] = "Waffle Maker";
        ITEM_NAMES[3] = "Blender";
        ITEM_NAMES[4] = "Kettle";

        boolean transactionComplete = false;
        while (!transactionComplete) {

            System.out.println("Please select a menu item from the list below: ");
            System.out.println("1 - View item menu \n2 - Pay total due \n3 - Add $5 in credit \n4 - Clear order \n");

            firstMenuInput = scnr.nextInt();

            /* Checks if the first input is valid */
            while (firstMenuInput > 4 || firstMenuInput < 1) {
                System.out.println("Please enter a valid option!");
                firstMenuInput = scnr.nextInt();
            }

            /* Item menu */
            while (firstMenuInput == 1) {
                System.out.println("What would you like to add to your order?");
                for (int i = 0; i <= ITEM_NUM; i++) {
                    int tempItemNum = i+1;
                    if (i < ITEM_NUM)
                        System.out.println("("+ tempItemNum +") "+ ITEM_NAMES[i] + ": $" + ITEM_PRICES[i]);
                    else
                        System.out.println("("+ tempItemNum +") Go to the main menu");
                }

                shoppingMenuInput = scnr.nextInt();
                while (shoppingMenuInput > ITEM_NUM+1 || shoppingMenuInput < 1) {
                    System.out.println("Please enter a valid option!");
                    shoppingMenuInput = scnr.nextInt();
                }

                if (shoppingMenuInput <= ITEM_NUM && shoppingMenuInput >= 1) {
                        System.out.println("You have added a "+ ITEM_NAMES[shoppingMenuInput-1] +" to your order.");
                        transactionTotal += ITEM_PRICES[shoppingMenuInput-1];
                        System.out.println(dfix.format(transactionTotal));
                }
                else if (shoppingMenuInput == ITEM_NUM+1)
                    break;

            }

            if (firstMenuInput == 2){
                if (transactionTotal > userBudget) {
                    System.out.println("Insufficient funds!");
                    transactionComplete = true;
                }
                else
                    System.out.println("Your total due is: $"+ transactionTotal);
            }

            if (firstMenuInput == 3){
                
            }

            if (firstMenuInput == 4){
                transactionTotal = 0;
                System.out.printf("Current order balance has been cleared. Current due: $"+ dfix.format(transactionTotal) +"\n");
            }
        }
    }
}