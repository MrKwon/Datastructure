package michael.dsalgo.Chapter05.Deque;

public class DequeException {
    public static class EmptyDequeException extends RuntimeException{
        public EmptyDequeException(String err) {
            super(err);
        }
    }
}
