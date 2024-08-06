package com.code.pep.pep_pro_servlet.b_Dao_Old;

import com.code.pep.pep_pro_servlet.a_Entity.FlightEntity;
import com.code.pep.pep_pro_servlet.a_Entity.FlightStatusEntity;
import com.code.pep.pep_pro_servlet.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDaoOld implements Dao<Long, FlightEntity> {

    // Создание INSTANCE для текущего DAO - Начало
    private static final FlightDaoOld INSTANCE = new FlightDaoOld();

    private FlightDaoOld() {
    }

    public static FlightDaoOld getInstance() {
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
        return new FlightEntity(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatusEntity.valueOf(resultSet.getObject("status", String.class)));
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
