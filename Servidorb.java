import java.io.*;
import java.net.*;
import java.util.*;
import utils.JsonLoader;

public class ServidorB {

    private static final int PORTA = 5001;
    private static final String CAMINHO_JSON = "dados/arxiv_B.json";

    public static void main(String[] args) {
        List<Artigo> artigos = JsonLoader.carregarArtigos(CAMINHO_JSON);
        System.out.println("Servidor B iniciado. Aguardando conexão na porta " + PORTA);

        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> tratarConexao(socket, artigos)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tratarConexao(Socket socket, List<Artigo> artigos) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ) {
            String termo = in.readLine();
            System.out.println("[B] Buscando por: " + termo);

            List<Artigo> resultados = new ArrayList<>();
            for (Artigo artigo : artigos) {
                if (artigo.contem(termo)) {
                    resultados.add(artigo);
                }
            }

            out.writeObject(resultados);
            System.out.println("[B] Resultados enviados: " + resultados.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
