package michael.dsalgo.Chapter09.Exceptions;

public class EntryException {
    public static class InvalidKeyException extends RuntimeException {
        public InvalidKeyException(String err) { super(err); }
    }
}
