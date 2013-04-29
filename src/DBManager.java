import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


class DBManager
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
	
        
        public static boolean enterdata(BasicData s)
		{
			boolean flag=false;
			try
			{
				Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("insert into cropdata(CropYield,PlantationDate,CropType,CropName,IrrigationMethod,SoilType,TillageType,Latitude,longitude,City,country,altitude,FieldSize,FarmerName,username) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				st.setString(14,s.getFarmerName());
				st.setString(1,s.getCropYield());
				st.setString(2,s.getDate());
				st.setString(3,s.getCropType());
				st.setString(4,s.getCropName());
				st.setString(5,s.getIrrigationMethod());
				st.setString(6,s.getSoilType());
				st.setString(7,s.getTillageType());
				st.setString(8,s.getLatitude());
				st.setString(9,s.getLongitude());
				st.setString(10,s.getCity());
                                st.setString(11,s.getCountry());
                                st.setString(12,s.getAltitude());
                                st.setString(13,s.getFieldSize()); 
                                st.setString(15,Login.name);
                              

				st.executeUpdate();
				st.close();
				con.close();
				flag=true;
			}
			catch(Exception ex){

                        }
			return flag;
	}



	
        
        public static boolean sensordata(Sensor t)
        {
            
             boolean flag=false;
			try
			{
                                java.util.Date myDate = new java.util.Date();
                                java.sql.Timestamp sqlDate = new java.sql.Timestamp(myDate.getTime());
                            	Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("insert into sensordata(WaterConsumed,MaxHumidity,MaxTemprature,Mintemprature,AvgWindSpeed,SoilMoisture,FertilizersUsed,RainFall,EnterDate,username,FertilizerQuantity,MinHumidity,SunshineHr) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                   
                                st.setString(1,t.getWaterConsumed());
				st.setString(2,t.getMaxHumidity());
				st.setString(3,t.getMaxTemprature());
				st.setString(4,t.getMintemprature());
				st.setString(5,t.getAvgWindSpeed());
				st.setString(6,t.getSoilMoisture());
				st.setString(7,t.getFertilizersUsed());
                                st.setString(11,t.getFertilizerQuantity());
				st.setString(8,t.getRainFall());
                                st.setTimestamp(9,sqlDate);
                                st.setString(10,Login.name);
                                st.setString(12,t.getMinHumidity());
                                st.setString(13,t.getSunshineHr());
                                

                                
                                
                                   st.executeUpdate();
                                   st.close();
                                   con.close();
                                   flag=true;
                        }
                        catch(Exception ex){

                        }
			return flag;
                        
    
        }
       
         public static boolean sensordataUpdate(Sensor t)
        {
            
             boolean flag=false;
			try
			{
                                java.util.Date myDate = new java.util.Date();
                                java.sql.Timestamp sqlDate = new java.sql.Timestamp(myDate.getTime());
                            	Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("update sensordata set WaterConsumed=?,MaxHumidity=?,MaxTemprature=?,Mintemprature=?,AvgWindSpeed=?,SoilMoisture=?,FertilizersUsed=?,RainFall=?,EnterDate=?,username=?,FertilizerQuantity=?,MinHumidity=?,SunshineHr=? where username=Login.name");
                                   
                                st.setString(1,t.getWaterConsumed());
				st.setString(2,t.getMaxHumidity());
				st.setString(3,t.getMaxTemprature());
				st.setString(4,t.getMintemprature());
				st.setString(5,t.getAvgWindSpeed());
				st.setString(6,t.getSoilMoisture());
				st.setString(7,t.getFertilizersUsed());
                                st.setString(11,t.getFertilizerQuantity());
				st.setString(8,t.getRainFall());
                                st.setTimestamp(9,sqlDate);
                                st.setString(10,Login.name);
                                st.setString(12,t.getMinHumidity());
                                st.setString(13,t.getSunshineHr());
                                

                                
                                
                                   st.executeUpdate();
                                   st.close();
                                   con.close();
                                   flag=true;
                        }
                        catch(Exception ex){

                        }
			return flag;
                        
    
        }
        
        
       public static BasicData getView(int fid){
            
            BasicData s = null;
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata where fieldid=?");
			st.setInt(1,fid);
			ResultSet rs = (ResultSet) st.executeQuery();
			if(rs.next())
			{
				s = new BasicData();
                                
				s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));
                                
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return s;
        }
        
        
        /*
        public static ArrayList<Sensor> getSensorData()
	{
		ArrayList<Sensor> list = new ArrayList<Sensor>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from sensordata");
			//st.setString(1,uname);
                        ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				Sensor d = new Sensor();
				d.setWaterConsumed(rs.getString(1));
                                d.setAvgHumidity(rs.getString(2));
                                d.setMaxTemprature(rs.getString(3));
                                d.setMintemprature(rs.getString(4));
                                d.setAvgWindSpeed(rs.getString(5));
                                d.setSoilMoisture(rs.getString(6));
                                d.setFertilizersUsed(rs.getString(7));
                                d.setRainFall(rs.getString(8));
                                d.setCurrentDate(rs.getString(9));
                                
				
				list.add(d);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return list;
	}
        */
        
        
        public static Sensor getSensorDataEto()
	{
		Sensor e=null;
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from sensordata");
			//st.setString(1,uname);
                        ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				 e = new Sensor();
				e.setWaterConsumed(rs.getString(1));
                                e.setMaxHumidity(rs.getString(2));
                                e.setMaxTemprature(rs.getString(3));
                                e.setMintemprature(rs.getString(4));
                                e.setAvgWindSpeed(rs.getString(5));
                                e.setSoilMoisture(rs.getString(6));
                                e.setFertilizersUsed(rs.getString(7));
                                e.setRainFall(rs.getString(8));
                                e.setCurrentDate(rs.getString(9));
                                
				
				
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return e;
	}
        
        
         public static ArrayList<LoginPassword> getlogframe()
	{
		ArrayList<LoginPassword> loglist = new ArrayList<LoginPassword>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from login");
			ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				LoginPassword g = new LoginPassword();
				g.setuserName(rs.getString(1));
                                g.setpassWord(rs.getString(2));                     
				loglist.add(g);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return loglist;
	}
        
         
         public static boolean userRegister(LoginPassword r)
		{
			boolean flag=false;
			try
			{
				Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("insert into login(username,password) values(?,?)");
				st.setString(1,r.getuserName());
				st.setString(2,r.getpassWord());
			            

				st.executeUpdate();
				st.close();
				con.close();
				flag=true;
			}
			catch(Exception ex){

                        }
			return flag;
	}
         
         public static ArrayList<LoginPassword> getusername()
	{
		ArrayList<LoginPassword> userlist = new ArrayList<LoginPassword>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select username from login");
			ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				LoginPassword u = new LoginPassword();
				
                                u.setuserName(rs.getString(1));                     
				userlist.add(u);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return userlist;
	}
         
         
         
         
         
         
         public static ArrayList<BasicData> getCropData()
	{
		ArrayList<BasicData> croplist = new ArrayList<BasicData>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata");
			ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				BasicData s = new BasicData();
				s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));
                                 s.setFieldId(rs.getString(15));
                                
				
				croplist.add(s);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return croplist;
	}
         
         
         public static ArrayList<BasicData> getIn(String uname)
	{
		ArrayList<BasicData> croplist = new ArrayList<BasicData>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata where username=?");
			st.setString(1,uname);
                        ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				BasicData s = new BasicData();
				s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));
                                s.setAltitude(rs.getString(13));
                                s.setLatitude(rs.getString(9));
                                
				
				croplist.add(s);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return croplist;
	}
         
         
         public static BasicData getData(String uname){
            //String a =new String();
            BasicData s = null;
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata where username=?");
			st.setString(1,uname);
			ResultSet rs = (ResultSet) st.executeQuery();
			if(rs.next())
			{
				s = new BasicData();
                                s.setUsername(rs.getString(16));
				/*s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));*/
                                s.setLatitude(rs.getString(9));
                                s.setAltitude(rs.getString(13));
                                //a=rs.getString(16);
                               // System.out.println(a);
                                
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return s;
        }
         
          public static LoginPassword getFarmerName(String uname){
            //String a =new String();
            LoginPassword l = null;
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from login where username=?");
			st.setString(1,uname);
			ResultSet rs = (ResultSet) st.executeQuery();
			if(rs.next())
			{
				l = new LoginPassword();
                                l.setuserName(rs.getString(1));
				
                                
                                //a=rs.getString(16);
                               // System.out.println(a);
                                
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return l;
        }
         
         
         public static ArrayList<Sensor> getUserSensorData(String uname) // data will be retrieved according to username only
	{
		ArrayList<Sensor> usersensorlist = new ArrayList<Sensor>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from sensordata where username=?");
			st.setString(1,uname);
                        ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				Sensor d = new Sensor();
				d.setWaterConsumed(rs.getString(1));
                                d.setMaxHumidity(rs.getString(2));
                                d.setMaxTemprature(rs.getString(3));
                                d.setMintemprature(rs.getString(4));
                                d.setAvgWindSpeed(rs.getString(5));
                                d.setSoilMoisture(rs.getString(6));
                                d.setFertilizersUsed(rs.getString(7));
                                d.setRainFall(rs.getString(8));
                                d.setCurrentDate(rs.getString(9));
                                
				
				usersensorlist.add(d);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return usersensorlist;
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
         
         public static BasicData getView1(){
            
            BasicData s = null;
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata");
			
			ResultSet rs = (ResultSet) st.executeQuery();
			if(rs.next())
			{
				s = new BasicData();
                                
				s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));
                                
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return s;
        }
         
         
         public static ArrayList<BasicData> getCropData1(String n)
	{
            
		ArrayList<BasicData> refreshcroplist = new ArrayList<BasicData>();
		try
		{
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("Select * from cropdata where username=?");
                        st.setString(1,n);
			ResultSet rs = (ResultSet) st.executeQuery();
			while(rs.next())
			{
				BasicData s = new BasicData();
				s.setFarmerName(rs.getString(14));
                                s.setCity(rs.getString(11));
                                s.setDate(rs.getString(3));
                                s.setCropType(rs.getString(4));
                                s.setCropName(rs.getString(5));
                                s.setIrrigationMethod(rs.getString(6));
                                s.setSoilType(rs.getString(7));
                                s.setTillageType(rs.getString(8));
                                s.setFieldId(rs.getString(15));
                                
				
				refreshcroplist.add(s);
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception ex){}
		return refreshcroplist;
	}

         
        
}

