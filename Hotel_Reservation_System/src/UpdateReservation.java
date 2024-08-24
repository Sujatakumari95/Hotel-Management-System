import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateReservation {
public static void updateReservation(Connection connection,Scanner scanner)throws SQLException{
	 try {
         System.out.print("Enter reservation ID to update: ");
         int reservationId = scanner.nextInt();
         scanner.nextLine(); // Consume the newline character

         if (!reservationExists(connection, reservationId)) {
             System.out.println("Reservation not found for the given ID.");
             return;
         }
         
	      System.out.print("Enter new guest name: ");
	      String newGuestName = scanner.next();
	      System.out.print("Enter new room number: ");
	      int newRoomNumber = scanner.nextInt();
	      System.out.print("Enter new contact number: ");
	      String newContactNumber = scanner.next();
	
	      String query ="UPDATE reservations SET guest_name = ?, room_number = ? ,contact_number = ? WHERE reservation_id = ?";
	      
	
	try(PreparedStatement prepareStatement = connection.prepareStatement(query)){
		
		prepareStatement.setString(1, newGuestName);
		prepareStatement.setInt(2, newRoomNumber);
		prepareStatement.setString(3, newContactNumber);
		prepareStatement.setInt(4, reservationId);
		int afectedRows = prepareStatement.executeUpdate();
		if(afectedRows>0){
			System.out.println("Reservation updated successfully!! ");
		}else{
			System.out.println("Reservation update failed. ");
		}
	}
	}catch(SQLException e){
		e.printStackTrace();
	}

	 
}

private static boolean reservationExists(Connection connection, int reservationId) {
    try {
        String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            return resultSet.next(); // If there's a result, the reservation exists
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Handle database errors as needed
    }
}
}