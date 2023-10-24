package task_1_3.developer.developer_atribute.skills;

import task_1_3.base.Status;

import java.util.ArrayList;

public class Skill {
    Status status=Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

     private String skill;

    public String getSkill() {
        if (this.status.equals(Status.ACTIVE)) {
            return skill;
        }
        return null;
    }

    public void setSkill(String skill) {
        status=Status.ACTIVE;
        this.skill = skill;
    }

    public static ArrayList<String> getFieldsSkillModel() {
        ArrayList<String> dataModel = new ArrayList<>();
        dataModel.add("skills");
        return dataModel;
    }

    public void removeSkill() {
        this.status = Status.DELETED;
    }
}
