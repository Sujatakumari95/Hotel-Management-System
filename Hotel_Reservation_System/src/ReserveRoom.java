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
	System.out.print("201,202,203,204,205,206,207,208");
	 System.out.println();
	 System.out.println("Reserved room ");
	 roomInfo(connection);
	 int roomNumber;
	 while(true) {
	
     roomNumber = scanner.nextInt();
	 switch(roomNumber) {
	 case 201:
	 case 202:
     case 203:	 
     case 204:
     case 205:
     case 206:
     case 207:
     case 208:
    	 break;
    default: 
    	System.out.println("Invalid Room Number! Re-enter room number");
    continue;
	 }
	 break;
	 }
	 
	 
	 System.out.print("Enter contact number: ");
	 String contactNumber;
	 
	while(true) {
		
		contactNumber = scanner.next();
		 // Check if the contact number is exactly 10 digits
        if (contactNumber.length() == 10 && contactNumber.matches("\\d+")) {
            break;  // Valid contact number
        } else {
            System.out.println("Invalid contact number. Please enter a 10-digit number.");
        }
    }
	 
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
