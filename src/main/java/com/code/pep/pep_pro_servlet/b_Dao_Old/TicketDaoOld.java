package com.code.pep.pep_pro_servlet.b_Dao_Old;

import com.code.pep.pep_pro_servlet.a_Entity_Old.TicketEntityOld;
import com.code.pep.pep_pro_servlet.util_Old.ConnectionManagerOld;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoOld implements Dao<Long, TicketEntityOld> {

    // Создание INSTANCE для текущего DAO - Начало
    private static final TicketDaoOld INSTANCE = new TicketDaoOld();

    private TicketDaoOld() {
    }

    public static TicketDaoOld getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего DAO - Конец

    // Подготовленные запросы SQL - Начало
    private static final String SQL_FIND_ALL_BY_FLIGHT_ID = """
            select *
            from ticket
            where flight_id=?
            """;
    // Подготовленные запросы SQL - Конец

    public List<TicketEntityOld> findAllByFlightId(Long flightId) {
        try (Connection connection = ConnectionManagerOld.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_FLIGHT_ID);
            preparedStatement.setObject(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TicketEntityOld> ticketEntities = new ArrayList<>();
            while (resultSet.next()) {
                ticketEntities.add(buildTicket(resultSet));
            }
            return ticketEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Билдер Entity - Начало
    private TicketEntityOld buildTicket(ResultSet resultSet) throws SQLException {
        return new TicketEntityOld(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class));
    }
    // Билдер Entity - Конец

    // Не реализованные методы - Начало
    @Override
    public List<TicketEntityOld> findAll() {
        return List.of();
    }

    @Override
    public Optional<TicketEntityOld> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void Update(TicketEntityOld entity) {
    }

    @Override
    public TicketEntityOld save(TicketEntityOld entity) {
        return null;
    }
    // Не реализованные методы - Конец
}


