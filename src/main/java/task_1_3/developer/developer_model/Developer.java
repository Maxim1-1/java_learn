package task_1_3.developer.developer_model;

import task_1_3.base.Status;
import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.specialty.Specialty;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    transient Status status;


    public int getId() {
        return id;
    }

    //    private static int nextId =1;
    private int id;
    private String firstName;
    private String lastName;
    private Specialty specialty;
    private List<Skill> skills;

    public Developer(String firstName, String lastName, int id){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

//    @Override
//    public String toString() {
//        return "Developer {" +
//                ", id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", specialty=" + specialty +
//                ", skills=" + skills +
//                '}';
//    }

    public static ArrayList<String> getFieldsDeveloperModel() {
        ArrayList<String> dataModel = new ArrayList<>();
        dataModel.add("firstName");
        dataModel.add("lastName");
        return dataModel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



}



