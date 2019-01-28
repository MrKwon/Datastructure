package michael.dsalgo.Chapter10.Exceptions;

public class EntryExceptions {
    public static class InvalidEntryException extends RuntimeException {
        public InvalidEntryException(String err) { super(err); }
    }

    public static class InvalidKeyException extends RuntimeException {
        public InvalidKeyException(String err) { super(err); }
    }
}
