package com.medium.userdetails;

import java.time.LocalDate;
import java.time.Month;

public class CommonUtil {

    public static LocalDate convertToDate(int year, Month month, int day) {
        return LocalDate.of(year, month, day);
    }

}
