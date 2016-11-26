
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
public class AdministrationEmployee extends Employee {

    static final double SALARY = 19;

    private final String[] disciplines;

    public AdministrationEmployee(String name, String phone, String[] disciplines) {
        super(name, phone, SALARY);
        this.disciplines = disciplines;
    }

    /*+3 за всеки студент
    +3 за всеки учител
    +1 за поддръжката*/
    @Override
    public double work(List<Person> people) {

        for (Person person : people) {
            if (person instanceof MaintenanceEmployee) {
                person.increaseTolerance(1);
            } else if (person instanceof Teacher) {
                person.increaseTolerance(3);
            } else if (person instanceof Student) {
                person.increaseTolerance(3);
            }
        }

        return -this.getSalaryPerHour();
    }

}
