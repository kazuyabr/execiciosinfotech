import entities.Anao;
import entities.Elfo;
import entities.Humano;
import exceptions.DueloInvalidoException;
import exceptions.NivelBaixoException;
import exceptions.VidaBaixaException;
import services.Aventura;

public class App {
    public static void main(String[] args) {
        Anao anao = new Anao("Thorin");
        Humano humano = new Humano("Aragorn");
        Elfo elfo = new Elfo("Legolas");

        
        System.out.println("Anao:");
        System.out.println("Nome: " + anao.getNome() + "\nLevel: " + anao.getLevel() + "\nVida: " + anao.getVida() + "\nForça: " + anao.getForca() + "\nMagia: " + anao.getMagia() + "\nAgilidade: " + anao.getAgilidade() + "\nInteligencia: " + anao.getInteligencia());
        System.out.println();

        System.out.println("Humano:");
        System.out.println("Nome: " + humano.getNome() + "\nLevel: " + humano.getLevel() + "\nVida: " + humano.getVida() + "\nForça: " + humano.getForca() + "\nMagia: " + humano.getMagia() + "\nAgilidade: " + humano.getAgilidade() + "\nInteligencia: " + humano.getInteligencia());
        System.out.println();

        System.out.println("Elfo:");
        System.out.println("Nome: " + elfo.getNome() + "\nLevel: " + elfo.getLevel() + "\nVida: " + elfo.getVida() + "\nForça: " + elfo.getForca() + "\nMagia: " + elfo.getMagia() + "\nAgilidade: " + elfo.getAgilidade() + "\nInteligencia: " + elfo.getInteligencia());


        try {
           Aventura humanoAventura = new Aventura(humano);
           Aventura elfoAventura = new Aventura(elfo);
           Aventura anaoAventura = new Aventura(anao);
        } catch (VidaBaixaException e) {
            System.out.println("Cuidado " +  e.getMessage());
        }
        catch (NivelBaixoException e) {
            System.out.println("Cuidado: " + e.getMessage());
        }
        catch (DueloInvalidoException e) {
            System.out.println("Cuidado: " + e.getMessage());
        }
    }
}
