package exceptions;

public class VidaBaixaException extends Exception {
    public VidaBaixaException(String nomePersonagem) {
        super(nomePersonagem+" você esta com menos de 50 de vida, se duelar vai morrer!");
    }
}

