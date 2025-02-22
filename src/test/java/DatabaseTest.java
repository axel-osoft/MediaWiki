import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Устанавливаем соединение с вашей базой данных
        String jdbcUrl = "jdbc:mysql://localhost:3306/mediawiki";
        String user = "root";
        String password = "root";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    @After
    public void tearDown() throws Exception {
        // Закрываем соединение
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testConnection() {
        // Проверяем, что соединение не является null
        assertNotNull("Connection should not be null", connection);
    }
}
