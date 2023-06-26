package api;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import static api.BaseTest.getConnection;

public class DBUtils {

    public static HashMap<String, String > sqlGetRow(String query) throws SQLException {
        getConnection();
        HashMap<String, String> row =new HashMap<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            while (resultSet.next()){
                for (int i = 1; i <= columns; i++) {
                    row.put(md.getColumnName(i), resultSet.getString(i));
                }
            }
        }
        return row;
    }
}
