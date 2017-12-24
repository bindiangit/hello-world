/*
 * ��������  2008-12-12
 * ���� ice_peak
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
     * ��ȡ����������Ϣ
     * @param strTableName
     * @return ����
     */
    public abstract ArrayList mGetTableDesc(String strTableName); 
    
    /**
     * ��ȡ����������Ϣ
     * @param strTableName
     * @return ����
     */
    public abstract int mGetTableRowCount(String strTableName);
    
    
    /**
     * ��ȡschema�ı�����
     * @return
     */
    public abstract ArrayList mGetSchemaTableNames();   
    
    /**
     * �жϱ��Ƿ����
     * @
     */    
    public boolean mTableExist(String strTableName);
    
    /**
     * ȡ�ñ����ע��
     * @return
     */
    public ArrayList mGetTableColumnComment(String strTableName);    

}
