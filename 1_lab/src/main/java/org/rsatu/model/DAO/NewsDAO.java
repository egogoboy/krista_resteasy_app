package org.rsatu.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.rsatu.db.Database;
import org.rsatu.view.App;
import org.rsatu.controller.categories.CategoryItemBO;
import org.rsatu.controller.news.NewsItemBO;

public class NewsDAO {
    private CategoryDAO categoryDAO = App.categoryDAO;

    public NewsDAO() {
        CreateTableIfNotExist();
    }

    public NewsItemBO addNews(NewsItemBO news) {
        String sql = "INSERT INTO news(title, text, category_id) VALUES(?, ?, ?)";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, news.getTitle());
            pstmt.setString(2, news.getText());

            CategoryItemBO category = categoryDAO.getCategoryByName(news.getCategory().getTitle());
            if (category == null) {
                return null;
            }
            pstmt.setLong(3, category.getId());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    Long generatedId = rs.getLong(1);
                    return getCurrentNews(generatedId);
                }
            }

            return null;
        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while creating news\n" + ex.getMessage());
            return null;
        }
    }

    public List<NewsItemBO> getAllNews() {
        List<NewsItemBO> news = new ArrayList<>();
        String sql = "SELECT * FROM news;";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                NewsItemBO n = new NewsItemBO(rs.getLong("id"), rs.getString("title"), rs.getString("text"),
                        App.categoryDAO.getCategory(rs.getLong("category_id")));
                news.add(n);
            }

            return news;

        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while getting news\n" + ex.getMessage());
            return null;
        }
    }

    public NewsItemBO getCurrentNews(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?;";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new NewsItemBO(rs.getLong("id"), rs.getString("title"), rs.getString("text"),
                        App.categoryDAO.getCategory(rs.getLong("category_id")));
            }

            return null;

        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while getting news\n" + ex.getMessage());
            return null;
        }
    }

    private final String LOG_LABEL = "[NewsDAO]";

    private void CreateTableIfNotExist() {
        String sql = "CREATE TABLE IF NOT EXISTS news (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, text TEXT NOT NULL, category_id INTEGER, FOREIGN KEY (category_id) REFERENCES categories(id) );";
        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
