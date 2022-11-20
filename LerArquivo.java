import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LerArquivo {

    public Map<String, String> programa = new HashMap<String, String>();
    public Map<String, Integer> valores = new HashMap<String, Integer>();

    public Dados Armazena(String nomeArquivo) {

        BufferedReader br = null;
        String linha = "";
        String nome = "";
        String valor = "";
        Dados dados = null;


        try {
            br = new BufferedReader(new FileReader(nomeArquivo));

            while ((linha = br.readLine()) != null){
                System.out.println(linha);

                if(linha.substring(0, 1).equalsIgnoreCase("i")){
                    for(int i=4; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(",")) break;
                        nome = nome + linha.substring(i, i+1);
                    }
                    for(int i=7; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        valor = valor + linha.substring(i, i+1);
                    }

                    programa.put("in", nome);
                    valores.put(nome, Integer.parseInt(valor));
                }

                else {
                    for(int i=5; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        nome = nome + linha.substring(i, i+1);
                    }
                    programa.put("out", nome);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dados = new Dados(programa, valores);
        return dados;
    }
}
