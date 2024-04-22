package DataManager;

import DataModel.Category;
import DataModel.Pet;
import DataModel.Tag;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * Serializes a Pet object to JSON format.
 *
 * @return The JSON representation of the Pet object.
 */
public class PetManager {
    public static String serializePetToJson() {
        Category category = new Category(1, "string");
        List<String> photoUrls = Arrays.asList("string");
        List<Tag> tags = Arrays.asList(new Tag(1, "string"));
        // Create a Pet object and set its field values
        Pet pet = new Pet();
        pet.setId(1);
        pet.setCategory(category);
        pet.setName("doggie");
        pet.setPhotoUrls(photoUrls);
        pet.setTags(tags);
        pet.setStatus("available");
        try {
            // Use an ObjectMapper object to serialize the Pet object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPet = objectMapper.writeValueAsString(pet);
            // Print the generated JSON
            //   System.out.println("JSON Pet: " + jsonPet);
            return jsonPet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
