import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

    private static final String HOST = "localhost";
    private static final int PORTA_SERVIDOR_A = 5000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("== CLIENTE ==");
        System.out.print("Digite o termo de busca: ");
        String termo = scanner.nextLine();

        try (
            Socket socket = new Socket(HOST, PORTA_SERVIDOR_A);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            // Envia termo
            out.println(termo);

            // Recebe artigos
            Object obj = in.readObject();
            List<Artigo> resultados = (List<Artigo>) obj;

            // Exibe resultados
            System.out.println("\n=== RESULTADOS ENCONTRADOS ===");
            if (resultados.isEmpty()) {
                System.out.println("Nenhum artigo encontrado.");
            } else {
                for (Artigo artigo : resultados) {
                    System.out.println(artigo);
                    System.out.println("----------------------------");
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
