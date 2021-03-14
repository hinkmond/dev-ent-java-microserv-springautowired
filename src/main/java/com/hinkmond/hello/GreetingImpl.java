package com.hinkmond.hello;

public class GreetingImpl implements Greeting {
    private long instanceID;
    private String instanceContent;

    public GreetingImpl(long id, String content) {
        this.instanceID = id;
        this.instanceContent = content;
    }

    public long getId() {
        return instanceID;
    }

    public String getContent() {
        return instanceContent;
    }
}