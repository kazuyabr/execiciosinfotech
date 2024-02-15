package services;

public class Experiencia {
    private static final int EXPERIENCIA_MAXIMA = 1000;

    public static int calcularNivel(int experiencia) {
        int nivel = experiencia / EXPERIENCIA_MAXIMA + 1;
        return nivel > 99 ? 99 : nivel;
    }

    public static int calcularExperienciaParaProximoNivel(int experiencia) {
        int nivelAtual = calcularNivel(experiencia);
        return EXPERIENCIA_MAXIMA * (nivelAtual + 1) - experiencia;
    }

    public static int calcularExperienciaParaNivel(int nivelDesejado) {
        int experienciaTotal = 0;
        for (int nivel = 1; nivel <= nivelDesejado; nivel++) {
            experienciaTotal += EXPERIENCIA_MAXIMA * nivel;
        }
        return experienciaTotal;
    }

    public static int calcularExperienciaParaMonstro(int nivelPersonagem) {
        
        return (int) (50 * Math.pow(1.1, nivelPersonagem - 1));
    }

    public static int limitarExperiencia(int experiencia) {
        if (experiencia > EXPERIENCIA_MAXIMA * 99) {
            return EXPERIENCIA_MAXIMA * 99;
        }
        return experiencia;
    }
}

