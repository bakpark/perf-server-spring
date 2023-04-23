package bob.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "chat")
@NoArgsConstructor
@Getter
@Setter
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    private String message;
    private String senderId;
    private String roomId;
    private LocalDateTime createdAt;

    public ChatEntity(String message, String senderId, String roomId) {
        this.message = message;
        this.senderId = senderId;
        this.roomId = roomId;
        this.createdAt = LocalDateTime.now();
    }

}
