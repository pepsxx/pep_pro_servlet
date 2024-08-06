package com.code.pep.pep_pro_servlet.d_Service;

import com.code.pep.pep_pro_servlet.b_Dao.TicketDao;
import com.code.pep.pep_pro_servlet.c_Dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    // Создание INSTANCE для текущего Service - Начало
    private static final TicketService INSTANCE = new TicketService();

    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего Service - Конец

    // Получение DAO - Начало
    private final TicketDao ticketDao = TicketDao.getInstance();
    // Получение DAO - Конец

    // Получение коллекции DTO - Начало
    public List<TicketDto> getAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(t -> TicketDto.builder()
                        .id(t.getId())
                        .flight_id(t.getFlight_id())
                        .seat_no(t.getSeat_no())
                        .build())
                .collect(Collectors.toList());
    }
    // Получение коллекции DTO - Конец
}
