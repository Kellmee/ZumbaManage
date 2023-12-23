package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zumba.model.Participant;
import com.zumba.util.DatabaseConnection;

public class ParticipantDAO {

    private Connection connection;

    public ParticipantDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String query = "SELECT * FROM participants";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setId(resultSet.getLong("id"));
              participant.setName(resultSet.getString("name"));
               

                participants.add(participant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participants;
    }

    public int addParticipant(Participant participant) {
        String query = "INSERT INTO participants (name, email) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, participant.getName());
            preparedStatement.setString(2, participant.getEmail());
           
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

 
}
