package com.example.calender.entity;

import com.example.calender.dto.CalenderResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Calender {

    private String todo;
    private String name;
    private int password;
    private String cdate; // 작성일
    private String mdate; // 수정일
    private Long id;

    public void update(CalenderResponseDto dto) {
        this.todo = dto.getTodo();
        this.name = dto.getName();
    }

    public void updateName(CalenderResponseDto dto) {
        this.name = dto.getName();
    }

}
// 할일 작성자명 만 수정 가능 수정요청때 비밀번호 필요 작성일은 변경안되며 수정일만 변경