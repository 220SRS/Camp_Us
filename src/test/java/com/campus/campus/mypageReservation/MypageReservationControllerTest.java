package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MypageReservationControllerTest {

    @Mock
    private MyPageReservationServiceImpl myPageReservationService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
        // <-- 이 부분을 추가해주세요.
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testFindAllReservationByUserId() throws Exception {
        Long userId = 1L;
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation1 = new Reservation();
        reservation1.setRsv_id(1L);
        reservation1.setStore_id(1L);
        reservation1.setStart_date(new Date());
        reservation1.setEnd_date(new Date());
        reservation1.setPayment_amt(10000L);
        reservation1.setRsv_status(Reservation.RsvStatus.RSV_USING);
        reservations.add(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setRsv_id(2L);
        reservation2.setStore_id(2L);
        reservation2.setStart_date(new Date());
        reservation2.setEnd_date(new Date());
        reservation2.setPayment_amt(20000L);
        reservation2.setRsv_status(Reservation.RsvStatus.RSV_COMPLETE);
        reservations.add(reservation2);

        Mockito.when(myPageReservationService.findAllReservationByUserId(userId)).thenReturn(reservations);
        mockMvc.perform(MockMvcRequestBuilders.get("/mypage/reservation")
                        .param("user_id", String.valueOf(userId)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].rsv_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].store_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].payment_amt", Matchers.is(10000)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].rsv_id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].store_id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].payment_amt", Matchers.is(20000)));
    }





}