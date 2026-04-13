package online_shop;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> list;

    public ShoppingCart() {
        this.list = new HashMap<>();
    }

    public void add(String product, int price) {
        for (Item item: list.values()) {
            if (item.toString().contains(product)) {
                item.increaseQuantity();
            } else {
                list.put(product, new Item(product, 1, price));
            }
        }
    }

    public int price() {
        int summa = 0;
        for (Item item : list.values()) {
            summa += item.price();
        }
        return summa;
    }

    public void print() {
        for (Item item: list.values()) {
            System.out.println(item);
        }
    }


}
