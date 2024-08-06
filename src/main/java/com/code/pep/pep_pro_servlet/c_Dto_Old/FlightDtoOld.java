package com.code.pep.pep_pro_servlet.c_Dto_Old;

import java.util.Objects;

public class FlightDtoOld {
    private final Long id;
    private final String description;

    public FlightDtoOld(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDtoOld that = (FlightDtoOld) o;
        return id.equals(that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "FlightDtoOld{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
