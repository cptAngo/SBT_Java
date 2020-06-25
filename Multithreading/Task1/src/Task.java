import java.util.concurrent.Callable;

public class Task<T>  {
    private final Callable<? extends T> callable;

    private volatile boolean mustDo = true;
    private MyException exception;
    private volatile T result = null;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public synchronized T get() throws Exception {
        T t = this.result;
        if(mustDo) {
            synchronized (this) {
                if(mustDo) {
                    try {
                        result = callable.call();
                    }
                    catch (Throwable e) {
                        this.exception = (MyException) e;
                    }
                    mustDo = false;
                }
                else {
                    t = result;
                }
            }
        }

        if(exception != null) {
            throw exception;
        }

        return t;
    }
}

class MyException extends RuntimeException {
    MyException (String message) {
        super(message);
    }
}