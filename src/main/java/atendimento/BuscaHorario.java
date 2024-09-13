package atendimento;

import com.google.gson.JsonArray;
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

        JsonArray predioArray = jsonObject.getAsJsonArray("predio");
        String[] predios = new String[predioArray.size()];
        for (int i = 0; i < predioArray.size(); i++) {
            predios[i] = predioArray.get(i).getAsString();
        }

        return new HorarioAtendimento(
                jsonObject.get("nomeProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsString(),
                predios
        );
    }

    public String escolhePredio(String sala, String[] predio){
        int salaInteger = Integer.parseInt(sala);

        int posicaoPredio = (salaInteger-1)/5;

        return predio[posicaoPredio];
    }

}
