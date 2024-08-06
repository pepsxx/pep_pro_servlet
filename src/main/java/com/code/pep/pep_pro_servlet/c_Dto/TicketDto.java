package com.code.pep.pep_pro_servlet.c_Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketDto {
    Long id;
    Long flight_id;
    String seat_no;
}
