/*
 * 创建日期 2009-2-22
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package morningstar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

/**
 * @author Administrator
 * 
 * TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class MSDataPaser {

	/**
	 * 根据传入的资源，以及要提取的tag类型数组，返回NodeList数组
	 * 
	 * @param resource
	 * @param filterStr[]
	 * @return
	 */
	public NodeList[] getNodeList(String resource, String filterStr[]) {
		NodeList nodeList[] = new NodeList[10];
		try {
			Parser myParser = new Parser(resource);
			// 设置编码
			myParser.setEncoding("UTF-8");
			for (int i = 0; i < filterStr.length; i++) {
				NodeFilter filter = new TagNameFilter(filterStr[i]);
				nodeList[i] = myParser.extractAllNodesThatMatch(filter);
				System.out.println(filterStr[i]+"  "+nodeList[i].size()) ;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return nodeList;
	}

	public void getRiskData() {
		ArrayList alFunds = new ArrayList();
		alFunds.add("F0000003VJ");
		alFunds.add("F020001001");
		alFunds.add("F020000001");
		alFunds.add("F0000003WH");
		alFunds.add("F00000041L");
		alFunds.add("F000000442");
		alFunds.add("F000000445");
		alFunds.add("F020001001");
		alFunds.add("F0000003ZF");
		alFunds.add("F000000490");
		alFunds.add("F000000491");
		alFunds.add("F020002001");
		alFunds.add("F0000003XW");
		alFunds.add("F00000040D");
		alFunds.add("F0000004DM");
		alFunds.add("F0000003VN");
		alFunds.add("F020020001");
		alFunds.add("F020020002");
		alFunds.add("F020020003");
		alFunds.add("F0000003W9");
		alFunds.add("F0000003XV");
		alFunds.add("F00000040S");
		alFunds.add("F00000042J");
		alFunds.add("F00000044A");
		alFunds.add("F0000004AZ");
		alFunds.add("F0000003Z9");
		alFunds.add("F0000004EN");
		alFunds.add("F0000004EM");
		alFunds.add("F020040001");
		alFunds.add("F020040002");
		alFunds.add("F020040003");
		alFunds.add("F0000003WK");
		alFunds.add("F00000040J");
		alFunds.add("F000000418");
		alFunds.add("F00000042B");
		alFunds.add("F00000043X");
		alFunds.add("F00000049L");
		alFunds.add("F00000049M");
		alFunds.add("F0000004D2");
		alFunds.add("F020050001");
		alFunds.add("F020050002");
		alFunds.add("F0200001XX");
		alFunds.add("F0000003WA");
		alFunds.add("F0000003Y5");
		alFunds.add("F0000003ZM");
		alFunds.add("F00000042F");
		alFunds.add("F00000043S");
		alFunds.add("F0000004A2");
		alFunds.add("F000000447");
		alFunds.add("F00000040V");
		alFunds.add("F020070001");
		alFunds.add("F020070002");
		alFunds.add("F020070003");
		alFunds.add("F020070005");
		alFunds.add("F0000003VM");
		alFunds.add("F0000003XB");
		alFunds.add("F0000003ZC");
		alFunds.add("F000000408");
		alFunds.add("F00000041P");
		alFunds.add("F000000446");
		alFunds.add("F0000004A3");
		alFunds.add("F0000004CQ");
		alFunds.add("F0000004CR");
		alFunds.add("F0000004EO");
		alFunds.add("F00000044D");
		alFunds.add("F020080001");
		alFunds.add("F00000049W");
		alFunds.add("F0000004CX");
		alFunds.add("F0000003YR");
		alFunds.add("F020090001");
		alFunds.add("F020090002");
		alFunds.add("F0000003W5");
		alFunds.add("F0000003WR");
		alFunds.add("F0000003XR");
		alFunds.add("F00000040K");
		alFunds.add("F0000004DJ");
		alFunds.add("F0000004CI");
		alFunds.add("F0000003XS");
		alFunds.add("F0000003ZN");
		alFunds.add("F020100016");
		alFunds.add("F020100018");
		alFunds.add("F0000003W7");
		alFunds.add("F0000003XE");
		alFunds.add("F0000003ZR");
		alFunds.add("F00000041A");
		alFunds.add("F00000041W");
		alFunds.add("F00000049S");
		alFunds.add("F0000004DW");
		alFunds.add("F020110001");
		alFunds.add("F020110002");
		alFunds.add("F0000003VJ");
		alFunds.add("F0000003WM");
		alFunds.add("F0000003X7");
		alFunds.add("F0000003Y9");
		alFunds.add("F0000003YA");
		alFunds.add("F000000402");
		alFunds.add("F000000429");
		alFunds.add("F0000004AI");
		alFunds.add("F0000004DI");
		alFunds.add("F0000004DS");
		alFunds.add("F0000004EK");
		alFunds.add("F00000040E");
		alFunds.add("F000000497");
		alFunds.add("F000000498");
		alFunds.add("F00000044F");
		alFunds.add("F00000040O");
		alFunds.add("F020121001");
		alFunds.add("F0000003VV");
		alFunds.add("F0000003Z8");
		alFunds.add("F000000413");
		alFunds.add("F0000004A8");
		alFunds.add("F00000043P");
		alFunds.add("F00000047P");
		alFunds.add("F00000044H");
		alFunds.add("F0000004E6");
		alFunds.add("F0000004E7");
		alFunds.add("F00000043Q");
		alFunds.add("F00000043U");
		alFunds.add("F000000493");
		alFunds.add("F0000003WS");
		alFunds.add("F00000041X");
		alFunds.add("F0000003VL");
		alFunds.add("F020151001");
		alFunds.add("F020151002");
		alFunds.add("F0000003YW");
		alFunds.add("F0000003ZW");
		alFunds.add("F0000003WP");
		alFunds.add("F0000003Y0");
		alFunds.add("F00000042I");
		alFunds.add("F00000044C");
		alFunds.add("F0000003WX");
		alFunds.add("F020206101");
		alFunds.add("F020206102");
		alFunds.add("F0000003VY");
		alFunds.add("F0000003XH");
		alFunds.add("F000000404");
		alFunds.add("F0000003ZT");
		alFunds.add("F00000040Y");
		alFunds.add("F00000041Q");
		alFunds.add("F00000042K");
		alFunds.add("F0000004A0");
		alFunds.add("F0000004CY");
		alFunds.add("F0000003XX");
		alFunds.add("F00000041S");
		alFunds.add("F00000043I");
		alFunds.add("F0000003YD");
		alFunds.add("F0000004DG");
		alFunds.add("F020161601");
		alFunds.add("F020161001");
		alFunds.add("F020161002");
		alFunds.add("F020161003");
		alFunds.add("F0000003VT");
		alFunds.add("F0000003XL");
		alFunds.add("F0000003YT");
		alFunds.add("F000000412");
		alFunds.add("F00000042M");
		alFunds.add("F0000003YH");
		alFunds.add("F0000003WO");
		alFunds.add("F0000003Y3");
		alFunds.add("F000000420");
		alFunds.add("F0000003W3");
		alFunds.add("F020162201");
		alFunds.add("F020162202");
		alFunds.add("F020162203");
		alFunds.add("F0000003WE");
		alFunds.add("F0000003XF");
		alFunds.add("F0000003YK");
		alFunds.add("F0000003ZB");
		alFunds.add("F00000041I");
		alFunds.add("F00000043T");
		alFunds.add("F0000004CU");
		alFunds.add("F0000004CV");
		alFunds.add("F0000003XA");
		alFunds.add("F0000003YY");
		alFunds.add("F0000003X2");
		alFunds.add("F0000003Y8");
		alFunds.add("F00000040H");
		alFunds.add("F0000003YF");
		alFunds.add("F0000003YN");
		alFunds.add("F0000003WZ");
		alFunds.add("F0000003XM");
		alFunds.add("F0000003Z2");
		alFunds.add("F00000040U");
		alFunds.add("F00000049C");
		alFunds.add("F0000004DH");
		alFunds.add("F0000004EQ");
		alFunds.add("F00000041U");
		alFunds.add("F0000004AM");
		alFunds.add("F020180001");
		alFunds.add("F0000003VC");
		alFunds.add("F0000003WI");
		alFunds.add("F0000003X4");
		alFunds.add("F0000003X5");
		alFunds.add("F0000003ZO");
		alFunds.add("F000000416");
		alFunds.add("F0000004CO");
		alFunds.add("F0000004DP");
		alFunds.add("F0000004A1");
		alFunds.add("F020184688");
		alFunds.add("F020184689");
		alFunds.add("F020184690");
		alFunds.add("F020184691");
		alFunds.add("F020184692");
		alFunds.add("F020184693");
		alFunds.add("F020184698");
		alFunds.add("F020184699");
		alFunds.add("F020184701");
		alFunds.add("F020184703");
		alFunds.add("F020184705");
		alFunds.add("F020184706");
		alFunds.add("F020184721");
		alFunds.add("F020184722");
		alFunds.add("F020184728");
		alFunds.add("F020520000");
		alFunds.add("F0000003VZ");
		alFunds.add("F0000003XP");
		alFunds.add("F0000003Z3");
		alFunds.add("F00000040F");
		alFunds.add("F00000043Y");
		alFunds.add("F0000004CM");
		alFunds.add("F0000004E1");
		alFunds.add("F020202001");
		alFunds.add("F00000040A");
		alFunds.add("F00000041J");
		alFunds.add("F00000042O");
		alFunds.add("F00000044B");
		alFunds.add("F000000492");
		alFunds.add("F0000004AA");
		alFunds.add("F020202101");
		alFunds.add("F0000003Z4");
		alFunds.add("F020202002");
		alFunds.add("F0000004DC");
		alFunds.add("F0000003VF");
		alFunds.add("F000000444");
		alFunds.add("F020206001");
		alFunds.add("F020210000");
		alFunds.add("F0000004DB");
		alFunds.add("F020213001");
		alFunds.add("F0000003X9");
		alFunds.add("F00000041T");
		alFunds.add("F0000004ED");
		alFunds.add("F00000049T");
		alFunds.add("F00000049Z");
		alFunds.add("F0000004DL");
		alFunds.add("F020217001");
		alFunds.add("F020217002");
		alFunds.add("F020217003");
		alFunds.add("F0200001XW");
		alFunds.add("F0000003W4");
		alFunds.add("F000000403");
		alFunds.add("F000000427");
		alFunds.add("F0000004AB");
		alFunds.add("F0000004D3");
		alFunds.add("F0000003ZH");
		alFunds.add("F0000003VK");
		alFunds.add("F020240001");
		alFunds.add("F020240002");
		alFunds.add("F020240003");
		alFunds.add("F0000003YG");
		alFunds.add("F0000003VX");
		alFunds.add("F0000003XC");
		alFunds.add("F0000003XD");
		alFunds.add("F0000003ZU");
		alFunds.add("F000000415");
		alFunds.add("F00000043F");
		alFunds.add("F0000004CZ");
		alFunds.add("F0000004E8");
		alFunds.add("F0000004E9");
		alFunds.add("F00000049N");
		alFunds.add("F0000003Y1");
		alFunds.add("F0000004EF");
		alFunds.add("F0000004EG");
		alFunds.add("F020255010");
		alFunds.add("F0000003VP");
		alFunds.add("F0000003YV");
		alFunds.add("F00000041R");
		alFunds.add("F0000004D1");
		alFunds.add("F020260101");
		alFunds.add("F0000003Y2");
		alFunds.add("F020260103");
		alFunds.add("F0000003WB");
		alFunds.add("F0000003ZX");
		alFunds.add("F000000410");
		alFunds.add("F00000043G");
		alFunds.add("F0000004CW");
		alFunds.add("F020270001");
		alFunds.add("F0000003WF");
		alFunds.add("F0000003XN");
		alFunds.add("F0000003YO");
		alFunds.add("F0000003ZP");
		alFunds.add("F00000043H");
		alFunds.add("F0000004CE");
		alFunds.add("F000000494");
		alFunds.add("F0000004E0");
		alFunds.add("F0000003VH");
		alFunds.add("F0000003YJ");
		alFunds.add("F0000003XJ");
		alFunds.add("F000000407");
		alFunds.add("F0000003VB");
		alFunds.add("F0000003WC");
		alFunds.add("F0000003ZY");
		alFunds.add("F00000041K");
		alFunds.add("F0000004AE");
		alFunds.add("F0000003VO");
		alFunds.add("F0000003WU");
		alFunds.add("F0000003YE");
		alFunds.add("F000000406");
		alFunds.add("F00000041H");
		alFunds.add("F0000004AK");
		alFunds.add("F0000004DN");
		alFunds.add("F0000004DO");
		alFunds.add("F0000003W0");
		alFunds.add("F0000003WV");
		alFunds.add("F0000003YS");
		alFunds.add("F00000040B");
		alFunds.add("F00000041D");
		alFunds.add("F00000049V");
		alFunds.add("F0000004EE");
		alFunds.add("F0000003VW");
		alFunds.add("F0000003ZK");
		alFunds.add("F00000040Q");
		alFunds.add("F00000049O");
		alFunds.add("F0000004ES");
		alFunds.add("F0000003WD");
		alFunds.add("F0000003X0");
		alFunds.add("F000000401");
		alFunds.add("F00000049J");
		alFunds.add("F0000004D4");
		alFunds.add("F0000003WJ");
		alFunds.add("F0000003XT");
		alFunds.add("F0000003Z6");
		alFunds.add("F00000040M");
		alFunds.add("F000000441");
		alFunds.add("F0000004D7");
		alFunds.add("F0000004D6");
		alFunds.add("F0000004EB");
		alFunds.add("F0000003XG");
		alFunds.add("F0000003XI");
		alFunds.add("F0000003ZJ");
		alFunds.add("F0000004A5");
		alFunds.add("F0000003WN");
		alFunds.add("F0000003YI");
		alFunds.add("F000000448");
		alFunds.add("F00000042A");
		alFunds.add("F00000040X");
		alFunds.add("F0000004E5");
		alFunds.add("F00000049F");
		alFunds.add("F0000003WL");
		alFunds.add("F0000003XU");
		alFunds.add("F000000422");
		alFunds.add("F0000004DF");
		alFunds.add("F0000003WW");
		alFunds.add("F0000003YP");
		alFunds.add("F00000040C");
		alFunds.add("F00000049U");
		alFunds.add("F0000004DR");
		alFunds.add("F0000003X8");
		alFunds.add("F000000400");
		alFunds.add("F000000424");
		alFunds.add("F00000049X");
		alFunds.add("F00000049Y");
		alFunds.add("F0000004DQ");
		alFunds.add("F0000003YB");
		alFunds.add("F00000049H");
		alFunds.add("F0000004D8");
		alFunds.add("F00000049I");
		alFunds.add("F0000003XQ");
		alFunds.add("F0000003ZS");
		alFunds.add("F000000425");
		alFunds.add("F0000004A9");
		alFunds.add("F0000004D5");
		alFunds.add("F0000004EC");
		alFunds.add("F0000004EL");
		alFunds.add("F0000003XK");
		alFunds.add("F00000042N");
		alFunds.add("F00000044G");
		alFunds.add("F0000004B3");
		alFunds.add("F0000003Y6");
		alFunds.add("F00000041O");
		alFunds.add("F00000043R");
		alFunds.add("F0000004CG");
		alFunds.add("F0000004EH");
		alFunds.add("F0000003Z0");
		alFunds.add("F000000405");
		alFunds.add("F00000042H");
		alFunds.add("F00000049E");
		alFunds.add("F00000042G");
		alFunds.add("F00000049D");
		alFunds.add("F00000044I");
		alFunds.add("F020500001");
		alFunds.add("F020500002");
		alFunds.add("F020500003");
		alFunds.add("F020500005");
		alFunds.add("F020500006");
		alFunds.add("F020500008");
		alFunds.add("F020500009");
		alFunds.add("F020500011");
		alFunds.add("F020500015");
		alFunds.add("F020500018");
		alFunds.add("F020500038");
		alFunds.add("F020500056");
		alFunds.add("F020500058");
		alFunds.add("F0000003X3");
		alFunds.add("F020510080");
		alFunds.add("F0000003W1");
		alFunds.add("F0000003Z5");
		alFunds.add("F00000041G");
		alFunds.add("F0000003Y4");
		alFunds.add("F0000003VG");
		alFunds.add("F0000003XZ");
		alFunds.add("F0000003ZL");
		alFunds.add("F0000003XY");
		alFunds.add("F020510001");
		alFunds.add("F000000417");
		alFunds.add("F000000428");
		alFunds.add("F00000041V");
		alFunds.add("F00000040I");
		alFunds.add("F00000044E");
		alFunds.add("F00000042D");
		alFunds.add("F0000004D0");
		alFunds.add("F00000040P");
		alFunds.add("F00000042L");
		alFunds.add("F000000449");
		alFunds.add("F0000004AL");
		alFunds.add("F000000421");
		alFunds.add("F0000004E2");
		alFunds.add("F00000047V");
		alFunds.add("F0000003Y7");
		alFunds.add("F0000004AN");
		alFunds.add("F00000041E");
		alFunds.add("F00000049G");
		alFunds.add("F0000004DV");
		alFunds.add("F020519180");
		alFunds.add("F00000041F");
		alFunds.add("F0000004A7");
		alFunds.add("F0000003Z1");
		alFunds.add("F0000003WY");
		alFunds.add("F00000040G");
		alFunds.add("F0000003ZQ");
		alFunds.add("F00000043V");
		alFunds.add("F0000003YZ");
		alFunds.add("F0000003Z7");
		alFunds.add("F0000003YU");
		alFunds.add("F00000043Z");
		alFunds.add("F0000004AD");
		alFunds.add("F00000041Y");
		alFunds.add("F0000004AJ");
		alFunds.add("F00000049P");
		alFunds.add("F000000499");
		alFunds.add("F00000049B");
		alFunds.add("F0000003YC");
		alFunds.add("F0000003ZV");
		alFunds.add("F000000419");
		alFunds.add("F00000043W");
		alFunds.add("F0000004CK");
		alFunds.add("F0000004DZ");
		alFunds.add("F0000004DY");
		alFunds.add("F0000004A4");
		alFunds.add("F00000040Z");
		alFunds.add("F0000003ZA");
		alFunds.add("F0000003X1");
		alFunds.add("F0000003VI");
		alFunds.add("F0000004ET");
		alFunds.add("F0000003YQ");
		alFunds.add("F0000003ZE");
		alFunds.add("F00000040N");
		alFunds.add("F00000041Z");
		alFunds.add("F0000004DK");
		alFunds.add("F0000004AC");
		alFunds.add("F0000003ZI");
		alFunds.add("F00000040R");
		alFunds.add("F000000426");
		alFunds.add("F0000004CF");
		alFunds.add("F0000004DU");
		alFunds.add("F0000003ZD");
		alFunds.add("F00000041C");
		alFunds.add("F00000049R");
		alFunds.add("F0000004CS");
		alFunds.add("F0000004CT");
		alFunds.add("F0000004EI");
		alFunds.add("F0000004EJ");
		alFunds.add("F000000409");
		alFunds.add("F00000041B");
		alFunds.add("F00000043O");
		alFunds.add("F00000049Q");
		alFunds.add("F00000042C");
		alFunds.add("F0000004DD");
		alFunds.add("F0000004EA");
		alFunds.add("F0000003X6");
		alFunds.add("F00000041N");
		alFunds.add("F00000049K");
		alFunds.add("F0000004D9");
		alFunds.add("F00000040T");
		alFunds.add("F000000443");
		alFunds.add("F000000423");
		alFunds.add("F0000004AG");
		alFunds.add("F000000440");
		alFunds.add("F0000004CL");
		alFunds.add("F0000004EP");
		alFunds.add("F00000042E");
		alFunds.add("F0000004DA");
		alFunds.add("F0000004E3");
		alFunds.add("F0000004E4");
		alFunds.add("F0000004CH");
		alFunds.add("F0000004DT");
		alFunds.add("F0000004ER");

		System.out.println("begin...........");
		for (int i = 0; i < alFunds.size(); i++) {
			String strFundMDCode = alFunds.get(i).toString();
			FundData fd = new FundData();
			fd.setFundDateDate("2009-10-31");
			fd.setFundMDCode(strFundMDCode);
			NodeList nodeList[] = null;

			//获取字段属性
			ArrayList alFieldsName = getFdFields();
			String resource = "http://cn.morningstar.com/fundtools/quicktake/risk.aspx?FundClassId="
					+ strFundMDCode + "&activetab=MorningstarRisk";
			//String resource =
			// "http://cn.morningstar.com/fundtools/quicktake/risk.aspx?FundClassId=F0000003VJ&activetab=MorningstarRisk";
			System.out.println(resource);
			nodeList = getNodeList(resource, new String[] { "span"});
			fd = setFundData(fd, alFieldsName, nodeList[0], "RiskInfo");
			//fd = setFundData(fd, alFieldsName, nodeList[1], "RiskImg");
			fd.Save();
		}

		System.out.println("end...........");
	}

	public FundData setFundData(FundData fd, ArrayList alFieldsName,
			NodeList nl, String strType) {
		for (int i = 0; i < nl.size(); i++) {
			String strTagId = nl.elementAt(i).getText();
			String strTagValue = nl.elementAt(i).toPlainTextString();
			if (strTagValue.equals("-")) { //如果为“-”设置为空
				strTagValue = "null";
			}

			if (strType.equals("RiskInfo")) {
				for (int j = 0; j < alFieldsName.size(); j++) {
					String strFieldName = alFieldsName.get(j).toString();
					if (strTagId.indexOf(strFieldName) > 0) {
						try {
							Method setMethod = FundData.class.getMethod("set"
									+ strFieldName,
									new Class[] { String.class });
							setMethod.invoke(fd, new Object[] { strTagValue });
							//System.out.println(strFieldName + " " +
							// strTagValue);
							break;
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			}
			
			if (strType.equals("RiskImg")) {
				System.out.println(strTagId+"     "+strTagValue);
			
			}
		}

		return fd;
	}

	/**
	 * 获取FundData的属性名称
	 * 
	 * @return
	 */
	public ArrayList getFdFields() {
		ArrayList alFieldsName = new ArrayList();
		Class fdClass = (new FundData()).getClass();
		Field fdFields[] = fdClass.getDeclaredFields();

		for (int i = 0; i < fdFields.length; i++) {
			//System.out.println(fdFields[i].getName()) ;
			alFieldsName.add(fdFields[i].getName());
		}
		return alFieldsName;
	}

	public HashMap getFundMDcode() {
		String resource = "c:\\a17.htm";
		HashMap hmFundMDcode = new HashMap();
		NodeList nodeList[] = getNodeList(resource, new String[] { "INPUT" });

		for (int i = 0; i < nodeList[0].size(); i++) {
			String strTagId = nodeList[0].elementAt(i).getText();

			if (strTagId.indexOf("', '(") > 0) {
				hmFundMDcode.put(strTagId.substring(117, 127), strTagId
						.substring(128, strTagId.indexOf(")')")));
				System.out.println(strTagId.substring(154, 164));

			}
		}

		return hmFundMDcode;

	}

	public static void main(String[] args) throws Exception {
		MSDataPaser mp = new MSDataPaser();
		//fi.getFund123Data_200706();
		//mp.getTableData("http://cn.morningstar.com/fundtools/quicktake/risk.aspx?FundClassId=F0000003VJ&activetab=MorningstarRisk",105);
		//mp.getTableData("http://cn.morningstar.com/fundtools/quicktake/risk.aspx?FundClassId=F0000003VJ&activetab=MorningstarRisk",113);

		mp.getRiskData();
		//mp.getFundMDcode();

	}

}