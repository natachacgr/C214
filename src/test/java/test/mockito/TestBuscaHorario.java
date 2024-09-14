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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import java.lang.NullPointerException;

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

        assertTrue(horario.getPredio().length == 5);
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

        String message = "";
        String predio1 = "";

        try{
            predio1 = buscaHorario.escolhePredio("5", new String[]{"1", "2", "3", "4", "6"});
        }catch(Exception e){
            message = e.getMessage();
        }


        assertEquals("1", predio1);
        assertEquals("", message);
    }

    //Teste 9
    @Test
    public void testEscolhePredioDois(){
        String message = "";
        String predio2 = "";

        try{
            predio2 = buscaHorario.escolhePredio("6", new String[]{"1", "2", "3", "4", "6"});
        }catch(Exception e){
            message = e.getMessage();
        }


        assertEquals("2", predio2);
        assertEquals("", message);
    }

    //Teste 10
    @Test
    public void testEscolhePredioSeis(){
        String message = "";
        String predio6 = "";

        try{
            predio6 = buscaHorario.escolhePredio("21", new String[]{"1", "2", "3", "4", "6"});
        }catch(Exception e){
            message = e.getMessage();
        }


        assertEquals("6", predio6);
        assertEquals("", message);
    }

    //Testes de Falha --------------------------------------------------------------------------------------------------------------------------------------------------

    //Teste 1
    @Test
    public void testHorarioInexistente(){
        Mockito.when(service.horarioExistente(0)).thenReturn(false);

        boolean horarioExistente = buscaHorario.verificaHorarioExistente(0);

        assertFalse(horarioExistente);

    }

    //Teste 2
    @Test
    public void testBuscaHorarioInvalido(){
        Mockito.when(service.busca(55)).thenReturn(HorarioConst.HORARIO_INVALIDO);

        HorarioAtendimento horario = buscaHorario.buscaHorario(55);

        assertEquals("-", horario.getNomeDoProfessor());
        assertEquals("-", horario.getHorario());
        assertEquals("-", horario.getPeriodo());
        assertEquals("-", horario.getSala());
    }

    //Teste 3
    @Test (expected = NullPointerException.class)
    public void testBuscaHorarioJsonIncompleto(){
        Mockito.when(service.busca(55)).thenReturn(HorarioConst.INCOMPLETE_JSON1);

        buscaHorario.buscaHorario(55);

    }    

    //Teste 4
    @Test
    public void testEscolhePredioFalha(){
        String message = "";
        String predio = "";
        
        try{
            predio = buscaHorario.escolhePredio("26", new String[]{"1", "2", "3", "4", "6"});
        }catch(Exception e){
            message = e.getMessage();
        }

        assertEquals("Sala inválida", message);
        assertEquals("", predio);
    
    }

    //Teste 5
    @Test
    public void testEscolhaPredioNegativo(){

        String predio = "";
        String message = "";

        try{
            predio = buscaHorario.escolhePredio("-1", new String[]{"1", "2", "3", "4", "6"});
        }catch(Exception e){
            message = e.getMessage();
        }
        
        assertEquals("Sala inválida", message);
        assertEquals("", predio);

    }

    //Teste 6
    @Test
    public void testPredioLengthVazio(){
        Mockito.when(service.busca(55)).thenReturn(HorarioConst.INCOMPLETE_JSON2);

        HorarioAtendimento horario = buscaHorario.buscaHorario(55);

        assertFalse(horario.getPredio().length == 5);
    }

    //Teste 7
    @Test
    public void testBuscaHorarioPredioIncompleto() {
        Mockito.when(service.busca(3)).thenReturn(HorarioConst.INCOMPLETE_JSON3);

        HorarioAtendimento horario = buscaHorario.buscaHorario(3);

        assertNotNull(horario.getPredio());
        assertTrue(horario.getPredio().length < 5);
    }

    //Teste 8
    @Test
    public void testEscolhePredioArrayNulo() {
        
        String message = "";
        String predio = "";
        
        try{
            predio = buscaHorario.escolhePredio("1", null);
        }catch(Exception e){
            message = e.getMessage();
        }

        assertEquals("Predio inválido", message);
        assertEquals("", predio);
    }

    //Teste 9
    @Test
    public void testEscolhePredioArrayVazio() {
        
        String message = "";
        String predio = "";
        
        try{
            predio = buscaHorario.escolhePredio("1", new String[]{});
        }catch(Exception e){
            message = e.getMessage();
        }

        assertEquals("Predio inválido", message);
        assertEquals("", predio);
    }

    //Teste 10
    @Test
    public void testBuscaHorarioIdNegativo(){
        Mockito.when(service.busca(-1)).thenReturn(HorarioConst.HORARIO_INVALIDO);

        HorarioAtendimento horario = buscaHorario.buscaHorario(-1);

        assertEquals("-", horario.getNomeDoProfessor());
        assertEquals("-", horario.getHorario());
        assertEquals("-", horario.getPeriodo());
        assertEquals("-", horario.getSala());
    }
}
