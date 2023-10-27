package com.Maxim.crud_app.repository;

import com.Maxim.crud_app.model.Developer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Integer> {


}