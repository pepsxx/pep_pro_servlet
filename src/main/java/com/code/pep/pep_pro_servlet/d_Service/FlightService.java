package com.code.pep.pep_pro_servlet.d_Service;

import com.code.pep.pep_pro_servlet.b_Dao.FlightDao;
import com.code.pep.pep_pro_servlet.c_Dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    // Создание INSTANCE для текущего Service - Начало
    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего Service - Конец

    // Получение DAO - Начало
    private final FlightDao flightDao = FlightDao.getInstance();
    // Получение DAO - Конец

    // Получение коллекции DTO - Начало
    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(f -> FlightDto.builder()
                        .id(f.getId())
                        .description(
                                """
                                        %s - %s - %s
                                        """.formatted(
                                        f.getDeparture_airport_code(),
                                        f.getArrival_airport_code(),
                                        f.getStatus()))
                        .build())
                .collect(Collectors.toList());
    }
    // Получение коллекции DTO - Конец
}
