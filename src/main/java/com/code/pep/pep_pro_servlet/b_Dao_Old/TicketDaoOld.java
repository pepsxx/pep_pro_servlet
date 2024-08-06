package com.code.pep.pep_pro_servlet.b_Dao_Old;

import com.code.pep.pep_pro_servlet.a_Entity.TicketEntity;
import com.code.pep.pep_pro_servlet.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoOld implements Dao<Long, TicketEntity> {

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

    public List<TicketEntity> findAllByFlightId(Long flightId) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_FLIGHT_ID);
            preparedStatement.setObject(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TicketEntity> ticketEntities = new ArrayList<>();
            while (resultSet.next()) {
                ticketEntities.add(buildTicket(resultSet));
            }
            return ticketEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Билдер Entity - Начало
    private TicketEntity buildTicket(ResultSet resultSet) throws SQLException {
        return new TicketEntity(
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
    public List<TicketEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<TicketEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void Update(TicketEntity entity) {
    }

    @Override
    public TicketEntity save(TicketEntity entity) {
        return null;
    }
    // Не реализованные методы - Конец
}


