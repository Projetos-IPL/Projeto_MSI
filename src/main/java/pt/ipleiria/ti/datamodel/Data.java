package pt.ipleiria.ti.datamodel;

import java.time.Duration;
import java.time.LocalDate;

public class Data {

    public static Duration getDatesDiff(LocalDate date) {
        return Duration.between(LocalDate.now().atStartOfDay(), date.atStartOfDay());
    }
}