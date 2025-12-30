package inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    
    // Dosyadan ürünleri okuyan metod
    // Static yaptım çünkü nesne oluşturmadan direkt FileIO.readProducts() diye çağırmak istiyorum
    public static List<Product> readProductsFromFile(String filename) {
        List<Product> productList = new ArrayList<>();
        
        // Try-catch bloğu ile dosya okuma hatası olursa programın çökmesini engelliyorum
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Her satırı virgüle göre ayırıp verileri alıyorum
                String[] data = line.split(",");
                
                // Verileri uygun tiplere dönüştürüp ürün oluşturuyorum
                String id = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                
                Product p = new Product(id, name, price, quantity);
                productList.add(p);
            }
            System.out.println("Success: Products loaded from " + filename);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: File format is incorrect.");
        }
        
        return productList;
    }
}