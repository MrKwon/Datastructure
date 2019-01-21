package michael.dsalgo.Chapter08.Exceptions;

public class TreeExceptions {
    /**
     * Thrown if a position provided as argument is not valid.
     * For example, it tis null reference of it has no associated list.
     */
    public static class InvalidPositionException extends RuntimeException {
        public InvalidPositionException(String err) {
            super(err);
        }
    }

    /**
     * Thrown if an attempt is made at accessing an element
     * whose position is outside the range of positions of the list.
     * For example, calling method next on the last position of the sequence
     */
    public static class BoundaryViolationException extends RuntimeException {
        public BoundaryViolationException(String err) {
            super(err);
        }
    }

    /**
     * Thrown if the tree target of method operation is empty
     */
    public static class EmptyTreeException extends RuntimeException {
        public EmptyTreeException(String err) {
            super(err);
        }
    }

    public static class NonEmptyTreeException extends RuntimeException {
        public NonEmptyTreeException(String err) { super(err); }
    }
}
