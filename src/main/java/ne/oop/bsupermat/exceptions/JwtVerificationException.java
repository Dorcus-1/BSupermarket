package ne.oop.bsupermat.exceptions;

public class JwtVerificationException extends RuntimeException{
    public JwtVerificationException(){}
    public JwtVerificationException (String message,Throwable cause){
        super(message,cause);
    }
}
