package com.campus.campus.mypageReservation;

import com.campus.campus.reservation.entity.Reservation;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MypageReservationControllerTest {

    @Mock
    private MyPageReservationServiceImpl myPageReservationService;

    @InjectMocks
    private MypageReservationController mypageReservationController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mypageReservationController).build();
    }

    @Test
    public void testFindAllReservationByUserId() throws Exception {
        Long userId = 1L;
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation1 = new Reservation();
        reservation1.setRsvId(1L);
        reservation1.setStoreId(1L);
        reservation1.setStartDate(new Date());
        reservation1.setEndDate(new Date());
        reservation1.setPaymentAmt(10000L);
        reservation1.setRsvStatus(Reservation.RsvStatus.RSV_USING);
        reservations.add(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setRsvId(2L);
        reservation2.setStoreId(2L);
        reservation2.setStartDate(new Date());
        reservation2.setEndDate(new Date());
        reservation2.setPaymentAmt(20000L);
        reservation2.setRsvStatus(Reservation.RsvStatus.RSV_COMPLETE);
        reservations.add(reservation2);

        Mockito.when(myPageReservationService.findAllReservationByUserId(userId)).thenReturn(reservations);
        mockMvc.perform(MockMvcRequestBuilders.get("/mypage/reservation")
                        .param("user_id", String.valueOf(userId)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].rsvId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].storeId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[0].paymentAmt", Matchers.is(10000)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].rsvId", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].storeId", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reservationResponseDtos[1].paymentAmt", Matchers.is(20000)));
    }
}
