/*
 * 创建日期 2007-10-9
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package fund;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

/**
 * @author Administrator
 * 
 * TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class FundInit {

	/**
	 * 读取文件的方式来分析内容. filePath也可以是一个Url.
	 * 
	 * @param resource
	 *            文件/Url
	 */
	public TableTag getTableData(String resource,int iNumber)  {
		TableTag tabletag = null;
		try {
			Parser myParser = new Parser(resource);

			// 设置编码
			myParser.setEncoding("UTF-8");
			String filterStr = "table";
			NodeFilter filter = new TagNameFilter(filterStr);
			NodeList nodeList = myParser.extractAllNodesThatMatch(filter);
			tabletag = (TableTag) nodeList.elementAt(iNumber);
			

			/**
			TableRow tablerow = tabletag.getRow(0);
			TableColumn[] tablecolumn = tablerow.getColumns();

			System.out.println(tabletag.toHtml());
			System.out.println("******************************************");
			System.out.println(tablerow.getText());
			System.out.println("******************************************");
			System.out.println(tablerow.toPlainTextString());
			System.out.println("******************************************");
			System.out.println(tablerow.toString());
			System.out.println("******************************************");
			*/
		} catch (Exception e) {
			System.out.println(e);
		}
		return tabletag;

	}
	
	
	public void getFund123Data_200706() {
		TableTag tabletag = this.getTableData("http://www.fund123.cn/html/161604/CCMX.html",5);
		System.out.println("getRowCount"+ tabletag.getRowCount());
		
		for(int i=2; i< tabletag.getRowCount();i++) {
			TableRow tablerow =  tabletag.getRow(i);			
			System.out.println(tablerow.toPlainTextString());
			System.out.println("******************************************");	
		}
	}

	public void getFund123Data_200703() {
		TableTag tabletag = this.getTableData("http://www.fund123.cn/html/161601/CCMX.html",6);
		System.out.println("getRowCount"+ tabletag.getRowCount());
		
		for(int i=2; i< tabletag.getRowCount();i++) {
			TableRow tablerow =  tabletag.getRow(i);			
			System.out.println(tablerow.toPlainTextString());
			System.out.println("******************************************");	
		}
	}
	
	public static void main(String[] args) throws Exception {
		FundInit fi = new FundInit();
		//fi.getFund123Data_200706();
		fi.getFund123Data_200703();

		
	}
}

//http://cn.morningstar.com/fundtools/quicktake/overview.aspx?fundclassid=F0000003VJ
