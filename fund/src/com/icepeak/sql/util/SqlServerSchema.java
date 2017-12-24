/*
 * ��������  2008-12-12
 * ���� ice_peak
 */
package com.icepeak.sql.util;


import java.util.ArrayList;

/**
 * @author ice_peak
 */
public class SqlServerSchema implements DatabaseSchema {

    DatabaseOperate databaseOperate = null;

    /**
     * ���캯������ʼ�����ݿ�
     * 
     * @param strURL
     * @param strDBriver
     * @param strUser
     * @param strPassword
     */
    public SqlServerSchema(String strURL, String strUser, String strPassword) {
        //����DatabaseOperate
        this.databaseOperate = new DatabaseOperate(strURL,
                "com.microsoft.jdbc.sqlserver.SQLServerDriver", strUser,
                strPassword);
    }

    /**
     * ��ȡ����������Ϣ
     * 
     * @param strTableName
     * @return ����
     */
    public ArrayList mGetTableDesc(String strTableName) {
        //��ȡoracle�����Ϣ���������������͡��������ͣ�ת���ã����Ƿ�ɿգ����ݳ��ȣ����ݾ��ȣ�����λ����Ĭ��ֵ
        String strSql = "select   column_name,data_type,data_type,is_nullable,character_octet_length,numeric_precision,numeric_precision_radix,column_default   from   information_schema.columns   where   table_name='"
                + strTableName + "' order by column_name ";
        ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

        //�Է��ؽ�����û�����
        for (int i = 0; i < alDatas.size(); i++) {
            ArrayList alDatasRow = (ArrayList) alDatas.get(i);
            //ת�����ͣ����ڲ�ͬ���ݿ�Ƚ�
            if ("varchar".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "�ַ���");
            } else if ("numeric".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "������");
            } else if ("datetime".equals(alDatasRow.get(2).toString())) {
                alDatasRow.set(2, "������");
                alDatasRow.set(5, "");  //datetime Ϊ23
            }

            //�Ƿ�Ϊ���ж�
            if ("YES".equals(alDatasRow.get(3).toString().trim())) {
                alDatasRow.set(3, "�ɿ�");
            } else if ("No".equals(alDatasRow.get(3).toString().trim())) {
                alDatasRow.set(3, "�ǿ�");
            }
            
            //������ת��
            if("numeric".equals(alDatasRow.get(1).toString()) & "18".equals(alDatasRow.get(5).toString().trim())) {
            	alDatasRow.set(5, "18");
            	alDatasRow.set(6, "");
            }
            
            //sql serverĬ��ֵȥ������
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
     * ��ȡ����������Ϣ
     * 
     * @param strTableName
     * @return ����
     */
    public int mGetTableRowCount(String strTableName) {
        //��ȡ��ļ�¼��
        String strSql = "select count(*) from  " + strTableName ;
        ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

        //��ȡ�������
        ArrayList alDataRow = (ArrayList) alDatas.get(0);
        int iTableCount = Integer.parseInt(alDataRow.get(0).toString());
        return iTableCount;
    }
    
    /**
     * ��ȡschema�ı�����
     * @return
     */
    public ArrayList mGetSchemaTableNames() {
        //��ȡ��ļ�¼��
        String strSql = "select name from sysobjects where xtype='U' and status>0 order by name" ;
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
     * ȡ�ñ����ע��
     * @return
     */
    public ArrayList mGetTableColumnComment(String strTableName) {
        String strSql = "select b.name,isnull(c.value,'NULL'),a.name from sysobjects  A inner join syscolumns b on  a.id=b.id left outer join sysproperties c on b.id=c.id and b.colid =c.smallid where a.xtype ='U' and a.name ='"+strTableName+"' order by a.id,b.colid" ;
		ArrayList alDatas = databaseOperate.mGetSelectData(strSql);

		return alDatas;    	
    }
    
    public void test() {
    	String strSql = " EXEC   sp_addextendedproperty 't_test.name' , '���Ա�name' ,'user' ,dbo , 'table',T_TEST,'column',name" ;
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