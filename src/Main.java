import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public void printHoofdmenu(){
        System.out.println("--- Wekelijkse boodschappen App --- \uD83D\uDED2" + "\n" +
                "Wat wil je doen?" + "\n" +
                "1. Genereer wekelijkse boodschappenlijst" + "\n" +
                "2. Voeg aantal random snacks toe" + "\n" +
                "3. Voeg nieuwe boodschap item toe" + "\n" +
                "4. Voeg nieuwe snack toe" + "\n" +
                "5. Geef totaal kosten weer"  + "\n" +
                "6. Stop");
    }

    public static void main(String[] args) {
        Main main = new Main();
        boolean app_draait = true;
        Scanner scanner = new Scanner(System.in);
        GroceryManager groceryManager = new GroceryManager();
        Reader reader = new Reader();
        DatabaseConnector databaseConnector = new DatabaseConnector();

        while(app_draait) {
            main.printHoofdmenu();
            int keuze = scanner.nextInt();
//            File file = new File("src/star_wars_meme.txt");
            if (keuze == 1){
//                groceryManager.printGroceryList();
//                String fileName = "groceryList.txt";
//                System.out.println(reader.getFileName(fileName) + "\n");
                databaseConnector.selectData();
            } else if (keuze == 2) {
                System.out.println("Hoeveel random snacks wil je toevoegen?");
                int hoeveelheid = scanner.nextInt();
                groceryManager.addSnacksRandomlyWithGivenAmount(hoeveelheid);
            } else if (keuze == 3) {
                System.out.println("Welke boodschappen naam wilt u toevoegen?");
                String boodschappenNaam = scanner.next();
                System.out.println("Hoe heet de category die u wilt toevoegen?");
                String category = scanner.next();
                System.out.println("Hoeveel wilt u toevoegen?");
                int hoeveelheid = scanner.nextInt();
                System.out.println("Wat is de prijs die u wilt toevoegen?");
                double prijs = scanner.nextDouble();
//                Item groceryItem = new Item(boodschappenNaam, category, hoeveelheid, prijs);
//                groceryManager.addGrocery(groceryItem);
//                Writer fileWriter = new Writer();
//                String groceryFileName = "src/groceryList.txt";
//                fileWriter.setWriteFile(groceryFileName, groceryItem);
                groceryManager.addGrocery(new Item(boodschappenNaam, category, hoeveelheid, prijs));
                databaseConnector.insertData(boodschappenNaam, category, hoeveelheid, prijs);
            } else if (keuze == 4) {
                System.out.println("Welke snack naam wilt u toevoegen?");
                String snackName = scanner.next();
                System.out.println("Hoe heet de snack category die u wilt toevoegen?");
                String snackCategory = scanner.next();
                System.out.println("Hoeveel wilt u toevoegen?");
                int snackAmount = scanner.nextInt();
                System.out.println("Wat is de prijs die u wilt toevoegen?");
                double snackPrice = scanner.nextDouble();
//                Item snackItem = new Item(snackName, snackCategory, snackAmount, snackPrice);
//                groceryManager.addSnack(snackItem);
//                Writer fileWriter = new Writer();
//                String snackFileName = "src/snackList.txt";
//                fileWriter.setWriteFile(snackFileName, snackItem);
                groceryManager.addSnack(new Item(snackName, snackCategory, snackAmount, snackPrice));
                databaseConnector.insertData(snackName, snackCategory, snackAmount, snackPrice);
            } else if (keuze == 5) {
                System.out.println(groceryManager.calculateTotalPriceGroceries());
            } else if (keuze == 6) {
                app_draait = false;
                databaseConnector.closeConnection();
            } else {
                System.out.println("Kies een geldige keuze");
            }

        }
    }
}