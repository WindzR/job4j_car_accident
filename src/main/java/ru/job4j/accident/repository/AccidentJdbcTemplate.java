package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident addAccident(Accident accident) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        LocalDateTime created = LocalDateTime.now();
        String sql = "INSERT INTO accident ("
                + "name, description, created, address, type_id) values (?, ?, ?, ?, ?)";
        jdbc.update(connection -> {
                    PreparedStatement ps = connection
                            .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, accident.getName());
                    ps.setString(2, accident.getText());
                    ps.setTimestamp(3, Timestamp.valueOf(created));
                    ps.setString(4, accident.getAddress());
                    ps.setInt(5, accident.getType().getId());
                    return ps;
                }, keyHolder);
        accident.setId((int) keyHolder.getKeys().get("id"));
        for (Rule rule : accident.getRules()) {
            jdbc.update(
                    "INSERT INTO accident_rules (accident_id, rules_id) VALUES (?, ?)",
                        accident.getId(), rule.getId()
            );
        }
        return accident;
    }

    public List<Accident> getAllAccidents() {
        String sql = "SELECT acc.id, acc.name, "
                + "acc.description, acc.address, "
                + "types.id, types.name "
                + "FROM accident acc "
                + "LEFT JOIN types ON acc.type_id = types.id";
        List<Accident> accidents = jdbc.query(sql, (resultSet, rowNum) -> {
            Accident accidentDb = new Accident();
            accidentDb.setId(resultSet.getInt("id"));
            accidentDb.setName(resultSet.getString("name"));
            accidentDb.setText(resultSet.getString("description"));
            accidentDb.setAddress(resultSet.getString("address"));
            AccidentType type = new AccidentType();
            type.setId(resultSet.getInt("id"));
            type.setName(resultSet.getString("name"));
            accidentDb.setType(type);
            return accidentDb;
        });
        for (Accident accident : accidents) {
            sql = "SELECT rules.* FROM rules "
                    + "LEFT JOIN accident_rules ON rules.id = accident_rules.rules_id "
                    + "WHERE accident_rules.accident_id = ?";
            List<Rule> rules = jdbc.query(sql, (resultSet, rowNum) -> {
                Rule rule = new Rule();
                rule.setId(resultSet.getInt("id"));
                rule.setName(resultSet.getString("name"));
                return rule;
            }, accident.getId());
            for (Rule rule : rules) {
                accident.addRule(rule);
            }
        }

        return accidents;
    }

    public List<AccidentType> findAllAccidentType() {
        String sql = "SELECT * FROM types";
        return jdbc.query(sql, (resultSet, rowNum) -> {
            AccidentType type = new AccidentType();
            type.setId(resultSet.getInt("id"));
            type.setName(resultSet.getString("name"));
            return type;
        });
    }

    public List<Rule> findAllRules() {
        String sql = "SELECT * FROM rules";
        return jdbc.query(sql, (resultSet, rowNum) -> {
            Rule rule = new Rule();
            rule.setId(resultSet.getInt("id"));
            rule.setName(resultSet.getString("name"));
            return rule;
        });
    }

    public Accident findAccidentById(int id) {
        Set<Rule> rules = new HashSet<>();
        Rule rule = Rule.of(1, "Статья 1");
        rules.add(rule);
        return Accident.of(1, "Default name", "Default description", "Default address", rules);
    }
}
