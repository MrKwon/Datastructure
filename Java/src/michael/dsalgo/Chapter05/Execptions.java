package michael.dsalgo.Chapter05;

public class Execptions {
    public static class EmptyStackExecption extends RuntimeException {
        public EmptyStackExecption(String err) { super(err); }
    }

    public static class FullStackExecption extends RuntimeException {
        public FullStackExecption(String err) { super(err); }
    }

    public static class EmptyQueueExecption extends RuntimeException {
        public EmptyQueueExecption(String err) { super(err); }
    }

    public static class FullQueueExecption extends RuntimeException {
        public FullQueueExecption(String err) { super(err); }
    }
}