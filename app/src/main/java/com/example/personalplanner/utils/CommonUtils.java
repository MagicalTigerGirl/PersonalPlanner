package com.example.personalplanner.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    /**
     * Validar el formato de la contraseña del usuario.
     * La contraseña debe estar formada por:
     * - Como mínimo 8 caracteres
     * - Al menos 1 número
     * - Al menos 1 letra en minúsculas
     * - Al menos 1 letra en mayúsculas
     * - Al menos 1 carácter especial (*@#$%^&+=)
     */
    public static boolean isPasswordValid(String password) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*@#$%^&+=]).{8,}";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
