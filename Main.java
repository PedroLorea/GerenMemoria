import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        LerArquivo lerArquivo = new LerArquivo();

        Dados dados = lerArquivo.Armazena("caso1.txt");

        Gerencia gerencia = new Gerencia(dados, 16);

        gerencia.firstFit();


        //======================Pra quando o programa tiver pronto========================================
        //String arquivo = "";
        //int tamanho;
        //int op;

        // System.out.println("Bem-vindo ao Gerenciador de Memória!");
        // System.out.println("Digite o nome do arquivo:");
        // arquivo = in.nextLine();

        // System.out.println("Digite o tamanho da memória");
        //tamanho = in.nextInt();

        // LerArquivo lerArquivo = new LerArquivo();
        // Dados dados = lerArquivo.Armazena(arquivo);
        // Gerencia gerencia = new Gerencia(dados,tamanho);

        // System.out.println("Digite o número da opção desejada:");
        // System.out.println("1- WorstFit   2- BestFit   3- FirstFit   4- CircularFit");
        // op = in.nextInt();
        
        // switch(op){
        //     case 1: gerencia.worstFit();
        //     break;

        //     case 2: gerencia.bestFit();
        //     break;

        //     case 3: gerencia.firstFit();
        //     break;

        //     case 4: gerencia.cirucularFit();
        //     break;

        //     default: System.out.println("Opção inválida, tente novamente.");
        // }

        


    
    }
}