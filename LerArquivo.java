import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LerArquivo {

    public Map<String, String> programa = new HashMap<String, String>();
    public Map<String, Integer> valores = new HashMap<String, Integer>();
    public Map<String, Integer> auxMap = new HashMap<String, Integer>();

    public Dados Armazena(String nomeArquivo) {

        BufferedReader br = null;
        String linha = "";
        String nome = "";
        String valor = "";
        Dados dados = null;
        int cont = 0;


        try {
            br = new BufferedReader(new FileReader(nomeArquivo));

            int num = 1;
            while ((linha = br.readLine()) != null){
                
                cont = -1;
                System.out.println(linha);

                if(linha.substring(0, 1).equalsIgnoreCase("i")){

                    for(int i=3; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(",")) break;
                        cont++;
                        nome = nome + linha.substring(i, i+1);
                    }

                    for(int i=6+cont; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        valor = valor + linha.substring(i, i+1);
                    }

                    if(temNome(nome) == true) {
                        auxMap.put(num + nome, Integer.parseInt(valor));
                    } else valores.put(nome, Integer.parseInt(valor));

                    programa.put(num + " in", nome);
                    nome = "";
                    valor = "";
                    num++;
                }

                else {
                    for(int i=4; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        nome = nome + linha.substring(i, i+1);
                    }
                    programa.put(num + " out", nome);
                    nome = "";
                    valor = "";
                    num++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dados = new Dados(programa, valores, auxMap);

        return dados;
    }

    public boolean temNome(String nome){
        for (Map.Entry<String, String> entrada : programa.entrySet()) { 
            if(entrada.getValue().equals(nome)) return true;
        }
        return false;
    }
}
