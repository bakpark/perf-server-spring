package bob.repository;

import bob.model.ChatEntity;
import bob.model.QChatEntity;
import bob.model.QEntranceEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatRepositoryCustom extends QuerydslRepositorySupport {
    public ChatRepositoryCustom() {
        super(ChatEntity.class);
    }

    private QChatEntity chat = QChatEntity.chatEntity;
    private QEntranceEntity entrance = QEntranceEntity.entranceEntity;

    public List<ChatEntity> findAllChatsUserReceived(String userId, int pageSize) {
        return from(chat)
                .innerJoin(chat).on(chat.roomId.eq(entrance.roomId))
                .where(entrance.roomId.eq(userId))
                .orderBy(chat.createdAt.desc())
                .limit(pageSize)
                .fetch();
    }
}
