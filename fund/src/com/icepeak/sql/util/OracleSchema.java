/*
 * 创建日期  2008-12-12
 * 作者 ice_peak
 */
package com.icepeak.sql.util;


import java.util.ArrayList;
import java.util.HashSet;
/**
 * @author ice_peak
 */
public class OracleSchema implements DatabaseSchema {

    DatabaseOperate databaseOperate = null;

    /**
     * 构造函数，初始化数据库
     * @param strURL
     * @param strDBriver
     * @param strUser
     * @param strPassword
     */
    public OracleSchema(String strURL, String strUser,
            String strPassword) {
        //构造DatabaseOperate
        this.databaseOperate = new DatabaseOperate(strURL,
                "oracle.jdbc.driver.OracleDriver", strUser, strPassword);
    }
    
    
    /**
     * 获取表格的描述信息
     * @param strTableName
     * @return 表格的
     */
    public ArrayList mGetTableDesc(String strTableName)  {
        //获取oracle表的信息，列名、数据类型、数据类型（转换用），是否可空，数据长度，数据精度，数据位数，默认值
		String strSql = "select column_name,data_type,data_type,nullable,data_length,data_precision,data_scale,data_default from user_tab_columns where table_name = '"
			+ strTableName + "' order by column_name ";
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		
		//对返回结果，置换处理
		for(int i=0; i<alDatas.size(); i++ ) {
		    ArrayList alDatasRow = (ArrayList) alDatas.get(i);
		    //转换类型，便于不同数据库比较
		    if("VARCHAR2".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"字符型");
		    } else if("NUMBER".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"数字型");
		    } else if ("DATE".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"日期型");
		    } 
		    
		    //是否为空判断
		    if("Y".equals(alDatasRow.get(3).toString())) {
		        alDatasRow.set(3,"可空");
		    } else if("N".equals(alDatasRow.get(3).toString().trim())) {
		        alDatasRow.set(3,"非空");
		    }		    
		}
		
		return  alDatas;  		
    }
    
    /**
     * 获取表格的描述信息
     * @param strTableName
     * @return 表格的
     */
    public int mGetTableRowCount(String strTableName)  {
        //获取表的记录数
        String strSql = "select count(*) from  " + strTableName ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		
		//获取表格行数
		ArrayList alDataRow =(ArrayList) alDatas.get(0);		
        int iTableCount =Integer.parseInt(alDataRow.get(0).toString()); 
        return iTableCount;    
    }
    
    
    /**
     * 获取schema的表名称
     * @return
     */
    public ArrayList mGetSchemaTableNames() {
        //获取表的记录数
        String strSql = "select table_name from user_tables" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		//构造一维表名ArrayList
		ArrayList alTableName = new ArrayList();		
		for(int i=0; i<alDatas.size(); i++) {
			ArrayList alDataRow = (ArrayList)alDatas.get(i);
			alTableName.add(i,alDataRow.get(0));			
		}
		return alTableName;
        
    }
    
    /**
     * 判断表是否存在
     * @
     */
    public boolean mTableExist(String strTableName) {
    	boolean bTableExist = false;
        String strSql = "select count(*) from user_tables where  table_name ='"+strTableName+"'" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);  	
		ArrayList alDatasRow = (ArrayList) alDatas.get(0);
		if(!"0".equals(alDatasRow.get(0).toString())) {
			 bTableExist = true;
		}
    	
    	return bTableExist;
    }   
    
    /**
     * 取得表的列注释
     * @return
     */
    public ArrayList mGetTableColumnComment(String strTableName) {
        String strSql = "select column_name,nvl(comments,'NULL'),table_name from user_col_comments where table_name = '"+strTableName+"'" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
//        //对返回结果，置换处理
//        for (int i = 0; i < alDatas.size(); i++) {
//            ArrayList alDatasRow = (ArrayList) alDatas.get(i);
//            //转换类型，便于不同数据库比较
//            if ("null".equals(alDatasRow.get(1).toString())) {
//                alDatasRow.set(1, "NULL");
//            }
//        }		
		return alDatas;    	
    }
    
    public static void main(String args[]) {
        OracleSchema os = new OracleSchema("jdbc:oracle:thin:@192.10.5.63:1521:ces","gdda32_dev","gdda32_dev");
        
        System.out.println(os.mGetTableDesc("T_FILE_WSDA"));
        System.out.println(os.mGetTableRowCount("T_FILE_WSDA"));
        System.out.println(os.mGetSchemaTableNames());
    }
    
    
        
    
    
    
    
    
}