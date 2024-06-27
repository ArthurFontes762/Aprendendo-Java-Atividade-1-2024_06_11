import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        String productName = product.name;  // Acesso direto ao campo 'name'
        products.put(productName, products.getOrDefault(productName, 0) + quantity);
        System.out.println("Adicionado " + quantity + " de " + productName + " no Inventário.");
    }

    public void removeProduct(Product product, int quantity) {
        String productName = product.name;  // Acesso direto ao campo 'name'
        if (products.containsKey(productName)) {
            int currentQuantity = products.get(productName);
            if (currentQuantity >= quantity) {
                products.put(productName, currentQuantity - quantity);
                if (products.get(productName) == 0) {
                    products.remove(productName);
                }
                System.out.println("Removido " + quantity + " de " + productName + " no Inventário.");
            } else {
                System.out.println("Insuficiente " + productName + " no inventário para remover. Quantidade atual: " + currentQuantity);
            }
        } else {
            System.out.println(productName + " não está no Inventário.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventário Atual:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}