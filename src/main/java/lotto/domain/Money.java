package lotto.domain;

public class Money {
    private final int value;

    public Money(final String value) {
        this(Integer.parseInt(value));
    }

    public Money(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}