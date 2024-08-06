package com.code.pep.pep_pro_servlet.d_Service_Old;

import com.code.pep.pep_pro_servlet.b_Dao_Old.FlightDaoOld;
import com.code.pep.pep_pro_servlet.c_Dto_Old.FlightDtoOld;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceOld {

    // Создание INSTANCE для текущего Service - Начало
    private static final FlightServiceOld INSTANCE = new FlightServiceOld();

    private FlightServiceOld() {
    }

    public static FlightServiceOld getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего Service - Конец

    // Получение DAO - Начало
    private final FlightDaoOld flightDao = FlightDaoOld.getInstance();
    // Получение DAO - Конец

    // Получение коллекции DTO - Начало
    public List<FlightDtoOld> findAll() {
        return flightDao.findAll().stream()
                .map(f -> new FlightDtoOld(
                        f.getId(),
                        """
                                %s - %s - %s
                                """.formatted(
                                f.getDeparture_airport_code(),
                                f.getArrival_airport_code(),
                                f.getStatus()
                        )
                ))
                .collect(Collectors.toList());
    }
    // Получение коллекции DTO - Конец
}
