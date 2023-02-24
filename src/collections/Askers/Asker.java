package collections.Askers;


/**
 * Abstract class for asking objects
 *
 * @param <T> type of object to be asked
 */
public abstract class Asker<T> {
    public abstract T build();
}
