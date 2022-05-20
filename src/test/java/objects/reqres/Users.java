package objects.reqres;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Users {
    Integer id;
    String email;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    String avatar;
}
