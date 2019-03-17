package service.possipleException;

public class NotValidFileException extends Exception {
    public NotValidFileException() {
    }

    public NotValidFileException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotValidFileException(Throwable throwable) {
        super(throwable);
    }

    public NotValidFileException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

    public NotValidFileException(String s) {
        super(s);
    }

}
