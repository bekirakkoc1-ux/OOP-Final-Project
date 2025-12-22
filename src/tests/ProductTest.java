package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import inventory.Product;

class ProductTest {

    @Test
    void testProductCreation() {
        // Geçerli bir ürün oluşturulabiliyor mu? 
        Product p = new Product("P001", "Laptop", 15000.0, 10);
        assertEquals("Laptop", p.getName());
        assertEquals(15000.0, p.getPrice());
        assertEquals(10, p.getStockLevel());
    }

    @Test
    void testNegativePriceThrowsException() {
        // Negatif fiyat girilince hata veriyor mu? (Olması gereken aga)
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("P002", "Hatalı Ürün", -100.0, 5);
        });
    }

    @Test
    void testAddStock() {
        // Stok ekleme çalışıyor mu?
        Product p = new Product("P003", "Mouse", 500.0, 20);
        p.addStock(5);
        assertEquals(25, p.getStockLevel());
    }

    @Test
    void testRemoveStock() {
        // Stok azaltma çalışıyor mu?
        Product p = new Product("P004", "Klavye", 750.0, 10);
        p.removeStock(3);
        assertEquals(7, p.getStockLevel());
    }
}