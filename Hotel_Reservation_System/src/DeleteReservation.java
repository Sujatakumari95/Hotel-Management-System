import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteReservation {
public static void deleteReservation(Connection connection,Scanner scanner) throws SQLException{
	System.out.print("Enter reservation ID to delete: ");
	int reservationId = scanner.nextInt();
	String query="DELETE FROM reservations WHERE reservation_id ="+reservationId;
	
	if(!reservationExists(connection,reservationId)){
		System.out.println("Reservation is not found for given ID.");
	}
	try{
		Statement stmt = connection.createStatement();
		int afectedRows = stmt.executeUpdate(query);
		if(afectedRows>0){
			System.out.println("Reservation deleted successfully!");
		}else{
			System.out.println("Reservation deletion failed.");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
}
 private static boolean reservationExists(Connection connection, int reservationId){
	 String query="SELECT reservation_id FROM reservations WHERE reservation_id="+reservationId;
	 try{
		 Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		
		 return resultSet.next();
	 }catch(SQLException e){
		 e.printStackTrace();
		 return false;
	 }
	
	
 }
}
