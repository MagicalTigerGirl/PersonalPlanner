package com.example.personalplanner.view_model;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();

    private MutableLiveData<FoodResult> result;

    public void validateCredentials() {
        // Validar credenciales sobre el nombre de la comida
        if (TextUtils.isEmpty(name.getValue()))
            result.setValue(FoodResult.NAMEEMPTY);

        // Validar credenciales sobre la descripción de la comida
        if (TextUtils.isEmpty(description.getValue()))
            result.setValue(FoodResult.DESCRIPTIONEMPTY);
    }

    public MutableLiveData<FoodResult> getResult() {
        if (result==null)
            result=new MutableLiveData<>();
        return result;
    }
}
