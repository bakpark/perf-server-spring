package bob.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RoomsResponse(List<String> rooms) {

    public static RoomsResponse empty() {
        return new RoomsResponse(Collections.emptyList());
    }
}
