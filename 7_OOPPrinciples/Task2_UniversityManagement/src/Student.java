
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Student extends Person {

    private String facultyNumber;
    private String[] disciplines;

    public Student(String name, String phone, String facultyNumber, String[] disciplines) {
        super(name, phone);
        this.facultyNumber = facultyNumber;
        this.disciplines = disciplines;
    }

    /*Студент
+2 за студента
-1 за поддръжката*/
    @Override
    public double work(List<Person> people) {

        this.increaseTolerance(2);
        people.stream().filter((person) -> (person instanceof MaintenanceEmployee)).forEach((person) -> {
            person.increaseTolerance(-1);
        });

        if (this.getTolerance() >= 50) {
            return 10;
        }

        return 0;
    }

}
