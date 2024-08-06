package com.code.pep.pep_pro_servlet.c_Dto;

import lombok.Builder;
import lombok.Value;

@Value
// @Getter                      - Геттеры
// @FieldDefaults(makeFinal=true, level=AccessLevel. PRIVATE)
//                              - Поля класса final и private
// @AllArgsConstructor          - Конструктор со всеми аргументами
// @ToString                    - Метод ToString
// @EqualsAndHashCode           - Методы Equals и HashCode
@Builder //                     - Создает аспект «строителя»
public class FlightDto {
    Long id;
    String description;
}
