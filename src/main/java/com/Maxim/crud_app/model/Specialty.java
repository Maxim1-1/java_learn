package com.Maxim.crud_app.model;

import com.Maxim.crud_app.base.Status;


public class Specialty {
    private Status status = Status.ACTIVE;

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

    private String name;

    public String getName() {
        if (this.status.equals(Status.ACTIVE)) {
            return name;
        } else {
            return null;
        }
    }

    public void setName(String name) {
        status = Status.ACTIVE;
        this.name = name;
    }

    public void removeSpecialty() {
        this.status = Status.DELETED;
    }


}
