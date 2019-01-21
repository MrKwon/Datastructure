package michael.dsalgo.Chapter08.Exceptions;

public class EntryExceptions {
    public static class InvalidEntryException extends RuntimeException {
        public InvalidEntryException(String err) { super(err); }
    }
}
