import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        // LerArquivo lerArquivo = new LerArquivo();

        // Dados dados = lerArquivo.Armazena("caso3.txt");

        // Gerencia gerencia = new Gerencia(dados, 12);

        // gerencia.bestFit();


    
        String arquivo = "";
        int tamanho;
        int op;

        System.out.println("Bem-vindo ao Gerenciador de Memória!");
        System.out.println("Digite o nome do arquivo:");
        arquivo = in.nextLine();

        LerArquivo lerArquivo = new LerArquivo();
        Dados dados = lerArquivo.Armazena(arquivo);

        System.out.println("\nDigite o tamanho da memória");
        tamanho = in.nextInt();

        Gerencia gerencia = new Gerencia(dados,tamanho);

        System.out.println("\nDigite o número da opção desejada:");
        System.out.println("1- Worst-Fit   2- Best-Fit   3- First-Fit   4- Circular-Fit");
        op = in.nextInt();
        
        switch(op){
            case 1: gerencia.worstFit();
            break;

            case 2: gerencia.bestFit();
            break;

            case 3: gerencia.firstFit();
            break;

            case 4: gerencia.circularFit();
            break;

            default: System.out.println("Opção inválida, tente novamente.");
        }

        


    
    }
}