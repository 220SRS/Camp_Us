package com.campus.campus.reservation.dto;

import com.campus.campus.reservation.entity.Reservation;
import lombok.Getter;

@Getter
public class ReservationPatchDto {
    private Long rsvId;
    private Reservation.RsvStatus rsvStatus;

    public void setRsvId(Long rsvId) {
        this.rsvId = rsvId;
    }
}
