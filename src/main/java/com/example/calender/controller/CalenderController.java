package com.example.calender.controller;

import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/calender")
public class CalenderController {

    private final Map<Long, Calender> calenders = new HashMap<>();
    private Long nextId = 1L;

    // 할 일 등록
    @PostMapping
    public CalenderResponseDto createCalender(@RequestBody CalenderRequestDto requestDto) {
        Long id = nextId++;
        Calender calender = new Calender(
                requestDto.getTodo(),
                requestDto.getName(),
                requestDto.getPassword(),
                requestDto.getCdate(),
                requestDto.getMdate(),
                id
        );
        calenders.put(id, calender);
        return new CalenderResponseDto(calender);
    }

    // 전체 조회
    @GetMapping
    public List<CalenderResponseDto> getAllCalenders() {
        List<CalenderResponseDto> list = new ArrayList<>();
        for (Calender calender : calenders.values()) {
            list.add(new CalenderResponseDto(calender));
        }
        return list;
    }

    // 수정
    @PutMapping("/{id}")
    public CalenderResponseDto updateCalender(
            @PathVariable Long id,
            @RequestBody CalenderRequestDto requestDto
    ) {
        Calender calender = calenders.get(id);
        if (calender == null) {
            throw new NoSuchElementException("해당 ID의 할 일을 찾을 수 없습니다.");
        }
        if (calender.getPassword() != requestDto.getPassword()) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 작성일은 변경 안됨
        Calender updated = new Calender(
                requestDto.getTodo(),
                requestDto.getName(),
                calender.getPassword(),
                calender.getCdate(),
                requestDto.getMdate(),
                calender.getId()
        );
        calenders.put(id, updated);
        return new CalenderResponseDto(updated);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public String deleteCalender(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> passwordMap
    ) {
        Calender calender = calenders.get(id);
        if (calender == null) {
            return "해당 ID의 할 일을 찾을 수 없습니다.";
        }
        if (calender.getPassword() != passwordMap.get("password")) {
            return "비밀번호가 일치하지 않습니다.";
        }
        calenders.remove(id);
        return "삭제 성공";
    }

    // 선택 일정 조회
    @GetMapping("/{id}")
    public CalenderResponseDto getCalenderById(@PathVariable Long id) {
        Calender calender = calenders.get(id);
        if (calender == null) {
            throw new NoSuchElementException("해당 ID의 할 일을 찾을 수 없습니다.");
        }
        return new CalenderResponseDto(calender);
    }
}
