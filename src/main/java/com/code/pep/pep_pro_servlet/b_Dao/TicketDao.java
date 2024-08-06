package com.code.pep.pep_pro_servlet.b_Dao;

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

public class TicketDao implements Dao<Long, TicketEntity> {

    // Создание INSTANCE для текущего DAO - Начало
    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {
    }

    public static TicketDao getInstance() {
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
        return TicketEntity.builder()
                .id(resultSet.getLong("id"))
                .passenger_no(resultSet.getString("passenger_no"))
                .passenger_name(resultSet.getString("passenger_name"))
                .flight_id(resultSet.getLong("flight_id"))
                .seat_no(resultSet.getString("seat_no"))
                .cost(resultSet.getBigDecimal("cost"))
                .build();
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


