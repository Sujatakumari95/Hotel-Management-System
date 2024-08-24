import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class GetRoomNumber {
 public static void getRoomNumber(Connection connection, Scanner scanner)throws SQLException {
	 System.out.print("Enter reservation Id: ");
	 int reservationId = scanner.nextInt();
	 System.out.print("Enter guest name: ");
	 String guestName = scanner.next();
	  String query ="select room_number from reservations where reservation_id= ? and guest_name= ?";
	 
	  try{
		  PreparedStatement prepareStatement = connection.prepareStatement(query);
		 prepareStatement.setInt(1, reservationId);
		 prepareStatement.setString(2, guestName);
		 ResultSet resultSet = prepareStatement.executeQuery();
		  
		 if(resultSet.next()){
			 int roomNumber =resultSet.getInt("room_number");
			 System.out.println("Room number for Reservation ID " + reservationId +
                     " and Guest " + guestName + " is: " + roomNumber);
		 }else{
			 System.out.println("Reservation not found for the given ID and guest name.");
		 }
		 
	 }catch(SQLException e){
		 System.out.println(e.getMessage());
	 }
 }
}
