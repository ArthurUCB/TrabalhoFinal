

public class Artigo {
    private String title;
    private String abstractText;

    public Artigo(String title, String abstractText) {
        this.title = title;
        this.abstractText = abstractText;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public boolean contem(String termo) {
        return title.toLowerCase().contains(termo.toLowerCase()) ||
               abstractText.toLowerCase().contains(termo.toLowerCase());
    }

    @Override
    public String toString() {
        return "Título: " + title + "\nResumo: " + abstractText + "\n";
    }
}
