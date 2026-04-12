package online_shop;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Warehouse {
    Map<String, Integer> productsPrises;
    Map<String, Integer> productsStocks;

    public Warehouse() {
        this.productsPrises = new HashMap<>();
        this.productsStocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        productsPrises.put(product, price);
        productsStocks.put(product, stock);
    }

    public int price(String product) {
        if (productsPrises.containsKey(product)) {
            return productsPrises.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (productsStocks.containsKey(product)) {
            return productsStocks.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (stock(product) > 0) {
            productsStocks.put(product, productsStocks.get(product) - 1);
            return true;
        } else {
            return false;
        }
    }

    public Set<String> products() {
        return productsPrises.keySet();
    }
}
