package test.mockito;

//importar a classe atendimento.BuscaHorario

import atendimento.BuscaHorario;
import atendimento.HorarioService;
import atendimento.HorarioAtendimento;
import test.HorarioConst;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestBuscaHorario {

    @Mock
    private HorarioService service;
    private BuscaHorario buscaHorario;

    @Before
    public void setup(){
        buscaHorario = new BuscaHorario(service);
    }

    @Test
    public void testBuscaNomeProfessor(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertEquals("João", horario.getNomeDoProfessor());
    }

    @Test
    public void testBuscaHorario(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertEquals("Segunda-feira 10:00", horario.getHorario());
    }

    @Test
    public void testBuscaPeriodo(){
        Mockito.when(service.busca(0)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(0);

        assertEquals("integral", horario.getPeriodo());
    }

    @Test
    public void testHorarioExistente(){
        Mockito.when(service.horarioExistente(0)).thenReturn(true);

        boolean horarioExistente = buscaHorario.verificaHorarioExistente(0);

        assertTrue(horarioExistente);
    }

}
