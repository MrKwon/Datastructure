package michael.dsalgo.Chapter08.Exceptions;

public class PQExceptions {
    public static class EmptyPriorityQueueException extends RuntimeException {
        public EmptyPriorityQueueException(String err) { super(err); }
    }

    public static class InvalidKeyException extends RuntimeException {
        public InvalidKeyException(String err) { super(err); }
    }
}
