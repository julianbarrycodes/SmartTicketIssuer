@FunctionalInterface
public interface InputParser<T> {
    T parse(String input) throws IllegalArgumentException;
}
