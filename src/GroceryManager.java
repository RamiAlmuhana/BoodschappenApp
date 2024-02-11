import java.util.ArrayList;
import java.util.Random;

public class GroceryManager {
    private ArrayList<Item> groceryList = new ArrayList<>();
    private ArrayList<Item> snackList = new ArrayList<>();



    public GroceryManager() {
        groceryList.add(new Item("Komkommer", "Groenten", 1, 10.50));
        groceryList.add(new Item("Tomaat", "Groenten", 1, 10.50));
        groceryList.add(new Item("Banaan", "Fruit", 1, 10.50));
        groceryList.add(new Item("Watermeloen", "Fruit", 1, 10.50));
        groceryList.add(new Item("Kaas", "Zuivel", 1, 10.50));

        snackList.add(new Item("M&M", "Chocolade", 1, 10.50));
        snackList.add(new Item("Milka", "Chocolade", 1, 10.50));
        snackList.add(new Item("Cheetos", "Chips", 1, 10.50));
        snackList.add(new Item("Doritos", "Chips", 1, 10.50));
        snackList.add(new Item("Borrelnootjes", "Noten", 1, 10.50));
    }

    public void printGroceryList(){
        for (Item item : groceryList){
            String toString = item.toString();
            System.out.println(toString);
        }
    }

    public double calculateTotalPriceGroceries(){
        double totalPrice = 0.0;
        for (Item item : groceryList){
            totalPrice += item.getPrice();
        }
        return Math.round(totalPrice * 100.0) / 100.0;
    }

    public void addSnacksRandomlyWithGivenAmount(int amount){
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int randomIndex = random.nextInt(snackList.size());
            groceryList.add(snackList.get(randomIndex));
        }
    }

    public void addSnack(Item snack){
        snackList.add(snack);
    }
    public void addGrocery(Item grocery){
        groceryList.add(grocery);
    }

    public ArrayList<Item> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(ArrayList<Item> groceryList) {
        this.groceryList = groceryList;
    }

    public ArrayList<Item> getSnackList() {
        return snackList;
    }

    public void setSnackList(ArrayList<Item> snackList) {
        this.snackList = snackList;
    }
}
