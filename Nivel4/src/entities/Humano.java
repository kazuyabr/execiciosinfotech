package entities;

public class Humano extends Personagem{
   
    public Humano(String nome) {
        super(nome, 2000, 15, 20, 20, 40, 1);
    }

    @Override
    public int atacar() {
        return Habilidade.ataqueBasico(forca);
    }

    @Override
    public void receberDano(int dano) {
        this.vida -= dano;
    }
}
