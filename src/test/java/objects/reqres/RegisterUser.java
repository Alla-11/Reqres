package objects.reqres;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUser {
    String email;
    String password;
}
