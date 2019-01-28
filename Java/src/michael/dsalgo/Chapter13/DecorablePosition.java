package michael.dsalgo.Chapter13;

public interface DecorablePosition<E>
        extends Position<E>, Map<Object, Object> {
    // this is a mixture of Position and Map
    // so no new methods needed
}
