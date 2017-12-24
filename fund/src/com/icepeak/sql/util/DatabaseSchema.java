/*
 * 创建日期  2008-12-12
 * 作者 ice_peak
 */
package com.icepeak.sql.util;

import java.util.ArrayList;

/**
 * @author ice_peak
 */
public interface DatabaseSchema {
    String strURL = "";
    String strUser = "";
    String strPassword = "";    
    String strDBDriver = "";
    
    DatabaseOperate databaseOperate = null;    
    
    /**
     * 获取表格的描述信息
     * @param strTableName
     * @return 表格的
     */
    public abstract ArrayList mGetTableDesc(String strTableName); 
    
    /**
     * 获取表格的描述信息
     * @param strTableName
     * @return 表格的
     */
    public abstract int mGetTableRowCount(String strTableName);
    
    
    /**
     * 获取schema的表名称
     * @return
     */
    public abstract ArrayList mGetSchemaTableNames();   
    
    /**
     * 判断表是否存在
     * @
     */    
    public boolean mTableExist(String strTableName);
    
    /**
     * 取得表的列注释
     * @return
     */
    public ArrayList mGetTableColumnComment(String strTableName);    

}
