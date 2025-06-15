package utils;

import java.io.FileReader;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import Artigo;

public class JsonLoader {

    public static List<Artigo> carregarArtigos(String caminho) {
        List<Artigo> artigos = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(new FileReader(caminho));

            for (Object obj : jsonArray) {
                JSONObject artigoJson = (JSONObject) obj;
                String title = (String) artigoJson.get("title");
                String abstractText = (String) artigoJson.get("abstract");

                artigos.add(new Artigo(title, abstractText));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return artigos;
    }
}
