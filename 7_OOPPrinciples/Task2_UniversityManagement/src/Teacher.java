
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
public class Teacher extends Employee {

    static final double SALARY = 25;

    private final String[] disciplines;

    public Teacher(String name, String phone, String[] disciplines) {
        super(name, phone, SALARY);
        this.disciplines = disciplines;

    }

    @Override
    public double work(List<Person> people) {
        /*+3 за всеки студент
-3 за поддръжката
-1 за всяко административно лице*/
        for (Person person : people) {
            if (person instanceof MaintenanceEmployee) {
                person.increaseTolerance(-3);
            } else if (person instanceof AdministrationEmployee) {
                person.increaseTolerance(-1);
            } else if (person instanceof Student) {
                person.increaseTolerance(3);
            }
        }
        
        return -this.getSalaryPerHour();
    }

}
