package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // List interface'ini kullanarak ürünleri tutuyorum (Polymorphism)
    // ArrayList, ürünleri dinamik bir listede saklamamı sağlıyor
    private List<Product> products;

    public Inventory() {
        // Listeyi başlatıyorum
        this.products = new ArrayList<>();
    }

    // Ürün ekleme metodu
    public void addProduct(Product product) {
        // Aynı ID ile ürün eklenmesini engelliyorum
        for(Product p : products) {
            if(p.getProductId().equals(product.getProductId())) {
                System.out.println("Error: Product ID " + product.getProductId() + " already exists.");
                return;
            }
        }
        products.add(product);
        System.out.println(product.getName() + " added to inventory.");
    }

    // ID'ye göre ürün silme
    public boolean removeProduct(String productId) {
        // Lambda expression ile pratik silme işlemi (Java 8 özelliği)
        boolean removed = products.removeIf(p -> p.getProductId().equals(productId));
        
        if(removed) {
            System.out.println("Product " + productId + " removed.");
        } else {
            System.out.println("Error: Product not found.");
        }
        return removed;
    }

    // Stokta belirli bir sayının altına düşen ürünleri bulma (Raporlama)
    public void listLowStockProducts(int threshold) {
        System.out.println("--- Low Stock Alert (< " + threshold + ") ---");
        for(Product p : products) {
            if(p.getStockLevel() < threshold) {
                System.out.println(p.getName() + " (Stock: " + p.getStockLevel() + ")");
            }
        }
        System.out.println("-----------------------------");
    }
    
    // Testlerde ve raporlarda kullanmak için ürün listesini döndüren metod
    public List<Product> getProducts() {
        return products;
    }
}