package com.code.pep.pep_pro_servlet.b_Dao_Old;

import com.code.pep.pep_pro_servlet.a_Entity_Old.FlightEntityOld;
import com.code.pep.pep_pro_servlet.a_Entity_Old.FlightStatusEntityOld;
import com.code.pep.pep_pro_servlet.util_Old.ConnectionManagerOld;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDaoOld implements Dao<Long, FlightEntityOld> {

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
    public List<FlightEntityOld> findAll() {
        try (Connection connection = ConnectionManagerOld.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<FlightEntityOld> flightEntities = new ArrayList<>();
            while (resultSet.next()) {
                flightEntities.add(buildFight(resultSet));
            }
            return flightEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Билдер Entity - Начало
    private FlightEntityOld buildFight(ResultSet resultSet) throws SQLException {
        return new FlightEntityOld(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatusEntityOld.valueOf(resultSet.getObject("status", String.class)));
    }
    // Билдер Entity - Конец

    // Не реализованные методы - Начало
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void Update(FlightEntityOld entity) {
    }

    @Override
    public FlightEntityOld save(FlightEntityOld entity) {
        return null;
    }

    @Override
    public Optional<FlightEntityOld> findById(Long id) {
        return Optional.empty();
    }
    // Не реализованные методы - Конец
}
