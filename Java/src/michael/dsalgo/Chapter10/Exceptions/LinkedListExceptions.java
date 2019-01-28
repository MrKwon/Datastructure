package michael.dsalgo.Chapter10.Exceptions;

public class LinkedListExceptions {
    public static class InvalidPositionException extends RuntimeException {
        public InvalidPositionException(String err) { super(err); }
    }

    public static class BoundaryViolentException extends RuntimeException {
        public BoundaryViolentException(String err) { super(err); }
    }

    public static class EmptyLinkedListException extends RuntimeException {
        public EmptyLinkedListException(String err) { super(err); }
    }
}
