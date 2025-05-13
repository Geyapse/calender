package com.example.calender.dto;

import lombok.Getter;

@Getter
public class CalenderRequestDto {
    private String todo;
    private String name;
    private int password;
    private String cdate; // 작성일
    private String mdate; // 수정일
    private Long id;
}
//할일 작성자명 비밀번호 작성/수정일(날짜와시간)(YYYY-MM-DD) 고유식별자