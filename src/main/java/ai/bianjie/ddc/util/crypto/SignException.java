package ai.bianjie.ddc.util.crypto;

public class SignException extends RuntimeException {
    final String message;

    public SignException(String msg) {
        this.message = msg;
    }
}
