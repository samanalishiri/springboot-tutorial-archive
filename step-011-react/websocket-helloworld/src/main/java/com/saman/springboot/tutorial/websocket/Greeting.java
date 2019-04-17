package com.saman.springboot.tutorial.websocket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class Greeting {

    private String content;


    @JsonIgnore
    private Greeting(Builder builder) {
        setContent(builder.content);
    }

    @JsonIgnore
    public static Builder builder() {
        return new Builder();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonIgnoreType
    public static final class Builder {
        private String content;

        private Builder() {
        }

        public Builder hello(String val) {
            content = String.format("Hello %s", val);
            return this;
        }

        public Builder bye(String val) {
            content = String.format("Bye %s", val);
            return this;
        }

        public Greeting build() {
            return new Greeting(this);
        }
    }
}
