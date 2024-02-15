package entities;

public class Anao extends Personagem{
   
    public Anao(String nome) {
        super(nome, 2000, 15, 20, 20, 40, 1);
    }

    @Override
    public int atacar() {
        return Habilidade.ataqueEpico(forca);
    }

    @Override
    public void receberDano(int dano) {
        this.vida -= dano;
    }
    
}
