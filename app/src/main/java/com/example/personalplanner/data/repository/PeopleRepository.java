package com.example.personalplanner.data.repository;

import android.graphics.Color;

import com.example.personalplanner.R;
import com.example.personalplanner.data.model.People;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleRepository {

    private ArrayList<People> list;

    private static PeopleRepository instance;

    private PeopleRepository() {
        list = new ArrayList<>();
        initialize();
    }

    public static PeopleRepository getInstance() {
        if (instance == null)
            instance = new PeopleRepository();
        return instance;
    }

    public List<People> getList() {return list; }

    public void AddPeople(String name, String surname, String rol){
        list.add(new People(name, surname, rol, R.drawable.icon_user));
    }

    private void initialize(){
        list.add(new People("María", "Molina Lorenzo", "Timi",  new Date(2003, 12, 26), Color.MAGENTA, R.drawable.maria));
        list.add(new People("Juan", "Molina Albalá", new Date(1970, 5, 19), Color.BLUE, R.drawable.icon_user));
        list.add(new People("María Inmaculada", "Lorenzo de la Torre", "Timi",  new Date(2003, 12, 26), Color.MAGENTA, R.drawable.icon_user));
    }
}
