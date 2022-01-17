package com.example.test.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Esta clase valida los formatos usados en el API
public class FormatValidator {
    public boolean validateDate(String date) {
        Pattern pat = Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
        Matcher mat = pat.matcher(date);
        if (mat.find() && date.length()==10) {
            return true;
        } else {
            throw new IllegalArgumentException("Formato de fecha incorrecto. Formato fecha: YYYY-mm-dd");
        }
    }

    public boolean validateVehicle(String idVehicle) {
        idVehicle=idVehicle.toUpperCase();
        Pattern pat = Pattern.compile("[a-zA-Z]{3}[0-9]{3}");
        Matcher mat = pat.matcher(idVehicle);
        if (mat.find() && idVehicle.length()==6) {
            return true;
        } else {
            throw new IllegalArgumentException("Formato de placa vehicular incorrecta. Formato de placa: ABC123");
        }

    }

    public boolean validateNumberBoat(String idVehicle) {
        idVehicle=idVehicle.toUpperCase();
        Pattern pat = Pattern.compile("[a-zA-Z]{3}[0-9]{4}[a-zA-Z]{1}");
        Matcher mat = pat.matcher(idVehicle);
        if (mat.find() && idVehicle.length()==8) {
            return true;
        } else {
            throw new IllegalArgumentException("Formato número de flota incorrecto.Formato de n");
        }
    }
}
