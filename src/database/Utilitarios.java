package database;

import java.sql.Date;
import java.util.Calendar;

public class Utilitarios {
    public static Date retornarPadraoSQL(String valor) {
        String[] numeros = valor.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(numeros[2]));
        calendar.set(Calendar.MONTH,        Integer.parseInt(numeros[1]) - 1);
        calendar.set(Calendar.YEAR,         Integer.parseInt(numeros[0]));
        return new Date(calendar.getTimeInMillis());
    }

    public static String retornarPadraoBR(Date data) {
        String valor = data.toString();
        String[] numeros = valor.split("-");
        return numeros[2] + "/" + numeros[1] + "/" + numeros[0];
    }
}
