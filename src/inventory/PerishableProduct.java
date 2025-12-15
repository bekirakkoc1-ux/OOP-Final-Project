package inventory;

import java.time.LocalDate; // Tarih işlemleri için gerekli kütüphane

// Inheritance (Kalıtım): Product sınıfının tüm özelliklerini miras alıyor
public class PerishableProduct extends Product {
    private LocalDate expirationDate; // Son Kullanma Tarihi (SKT)

    public PerishableProduct(String productId, String name, double price, int quantity, LocalDate expirationDate) {
        // super() ile üst sınıfın (Product) yapıcısını çağırıyoruz
        super(productId, name, price, quantity); 
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    
    // toString metodunu eziyoruz (Overriding) ki SKT'yi de yazdırsın
    @Override
    public String toString() {
        return super.toString() + " | SKT: " + expirationDate;
    }
}