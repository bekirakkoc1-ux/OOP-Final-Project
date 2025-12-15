package inventory;

// Storable interface'ini implemente ediyoruz (Kalıtım/Polimorfizm)
public class Product implements Storable {
    // Encapsulation: Değişkenler private (dışarıya kapalı)
    private String productId;
    private String name;
    private double price;
    private int quantity;

    // Constructor (Yapıcı Metot)
    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        setPrice(price); // Fiyat kontrolü için setter kullanıyoruz
        this.quantity = quantity;
    }

    // Encapsulation: Getter ve Setter metotları
    public void setPrice(double price) {
        // Validation (Doğrulama): Fiyat negatif olamaz
        if (price < 0) {
            throw new IllegalArgumentException("Hata: Ürün fiyatı negatif olamaz!");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    public String getProductId() {
        return productId;
    }

    // Interface metotlarını dolduruyoruz (Override)
    @Override
    public void addStock(int amount) {
        if(amount > 0) {
            this.quantity += amount;
            System.out.println(amount + " adet eklendi. Yeni stok: " + this.quantity);
        }
    }

    @Override
    public void removeStock(int amount) {
        if(amount > 0 && this.quantity >= amount) {
            this.quantity -= amount;
            System.out.println(amount + " adet çıkarıldı. Kalan stok: " + this.quantity);
        } else {
            System.out.println("Hata: Yetersiz stok veya geçersiz miktar.");
        }
    }

    @Override
    public int getStockLevel() {
        return this.quantity;
    }
    
    @Override
    public String toString() {
        return "ID: " + productId + " | Ürün: " + name + " | Fiyat: " + price + " TL | Stok: " + quantity;
    }
}