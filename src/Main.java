import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> Shelf = new ArrayList<>();
        ArrayList<String> Product = new ArrayList<>();
        ArrayList<Integer> Quantity = new ArrayList<>();
        ArrayList<Integer> Price = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int type = 3;

        System.out.println("Press 1 for ADMIN PANEL and 0 for USER PANEL");
        try {
            type = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        Shop shop = new Shop(Shelf, Product, Quantity, Price);
        User user = new User(Shelf, Product, Quantity, Price);
        Menu menu = new Menu();

        int choice = 0, switchtype = 0;
        do {
            if (type == 1) {
                do {
                    menu.adminMenu();
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1 -> shop.checkStock();
                        case 2 -> shop.addNewProduct();
                        case 3 -> shop.delProduct();
                        case 4 -> shop.replenishStock();
                        case 5 -> {
                            type = 0;
                            choice = 0;
                            switchtype = 1;
                        }
                        case 0 -> System.out.println("Goodbye. :)");
                    }
                } while (choice != 0);
            } else if (type == 0) {
                do {
                    menu.userMenu();
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1 -> user.buyProduct();
                        case 2 -> {
                            type = 1;
                            choice = 0;
                            switchtype = 1;
                        }
                        case 3 -> user.checkStock();
                        case 4 -> user.setMoney();
                        case 5 -> user.checkBalance();
                        case 0 -> System.out.println("Goodbye. :)");
                    }
                } while (choice != 0);
            } else System.out.println("Invalid user type.");

            if (switchtype==1) {
                switchtype = 0;
                choice = 1;
            }
        } while ((type==1 || type==0) && choice != 0);
    }
}