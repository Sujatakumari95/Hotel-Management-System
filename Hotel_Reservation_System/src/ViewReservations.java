import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewReservations {
  public static void viewReservations(Connection connection){
	  String query="SELECT *  FROM reservations";
	  
	  try{
    PreparedStatement prepareStatement =connection.prepareStatement(query);
	// Statement stmt= connection.createStatement();
	ResultSet resultSet= prepareStatement.executeQuery();
	System.out.println("Current Reservation ");
	System.out.println("+----------------+---------------+-------------+----------------+-----------------------+");
	System.out.println("| Reservation_Id | Guest         | Room Number | Contact Number | Reservation Date      |");
	System.out.println("+----------------+---------------+-------------+----------------+-----------------------+");
	
	
	while(resultSet.next()){	
		 int reservation_id = resultSet.getInt("reservation_id");
		String guest_Name = resultSet.getString("guest_name");
		int room_number = resultSet.getInt("room_number");
		String contact_number = resultSet.getString("contact_number");
		String reservation_date= resultSet.getTimestamp("reservation_date").toString();
		
		//format and display the reservation data in a table-like format
		
		System.out.printf("| %-14d | %-13s | %-11d | %-14s |%-22s |\n", reservation_id,guest_Name,room_number,contact_number,reservation_date);
		
	}
	System.out.println("+----------------+---------------+-------------+----------------+-----------------------+");
	
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
  }
}
