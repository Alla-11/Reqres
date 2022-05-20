package objects.reqres;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ListResource {
    ArrayList<ResourceValue> data;
}
