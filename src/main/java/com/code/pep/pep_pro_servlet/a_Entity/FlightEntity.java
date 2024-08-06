package com.code.pep.pep_pro_servlet.a_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

// map один к одному с db
@Data // Набор аннотаций:
// @Getter                  - Геттеры
// @Setter                  - Сеттеры
// @RequiredArgsConstructor - Пустой конструктор если нет других
// @ToString                - метод ToString
// @EqualsAndHashCode       - методы Equals и HashCode
@AllArgsConstructor // Конструктор со всеми аргументами
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Equals и HashCode только для помеченных полей
public class FlightEntity {
    @EqualsAndHashCode.Include
    private Long id;
    private String flight_no;
    private LocalDateTime departure_date;
    private String departure_airport_code;
    private LocalDateTime arrival_date;
    private String arrival_airport_code;
    private Integer aircraft_id;
    private FlightStatusEntity status;
}
