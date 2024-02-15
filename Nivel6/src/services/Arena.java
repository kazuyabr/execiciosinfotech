package services;

import java.util.Random;

import entities.Personagem;
import exceptions.DueloInvalidoException;
import exceptions.NivelBaixoException;

public class Arena {
    public static void duelar(Personagem personagem1, Personagem personagem2) throws NivelBaixoException, DueloInvalidoException {

        if (personagem1.getClass() == personagem2.getClass()) {
            throw new DueloInvalidoException(personagem1.getNome());
        }

        System.out.println("Começando o duelo entre " + personagem1.getNome() + " e " + personagem2.getNome() + "!");
        
        Random random = new Random();
        
        while (personagem1.getVida() > 0 && personagem2.getVida() > 0) {
            // Personagem 1 ataca
            int dano1 = personagem1.atacar();
            personagem2.receberDano(dano1);
            System.out.println(personagem1.getNome() + " ataca " + personagem2.getNome() + " e causa " + dano1 + " de dano!");
            
            // Verifica se o personagem 2 ainda está vivo
            if (personagem2.getVida() <= 0) {
                System.out.println(personagem2.getNome() + " foi derrotado!");
                System.out.println(personagem1.getNome() + " é o campeao!");
                return; // Termina o duelo com sucesso
            }
            
            // Personagem 2 ataca
            int dano2 = personagem2.atacar();
            personagem1.receberDano(dano2);
            System.out.println(personagem2.getNome() + " ataca " + personagem1.getNome() + " e causa " + dano2 + " de dano!");
            
            // Verifica se o personagem 1 ainda está vivo
            if (personagem1.getVida() <= 0) {
                System.out.println(personagem1.getNome() + " foi derrotado!");
                System.out.println(personagem2.getNome() + " é o campeão!");
                return; // Termina o duelo com sucesso
            }
        }
        if (personagem1.getLevel() < 10 || personagem2.getLevel() < 10) {
            String nomePersonagemNivelBaixo = personagem1.getLevel() < 10 ? personagem1.getNome() : personagem2.getNome();
            throw new NivelBaixoException(nomePersonagemNivelBaixo);
        }
    }
}
