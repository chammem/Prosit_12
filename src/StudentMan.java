import java.util.*;
import java.util.stream.*;

public class StudentMan {





    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,22,"sinda"));
        students.add(new Student(2,23,"Asma"));
        students.add(new Student(3,13,"Takwa"));

        StudentManagement management = new StudentManagement();

        // Test de displayStudents
        System.out.println("Afficher tous les étudiant:");
        management.displayStudents(students, System.out::println);
        System.out.println();

        // Test de displayStudentsByFilter
        System.out.println("Affichage des étudiants avec ID > 1:");
        management.displayStudentsByFilter(students, student -> student.getId() > 1, System.out::println);
        System.out.println();

        // Test de returnStudentsNames
        System.out.println("Retourner les noms des étudiants sous forme de chaîne séparée par des virgules:");
        String names = management.returnStudentsNames(students, Student::getNom);
        System.out.println("Noms: " + names);
        System.out.println();

        // Test de createStudent
        System.out.println("Création d'un nouvel étudiant à l'aide d'un fournisseur:");
        Student newStudent = management.createStudent(() -> new Student(4,27,"Ayoub"));
        System.out.println("Nouvel étudiant créé: " + newStudent);
        System.out.println();

        // Test de sortStudentsById
        System.out.println("Tri des étudiants par ID:");
        Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);
        List<Student> sortedStudents = management.sortStudentsById(new ArrayList<>(students), idComparator);
        sortedStudents.forEach(System.out::println);
        System.out.println();

        // Test de convertToStream
        System.out.println("Conversion des étudiants en flux:");
        Stream<Student> studentStream = management.convertToStream(students);
        studentStream.forEach(System.out::println);
    }



}
