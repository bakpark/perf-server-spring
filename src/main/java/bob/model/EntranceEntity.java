package bob.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "entrance")
@NoArgsConstructor
@Getter
@Setter
public class EntranceEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long entranceId;
    private String roomId;
    private String userId;
    private LocalDateTime createdAt;

    public EntranceEntity(String roomId, String userId){
        this.roomId = roomId;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }
}
