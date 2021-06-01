package kpi.stud.servletProject.model.dao;

import kpi.stud.servletProject.model.Role;
import kpi.stud.servletProject.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlUserDao implements UserDao{
    private static final String SQL_GET_ALL_USERS = "SELECT * FROM users";
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_GET_ALL_USERS);
            while (rs.next()){
                users.add(new User(rs.getString("login_user"), rs.getString("pass_user"),
                        rs.getString("name_user"), rs.getString("surname_user"), Role.valueOf(rs.getString("role_user"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

}
