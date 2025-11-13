package org.rsatu.model.DAO;

import java.sql.*;

import org.rsatu.db.Database;
import org.rsatu.controller.categories.CategoryItemBO;

public class CategoryDAO {
    public CategoryDAO() {
        CreateTableIfNotExist();
    }

    public CategoryItemBO addCategory(CategoryItemBO category) {
        if (getCategoryByName(category.getTitle()) != null) {
            return null;
        }

        String sql = "INSERT INTO categories(name) VALUES(?)";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getTitle());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    Long generatedId = rs.getLong(1);
                    return getCategory(generatedId);
                }
            }

            return null;
        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while creating category");
            return null;
        }
    }

    public CategoryItemBO updateCategory(CategoryItemBO new_category) {
        String sql = "UPDATE categories SET name = ? WHERE id = ?";

        if (getCategory(new_category.getId()) == null) {
            return addCategory(new_category);
        }

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, new_category.getTitle());
            pstmt.setLong(2, new_category.getId());

            pstmt.executeUpdate();
            return getCategory(new_category.getId());
        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while getting category");
            return null;
        }
    }

    public CategoryItemBO getCategoryByName(String name) {
        String sql = "SELECT * FROM categories WHERE name = ?";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CategoryItemBO(rs.getLong("id"), rs.getString("name"));
            }

            return null;
        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while getting category");
            return null;
        }

    }

    public CategoryItemBO getCategory(Long id) {
        String sql = "SELECT * FROM categories WHERE id = ?";

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CategoryItemBO(rs.getLong("id"), rs.getString("name"));
            }

            return null;
        } catch (SQLException ex) {
            System.out.println(LOG_LABEL + "Error while getting category");
            return null;
        }

    }

    private final String LOG_LABEL = "[CategoryDAO]";

    private void CreateTableIfNotExist() {
        String sql = "CREATE TABLE IF NOT EXISTS categories (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL);";
        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
