package michael.dsalgo.Chapter06.PositionList;

/**
 * Execptions about PositionList
 * InvalidPositionException
 * BoundaryViolentException
 */
public class PositionException {
    public static class InvalidPositionException extends RuntimeException {
        public InvalidPositionException(String err) {
            super(err);
        }
    }

    public static class BoundaryViolentException extends RuntimeException {
        public BoundaryViolentException(String err) {
            super(err);
        }
    }

    public static class EmptyListException extends RuntimeException {
        public EmptyListException(String err) { super(err); }
    }
}
