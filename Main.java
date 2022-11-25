import java.util.HashMap;
import java.util.Map;

public class Main{

    private Map<String, String> programa = new HashMap<String, String>();
    private Map<String, Integer> valores = new HashMap<String, Integer>();
    public static void main(String[] args) {

        
        LerArquivo lerArquivo = new LerArquivo();

        Dados dados = lerArquivo.Armazena("caso1.txt");

        
    
    }
}