package com.zumba.dao;

import com.zumba.model.Batch;
import com.zumba.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {

    public List<Batch> getAllBatches() {
        List<Batch> batches = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM batches");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Batch batch = new Batch();
                batch.setBatchId(resultSet.getLong("batch_id"));
                batch.setName(resultSet.getString("name"));
                batch.setStartTime(resultSet.getString("start_time"));
                batch.setEndTime(resultSet.getString("end_time"));
                batches.add(batch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batches;
    }

    public boolean addBatch(Batch batch) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO batches (name, start_time, end_time) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, batch.getName());
            preparedStatement.setString(2, batch.getStartTime());
            preparedStatement.setString(3, batch.getEndTime());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

  
}

