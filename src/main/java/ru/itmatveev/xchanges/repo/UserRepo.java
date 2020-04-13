//package ru.itmatveev.xchanges.repo;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import ru.itmatveev.xchanges.data.User;
//
//import java.util.List;
//
//@Repository
//public class UserRepo {
//
//    private static final String GET_USERS = "SELECT * FROM USERS";
//    private static final String GET_USER_BY_ID ="SELECT * FROM USERS WHERE id = ?";
//    private static final String SAVE_USER = "INSERT INTO users (id, name, username, password) VALUES (?,?,?,?)";
//    private static final String UPDATE_USER = "UPDATE users SET name=?, username=?, password=? where id = ?";
//    private JdbcTemplate jdbcTemplate;
//
//    public UserRepo(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<User> getUsers() {
//        return jdbcTemplate.query(GET_USERS,
//                (rs, i) -> new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("username"),
//                        rs.getString("password")
//                )
//        );
//    }
//
//    public User getUserById(int id){
//        return jdbcTemplate.queryForObject(GET_USER_BY_ID,
//                new Object[]{id},
//                (rs , i) -> new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("username"),
//                        rs.getString("password")
//                ));
//    }
//
//    public void saveUser(User user){
//        jdbcTemplate.update(SAVE_USER,
//                user.getId(),
//                user.getName(),
//                user.getUsername(),
//                user.getPassword()
//                );
//    }
//
//    public void updateUser(User user){
//        jdbcTemplate.update(UPDATE_USER,
//                user.getId(),
//                user.getName(),
//                user.getUsername(),
//                user.getPassword()
//        );
//    }
//}
//
