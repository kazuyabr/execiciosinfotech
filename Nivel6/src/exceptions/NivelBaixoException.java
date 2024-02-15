package exceptions;

public class NivelBaixoException extends Exception {
    public NivelBaixoException(String nomePersonagem) {
        super("Lamento "+nomePersonagem+", mas aqui e so os fortes e voce precisa estar pelo menos no nivel 10 para ser aceito!");
    }
}
