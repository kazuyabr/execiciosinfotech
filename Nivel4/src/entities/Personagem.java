package entities;

import interfaces.Lutador;

public abstract class Personagem implements Lutador {

    protected String nome;
    protected Integer vida;
    protected Integer forca;
    protected Integer magia;
    protected Integer agilidade;
    protected Integer inteligencia;
    protected Integer level;

    
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


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return this.vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getForca() {
        return this.forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getMagia() {
        return this.magia;
    }

    public void setMagia(Integer magia) {
        this.magia = magia;
    }

    public Integer getAgilidade() {
        return this.agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getInteligencia() {
        return this.inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
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
    
}
