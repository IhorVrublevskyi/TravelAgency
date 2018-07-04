package org.lv326java.two.travelagency.entities;

public class User implements Entity {

    public static enum UserEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (login, password, first_name, last_name, roles_id) VALUES ('%s', '%s', '%s', '%s', %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, login, password, first_name, last_name, roles_id FROM users WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, login, password, first_name, last_name, roles_id FROM users WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, login, password, first_name, last_name, roles_id FROM users;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET password = '%s', first_name = '%s', last_name = '%s', WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE users WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE users WHERE %s = '%s';");

        private SqlQueries sqlQuery;
        private String query;

        private UserEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Long roleId;

    public User(Long id, String firstName, String lastName, String login, String password, Long roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
