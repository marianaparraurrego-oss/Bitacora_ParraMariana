package dosw.bitacora.Corte2.Semana1;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private String team; //"NARANJA", "AZUL", "VERDE"
    private List<Grade> grades;

    public Student(String id, String name, String team, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
