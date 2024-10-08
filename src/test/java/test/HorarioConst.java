package test;

public class HorarioConst {
        public static String HORARIO1=
                "{\"nomeProfessor\": \"João\", \n" +
                        "\"horarioDeAtendimento\": \"Segunda-feira 10:00\", \n" +
                        "\"periodo\": \"integral\", \n" +
                        "\"sala\": \"1\", \n" +
                        "\"predio\": [\"1\", \"2\", \"3\", \"4\", \"6\"]}";

        public static String HORARIO2=
                "{\"nomeProfessor\": \"Maria\", \n" +
                        "\"horarioDeAtendimento\": \"Terça-feira 14:00\", \n" +
                        "\"periodo\": \"noturno\", \n" +
                        "\"sala\": \"2\", \n" +
                        "\"predio\": [\"1\", \"2\", \"3\", \"4\", \"6\"]}";

        public static String HORARIO3=
                "{\"nomeProfessor\": \"José\", \n" +
                        "\"horarioDeAtendimento\": \"Quarta-feira 16:00\", \n" +
                        "\"periodo\": \"matutino\", \n" +
                        "\"sala\": \"3\", \n" +
                        "\"predio\": [\"1\", \"2\", \"3\", \"4\", \"6\"]}";

        public static String HORARIO_INVALIDO=
                "{\"nomeProfessor\": \"-\", \n" +
                        "\"horarioDeAtendimento\": \"-\", \n" +
                        "\"periodo\": \"-\", \n" +
                        "\"sala\": \"-\", \n" +
                        "\"predio\": [\"1\", \"2\", \"3\", \"4\", \"6\"]}";

        public static String INCOMPLETE_JSON1=
                "{\"horarioDeAtendimento\": \"Quarta-feira 16:00\", \n" +
                        "\"periodo\": \"matutino\", \n" +
                        "\"sala\": \"3\"}";

        public static String INCOMPLETE_JSON2=
                "{\"nomeProfessor\": \"-\", \n" +
                        "\"horarioDeAtendimento\": \"-\", \n" +
                        "\"periodo\": \"-\", \n" +
                        "\"sala\": \"-\"}";

        public static String INCOMPLETE_JSON3=
                "{\"nomeProfessor\": \"José\", \n" +
                        "\"horarioDeAtendimento\": \"Quarta-feira 16:00\", \n" +
                        "\"periodo\": \"matutino\", \n" +
                        "\"sala\": \"3\", \n" +
                        "\"predio\": [\"1\", \"2\", \"3\"]}";
}
