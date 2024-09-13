package atendimento;

public class HorarioAtendimento {

    private String nomeDoProfessor;
    private String horario;
    private String periodo;
    private String sala;
    private String[] predio;

    public HorarioAtendimento(String nomeDoProfessor, String horario, String periodo, String sala, String[] predio) {
        this.nomeDoProfessor = nomeDoProfessor;
        this.horario = horario;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public String getNomeDoProfessor() {
        return nomeDoProfessor;
    }

    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.nomeDoProfessor = nomeDoProfessor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String[] getPredio() {
        return predio;
    }

    public void setPredio(String[] predio) {
        this.predio = predio;
    }
}
