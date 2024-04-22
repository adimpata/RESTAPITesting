package DataModel;

import java.util.List;

/**
 * Represents a pet entity.
 * <p>
 * This class encapsulates the information related to a pet.
 * It contains methods for retrieving and setting the id, category, name,
 * photo URLs, tags, and status of the pet.
 * </p>
 */
public class Pet {
    private int id;
    private DataModel.Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    //Constructor
    public Pet(int id, DataModel.Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }

    //Getter and setters
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(DataModel.Category category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", category=" + category + ", name='" + name + '\'' + ", photoUrls=" + photoUrls + ", tags=" + tags + ", status='" + status + '\'' + '}';
    }
}
