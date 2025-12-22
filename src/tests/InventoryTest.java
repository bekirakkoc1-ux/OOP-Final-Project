package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import inventory.Inventory;
import inventory.Product;

class InventoryTest {

    @Test
    void testAddProduct() {
        // Envanteri oluşturup içine bir ürün ekliyorum
        Inventory inv = new Inventory();
        Product p = new Product("T001", "Test Laptop", 1000.0, 5);
        
        inv.addProduct(p);
        
        // Listenin boyutu 1 olmalı, yani ürün eklenmiş olmalı
        assertEquals(1, inv.getProducts().size());
        // Eklenen ürünün ismi doğru mu?
        assertEquals("Test Laptop", inv.getProducts().get(0).getName());
    }

    @Test
    void testRemoveProduct() {
        // Önce ekleyip sonra silmeyi deniyorum
        Inventory inv = new Inventory();
        Product p = new Product("T002", "Test Phone", 500.0, 10);
        
        inv.addProduct(p);
        boolean isRemoved = inv.removeProduct("T002");
        
        // Silme işlemi başarılı dönmeli (true)
        assertTrue(isRemoved);
        // Liste tekrar boş olmalı
        assertEquals(0, inv.getProducts().size());
    }

    @Test
    void testDuplicateIdCheck() {
        // Aynı ID ile iki ürün eklemeye çalışıyorum
        Inventory inv = new Inventory();
        Product p1 = new Product("ID99", "Item 1", 10.0, 1);
        Product p2 = new Product("ID99", "Item 2", 20.0, 1); // Aynı ID!
        
        inv.addProduct(p1);
        inv.addProduct(p2); // Bunu eklememeli
        
        // Liste boyutu hala 1 olmalı
        assertEquals(1, inv.getProducts().size());
    }
}