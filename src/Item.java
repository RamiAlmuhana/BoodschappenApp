public class Item {
    private String name;
    private String category;
    private int amount;
    private double price;

    public Item(String name, String category, int amount, double price) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.price = price;
    }

    public String toString(){
        return name + " - " + category + " - " + amount + " - " + price + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
