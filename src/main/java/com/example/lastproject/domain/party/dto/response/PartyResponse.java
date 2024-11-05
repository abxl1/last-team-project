package com.example.lastproject.domain.party.dto.response;

import com.example.lastproject.domain.party.entity.Party;
import com.example.lastproject.domain.party.enums.PartyStatus;
import lombok.Getter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;

@Getter
@ToString
public class PartyResponse {

    private final Long id;
    private final String marketName;
    private final String marketAddress;
    private final Long itemId;
    private final String category;
    private final int itemCount;
    private final String itemUnit;
    private final String formattedStartTime;
    private final String formattedEndTime;
    private final int membersCount;
    private final PartyStatus partyStatus;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");

    public PartyResponse(Party party) {
        this.id = party.getId();
        this.marketName = party.getMarketName();
        this.marketAddress = party.getMarketAddress();
        this.itemId = party.getItem().getId();
        this.category = party.getItem().getCategory();
        this.itemCount = party.getItemCount();
        this.itemUnit = party.getItemUnit();
        this.formattedStartTime = party.getStartTime().format(formatter);
        this.formattedEndTime = party.getEndTime().format(formatter);
        this.membersCount = party.getMembersCount();
        this.partyStatus = party.getPartyStatus();
    }

}
