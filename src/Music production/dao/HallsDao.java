package weddinghall.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weddinghall.dbconnection.DbConnection;
import weddinghall.model.Halls;

public class HallsDao {

	// rooms
	private static final String INSERT_rooms_SQL = "INSERT INTO weddinghall"
			+ " ( roomtype,Facilities,CostPerDay,filename,path) VALUES " + " ( ?, ?,?,?,?);";

	private static final String SELECT_rooms_BY_ID = "select id,roomtype,Facilities,CostPerDay from weddinghall where id =?";
	private static final String SELECT_ALL_erooms = "select * from weddinghall";
	private static final String DELETE_rooms_SQL = "delete from weddinghall where id = ?;";
	private static final String UPDATE_rooms_SQL = "update weddinghall set   roomtype = ?,Facilities = ?,CostPerDay = ?  where id = ?;";

	public HallsDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Rooms
	public void insertRooms(Halls room) throws SQLException {
		System.out.println(INSERT_rooms_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_rooms_SQL)) {
			preparedStatement.setString(1, room.getRoomtype());

			preparedStatement.setString(3, room.getFacilities());
			preparedStatement.setInt(4, room.getCost());
			preparedStatement.setString(5, room.getFilename());
			preparedStatement.setString(6, room.getPath());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Room
	public Halls selectRoom(int id) {
		Halls room = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_rooms_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String roomtype = rs.getString("roomtype");

				int nobeds = rs.getInt("NoBeds");
				String facilities = rs.getString("Facilities");
				int cost = rs.getInt("CostPerDay");

				room = new Halls(id, roomtype, facilities, cost);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return room;
	}

	// select All Rooms
	public List<Halls> selectAllRooms() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Halls> rooms = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_erooms);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String roomtype = rs.getString("roomtype");

				String facilities = rs.getString("Facilities");
				int cost = rs.getInt("CostPerDay");
				String filename = rs.getString("filename");
				String path = rs.getString("path");
				rooms.add(new Halls(id, roomtype, facilities, cost, filename, path));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return rooms;
	}

	// Delete rooms
	public boolean deleteRoom(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_rooms_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Room
	public boolean updateRooms(Halls room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_rooms_SQL);) {
			statement.setString(1, room.getRoomtype());

			statement.setString(3, room.getFacilities());
			statement.setInt(4, room.getCost());
			statement.setInt(5, room.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}