package BsM.util;

import java.sql.*;
import BsM.model.Global;
public class DBPool {
	private static DBPool instance=null;
	public synchronized static Connection getConnection(){
		if(instance==null)
			instance=new DBPool();
		return instance._getConnection();
		
	}
	private DBPool(){}
	private Connection _getConnection() {

		try{
			 Class.forName(Global.DB_DRIVER);
			return DriverManager.getConnection(Global.DB_URL,Global.DB_USERNAME,Global.DB_PASSWORD);//建立数据库连接
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

}