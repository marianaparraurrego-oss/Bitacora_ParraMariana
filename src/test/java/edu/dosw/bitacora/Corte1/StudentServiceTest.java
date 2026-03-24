package edu.dosw.bitacora.bitacora.ParraMariana;
import dosw.bitacora.Corte2.Semana1.Grade;
import dosw.bitacora.Corte2.Semana1.Student;
import dosw.bitacora.Corte2.Semana1.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {
    private StudentService service;
    private List<Student> students;

    @BeforeEach
    void setUp() {

        service = new StudentService();

        Grade g1 = new Grade("DOSW", 4.8, LocalDate.now(), true);
        Grade g2 = new Grade("BD", 4.2, LocalDate.now(), true);
        Grade g3 = new Grade("REDES", 3.0, LocalDate.now(), false);

        Grade g4 = new Grade("DOSW", 3.5, LocalDate.now(), true);
        Grade g5 = new Grade("REDES", 2.5, LocalDate.now(), false);
        Grade g6 = new Grade("BD", 4.0, LocalDate.now(), true);

        Student s1 = new Student(
                "1",
                "Natalia",
                "NARANJA",
                List.of(g1, g2, g3)
        );
        Student s2 = new Student(
                "2",
                "Laura",
                "ROSADO",
                List.of(g4, g5, g6)
        );

        students = List.of(s1, s2);
    }
    @Test
    void shouldReturnOrangeTeamStudents() {

        List<Student> result = service.getStudentsFromOrangeTeam(students);

        assertEquals(1, result.size());
        assertEquals("Natalia", result.get(0).getName());
    }
    @Test
    void shouldReturnSortedNames() {

        List<String> names = service.getStudentNamesSorted(students);

        assertEquals("Laura", names.get(0));
        assertEquals("Natalia", names.get(1));
    }
    @Test
    void shouldCalculateGlobalAverage() {

        double avg = service.getGlobalAverage(students);

        assertTrue(avg > 3.0);
    }
    @Test
    void shouldReturnBestStudent() {

        Student best = service.getBestStudent(students).orElse(null);

        assertNotNull(best);
        assertEquals("Natalia", best.getName());
    }
    @Test
    void shouldReturnTopStudents() {

        List<Student> top = service.top3StudentsWithMostPassed(students);

        assertFalse(top.isEmpty());
    }
    @Test
    void shouldReturnSubjectWithMostFails() {

        String subject = service.subjectWithMostFails(students).orElse(null);

        assertNotNull(subject);
    }
    @Test
    void shouldGroupStudentsByPerformance() {

        var result = service.groupByPerformance(students);

        assertNotNull(result);
    }
}
