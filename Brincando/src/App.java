import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import entities.Anao;
import entities.Elfo;
import entities.Humano;
import entities.Personagem;
import exceptions.DueloInvalidoException;
import exceptions.NivelBaixoException;
import exceptions.VidaBaixaException;
import services.Arena;
import services.Aventura;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personagem personagemCriado = null;
        Personagem npcUm = null;
        boolean personagemCriadoFlag = false;

        boolean encerrar = false;
        while (!encerrar) {
            System.out.println("===== Menu Principal =====");
            if (!personagemCriadoFlag) {
                System.out.println("1 - Criar personagem");
            } else {
                System.out.println("1 - Ver Status\t2 - Ver Inventario");
                System.out.println("3 - Se aventurar\t4 - Duelar");
            }
            System.out.println("0 - Encerrar a aplicacao");
            System.out.print("Digite a opcao: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        if (!personagemCriadoFlag) {
                            personagemCriado = criarPersonagem(scanner);
                            npcUm = criarNPCComRacaRestante(personagemCriado);
                            personagemCriadoFlag = true;
                        } else {
                            personagemCriado.mostrarAtributos();
                        }
                        break;
                    case 2:
                        if (personagemCriadoFlag) {
                            System.out.println("Inventário:");
                            System.out.println(personagemCriado.getInventory());
                        } else {
                            System.out.println("Crie um personagem primeiro.");
                        }
                        break;
                    case 3:
                        if (personagemCriadoFlag) {
                            Aventura minhaAventura = new Aventura(personagemCriado);
                        } else {
                            System.out.println("Crie um personagem primeiro.");
                        }
                        break;
                    case 4:
                        if (personagemCriadoFlag && npcUm != null) {
                            try {
                                Arena.duelar(personagemCriado, npcUm);
                            } catch (NivelBaixoException e) {
                                System.out.println("O NPC nao está pronto para duelar. Ele vai se aventurar para ganhar experiência.");
                                new Aventura(npcUm);
                            }
                        } else {
                            System.out.println("Crie um personagem e um NPC primeiro.");
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando a aplicacao...");
                        encerrar = true;
                        break;
                    default:
                        System.out.println("Opcao inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            } catch (VidaBaixaException | NivelBaixoException | DueloInvalidoException e) {
                System.out.println("Cuidado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static Personagem criarPersonagem(Scanner scanner) {
        System.out.println("Escolha a raca do seu personagem:");
        System.out.println("1 - Elfo\t2 - Humano\t3 - Anao");
        int raca = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        switch (raca) {
            case 1:
                return new Elfo(nome);
            case 2:
                return new Humano(nome);
            case 3:
                return new Anao(nome);
            default:
                System.out.println("Opcao inválida. Tente novamente.");
                return null;
        }
    }

    public static Personagem criarNPCComRacaRestante(Personagem personagemCriado) {
        Random random = new Random();
        String nomeNPC = "NPC_" + random.nextInt(1000); 
    
        if (personagemCriado instanceof Humano) {
            return new Elfo(nomeNPC);
        } else if (personagemCriado instanceof Elfo) {
            return new Anao(nomeNPC);
        } else if (personagemCriado instanceof Anao) {
            return new Humano(nomeNPC);
        } else {
            return null;
        }
    }
}
