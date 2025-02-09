package main.utils;

/**
 * A functional interface for parsing user input into a specified type.
 *
 * <p>This interface allows for flexible and reusable parsing logic,
 * enabling the conversion of string input into different types.</p>
 *
 * @param <T> The type to which the input string should be parsed.
 */
@FunctionalInterface
public interface InputParser<T> {

    /**
     * Parses the given input string into the specified type.
     *
     * @param input The input string to be parsed.
     * @return The parsed value of type {@code T}.
     * @throws IllegalArgumentException If the input cannot be parsed.
     */
    T parse(String input) throws IllegalArgumentException;
}
