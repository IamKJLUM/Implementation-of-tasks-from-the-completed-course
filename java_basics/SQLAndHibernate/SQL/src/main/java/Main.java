import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url               = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user              = "root";
        String pass              = "testtest";
        String rangeFor          = "'2018-01-01'";
        String rangeBefore       = "'2018-12-31'";
        String nameRow           = "course_name";
        String nameTable         = "purchaselist";
        String nameDependRow     = "subscription_date";
        String averagePercentage = "Average_percentage_of_sales_per_month";

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {

            Statement statement = connection.createStatement();

            ResultSet r = statement.executeQuery(
                    "SELECT " + nameRow + ", COUNT(" + nameRow + ")/(MAX(MONTH(" + nameDependRow + ")) - MIN(MONTH(" + nameDependRow + "))) AS " + averagePercentage + " " +
                            "FROM " + nameTable + " " +
                            "WHERE " + nameDependRow + " " +
                            "BETWEEN " + rangeFor + " AND " + rangeBefore + " " +
                            "GROUP BY " + nameRow);

            while (r.next()) {
                System.out.println(r.getString(nameRow) + " | " + r.getString(averagePercentage));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
