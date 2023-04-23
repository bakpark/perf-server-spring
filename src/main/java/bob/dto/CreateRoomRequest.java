package bob.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateRoomRequest {
    private String roomId;
    private List<String> users;
}
