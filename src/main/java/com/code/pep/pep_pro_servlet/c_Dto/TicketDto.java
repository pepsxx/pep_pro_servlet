package com.code.pep.pep_pro_servlet.c_Dto;

import lombok.Builder;
import lombok.Value;

@Value
// @Getter                      - Геттеры
// @FieldDefaults(makeFinal=true, level=AccessLevel. PRIVATE)
//                              - Поля класса final и private
// @AllArgsConstructor          - Конструктор со всеми аргументами
// @ToString                    - метод ToString
// @EqualsAndHashCode           - методы Equals и HashCode
@Builder //                     - Создает аспект «строителя»
public class TicketDto {
    Long id;
    Long flight_id;
    String seat_no;
}
