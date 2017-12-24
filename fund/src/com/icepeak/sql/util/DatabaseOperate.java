/*
 * 创建日期  2008-12-12
 * 作者 ice_peak
 */
package com.icepeak.sql.util;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * @author ice_peak
 */

public class DatabaseOperate {
    String strURL = "";
    String strDBDriver = "";
    String strUser = "";
    String strPassword = ""; 
    
    Connection conn = null;
    PreparedStatement pstmt =null;
    
    /**
     * 构造函数
     * @param strURL
     * @param strDBriver
     * @param strUser
     * @param strPassword
     */
    public DatabaseOperate (String strURL,String strDBriver,String strUser,String strPassword) {
        this.strURL = strURL;
        this.strDBDriver = strDBriver;
        this.strUser = strUser;
        this.strPassword = strPassword;               
    }
    
    
    /**
     * 检查
     * @return
     */
    public boolean mCheck() {
        boolean bCheck = false;
        if("".equals(this.strDBDriver)|| null == this.strDBDriver) {
            System.out.println("strDBDriver 为空！不能连接数据库！") ;          
        } else if ("".equals(this.strURL)|| null == this.strURL) {
            System.out.println("strURL 为空！不能连接数据库！") ; 
        } else if ("".equals(this.strUser)|| null == this.strUser) {
            System.out.println("strUser 为空！不能连接数据库！") ; 
        }  else if ("".equals(this.strPassword)|| null == this.strPassword) {
            System.out.println("strPassword 为空！不能连接数据库！") ; 
        } else {
            bCheck = true;
        }
        return bCheck;
        
    }


    public ArrayList mGetSelectData(String strSql) {
        ArrayList vData = new ArrayList();
        try {

            //如果检查不通过
            if(!mCheck()) {
                return vData;
            }
            
            Class.forName(strDBDriver);

            conn = DriverManager.getConnection(strURL, strUser, strPassword);

            pstmt =conn.prepareStatement(strSql)  ;
            //System.out.println(strSql) ;
            ResultSet rs=pstmt.executeQuery();
            int iColumnNumber =  pstmt.getMetaData().getColumnCount() ;

            while(rs.next()) {
                ArrayList vRowData = new ArrayList();
                for (int i = 0; i < iColumnNumber; i++) {
                    Object o=rs.getObject(i+1);
                    if(o==null)
                        o="";
                    vRowData.add(o);
                }
                vData.add(vRowData) ;
            }
            rs.close() ;
            conn.close() ;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！") ; 
        }
        return vData;
    }    
    
    
	public void executeDML(String strSql) {
		try {


			Class.forName(strDBDriver);
			conn = DriverManager.getConnection(strURL, strUser,
					strPassword);
			pstmt = conn.prepareStatement(strSql);
			int iReturn = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}
	

	public void executeMoreDML(ArrayList al) {
		try {


			Class.forName(strDBDriver);
			conn = DriverManager.getConnection(strURL, strUser,
					strPassword);
			int iSize = al.size();
			String strSql ;
			for(int i=0;i < iSize; i++) {
				
				//Date d =new Date();
				//System.out.println("execute sql:"+d.toLocaleString()) ;
				strSql = al.get(i).toString() ;
				System.out.println(strSql);
				pstmt = conn.prepareStatement(strSql);
				int iReturn = pstmt.executeUpdate();		
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}	
	

}
