package com.example.personalplanner.view_model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.personalplanner.utils.CommonUtils;

import java.util.Objects;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> confirmPassword = new MutableLiveData<>();

    private MutableLiveData<UserResult> result;

    public void validateCredentials() {
        // Validar credenciales sobre el nombre del usuario
        if (TextUtils.isEmpty(name.getValue()))
            result.setValue(UserResult.NAMEEMPTY);

        // Validar credenciales sobre el email del usuario
        if (TextUtils.isEmpty(email.getValue()))
            result.setValue(UserResult.EMAILEMPTY);
        else if (!Patterns.EMAIL_ADDRESS.matcher(email.getValue()).matches())
            result.setValue(UserResult.EMAILFORMAT);

        // Validar credenciales sobre la contraseña del usuario
        if (TextUtils.isEmpty(password.getValue()))
            result.setValue(UserResult.PASSWORDEMPTY);
        else if (!CommonUtils.isPasswordValid(password.getValue()))
            result.setValue(UserResult.PASSWORDFORMAT);

        // Validar credenciales sobre la contraseña del usuario
        if (TextUtils.isEmpty(confirmPassword.getValue()))
            result.setValue(UserResult.CONFIRMPASSWORDEMPTY);
        else if (!Objects.equals(password.getValue(),confirmPassword.getValue()))
            result.setValue(UserResult.CONFIRMPASSWORDNOTEQUALS);
    }

    public MutableLiveData<UserResult> getResult() {
        if (result==null)
            result=new MutableLiveData<>();
        return result;
    }
}
