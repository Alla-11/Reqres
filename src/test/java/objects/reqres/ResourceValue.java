package objects.reqres;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResourceValue {
    Integer id;
    String name;
    String year;
    String color;
    @SerializedName("pantone_value")
    String pantoneValue;
}
