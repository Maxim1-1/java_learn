package task_1_3.developer.developer_atribute.specialty;

import task_1_3.base.Status;

import java.util.ArrayList;

public class Specialty {
    transient Status status=Status.ACTIVE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String specialty;

    public String getSpecialty() {
        if (this.status.equals(Status.ACTIVE)) {
            return specialty;
        }
        return null;
    }

    public void setSpecialty(String specialty) {
        status=Status.ACTIVE;
        this.specialty = specialty;
    }

    public void removeSpecialty() {
        this.status = Status.DELETED;
    }

    public static ArrayList<String> getFieldsSpecialtyModel() {
        ArrayList<String> dataModel = new ArrayList<>();
        dataModel.add("specialty");
        return dataModel;
    }

}
