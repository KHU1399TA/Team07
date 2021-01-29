
package main;

public class Food {
    
    int id;
    String name;
    String[] Ingredients;
    boolean isAvailable;
    
    Food(int id, String name, String[] Ingredients, boolean isAvailable) {
        
        this.id = id;
        this.name = name;
        this.Ingredients = Ingredients;
        this.isAvailable = isAvailable;
    }
    
    @Override
    public String toString() {
        return "-".repeat(34) + "\n Food {" + " ID = " + id + "\n Name = " + name
                + "\n Ingredients = " + Ingredients + "\n Is Available = " + isAvailable + " }";
    }
}