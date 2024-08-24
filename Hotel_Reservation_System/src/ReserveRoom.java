import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ReserveRoom {
 public static void reservRoom(Connection connection,Scanner scanner){
	try{ 
     System.out.print("Enter Guest name: ");
	 String guestName = scanner.next();
	 System.out.print("Enter room number: ");
	 int roomNumber = scanner.nextInt();
	 System.out.print("Enter contact number: ");
	 String contactNumber = scanner.next();
	 String query ="INSERT INTO reservations(guest_name, room_number, contact_number) VALUES (?,?,?);";
	 
		 try(PreparedStatement prepareStatement = connection.prepareStatement(query)){
			 prepareStatement.setString(1, guestName);
			 prepareStatement.setInt(2, roomNumber);
			 prepareStatement.setString(3, contactNumber);
 	 int afectedRows = prepareStatement.executeUpdate(); 
		if(afectedRows>0){
			System.out.println("Reservatioin successful!");
			
		}else{
			System.out.println("Reservation failed.");
		}
	 } 
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
	            
 }
}
