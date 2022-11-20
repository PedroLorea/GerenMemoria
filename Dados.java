import java.util.HashMap;
import java.util.Map;

public class Dados {

    public Map<String, String> programa;
    public Map<String, Integer> valores;

    public Dados( Map<String, String> programa, Map<String, Integer> valores){
        this.programa = programa;
        this.valores = valores;
    }
}
