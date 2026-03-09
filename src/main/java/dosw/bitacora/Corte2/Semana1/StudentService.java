package dosw.bitacora.Corte2.Semana1;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    //Estudiantes del equipo naranja
    public List<Student> getStudentsFromOrangeTeam(List<Student> students) {
        return students.stream()
                .filter(s -> "NARANJA".equals(s.getTeam()))
                .toList();
    }
    //Nombres ordenados
    public List<String> getStudentNamesSorted(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .toList();
    }
    //Promedio general
    public double getGlobalAverage(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }
    //Promedio por materia por estudiante
    public Map<String, Double> getAverageBySubject(Student student) {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }
    //Estudiante con mayor promedio
    public Optional<Student> getBestStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(s ->
                        s.getGrades().stream()
                                .mapToDouble(Grade::getScore)
                                .average()
                                .orElse(0)
                ));
    }
    //Materias reprobadas por equipo
    public Map<String, Long> getFailedSubjectsByTeam(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getTeam,
                        Collectors.flatMapping(
                                s -> s.getGrades().stream(),
                                Collectors.filtering(
                                        g -> !g.isPassed(),
                                        Collectors.counting()
                                )
                        )
                ));
    }
    //Top 3
    public List<Student> top3StudentsWithMostPassed(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingLong(
                        (Student s) -> s.getGrades().stream()
                                .filter(Grade::isPassed)
                                .count()
                ).reversed())
                .limit(3)
                .toList();
    }
    //Estudiantes por estado academico
    public Map<String, List<Student>> groupByPerformance(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> {
                    double avg = s.getGrades().stream()
                            .mapToDouble(Grade::getScore)
                            .average()
                            .orElse(0);

                    if (avg >= 4.5) return "ALTO RENDIMIENTO";
                    if (avg >= 3.5) return "REGULAR";
                    return "RIESGO";
                }));
    }
    //Materia con mas reprobados
    public Optional<String> subjectWithMostFails(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .filter(g -> !g.isPassed())
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
    //Filtrar, obtener notas, filtrar aprobados,
    //agrupar por materia, calcular promedio, orden desc, retornar linkedhashmap
    public Map<String, Double> orangeTeamSubjectAverage(List<Student> students) {

        return students.stream()
                .filter(s -> "NARANJA".equals(s.getTeam()))
                .flatMap(s -> s.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
