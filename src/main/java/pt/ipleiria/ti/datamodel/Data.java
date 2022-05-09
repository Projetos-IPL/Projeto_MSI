package pt.ipleiria.ti.datamodel;

import pt.ipleiria.ti.exceptions.ValorInvalidoException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final int dia;
    private final int mes;
    private final int ano;

    public Data(int dia, int mes, int ano) throws ValorInvalidoException {
        if (dia < 0 && mes < 0 && ano < 0) {
            throw new ValorInvalidoException("O dia/mês/ano não pode ser inferior a 0");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public static Data getDataAtual() throws ValorInvalidoException {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
        return new Data(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }

    @Override
    public String toString() {
        String mesNovo = null;

        if (mes < 10) {
            mesNovo = String.format("%02d", mes);
        }

        return dia + "/" + (mesNovo == null ? String.valueOf(mes) : mesNovo) + "/" + ano;
    }
}
