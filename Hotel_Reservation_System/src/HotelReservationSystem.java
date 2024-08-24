import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class HotelReservationSystem {
	private static final String url="jdbc:postgresql://localhost:5432/Hotal_DB";
	private static final String Username="postgres";
	private static final String Password="sujata";

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException{
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		try{
			Connection connection = DriverManager.getConnection(url,Username,Password);
			while(true){
			System.out.println();
			System.out.println("Hotel Management System ");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Reserve a room ");
			System.out.println("2. View Reservations ");
			System.out.println("3. Get Room Number ");
			System.out.println("4. Update Reservations ");
			System.out.println("5. Delete Reservations");
			System.out.println("0. Exit ");
			System.out.println("Choose an option: ");
			int choice = scanner.nextInt();
			
			switch(choice){
				case 1:
					ReserveRoom.reservRoom(connection,scanner);
					break;
				case 2:
					ViewReservations.viewReservations(connection);
					break;
				case 3:
					GetRoomNumber.getRoomNumber(connection, scanner);				
					break;
				case 4:
					UpdateReservation.updateReservation(connection, scanner);
					break;
				case 5:
					DeleteReservation.deleteReservation(connection, scanner);
					break;
				case 0:
					Exist.exist();
					scanner.close();
					return;
					default:
						System.out.println("Invalid choice. Try Again.");
			}
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}

	}


}
