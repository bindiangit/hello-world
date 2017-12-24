/*
 * 创建日期  2008-12-12
 * 作者 ice_peak
 */
package com.icepeak.sql.util;


import java.util.ArrayList;

/**
 * @author ice_peak
 */
public class SqlServerSchema implements DatabaseSchema {

    DatabaseOperate databaseOperate = null;

    /**
     * 构造函数，初始化数据库
     * 
     * @param strURL
     * @param strDBriver
     * @param strUser
     * @param strPassword
     */
    public SqlServerSchema(String strURL, String strUser, String strPassword) {
        //构造DatabaseOperate
        this.databaseOperate = new DatabaseOperate(strURL,
                "com.microsoft.jdbc.sqlserver.SQLServerDriver", strUser,
                strPassword);
    }

    /**
     * 获取表格的描述信息
     * 
     * @param strTableName
     * @return 表格的
     */
    public ArrayList mGetTableDesc(String strTableName) {
        //获取oracle表的信息，列名、数据类型、数据类型（转换用），是否可空，数据长度，数据精度，数据位数，默认值
        String strSql = "select   column_name,data_type,data_type,is_nullable,character_octet_length,numeric_precision,numeric_precision_radix,column_default   from   information_schema.columns   where   table_name='"
                + strTableName + "' order by column_name ";
        ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

        //对返回结果，置换处理
        for (int i = 0; i < alDatas.size(); i++) {
            ArrayList alDatasRow = (ArrayList) alDatas.get(i);
            //转换类型，便于不同数据库比较
            if ("varchar".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "字符型");
            } else if ("numeric".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "数字型");
            } else if ("datetime".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "日期型");
                alDatasRow.set(5, "");  //datetime 为23
            }

            //是否为空判断
            if ("YES".equals(alDatasRow.get(3).toString().trim())) {
                alDatasRow.set(3, "可空");
            } else if ("No".equals(alDatasRow.get(3).toString().trim())) {
                alDatasRow.set(3, "非空");
            }
            
            //数字型转换
            if("numeric".equals(alDatasRow.get(1).toString()) & "18".equals(alDatasRow.get(5).toString().trim())) {
            	alDatasRow.set(5, "18");
            	alDatasRow.set(6, "");
            }
            
            //sql server默认值去掉（）
            if(!"".equals(alDatasRow.get(7).toString().trim())) {
            	if("(convert(char(10),getdate(),20))".equals(alDatasRow.get(7).toString().trim())) {
            		alDatasRow.set(7, "sysdate");
            	}
            	
            	String strDefault = alDatasRow.get(7).toString().trim().replaceAll("\\(","").replaceAll("\\)","");
            	
            	alDatasRow.set(7, strDefault);            	
            }
        }

        return alDatas;
    }

    /**
     * 获取表格的描述信息
     * 
     * @param strTableName
     * @return 表格的
     */
    public int mGetTableRowCount(String strTableName) {
        //获取表的记录数
        String strSql = "select count(*) from  " + strTableName ;
        ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

        //获取表格行数
        ArrayList alDataRow = (ArrayList) alDatas.get(0);
        int iTableCount = Integer.parseInt(alDataRow.get(0).toString());
        return iTableCount;
    }
    
    /**
     * 获取schema的表名称
     * @return
     */
    public ArrayList mGetSchemaTableNames() {
        //获取表的记录数
        String strSql = "select name from sysobjects where xtype='U' and status>0 order by name" ;
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
    	//System.out.println("[INFO] "+strTableName) ;
    	boolean bTableExist = false;
        String strSql = "select count(*) from sysobjects where xtype='U' and name ='"+strTableName+"'" ;
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
        String strSql = "select b.name,isnull(c.value,'NULL'),a.name from sysobjects  A inner join syscolumns b on  a.id=b.id left outer join sysproperties c on b.id=c.id and b.colid =c.smallid where a.xtype ='U' and a.name ='"+strTableName+"' order by a.id,b.colid" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

		return alDatas;    	
    }
    
    public void test() {
    	String strSql = " EXEC   sp_addextendedproperty 't_test.name' , '测试表name' ,'user' ,dbo , 'table',T_TEST,'column',name" ;
    	databaseOperate.executeDML(strSql);
    }
    

    public static void main(String args[]) {
        SqlServerSchema os = new SqlServerSchema(
                //"jdbc:microsoft:sqlserver://192.10.5.63:1433;databasename=gdda32;SelectMethod=cursor",
        		"jdbc:microsoft:sqlserver://127.0.0.1:1433;databasename=master;SelectMethod=cursor","sa", "sa");

//        System.out.println(os.mGetTableDesc("T_FILE_WSDA"));
//        System.out.println(os.mGetTableRowCount("T_FILE_WSDA"));
//        System.out.println(os.mGetSchemaTableNames());
//        System.out.println(os.mTableExist("T_FILE_WSDA"));
        	os.test();

    }

}