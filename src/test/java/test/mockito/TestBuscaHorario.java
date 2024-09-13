package test.mockito;

//importar a classe atendimento.BuscaHorario

import atendimento.BuscaHorario;
import atendimento.HorarioService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestBuscaHorario {

    @Mock
    private HorarioService service;
    private BuscaHorario buscaHorario;

    @Before
    public void setup(){
        buscaHorario = new BuscaHorario(service);
    }

}
