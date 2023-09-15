
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelDAO {

	void insertDetails(hotelBean ht) throws ClassNotFoundException ,SQLException 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
	
	String query="insert into user value(?,?,?,?,?,?)";
	
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1, ht.getName());
	ps.setString(2, ht.getEmail());
	ps.setLong(3, ht.getMobile());
	ps.setInt(4, ht.getRoom_no());
	ps.setString(5, ht.getEntry());
	ps.setInt(6, ht.getStay());
	
	ps.execute();
	con.close();
	
}
}
