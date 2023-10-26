package com.Maxim.crud_app.model;

import com.Maxim.crud_app.base.Status;


public class Skill {
    private Status status=Status.ACTIVE;

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

    public void removeSkill() {
        this.status = Status.DELETED;
    }
}
