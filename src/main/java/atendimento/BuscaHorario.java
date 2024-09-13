package atendimento;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaHorario {

    HorarioService horarioService;

    public BuscaHorario(HorarioService service) {
        this.horarioService = service;
    }

    public boolean verificaHorarioExistente(int id){
        boolean horarioExistente = horarioService.horarioExistente(id);

        if(horarioExistente){
            return true;
        }
        else{
            return false;
        }
    }

    public HorarioAtendimento buscaHorario(int id){
        String horarioJson = horarioService.busca(id);

        JsonObject jsonObject = JsonParser.parseString(horarioJson).getAsJsonObject();

        return new HorarioAtendimento(
                jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horario").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsString(),
                jsonObject.get("predio").getAsString().split(",")
        );
    }

    //Caso a sala seja (1-5) o prédio escolhido no array "predio"deve ser 1. Caso seja (6 - 10) o prédio é o 2 e assim por diante até o prédio 6, excluindo o prédio 5.
    public String escolhePredio(String sala, String[] predio){
        int salaInteger = Integer.parseInt(sala);

        int posicaoPredio = (salaInteger-1)/5;

        return predio[posicaoPredio];
    }
}
