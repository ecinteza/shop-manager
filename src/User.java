import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User implements iUser {
    ArrayList<Integer> Shelf;
    ArrayList<String> Product;
    ArrayList<Integer> Quantity;
    ArrayList<Integer> Price;
    Integer money = 0;
    Scanner sc = new Scanner(System.in);

    public User(ArrayList<Integer> _Shelf, ArrayList<String> _Product, ArrayList<Integer> _Quantity, ArrayList<Integer> _Price) {
        Shelf = _Shelf;
        Product = _Product;
        Quantity = _Quantity;
        Price = _Price;
    }

    @Override
    public void checkStock() {
        for (int i = 0; i< Shelf.size(); i++) {
            System.out.println("On shelf # " + (Shelf.get(i)+1) + " we got " + Quantity.get(i) + " " + Product.get(i) + "(s) that cost " + Price.get(i) + "$");
        }

        if (Shelf.size() == 0) System.out.println("All shelves are empty");
    }

    public int checkNum(String num) {
        for (int i=0; i<num.length(); i++)
            if (!Character.isDigit(num.charAt(i))) return 0;
        return 1;
    }

    public void addMoney(int m) {
        money += m;
    }
    public int balance() {
        return money;
    }

    public void checkBalance() {
        System.out.println("You have " + money + "$");
    }

    @Override
    public void setMoney() {
        String card, exp, cvc;

        System.out.println("Card Number: ");
        card = sc.nextLine();
        if (card.length() != 16 || checkNum(card)==0) {
            System.out.println("Invalid card number");
            return;
        }

        System.out.println("Expiration (mm/yy): ");
        exp = sc.nextLine();

        System.out.println("CVC: ");
        cvc = sc.nextLine();
        if (cvc.length()!=3 || checkNum(cvc)==0) {
            System.out.println("Invalid CVC number");
            return;
        }

        System.out.println("How much do you want to recharge?: ");
        try {
            money += Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Not a number. Cancelling transaction.");
        }
    }

    @Override
    public void buyProduct() {
        System.out.println("The shelf of the product: ");
        try {
            int raft = Integer.parseInt(sc.nextLine()) - 1;
            if (Shelf.contains(raft)) {
                if (Quantity.get(raft) == 0) System.out.println("The product is not in stock.");
                else {
                    System.out.println("How many?: ");
                    Integer cate = Integer.parseInt(sc.nextLine());
                    if (Quantity.get(raft) < cate) System.out.println("We do not have that many products in stock.");
                    else {
                        int price = Price.get(raft)*cate;
                        if (money < price) {
                            System.out.println("You do not have enough money. Do you wish to recharge? (yes/no)");
                            String choice = sc.nextLine();
                            if (Objects.equals(choice, "yes")) {
                                setMoney();
                            } else if (Objects.equals(choice, "no")) {
                                System.out.println("Cancelling process.");
                            } else System.out.println("Invalid choice.");
                        } else {
                            Quantity.set(raft, Quantity.get(raft) - cate);
                            money -= price;
                            System.out.println("Success. Money left: " + money);
                        }
                    }
                }
            } else {
                System.out.println("Invalid shelf. Process ended.");
            }
        } catch (Exception e) {
            System.out.println("Invalid number");
        }
    }
}
