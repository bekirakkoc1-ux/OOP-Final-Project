package inventory;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Envanter nesnemi oluşturuyorum
        Inventory myInventory = new Inventory();
        
        System.out.println(">>> System Initializing... Please Wait <<<");
        
        // 1. Dosyadan ürünleri yükleme (File I/O)
        // 'products.txt' dosyasını okuyup listeye atıyor
        List<Product> loadedProducts = FileIO.readProductsFromFile("products.txt");
        
        // Okunan ürünleri envantere tek tek ekliyorum
        for(Product p : loadedProducts) {
            myInventory.addProduct(p);
        }
        
        System.out.println(loadedProducts.size() + " products loaded successfully.\n");
        
        // 2. Kullanıcı Menüsü (Sonsuz Döngü)
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while(running) {
        	System.out.println("\n#########################################");
        	System.out.println("#      INVENTORY MANAGEMENT SYSTEM      #");
        	System.out.println("#########################################");
        	System.out.println("v1.0.2 - Stable Build\n");
            System.out.println("1. List All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Low Stock");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            // Kullanıcı sayı yerine harf girerse hata almamak için try-catch eklenebilir
            // Ama şimdilik basit tutuyok.
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                scanner.nextLine(); // Buffer temizleme (Enter tuşu sorunu için)
                
                switch(choice) {
                    case 1:
                        myInventory.listAllProducts();
                        break;
                        
                    case 2:
                        System.out.print("Enter Product ID: ");
                        String id = scanner.nextLine();
                        
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        
                        System.out.print("Enter Quantity: ");
                        int qty = scanner.nextInt();
                        
                        Product newProduct = new Product(id, name, price, qty);
                        myInventory.addProduct(newProduct);
                        break;
                        
                    case 3:
                        System.out.print("Enter Product ID to remove: ");
                        String removeId = scanner.nextLine();
                        myInventory.removeProduct(removeId);
                        break;
                        
                    case 4:
                        System.out.print("Enter stock threshold (e.g. 10): ");
                        int limit = scanner.nextInt();
                        myInventory.listLowStockProducts(limit);
                        break;
                        
                    case 5:
                        System.out.println("Exiting system. Goodbye!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Hatalı girdiyi temizle
            }
        }
        
        scanner.close();
    }
 // To do: Add database support in the next version
 // To do: Implement user login system
    
    
    
}