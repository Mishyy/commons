package co.mhdv.commons.builders;

import javafx.util.Pair;

public class MessageBuilder {

    private String message;

    private MessageBuilder(String message) {
        this.message = message;
    }

    public static MessageBuilder of(String message) {
        return new MessageBuilder(message);
    }

    public MessageBuilder replace(Pair<String, Object> replacement) {
        this.message = this.message.replaceAll(replacement.getKey(), "" + replacement.getValue());
        return this;
    }

    public String build() {
        return this.message;
    }

}
