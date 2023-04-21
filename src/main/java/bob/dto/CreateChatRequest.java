package bob.dto;

public class CreateChatRequest {
    private String roomId;
    private String senderId;
    private String message;

    public String getRoomId() {
        return roomId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}
