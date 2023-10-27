package com.Maxim.crud_app.repository;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public interface SkillRepository extends GenericRepository<Skill,Integer> {

}
