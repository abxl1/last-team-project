package com.example.lastproject.domain.party.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PartyUpdateRequest {

    private Long itemId; // 거래 품목
    private Integer itemCount; // 품목 개수
    private String itemUnit; // 거래 단위
    private String startTime; // 장보기 시작 시간
    private String endTime; // 장보기 종료 시간
    private Integer membersCount; // 파티 인원

}
