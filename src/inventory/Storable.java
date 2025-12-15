package inventory;

public interface Storable {
    // Stok artırma
    void addStock(int amount);
    
    // Stok azaltma
    void removeStock(int amount);
    
    // Mevcut stok durumunu görme
    int getStockLevel();
}