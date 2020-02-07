import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mainMenuInput, itemMenuInput;
        double userBudget = 100.00, totalBeforeTax = 0.00, totalAfterTax;
        final int NUM_ITEMS = 5;
        final double[] ITEM_PRICES = new double[NUM_ITEMS];
        ITEM_PRICES[0] = 19.99;
        ITEM_PRICES[1] = 29.49;
        ITEM_PRICES[2] = 15.79;
        ITEM_PRICES[3] = 24.99;
        ITEM_PRICES[4] = 24.99;
        final String[] ITEM_NAMES = new String[NUM_ITEMS];
        ITEM_NAMES[0] = "Toaster";
        ITEM_NAMES[1] = "Coffee maker";
        ITEM_NAMES[2] = "Waffle maker";
        ITEM_NAMES[3] = "Blender";
        ITEM_NAMES[4] = "Kettle";
        boolean transactionComplete = false;

        //Main Menu
        while (!transactionComplete) {
            System.out.println("Please select a menu item from the list below:");
            System.out.println("1 – View item menu\n2 – Pay total due\n3 – Add $5 in credit\n4 – Clear order");
            mainMenuInput = scan.nextInt();

            while (mainMenuInput > 4 || mainMenuInput < 1) { //Ensures valid input
                System.out.println("Please enter a valid option!");
                mainMenuInput = scan.nextInt();
            }

            //Menu Option 1: View item menu
            while (mainMenuInput == 1) {
                System.out.println("What would you like to add to your order?");
                for (int i = 0; i <= NUM_ITEMS; i++) { //This loop will display all item names and prices from the respective arrays
                    int itemNum = i+1; //Increments i by 1 to represent menu option numbers
                    if (i < NUM_ITEMS)
                        System.out.println("("+ itemNum +") "+ ITEM_NAMES[i] + ": $" + ITEM_PRICES[i]);
                    else
                        System.out.println("("+ itemNum +") Go to the main menu");
                }
                System.out.printf("Your current total is: $%.2f%n", totalBeforeTax);
                itemMenuInput = scan.nextInt();

                if (itemMenuInput <= NUM_ITEMS && itemMenuInput >= 1) {
                        System.out.println("You have added a "+ ITEM_NAMES[itemMenuInput-1] +" to your order.");
                        totalBeforeTax += ITEM_PRICES[itemMenuInput-1];
                }

                else if (itemMenuInput == NUM_ITEMS+1) //"NUM_ITEMS+1" represents the "Go to main menu" option, which will always display after the last element in an array of "NUM_ITEMS" elements
                    break;

                else
                    System.out.println("Invalid item number please try again");
            } //End Menu Option 1

            //Menu Option 2: Pay total due
            if (mainMenuInput == 2) {
                double discountAmount = 0;
                boolean discountApplied = false;
                totalAfterTax = totalBeforeTax;

                if (totalBeforeTax > 50) { //If the total is above $50, a 20% discount is applied
                    discountAmount = totalBeforeTax * 0.20;
                    discountApplied = true;
                    totalAfterTax *= 0.80;

                }
                totalAfterTax += (totalAfterTax * 0.085); //8.5% tax rate

                if (totalAfterTax > userBudget) { //Program will exit here if this condition is true
                    System.out.println("Insufficient funds!");
                    break;
                }

                System.out.printf("Your total due is: $%.2f%n", totalBeforeTax);
                System.out.print("Thank you! ");
                if (discountApplied)
                    System.out.printf("You saved: $%.2f", discountAmount);
                System.out.printf(" Your change is: $%.2f%n", (userBudget - totalAfterTax));
                System.out.println("Your items will be on their way soon!");

                transactionComplete = true;
            } //End Menu Option 2

            //Menu Option 3: Add $5 in credit
            if (mainMenuInput == 3) {
                userBudget += 5.00;
                System.out.printf("Credit available: $%.1f%n", userBudget);
            } //End Menu Option 3

            //Menu Option 4: Clear order
            if (mainMenuInput == 4) {
                totalBeforeTax = 0.0;
                System.out.printf("Current order balance has been cleared. Current due: $%.2f%n", totalBeforeTax);
            } //End Menu Option 4
        } //End Main Menu
    }
}