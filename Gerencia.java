import java.util.HashMap;
import java.util.Map;

public class Gerencia {

    public Map<String, String> programa = new HashMap<String, String>();
    public Map<String, Integer> valores = new HashMap<String, Integer>();
    
    public Gerencia (Dados dados){
        this.programa = dados.programa;
        this.valores = dados.valores;
    }
    
    public void worstFit(){

    }

    public void bestFit(){

    }

    public void firstFit(){

    }

    public void cirucularFit(){

    }

    public void printTela(){
        
    }
}    

