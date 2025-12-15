package inventory;

import java.time.LocalDate;

// Inheritance: Product sınıfından miras aldım
public class PerishableProduct extends Product {
    private LocalDate expirationDate; // Ekstra özellik

    public PerishableProduct(String productId, String name, double price, int quantity, LocalDate expirationDate) {
        super(productId, name, price, quantity); // Parent class constructor'ını çağırdım
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    
    // toString metodunu override edip tarihi de ekledim
    @Override
    public String toString() {
        return super.toString() + " | Exp. Date: " + expirationDate;
    }
}