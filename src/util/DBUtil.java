package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import pojo.Food;

public class DBUtil {
	private static DBUtil instance = new DBUtil();
	private static DataSource ds = new ComboPooledDataSource();
	private DBUtil() {
	}
	public static DBUtil getInstance() {
		return instance;
	}
	public static Connection getConn() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 封装数据库表的增、删、改操作
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static boolean update(String sql,Object ...params) throws SQLException {
		Connection conn=getConn();
		PreparedStatement ps=conn.prepareStatement(sql);
		boolean flag = false;
        try {
            ps=conn.prepareStatement(sql);
            //判断参数是否为空
            if(params!= null&& params.length>0) {
                ps.clearParameters();//清除当前的参数
                for(int i = 0;i<params.length;i++) {
                    ps.setObject((i+1), params[i]);
                }
            }
            int result=ps.executeUpdate();
            flag = result > 0? true : false;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }finally {
            close(conn, ps);
        }
        return flag;    
	}
	
	/**
	 * 获取单个对象 可用于登录注册验证
	 * @throws SQLException 
	 */
	public static <T> T findBySingleObject(String sql,List<Object> params,Class<T> cls) throws SQLException {
        Connection conn =getConn();
        PreparedStatement ps = null;
        ResultSet rs=null;
        T singleObject = null;
       try {
            ps = conn.prepareStatement(sql);
            if(params != null && params.size()>0) {
                ps.clearParameters();//清除当前的参数  
                for(int i = 0;i<params.size();i++) {
                    ps.setObject((i+1),params.get(i));
                }
            }
            rs = ps.executeQuery();
            //获取元数据对象
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取字段的个数
            int columnCount = rsmd.getColumnCount();
            while(rs.next()) {
                singleObject = cls.newInstance();
                for(int i = 0;i<columnCount;i++) {
                    String columnName = rsmd.getColumnName(i+1);//根据索引得到字段的名字
                    Object columnValue = rs.getObject(columnName);//获取字段对应的值
                    Field field = cls.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(singleObject, columnValue);
                }
            }
        } catch (Exception e) {
          
            e.printStackTrace();
        } finally {
            close(conn, ps);

        }
        return singleObject;

    }
	
	
	 /**
     * 
     * 列表查询
	 * @throws SQLException 
     */
    public static<T> List<T> queryListExecute(String sql,List<Object> params,Class<T> class1 ) throws SQLException{
        Connection conn = getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        T singleObject = null;
        List <T> list = new ArrayList<T>();
        try {
            ps = conn.prepareStatement(sql);
            if(params !=null && params.size()>0) {
                ps.clearParameters();
                for(int i = 0;i<params.size();i++) {
                    ps.setObject((i+1), params.get(i));
                }   
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()) {
                singleObject = (T) class1.newInstance();
                for(int i = 0;i<columnCount;i++) {
                    String columnName = rsmd.getColumnName(i+1);
                    Object columdValue = rs.getObject(columnName);
                    Field field = class1.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(singleObject, columdValue);
                }
                list.add(singleObject);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }

        return list;
    }

	
	/**
	 * 释放资源
     */
    public static void close(Connection conn, PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * close方法进行重载
     * @param conn
     * @param pst
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement pst,
            ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
