package com.code.pep.pep_pro_servlet.a_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

// map один к одному с db
@Data // Набор аннотаций:
// @Getter                  - Геттеры
// @Setter                  - Сеттеры
// @RequiredArgsConstructor - Пустой конструктор если нет других
// @ToString                - метод ToString
// @EqualsAndHashCode       - методы Equals и HashCode
@AllArgsConstructor // Конструктор со всеми аргументами
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Equals и HashCode только для помеченных полей
public class TicketEntity {
    @EqualsAndHashCode.Include
    Long id;
    String passenger_no;
    String passenger_name;
    Long flight_id;
    String seat_no;
    BigDecimal cost;
}
