package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Personagem;
import exceptions.DueloInvalidoException;
import exceptions.NivelBaixoException;
import exceptions.VidaBaixaException;

public class Aventura {
    private List<String> objetosMagicos;
    private static final int VIDA_MINIMA_PARA_AVENTURA = 50;

    public Aventura(Personagem personagem) throws VidaBaixaException, NivelBaixoException, DueloInvalidoException {
        this.objetosMagicos = new ArrayList<>();
        inicializarObjetosMagicos(personagem);
    }

    private void inicializarObjetosMagicos(Personagem personagem) throws VidaBaixaException, NivelBaixoException, DueloInvalidoException {
        this.objetosMagicos.add("Espada Magica");
        this.objetosMagicos.add("Pocao de Cura");
        this.objetosMagicos.add("Amuleto da Protecao");
        this.objetosMagicos.add("Varinha Encantada");
        this.objetosMagicos.add("Anel da Invisibilidade");

        if (personagem.getVida() < VIDA_MINIMA_PARA_AVENTURA) {
            throw new VidaBaixaException(personagem.getNome());
        }

        explorar(personagem);
    }
    
    public void explorar(Personagem personagem) throws NivelBaixoException, DueloInvalidoException {
        Random random = new Random();
        
        while (true) {
            int chanceEvento = random.nextInt(100);

            if (chanceEvento < 30) {
                int indiceObjeto = random.nextInt(objetosMagicos.size());
                String objetoMagicoEncontrado = objetosMagicos.get(indiceObjeto);
                personagem.adicionarItemInventario(objetoMagicoEncontrado);
                System.out.println(personagem.getNome() + " encontrou um objeto magico: " + objetoMagicoEncontrado);
            } else if (chanceEvento >= 30 && chanceEvento < 60) { 
                try {
                    combater(personagem);
                } catch (NivelBaixoException e) {
                    throw new NivelBaixoException(personagem.getNome());
                } catch (DueloInvalidoException e) {
                    throw new DueloInvalidoException(personagem.getNome());
                }
            } else {
                System.out.println(personagem.getNome() + " explorou, mas nao encontrou nada desta vez.");
            }

            if (personagem.verificarLevelUp()) {
                System.out.println(personagem.getNome() + " subiu para o nível " + personagem.getLevel() + "!");
                break; 
            }
        }
    }

    private void combater(Personagem personagem) throws NivelBaixoException, DueloInvalidoException {
        Random random = new Random();
        int forcaMonstro = random.nextInt(50) + 50;
        int danoPersonagem = personagem.atacar();
        int danoMonstro = random.nextInt(forcaMonstro);
    
        System.out.println(personagem.getNome() + " ataca o monstro e causa " + danoPersonagem + " de dano!");
        System.out.println("O monstro contra-ataca e causa " + danoMonstro + " de dano a " + personagem.getNome() + "!");
    
        if (danoPersonagem > danoMonstro) {
            System.out.println(personagem.getNome() + " derrotou o monstro!");
            personagem.ganharExperiencia(100);
        } else {
            System.out.println(personagem.getNome() + " foi derrotado pelo monstro...");
            personagem.receberDano(danoMonstro);
        }
    }
}
