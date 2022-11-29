import java.util.Map;

public class Dados {

    public Map<String, String> programa;
    public Map<String, Integer> valores;
    public Map<String, Integer> auxMap;

    public Dados(Map<String, String> programa, Map<String, Integer> valores, Map<String, Integer> auxMap){
        this.programa = programa;
        this.valores = valores;
        this.auxMap = auxMap;
    }
}
