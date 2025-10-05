package com.example.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;

    @Builder.Default
    private String photo = "552961459_1161287582587654_7090081207822496985_n.png";

    @Builder.Default
    private Boolean gender = true;

    @Builder.Default
    private Date birthday = new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime();

    @Builder.Default
    private Double salary = 1000.0;

    @Builder.Default
    private Integer level = 0;
}
