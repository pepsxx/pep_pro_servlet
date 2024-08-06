package com.code.pep.pep_pro_servlet.b_Dao;

import com.code.pep.pep_pro_servlet.a_Entity.FlightEntity;
import com.code.pep.pep_pro_servlet.a_Entity.FlightStatusEntity;
import com.code.pep.pep_pro_servlet.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, FlightEntity> {

    // Создание INSTANCE для текущего DAO - Начало
    private static final FlightDao INSTANCE = new FlightDao();

    private FlightDao() {
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }
    // Создание INSTANCE для текущего DAO - Конец

    // Подготовленные запросы SQL - Начало
    private static final String SQL_FIND_ALL = """
            SELECT *
            FROM flight
            """;
    // Подготовленные запросы SQL - Конец

    @Override
    public List<FlightEntity> findAll() {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<FlightEntity> flightEntities = new ArrayList<>();
            while (resultSet.next()) {
                flightEntities.add(buildFight(resultSet));
            }
            return flightEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Билдер Entity - Начало
    private FlightEntity buildFight(ResultSet resultSet) throws SQLException {
        return FlightEntity.builder()
                .id(resultSet.getLong("id"))
                .flight_no(resultSet.getString("flight_no"))
                .departure_date(resultSet.getTimestamp("departure_date").toLocalDateTime())
                .departure_airport_code(resultSet.getString("departure_airport_code"))
                .arrival_date(resultSet.getTimestamp("arrival_date").toLocalDateTime())
                .arrival_airport_code(resultSet.getString("arrival_airport_code"))
                .aircraft_id(resultSet.getInt("aircraft_id"))
                .status(FlightStatusEntity.valueOf(resultSet.getString("status")))
                .build();
    }
    // Билдер Entity - Конец

    // Не реализованные методы - Начало
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void Update(FlightEntity entity) {
    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return null;
    }

    @Override
    public Optional<FlightEntity> findById(Long id) {
        return Optional.empty();
    }
    // Не реализованные методы - Конец
}
