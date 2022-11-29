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
                        System.out.println("cont dentro" + cont);
                        nome = nome + linha.substring(i, i+1);
                    }

                    System.out.println("cont" + cont);

                    for(int i=6+cont; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        valor = valor + linha.substring(i, i+1);
                        System.out.println("Valor= " + valor);
                    }
                    

                    programa.put(num + "in", nome);
                    valores.put(nome, Integer.parseInt(valor));
                    nome = "";
                    valor = "";
                    num++;
                }

                else {
                    for(int i=4; i<=linha.length(); i++){
                        if(linha.substring(i, i+1).equals(")")) break;
                        nome = nome + linha.substring(i, i+1);
                    }
                    programa.put(num + "out", nome);
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

        dados = new Dados(programa, valores);

        // System.out.println("-------Programa!!-------");
        // for (Map.Entry<String, String> set :
        //      programa.entrySet()) {
 
            
        //     System.out.println(set.getKey() + " = "
        //                        + set.getValue());
        // }

        // System.out.println("-------Valores!!----------");
        // for (Map.Entry<String, Integer> set :
        //      valores.entrySet()) {
 
            
        //     System.out.println(set.getKey() + " = "
        //                        + set.getValue());
        // }
        // System.out.println("-----------------------\n");         

        return dados;
    }
}
