package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Personagem;

public class Aventura {
    private List<String> objetosMagicos;

    public Aventura(Personagem personagem) {
        this.objetosMagicos = new ArrayList<>();
        inicializarObjetosMagicos(personagem);
    }

    private void inicializarObjetosMagicos(Personagem personagem) {
        this.objetosMagicos.add("Espada Magica");
        this.objetosMagicos.add("Pocao de Cura");
        this.objetosMagicos.add("Amuleto da Protecao");
        this.objetosMagicos.add("Varinha Encantada");
        this.objetosMagicos.add("Anel da Invisibilidade");
        explorar(personagem);
    }

    public void explorar(Personagem personagem) {
        Random random = new Random();
        int chanceEvento = random.nextInt(100);

        if (chanceEvento < 30) { // 30% de chance de encontrar um objeto mágico
            int indiceObjeto = random.nextInt(objetosMagicos.size());
            String objetoMagicoEncontrado = objetosMagicos.get(indiceObjeto);
            personagem.adicionarItemInventario(objetoMagicoEncontrado);
            System.out.println(personagem.getNome() + " encontrou um objeto magico: " + objetoMagicoEncontrado);
        } else if (chanceEvento >= 30 && chanceEvento < 60) { // 30% de chance de combate
            combater(personagem);
        } else {
            System.out.println(personagem.getNome() + " explorou, mas nao encontrou nada desta vez.");
        }
    }

    private void combater(Personagem personagem) {
        Random random = new Random();
        int forcaMonstro = random.nextInt(50) + 50; // Força do monstro varia entre 50 e 99
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
