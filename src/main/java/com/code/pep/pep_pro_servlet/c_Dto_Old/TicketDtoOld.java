package com.code.pep.pep_pro_servlet.c_Dto_Old;

import java.util.Objects;

public class TicketDtoOld {
    private final Long id;
    private final Long flight_id;
    private final String seat_no;

    public TicketDtoOld(Long id, Long flight_id, String seat_no) {
        this.id = id;
        this.flight_id = flight_id;
        this.seat_no = seat_no;
    }

    public Long getId() {
        return id;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketDtoOld that = (TicketDtoOld) o;
        return id.equals(that.id) && Objects.equals(flight_id, that.flight_id) && Objects.equals(seat_no, that.seat_no);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Objects.hashCode(flight_id);
        result = 31 * result + Objects.hashCode(seat_no);
        return result;
    }

    @Override
    public String toString() {
        return "TicketDtoOld{" +
               "id=" + id +
               ", flight_id=" + flight_id +
               ", seat_no='" + seat_no + '\'' +
               '}';
    }
}
