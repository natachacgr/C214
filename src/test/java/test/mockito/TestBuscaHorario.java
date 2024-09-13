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
import static org.junit.Assert.assertFalse;
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

    //Testes de Sucesso ------------------------------------------------------------------------------------------------------------------------------------------------

    //Teste 1
    @Test
    public void testBuscaNomeProfessor(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertEquals("João", horario.getNomeDoProfessor());
    }

    //Teste 2
    @Test
    public void testBuscaHorario(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertEquals("Segunda-feira 10:00", horario.getHorario());
    }

    //Teste 3
    @Test
    public void testBuscaSala(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertEquals("1", horario.getSala());
    }

    //Teste 4
    @Test
    public void testBuscaPeriodo(){
        Mockito.when(service.busca(0)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(0);

        assertEquals("integral", horario.getPeriodo());
    }

    //Teste 5
    @Test
    public void testHorarioExistente(){
        Mockito.when(service.horarioExistente(0)).thenReturn(true);

        boolean horarioExistente = buscaHorario.verificaHorarioExistente(0);

        assertTrue(horarioExistente);
    }

    //Teste 6
    @Test
    public void testProfessorPrediosLength(){
        Mockito.when(service.busca(2)).thenReturn(HorarioConst.HORARIO2);

        HorarioAtendimento horario = buscaHorario.buscaHorario(2);

        assertTrue(horario.getPredio().length > 1);
    }

    //Teste 7
    @Test
    public void testBuscaPredio(){
        Mockito.when(service.busca(0)).thenReturn(HorarioConst.HORARIO1);

        HorarioAtendimento horario = buscaHorario.buscaHorario(0);

        assertEquals("1", horario.getPredio()[0]);
        assertEquals("2", horario.getPredio()[1]);
        assertEquals("3", horario.getPredio()[2]);
        assertEquals("4", horario.getPredio()[3]);
        assertEquals("6", horario.getPredio()[4]);
    }

    //Teste 8
    @Test
    public void testEscolhePredioUm(){
        String predio1 = buscaHorario.escolhePredio("5", new String[]{"1", "2", "3", "4", "6"});

        assertEquals("1", predio1);
    }

    //Teste 9
    @Test
    public void testEscolhePredioDois(){
        String predio2 = buscaHorario.escolhePredio("6", new String[]{"1", "2", "3", "4", "6"});

        assertEquals("2", predio2);
    }

    //Teste 10
    @Test
    public void testEscolhePredioSeis(){
        String predio6 = buscaHorario.escolhePredio("21", new String[]{"1", "2", "3", "4", "6"});

        assertEquals("6", predio6);
    }

    //Testes de Falha --------------------------------------------------------------------------------------------------------------------------------------------------

    



}
