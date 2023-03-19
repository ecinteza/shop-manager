import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements iShop {
    ArrayList<Integer> Shelf;
    ArrayList<String> Product;
    ArrayList<Integer> Quantity;
    ArrayList<Integer> Price;
    Scanner sc = new Scanner(System.in);

    public Shop(ArrayList<Integer> _Shelf, ArrayList<String> _Product, ArrayList<Integer> _Quantity, ArrayList<Integer> _Price) {
        Shelf = _Shelf;
        Product = _Product;
        Quantity = _Quantity;
        Price = _Price;
    }
    public void test_addProduct(String name, Integer stock, Integer price) {
        Product.add(name);
        Quantity.add(stock);
        Price.add(price);
        Shelf.add(Shelf.size());
    }

    public int test_shelfSize() {
        return Shelf.size();
    }

    @Override
    public void checkStock() {
        for (int i = 0; i< Shelf.size(); i++) {
            System.out.println("On shelf # " + (Shelf.get(i)+1) + " we got " + Quantity.get(i) + " " + Product.get(i) + "(s) that cost " + Price.get(i) + "$");
        }

        if (Shelf.size() == 0) System.out.println("All shelves are empty");
    }

    @Override
    public void addNewProduct() {
        if (Shelf.size() < 50) {
            System.out.println("Product name: ");
            String name = sc.nextLine();
            if (Product.contains(name)) {
                System.out.println("The product is already on a shelf, do you wish to replenish stock? (yes / no)");
                String choice = sc.nextLine().toLowerCase();
                if (choice.equals("no")) {
                    System.out.println("Process ended.");
                } else if (choice.equals("yes")) {
                    System.out.println("How many?: ");
                    Integer hm = Integer.parseInt(sc.nextLine());
                    try {
                        int raft = Product.indexOf(name);
                        Quantity.set(raft, Quantity.get(raft) + hm);
                        System.out.println("Success.");
                    } catch (Exception e) {
                        System.out.println("Invalid number.");
                    }
                } else {
                    System.out.println("Invalid Choice.");
                }
            } else {
                try {
                    System.out.println("Available stock: ");
                    Integer stock = Integer.parseInt(sc.nextLine());
                    System.out.println("Price of the product: ");
                    Integer price = Integer.parseInt(sc.nextLine());
                    Product.add(name);
                    Quantity.add(stock);
                    Price.add(price);
                    Shelf.add(Shelf.size());
                    System.out.println("Product added.");
                } catch (Exception e) {
                    System.out.println("Invalid number");
                }
            }
        } else {
            System.out.println("No shelves available.");
        }
    }

    @Override
    public void delProduct() {
        System.out.println("The shelf the product is on: ");
        try {
            int theshelf = Integer.parseInt(sc.nextLine()) - 1;
            if (Shelf.contains(theshelf)) {
                for (int i = theshelf; i < Shelf.size() - 1; i++) {
                    Product.set(i, Product.get(i + 1));
                    Quantity.set(i, Quantity.get(i + 1));
                    Price.set(i, Price.get(i+1));
                }
                Shelf.remove(Shelf.size() - 1);
                System.out.println("Product deleted.");
            } else {
                System.out.println("Invalid shelf, process ended.");
            }
        } catch (Exception e) {
            System.out.println("Invalid number.");
        }
    }

    @Override
    public void replenishStock() {
        System.out.println("The shelf of the product: ");
        try {
            int theshelf = Integer.parseInt(sc.nextLine()) - 1;
            if (Shelf.contains(theshelf)) {
                System.out.println("How many products?: ");
                Integer cate = Integer.parseInt(sc.nextLine());
                Quantity.set(theshelf, Quantity.get(theshelf) + cate);
                System.out.println("Success.");
            } else {
                System.out.println("Invalid shelf, process ended.");
            }
        } catch (Exception e) {
            System.out.println("Invalid number.");
        }
    }

}
