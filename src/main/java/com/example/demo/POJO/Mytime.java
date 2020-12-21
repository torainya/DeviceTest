package com.example.demo.POJO;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Mytime {

    public static String getTime() {
        Calendar c = GregorianCalendar.getInstance();
        return "Time:"+String.format("%s年%s月%s日%s时%s分%s秒",
                c.get(Calendar.YEAR), (c.get(Calendar.MONTH) + 1), c.get(Calendar.DAY_OF_MONTH),
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)
        );

    }

}