package com.code.pep.pep_pro_servlet.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Утилитный класс - для установки соединения с базой.
@UtilityClass
// Помечается как final
// Создаётся пустой приватный конструктор
// Методы, поля, вн. Классы помечаются static
// ВНИМАНИЕ: Не используйте статический импорт без звездочки для импорта этих членов; либо явно пометить Методы, поля, вн. Классы static
public class PropertiesUtil {
    private final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
