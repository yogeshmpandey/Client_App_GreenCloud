import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


class DBSuggestion
{
	private static final String DBDriver="com.mysql.jdbc.Driver";
	private static final String DBUrl = "jdbc:mysql://localhost/enterdata";
	private static final String DBUser = "root";
	private static final String DBPasswd = "";
        String runTimeUser = new String();
        
        static String a;
        
	static
		{
			try
			{
				Class.forName(DBDriver);
			}
			catch(Exception ex){}
	}
	private static Connection getConnection()throws Exception
		{
			Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPasswd);
			return con;
	}
	
        
      
         
         public static ArrayList<suggestion> getSuggestionList(String uname) // data will be retrieved from Suggestion Table according to username only
	{
		ArrayList<suggestion> suggestlist = new ArrayList<suggestion>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from suggest where username=?");
			st.setString(1,uname);
                        ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				suggestion d = new suggestion();
				d.setName(rs.getString(2));
                                d.setDate(rs.getString(4));
                                d.setComment(rs.getString(5));
                                
                                
				
				suggestlist.add(d);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return suggestlist;
	}
}

