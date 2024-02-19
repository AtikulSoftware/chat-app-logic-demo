package com.example.chatapp.model;

public class Message {
    private String senderName;
    private String messageContent;
    private long timestamp;

    public Message(String senderName, String messageContent, long timestamp) {
        this.senderName = senderName;
        this.messageContent = messageContent;
        this.timestamp = timestamp;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

} // Message end here ============
