package com.code.pep.pep_pro_servlet.a_Entity_Old;

import java.math.BigDecimal;

// map один к одному с db
public class TicketEntityOld {
    Long id;
    String passenger_no;
    String passenger_name;
    Long flight_id;
    String seat_no;
    BigDecimal cost;

    public Long getId() {
        return id;
    }

    public String getPassenger_no() {
        return passenger_no;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassenger_no(String passenger_no) {
        this.passenger_no = passenger_no;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TicketEntity_old{" +
               "id=" + id +
               ", passenger_no='" + passenger_no + '\'' +
               ", passenger_name='" + passenger_name + '\'' +
               ", flight_id=" + flight_id +
               ", seat_no='" + seat_no + '\'' +
               ", cost=" + cost +
               '}';
    }

    public TicketEntityOld(Long id, String passenger_no, String passenger_name, Long flight_id, String seat_no, BigDecimal cost) {
        this.id = id;
        this.passenger_no = passenger_no;
        this.passenger_name = passenger_name;
        this.flight_id = flight_id;
        this.seat_no = seat_no;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntityOld that = (TicketEntityOld) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
