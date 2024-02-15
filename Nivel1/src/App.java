import entities.Anao;
import entities.Elfo;
import entities.Humano;

public class App {
    public static void main(String[] args) {
        
        
                Anao anao = new Anao("Thorin");
                Humano humano = new Humano("Aragorn");
                Elfo elfo = new Elfo("Legolas");
        
                System.out.println("Anao: " + anao.getNome() + "\n Level: " + anao.getLevel() + "\n Vida: " + anao.getVida() + "\n Força: " + anao.getForca() + "\n Magia: " + anao.getMagia() + "\n Agilidade: " + anao.getAgilidade() + "\n Inteligencia: " + anao.getInteligencia());
                System.out.println("\n\nHumano: " + humano.getNome() + "\n Level: " + humano.getLevel() + "\n Vida: " + humano.getVida() + "\n Força: " + humano.getForca() + "\n Magia: " + humano.getMagia() + "\n Agilidade: " + humano.getAgilidade() + "\n Inteligencia: " + humano.getInteligencia());
                System.out.println("\n\nElfo: " + elfo.getNome() + "\n Level: " + elfo.getLevel() + "\n Vida: " + elfo.getVida() + "\n Força: " + elfo.getForca() + "\n Magia: " + elfo.getMagia() + "\n Agilidade: " + elfo.getAgilidade() + "\n Inteligencia: " + elfo.getInteligencia());
        
    }
}
