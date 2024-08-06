package com.code.pep.pep_pro_servlet.d_Service_Old;

import com.code.pep.pep_pro_servlet.b_Dao_Old.TicketDaoOld;
import com.code.pep.pep_pro_servlet.c_Dto_Old.TicketDtoOld;

import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceOld {

    // Создание INSTANCE для текущего Service - Начало
    private static final TicketServiceOld INSTANCE = new TicketServiceOld();

    private TicketServiceOld() {
    }

    public static TicketServiceOld getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего Service - Конец

    // Получение DAO - Начало
    private final TicketDaoOld ticketDao = TicketDaoOld.getInstance();
    // Получение DAO - Конец

    // Получение коллекции DTO - Начало
    public List<TicketDtoOld> getAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(t -> new TicketDtoOld(
                        t.getId(),
                        t.getFlight_id(),
                        t.getSeat_no()
                ))
                .collect(Collectors.toList());
    }
    // Получение коллекции DTO - Конец
}
