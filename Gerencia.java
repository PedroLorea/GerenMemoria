import java.util.HashMap;
import java.util.Map;

public class Gerencia {

    public Map<String, String> programa = new HashMap<String, String>();
    public Map<String, Integer> valores = new HashMap<String, Integer>();
    public String [] list;
    
    public Gerencia (Dados dados, int tamanho){
        this.programa = dados.programa;
        this.valores = dados.valores;
        list = new String[tamanho];
    }
    
    public void worstFit(){

    }

    public void bestFit(){

    }

    public void cirucularFit(){

    }


    public void firstFit(){
        printTelaMemoria();

        for(int i=1; i<=programa.size(); i++){ //Percorre o hash e procura o número (hash ta com numeros para identificar a ordem)

            for (Map.Entry<String, String> entrada : programa.entrySet()) { //Pega a entrada
    
                if(Integer.parseInt(entrada.getKey().substring(0, 1)) == i){ //Ve se é o número 

                    if(entrada.getKey().substring(1, 2).equals("i")){ // If para se for "in"
                        String nome = entrada.getValue();
                        int valor = valores.get(nome);
                        boolean alocado = false;
                        int inicial = 0;
                        int contador = 0;

                        for(int j=0; j<list.length; j++){

                            if(list[j] == null) {
                                if(contador == 0) inicial = j;
                                contador++;

                                if(contador == valor){
                                    for(int k=inicial; k<contador+inicial; k++){
                                        list[k] = nome;
                                    }
                                    alocado = true;
                                    break;
                                }
                            }
                            else {
                                contador = 0;
                            }
                        }
                        printTela(nome, valor, "in");
                        printTelaMemoria();

                        if (alocado == false) System.out.println("Espaço insuficiente de memória.");

                    } 
                    else { // Else para se for "out"
                        String nome = entrada.getValue();
                    
                        for(int l=0; l<list.length; l++){
                            if(list[l]==null) {
                                continue;
                            }
                            if(nome.equals(list[l])){
                                list[l] = null;
                            } 
                        }
                        printTela(nome, 0, "out");
                        printTelaMemoria();
                    }
                }
           }
        }
    }


    public void printTelaMemoria(){ //Apenas para testar
        String mensagem = "";
        for(int i=0; i<list.length ; i++){
            mensagem = mensagem + "|" + list[i] + "|";
        }
        System.out.println(mensagem);
        System.out.println();
    }


    public void printTela(String nomeComando, int valor, String InOuOut){
        
        int contadorNull = 0;
        String mensagem = "";    
        if(InOuOut.equals("in"))  {
            mensagem = "IN(" + nomeComando + ", " + valor + ")   =>    ";
        }
        else {
            mensagem = "OUT(" + nomeComando + ")   =>    ";
        }

        for(int i=0; i<list.length; i++){
            if(list[i] == null){
                contadorNull++;
            }
            else {
                if(contadorNull>=1) mensagem = mensagem + "| " + contadorNull + " |" + " ";
                contadorNull = 0;
            }
            if(i == list.length-1) mensagem = mensagem + "| " + contadorNull + " |" + " ";
        }
       
        if(contadorNull == list.length-1) mensagem = mensagem + "| " + contadorNull + " |";
    
        System.out.println(mensagem);
    }
}    

