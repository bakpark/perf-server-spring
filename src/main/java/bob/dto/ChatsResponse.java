package bob.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatsResponse(List<String> chats) {

    public static ChatsResponse empty() {
        return new ChatsResponse(Collections.emptyList());
    }
}
