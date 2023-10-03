package Practice.flyweight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

interface Employee{
    void assignSkill(String skill);
    void getTask();
}

class Developer implements Employee{
    private final String job;
    private String skill;

    Developer(){
        job = "Fix the Bug";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void getTask() {
        System.out.println("Developer Job " + job + "with " + skill);
    }
}


class Tester implements Employee{
    private final String job;
    private String skill;

    Tester(){
        job = "Test the Bug";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void getTask() {
        System.out.println("Tester Job " + job + "with " + skill);
    }
}

class EmployeeFactory{
    private static HashMap<String,Employee> map = new HashMap<>();

    public static Employee getEmployee(String employeeType){
        Employee employee = null;
        if(map.containsKey(employeeType))
            return map.get(employeeType);
        else{
            switch (employeeType){
                case "developer":
                    System.out.println("Employee Created");
                    employee = new Developer();
                    break;
                case "tester":
                    System.out.println("Tester Created");
                    employee = new Tester();
                    break;
                default:
                    System.out.println("No such employee");

            }
            map.put(employeeType, employee);
            return employee;
        }

    }
}


public class Engineering {

   static List<String> skills = Arrays.asList("python", "java", "c++", "dot net");
    static  List<String> employeeType = Arrays.asList("developer", "tester");

    public static void main(String[] args) {

        for(int i = 0 ; i < 22; i++){
            Employee employee = EmployeeFactory.getEmployee(getRandEmployeeType());

            employee.assignSkill(getRandSkill());

            employee.getTask();
        }

    }

    private static String getRandSkill(){
        Random random = new Random();
        return skills.get(random.nextInt(skills.size()));
    }
    private static String getRandEmployeeType(){
        Random random = new Random();
        return employeeType.get(random.nextInt(employeeType.size()));
    }
}