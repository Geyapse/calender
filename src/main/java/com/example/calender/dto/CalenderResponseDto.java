package com.example.calender.dto;

import com.example.calender.entity.Calender;
import lombok.Getter;

@Getter
public class CalenderResponseDto {
    private String todo;
    private String name;
    private int password;
    private String cdate; // 작성일
    private String mdate; // 수정일
    private Long id;

    public CalenderResponseDto(Calender calender) {
        this.todo =  calender.getTodo();
        this.name =  calender.getName();
        this.password =  calender.getPassword();
        this.cdate =  calender.getCdate();
        this.mdate =  calender.getMdate();
        this.id =  calender.getId();

    }
}
