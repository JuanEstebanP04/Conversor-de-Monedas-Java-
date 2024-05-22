import java.util.ArrayList;
import java.util.List;

public class Historial {
    List<ResultadoFInal> lista = new ArrayList<>();
    List<String> VerConsultas = new ArrayList<>();

    public void AddConsulta (ResultadoFInal response){
        lista.add(response);
        var mensaje = """
                ***********************************************
                Fecha de consulta:
                """
                +response.getFechaConsulta()+"\n"+response.toString()+"\n";
        VerConsultas.add(mensaje);
    }
    public String toString() {
        if(VerConsultas.isEmpty()){
            return "Aún no se ha realizado una consulta";
        }
        return VerConsultas.toString();
    }
}
