package co.mhdv.commons.utils;

import javafx.util.Pair;

public class Pairs {

    private final String key;
    private final Object value;

    private Pairs(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public static Pair<String, Object> of(String key, Object value) {
        final Pairs pair = new Pairs(key, value);
        return new Pair<>(pair.key, pair.value);
    }

}
