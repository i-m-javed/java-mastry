package diwithmap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@Data
@AllArgsConstructor
public class Kit {
    private String name;
    private Map<String, Integer> items;

}
