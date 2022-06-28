package pt.ipleiria.ti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    private final Calendar calendar;

    public Data(int dia, int mes, int ano) {
        calendar = new GregorianCalendar(ano, mes - 1, dia);
    }

    public static Data parse(String data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        simpleDateFormat.parse(data);

        String[] dataComponentes = data.trim().split("/");
        int dia = Integer.parseInt(dataComponentes[0]);
        int mes = Integer.parseInt(dataComponentes[1]);
        int ano = Integer.parseInt(dataComponentes[2]);

        return new Data(dia, mes, ano);
    }

    @Override
    public String toString() {
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" +
                (calendar.get(Calendar.MONTH) + 1) + "/" +
                calendar.get(Calendar.YEAR);
    }
}