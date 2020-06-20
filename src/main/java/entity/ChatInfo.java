package entity;

import java.io.Serializable;

public class ChatInfo implements Serializable {
    private int senderId;
    private int receiverId;
    private String sendTime;
    private String content;

    public int getSenderId() { // Offline message initialization
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatInfo{" +
                "senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", sendTime='" + sendTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
