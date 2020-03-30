package com.ibm.rdh.rfc.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import com.ibm.pprds.epimshw.util.ConfigManager;


/**
 * @version 1.0
 */

public class ConnectionFactory {
    private static Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    //move the getconnection from RdhDb2Proxy.class
	public static final String KEY_RDH_DB_DATASOURCE = "rdh.dataSource";
	public static final String KEY_RDH_DB_JDBCDRIVERCLASS = "rdh.jdbcDriverClass";
	public static final String KEY_RDH_DB_DBUSER = "rdh.DBUser";
	public static final String KEY_RDH_DB_DBPASSWORD = "rdh.DBPassword";
	
	//private Connection _connection;
	
	public static int commit(Connection _connection)
	{
		if(_connection == null) return -1;
		try {
			_connection.commit();
			return 0;
		}
		catch (SQLException ex) {
			logger.error("RdhDb2Proxy.commit(), Commit error.\n", ex);
			return -1;
		}
	}

	public static int rollback(Connection _connection)
	{
		if(_connection == null) return -1;
		try {
			_connection.rollback();
			return 0;
		}
		catch (SQLException ex) {
			logger.error("RdhDb2Proxy.rollback(), Rollback error.\n", ex);
			return -1;
		}
	}
	

	public static void closeConnection(Connection conn) {
	    try {
	        if (conn != null) {
	        	conn.commit();
	            conn.close();
	        }
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeConnection(Statement stmt, Connection conn) {
	    try {
	        if (stmt != null) {
	            stmt.close();
	        }
	        //closeConnection(conn);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeConnection(PreparedStatement prestmt,
	                                   Connection conn) {
	    try {
	        if (prestmt != null) {
	            prestmt.close();
	        }
	        //closeConnection(conn);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeConnection(ResultSet rs, Statement stmt,
	                                   Connection conn) {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        //closeConnection(conn);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeConnection(ResultSet rs, PreparedStatement prestmt,
	                                   Connection conn) {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (prestmt != null) {
	            prestmt.close();
	        }
	        //closeConnection(conn);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static Connection getTransConnection(String dbcpNameValue) {
	    if (dbcpNameValue == null || "".equals(dbcpNameValue)) {
	        return null;
	    }
	    Connection conn = null;
	    try {
	        Context ctx = new InitialContext();
	        javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup(
	            dbcpNameValue);
	        conn = ds.getConnection();
	        //conn.setAutoCommit(false);
	    }
	    catch (Exception err) {
	        err.printStackTrace();
	    }
	    return conn;
	}

	public static void closeTransConnection(Connection conn,
	                                        boolean abortTransaction) {
	    try {
	        if (conn != null) {
	            if (abortTransaction) {
	                conn.rollback();
	            }
	            else {
	                conn.commit();
	            }
	            //conn.setAutoCommit(true);
	            conn.close();
	        }
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeTransConnection(Statement stmt, Connection conn,
	                                        boolean abortTransaction) {
	    try {
	        if (stmt != null) {
	            stmt.close();
	        }
	        closeTransConnection(conn, abortTransaction);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}

	public static void closeTransConnection(ResultSet rs, Statement stmt,
	                                        Connection conn,
	                                        boolean abortTransaction) {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        closeTransConnection(conn, abortTransaction);
	    }
	    catch (SQLException err) {
	        err.printStackTrace();
	    }
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		ConfigManager cm = ConfigManager.getConfigManager();
		String datasource = cm.getString(ConnectionFactory.KEY_RDH_DB_DATASOURCE);
		String driver = cm.getString(ConnectionFactory.KEY_RDH_DB_JDBCDRIVERCLASS);
		String user = cm.getString(KEY_RDH_DB_DBUSER);
		String password = cm.getString(ConnectionFactory.KEY_RDH_DB_DBPASSWORD);
		logger.debug("datasource:" + datasource + " driver:" + driver + " user" + user + " password:" + password);
		Connection _connection = null;
		try {
			Class.forName(driver);
			_connection = DriverManager.getConnection(datasource, user, password);
			_connection.setAutoCommit(false);
			logger.info("connect(), has connect to db successfully");
		}catch (SQLException ex) {
			logger.error("connect(), Can not connect to database.\n" + ex);
			throw ex;
		}
		catch (ClassNotFoundException ex) {
			logger.error("connect(), Can not load Database driver.\n" + ex);
			throw ex;
		}  
		return _connection;
		
	}
	
//	public static Connection getConnection() {
//		String jdbc_url = "jdbc:db2://rdtst1e4.sby.ibm.com:50000/pprdshad";
//        String jdbc_user = "wangyul";
//        String jdbc_password = "";
//        String jdbc_driver = "com.ibm.db2.jcc.DB2Driver";
//        Connection conn = null;
//	    try {
//	        Class.forName(jdbc_driver);
//	        conn = DriverManager.getConnection(jdbc_url, jdbc_user,jdbc_password);
//	    }
//	    catch (ClassNotFoundException cne) {
//	       cne.printStackTrace();
//	    }
//	    catch (SQLException se) {
//	        se.printStackTrace();
//	    }
//	    return conn;
//	}

}