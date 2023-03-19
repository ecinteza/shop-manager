import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

public class UnitTests {
    @Test
    public void shopTest() {
        ArrayList<Integer> Shelf = new ArrayList<>();
        ArrayList<String> Product = new ArrayList<>();
        ArrayList<Integer> Quantity = new ArrayList<>();
        ArrayList<Integer> Price = new ArrayList<>();

        Shop shop = new Shop(Shelf, Product, Quantity, Price);

        shop.test_addProduct("Orange", 10, 5);
        shop.test_addProduct("Apple", 20, 3);

        assertEquals(2, shop.test_shelfSize());
    }

    @Test
    public void userTest() {
        ArrayList<Integer> Shelf = new ArrayList<>();
        ArrayList<String> Product = new ArrayList<>();
        ArrayList<Integer> Quantity = new ArrayList<>();
        ArrayList<Integer> Price = new ArrayList<>();

        Shop shop = new Shop(Shelf, Product, Quantity, Price);
        User user = new User(Shelf, Product, Quantity, Price);

        shop.test_addProduct("Orange", 10, 5);
        shop.test_addProduct("Apple", 20, 3);

        assertEquals(0, user.balance());
        user.addMoney(100);
        assertEquals(100, user.balance());
    }
}
