package com.example.personalplanner.data.repository;

import com.example.personalplanner.R;
import com.example.personalplanner.data.model.Food;

import java.util.ArrayList;
import java.util.Collections;

public class FoodRepository {
    private ArrayList<Food> list;

    private static FoodRepository instance;

    private FoodRepository() {
        list = new ArrayList<>();
        initialice();
    }

    public static FoodRepository getInstance() {
        if (instance == null) {
            instance = new FoodRepository();
        }
        return instance;
    }

    public ArrayList<Food> getList(){
        return list;
    }

    public void AddFood(String name, String description){
        list.add(new Food(name, description, R.drawable.icon_food));
    }

    private void initialice(){
        list.add(new Food("Couscous", "couscous marroquí", R.drawable.couscous));
        list.add(new Food("Pasta carbonara", "pasta con nata y bacon", R.drawable.pasta_carbonara));
        Collections.sort(list);
    }
}
