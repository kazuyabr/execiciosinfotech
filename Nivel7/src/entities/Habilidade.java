package entities;

public class Habilidade {
    public static int ataqueBasico(int forca) {
        return forca * 2;
    }

    
    public static int ataqueEpico(int forca) {
        return forca * 4;
    }

    public static int magiaSimples(int inteligencia) {
        return inteligencia * 2;
    }

    public static int magiaAvancada(int inteligencia) {
        return inteligencia * 3;
    }

}
