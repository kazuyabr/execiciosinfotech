package exceptions;

public class DueloInvalidoException extends Exception{
    public DueloInvalidoException(String nomePersonagem) {
        super(nomePersonagem+" você esta sozinho na arena tente mais tarde!");
    }
}
