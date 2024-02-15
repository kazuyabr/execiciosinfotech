package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.Lutador;
import services.Experiencia;

public abstract class Personagem implements Lutador {

    protected String nome;
    protected Integer vida;
    protected Integer forca;
    protected Integer magia;
    protected Integer agilidade;
    protected Integer inteligencia;
    protected int experiencia;
    private int level;    
    protected List<String> inventario = new ArrayList<String>();

    
    public Personagem() {
    }

    
    public Personagem(String nome, Integer vida, Integer forca, Integer magia, Integer agilidade, Integer inteligencia, Integer level) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.magia = magia;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.level = level;
    }


    public void mostrarAttributos() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        System.out.println("Magia: " + magia);
        System.out.println("Agilidade: " + agilidade);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Level: " + level);
    }
    
    @Override
    public abstract int atacar();
    
    @Override
    public abstract void receberDano(int dano);

    public void adicionarItemInventario(String item) {
        inventario.add(item);
    }

    public void ganharExperiencia(int experienciaGanha) {
        this.experiencia += experienciaGanha;
        this.experiencia = Experiencia.limitarExperiencia(this.experiencia); // Limita a experiência máxima

        this.level = Experiencia.calcularNivel(this.experiencia);
    }
    

    public void lutarContraMonstro(Monstro monstro) {
        System.out.println(nome + " está lutando contra " + monstro.getNome() + "!");
    
        while (vida > 0 && monstro.getVida() > 0) {
            int danoPersonagem = atacar();
            int danoMonstro = monstro.getForca(); // O monstro sempre ataca com sua força
    
            monstro.receberDano(danoPersonagem);
            System.out.println(nome + " ataca " + monstro.getNome() + " causando " + danoPersonagem + " de dano.");
    
            if (monstro.getVida() <= 0) {
                System.out.println(monstro.getNome() + " foi derrotado!");
                ganharExperiencia(100); // Ganha 100 de experiência por derrotar o monstro
                break;
            }
    
            receberDano(danoMonstro);
            System.out.println(monstro.getNome() + " ataca " + nome + " causando " + danoMonstro + " de dano.");
    
            if (vida <= 0) {
                System.out.println(nome + " foi derrotado por " + monstro.getNome() + "!");
                break;
            }
        }
    }

    public String getNome() {
        return this.nome;
    }
    
    public int getVida() {
        return this.vida;
    }

    public int getForca() {
        return this.forca;
    }

    public int getMagia() {
        return this.magia;
    }

    public int getAgilidade() {
        return this.agilidade;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public int getLevel() {
        return level;
    }

    

    public void setLevel(int level) {
        this.level = level;
        this.experiencia = Experiencia.calcularExperienciaParaNivel(level - 1);
    }

    public List<String> getInventory() {
        List<String> inventoryList = new ArrayList<>();
        for (int i = 0; i < this.inventario.size(); i++) {
            inventoryList.add(i + " - " + this.inventario.get(i));
        }
        return inventoryList;
    }
    

}
