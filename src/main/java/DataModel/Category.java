package DataModel;

/**
 * Represents a category entity.
 * <p>
 * This class encapsulates the information related to a category.
 * It contains methods for retrieving and setting the id and name of the category.
 * </p>
 */
public class Category {
    private int id;
    private String name;

    //Constructor
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
