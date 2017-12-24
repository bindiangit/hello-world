/*
 * ��������  2008-12-12
 * ���� ice_peak
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
     * ���캯������ʼ�����ݿ�
     * @param strURL
     * @param strDBriver
     * @param strUser
     * @param strPassword
     */
    public OracleSchema(String strURL, String strUser,
            String strPassword) {
        //����DatabaseOperate
        this.databaseOperate = new DatabaseOperate(strURL,
                "oracle.jdbc.driver.OracleDriver", strUser, strPassword);
    }
    
    
    /**
     * ��ȡ����������Ϣ
     * @param strTableName
     * @return ����
     */
    public ArrayList mGetTableDesc(String strTableName)  {
        //��ȡoracle�����Ϣ���������������͡��������ͣ�ת���ã����Ƿ�ɿգ����ݳ��ȣ����ݾ��ȣ�����λ����Ĭ��ֵ
		String strSql = "select column_name,data_type,data_type,nullable,data_length,data_precision,data_scale,data_default from user_tab_columns where table_name = '"
			+ strTableName + "' order by column_name ";
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		
		//�Է��ؽ�����û�����
		for(int i=0; i<alDatas.size(); i++ ) {
		    ArrayList alDatasRow = (ArrayList) alDatas.get(i);
		    //ת�����ͣ����ڲ�ͬ���ݿ�Ƚ�
		    if("VARCHAR2".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"�ַ���");
		    } else if("NUMBER".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"������");
		    } else if ("DATE".equals(alDatasRow.get(2).toString())) {
		        alDatasRow.set(2,"������");
		    } 
		    
		    //�Ƿ�Ϊ���ж�
		    if("Y".equals(alDatasRow.get(3).toString())) {
		        alDatasRow.set(3,"�ɿ�");
		    } else if("N".equals(alDatasRow.get(3).toString().trim())) {
		        alDatasRow.set(3,"�ǿ�");
		    }		    
		}
		
		return  alDatas;  		
    }
    
    /**
     * ��ȡ����������Ϣ
     * @param strTableName
     * @return ����
     */
    public int mGetTableRowCount(String strTableName)  {
        //��ȡ��ļ�¼��
        String strSql = "select count(*) from  " + strTableName ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		
		//��ȡ�������
		ArrayList alDataRow =(ArrayList) alDatas.get(0);		
        int iTableCount =Integer.parseInt(alDataRow.get(0).toString()); 
        return iTableCount;    
    }
    
    
    /**
     * ��ȡschema�ı�����
     * @return
     */
    public ArrayList mGetSchemaTableNames() {
        //��ȡ��ļ�¼��
        String strSql = "select table_name from user_tables" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
		//����һά����ArrayList
		ArrayList alTableName = new ArrayList();		
		for(int i=0; i<alDatas.size(); i++) {
			ArrayList alDataRow = (ArrayList)alDatas.get(i);
			alTableName.add(i,alDataRow.get(0));			
		}
		return alTableName;
        
    }
    
    /**
     * �жϱ��Ƿ����
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
     * ȡ�ñ����ע��
     * @return
     */
    public ArrayList mGetTableColumnComment(String strTableName) {
        String strSql = "select column_name,nvl(comments,'NULL'),table_name from user_col_comments where table_name = '"+strTableName+"'" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);
//        //�Է��ؽ�����û�����
//        for (int i = 0; i < alDatas.size(); i++) {
//            ArrayList alDatasRow = (ArrayList) alDatas.get(i);
//            //ת�����ͣ����ڲ�ͬ���ݿ�Ƚ�
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