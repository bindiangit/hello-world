/*
 * �������� 2009-2-22
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package morningstar;

import com.icepeak.sql.util.DatabaseOperate;

/**
 * @author Administrator
 * 
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class FundData {
	String FundMDCode=""; //���Ǵ���

	String Label2=""; //����

	String FundNameLabel=""; //����

	String FundDateDate=""; //ͳ������

	String MeanText2Year="";

	String MeanRank2Year="";

	String MeanText3Year="";

	String MeanRank3Year="";

	String MeanText5Year="";

	String MeanRank5Year="";

	String StandardDeviationText2Year="";

	String StandardDeviationRank2Year="";

	String StandardDeviationText3Year="";

	String StandardDeviationRank3Year="";

	String StandardDeviationText5Year="";

	String StandardDeviationRank5Year="";

	String DR2Year="";

	String DRRank2Year="";

	String DR3Year="";

	String DRRank3Year="";

	String DR5Year="";

	String DRRank5Year="";

	String SharpeRatioText2Year="";

	String SharpeRatioRank2Year="";

	String SharpeRatioText3Year="";

	String SharpeRatioRank3Year="";

	String SharpeRatioText5Year="";

	String SharpeRatioRank5Year="";

	String AlphaText1="";

	String AlphaText2="";

	String BetaText1="";

	String BetaText2="";

	String RSquaredText1="";

	String RSquaredText2="";

	/**
	 * @return ���� alphaText1��
	 */
	public String getAlphaText1() {
		return AlphaText1;
	}

	/**
	 * @param alphaText1
	 *            Ҫ���õ� alphaText1��
	 */
	public void setAlphaText1(String alphaText1) {
		AlphaText1 = alphaText1;
	}

	/**
	 * @return ���� alphaText2��
	 */
	public String getAlphaText2() {
		return AlphaText2;
	}

	/**
	 * @param alphaText2
	 *            Ҫ���õ� alphaText2��
	 */
	public void setAlphaText2(String alphaText2) {
		AlphaText2 = alphaText2;
	}

	/**
	 * @return ���� betaText1��
	 */
	public String getBetaText1() {
		return BetaText1;
	}

	/**
	 * @param betaText1
	 *            Ҫ���õ� betaText1��
	 */
	public void setBetaText1(String betaText1) {
		BetaText1 = betaText1;
	}

	/**
	 * @return ���� betaText2��
	 */
	public String getBetaText2() {
		return BetaText2;
	}

	/**
	 * @param betaText2
	 *            Ҫ���õ� betaText2��
	 */
	public void setBetaText2(String betaText2) {
		BetaText2 = betaText2;
	}

	/**
	 * @return ���� dR2Year��
	 */
	public String getDR2Year() {
		return DR2Year;
	}

	/**
	 * @param year
	 *            Ҫ���õ� dR2Year��
	 */
	public void setDR2Year(String year) {
		DR2Year = year;
	}

	/**
	 * @return ���� dR3Year��
	 */
	public String getDR3Year() {
		return DR3Year;
	}

	/**
	 * @param year
	 *            Ҫ���õ� dR3Year��
	 */
	public void setDR3Year(String year) {
		DR3Year = year;
	}

	/**
	 * @return ���� dR5Year��
	 */
	public String getDR5Year() {
		return DR5Year;
	}

	/**
	 * @param year
	 *            Ҫ���õ� dR5Year��
	 */
	public void setDR5Year(String year) {
		DR5Year = year;
	}

	/**
	 * @return ���� dRRank2Year��
	 */
	public String getDRRank2Year() {
		return DRRank2Year;
	}

	/**
	 * @param rank2Year
	 *            Ҫ���õ� dRRank2Year��
	 */
	public void setDRRank2Year(String rank2Year) {
		
		if (rank2Year.equals("null")) {
			DRRank2Year ="";
		} else {			
			System.out.println("###"+rank2Year+"###") ;
			DRRank2Year = rank2Year;
		}
	}

	/**
	 * @return ���� dRRank3Year��
	 */
	public String getDRRank3Year() {
		return DRRank3Year;
	}

	/**
	 * @param rank3Year
	 *            Ҫ���õ� dRRank3Year��
	 */
	public void setDRRank3Year(String rank3Year) {
		if (rank3Year.equals("null")) {
			DRRank3Year ="";
		} else {			
			DRRank3Year = rank3Year;
		}
	}

	/**
	 * @return ���� dRRank5Year��
	 */
	public String getDRRank5Year() {
		return DRRank5Year;
	}

	/**
	 * @param rank5Year
	 *            Ҫ���õ� dRRank5Year��
	 */
	public void setDRRank5Year(String rank5Year) {
		if (rank5Year.equals("null")) {
			DRRank5Year ="";
		} else {				
			DRRank5Year = rank5Year;
		}
	}

	/**
	 * @return ���� rSquaredText1��
	 */
	public String getRSquaredText1() {
		return RSquaredText1;
	}

	/**
	 * @param squaredText1
	 *            Ҫ���õ� rSquaredText1��
	 */
	public void setRSquaredText1(String squaredText1) {
		RSquaredText1 = squaredText1;
	}

	/**
	 * @return ���� rSquaredText2��
	 */
	public String getRSquaredText2() {
		return RSquaredText2;
	}

	/**
	 * @param squaredText2
	 *            Ҫ���õ� rSquaredText2��
	 */
	public void setRSquaredText2(String squaredText2) {
		RSquaredText2 = squaredText2;
	}

	/**
	 * @return ���� sharpeRatioRank2Year��
	 */
	public String getSharpeRatioRank2Year() {
		return SharpeRatioRank2Year;
	}

	/**
	 * @param sharpeRatioRank2Year
	 *            Ҫ���õ� sharpeRatioRank2Year��
	 */
	public void setSharpeRatioRank2Year(String sharpeRatioRank2Year) {
		if (sharpeRatioRank2Year.equals("null")) {
			SharpeRatioRank2Year ="";
		} else {				
			SharpeRatioRank2Year = sharpeRatioRank2Year;
		}
	}

	/**
	 * @return ���� sharpeRatioRank3Year��
	 */
	public String getSharpeRatioRank3Year() {
		return SharpeRatioRank3Year;
	}

	/**
	 * @param sharpeRatioRank3Year
	 *            Ҫ���õ� sharpeRatioRank3Year��
	 */
	public void setSharpeRatioRank3Year(String sharpeRatioRank3Year) {
		if (sharpeRatioRank3Year.equals("null")) {
			SharpeRatioRank3Year ="";
		} else {				
			SharpeRatioRank3Year = sharpeRatioRank3Year;
		}
	}

	/**
	 * @return ���� sharpeRatioRank5Year��
	 */
	public String getSharpeRatioRank5Year() {
		return SharpeRatioRank5Year;
	}

	/**
	 * @param sharpeRatioRank5Year
	 *            Ҫ���õ� sharpeRatioRank5Year��
	 */
	public void setSharpeRatioRank5Year(String sharpeRatioRank5Year) {
		if (sharpeRatioRank5Year.equals("null")) {
			SharpeRatioRank5Year ="";
		} else {			
			SharpeRatioRank5Year = sharpeRatioRank5Year;
		}
	}

	/**
	 * @return ���� sharpeRatioText2Year��
	 */
	public String getSharpeRatioText2Year() {
		return SharpeRatioText2Year;
	}

	/**
	 * @param sharpeRatioText2Year
	 *            Ҫ���õ� sharpeRatioText2Year��
	 */
	public void setSharpeRatioText2Year(String sharpeRatioText2Year) {
		SharpeRatioText2Year = sharpeRatioText2Year;
	}

	/**
	 * @return ���� sharpeRatioText3Year��
	 */
	public String getSharpeRatioText3Year() {
		return SharpeRatioText3Year;
	}

	/**
	 * @param sharpeRatioText3Year
	 *            Ҫ���õ� sharpeRatioText3Year��
	 */
	public void setSharpeRatioText3Year(String sharpeRatioText3Year) {
		SharpeRatioText3Year = sharpeRatioText3Year;
	}

	/**
	 * @return ���� sharpeRatioText5Year��
	 */
	public String getSharpeRatioText5Year() {
		return SharpeRatioText5Year;
	}

	/**
	 * @param sharpeRatioText5Year
	 *            Ҫ���õ� sharpeRatioText5Year��
	 */
	public void setSharpeRatioText5Year(String sharpeRatioText5Year) {
		SharpeRatioText5Year = sharpeRatioText5Year;
	}

	/**
	 * @return ���� standardDeviationRank3Year��
	 */
	public String getStandardDeviationRank3Year() {
		return StandardDeviationRank3Year;
	}

	/**
	 * @param standardDeviationRank3Year
	 *            Ҫ���õ� standardDeviationRank3Year��
	 */
	public void setStandardDeviationRank3Year(String standardDeviationRank3Year) {
		if (standardDeviationRank3Year.equals("null")) {
			StandardDeviationRank3Year ="";
		} else {
			StandardDeviationRank3Year = standardDeviationRank3Year;
		}
	}

	/**
	 * @return ���� standardDeviationRank5Year��
	 */
	public String getStandardDeviationRank5Year() {
		return StandardDeviationRank5Year;
	}

	/**
	 * @param standardDeviationRank5Year
	 *            Ҫ���õ� standardDeviationRank5Year��
	 */
	public void setStandardDeviationRank5Year(String standardDeviationRank5Year) {
		if (standardDeviationRank5Year.equals("null")) {
			StandardDeviationRank5Year ="";
		} else {				
			StandardDeviationRank5Year = standardDeviationRank5Year;
		}
	}

	/**
	 * @return ���� standardDeviationText3Year��
	 */
	public String getStandardDeviationText3Year() {
		return StandardDeviationText3Year;
	}

	/**
	 * @param standardDeviationText3Year
	 *            Ҫ���õ� standardDeviationText3Year��
	 */
	public void setStandardDeviationText3Year(String standardDeviationText3Year) {
		StandardDeviationText3Year = standardDeviationText3Year;
	}

	/**
	 * @return ���� standardDeviationText5Year��
	 */
	public String getStandardDeviationText5Year() {
		return StandardDeviationText5Year;
	}

	/**
	 * @param standardDeviationText5Year
	 *            Ҫ���õ� standardDeviationText5Year��
	 */
	public void setStandardDeviationText5Year(String standardDeviationText5Year) {
		StandardDeviationText5Year = standardDeviationText5Year;
	}

	/**
	 * @return ���� meanRank2Year��
	 */
	public String getMeanRank2Year() {
		return MeanRank2Year;
	}

	/**
	 * @param meanRank2Year
	 *            Ҫ���õ� meanRank2Year��
	 */
	public void setMeanRank2Year(java.lang.String meanRank2Year) {
		if(meanRank2Year.equals("null")) {
			MeanRank2Year ="";
		} else {
			MeanRank2Year = meanRank2Year;
		}
	}

	/**
	 * @return ���� meanRank3Year��
	 */
	public String getMeanRank3Year() {
		return MeanRank3Year;
	}

	/**
	 * @param meanRank3Year
	 *            Ҫ���õ� meanRank3Year��
	 */
	public void setMeanRank3Year(String meanRank3Year) {
		if(meanRank3Year.equals("null")) {	
			MeanRank3Year ="";
		} else {				
			MeanRank3Year = meanRank3Year;
		}
	}

	/**
	 * @return ���� meanRank5Year��
	 */
	public String getMeanRank5Year() {
		return MeanRank5Year;
	}

	/**
	 * @param meanRank5Year
	 *            Ҫ���õ� meanRank5Year��
	 */
	public void setMeanRank5Year(String meanRank5Year) {
		if(meanRank5Year.equals("null")) {		
			MeanRank5Year ="";
		} else {			
		MeanRank5Year = meanRank5Year;
		}
	}

	/**
	 * @return ���� meanText2Year��
	 */
	public String getMeanText2Year() {
		return MeanText2Year;
	}

	/**
	 * @param meanText2Year
	 *            Ҫ���õ� meanText2Year��
	 */
	public void setMeanText2Year(String meanText2Year) {
		MeanText2Year = meanText2Year;
	}

	/**
	 * @return ���� meanText3Year��
	 */
	public String getMeanText3Year() {
		return MeanText3Year;
	}

	/**
	 * @param meanText3Year
	 *            Ҫ���õ� meanText3Year��
	 */
	public void setMeanText3Year(String meanText3Year) {
		MeanText3Year = meanText3Year;
	}

	/**
	 * @return ���� meanText5Year��
	 */
	public String getMeanText5Year() {
		return MeanText5Year;
	}

	/**
	 * @param meanText5Year
	 *            Ҫ���õ� meanText5Year��
	 */
	public void setMeanText5Year(String meanText5Year) {
		MeanText5Year = meanText5Year;
	}

	/**
	 * @return ���� standardDeviationRank2Year��
	 */
	public String getStandardDeviationRank2Year() {			
		return StandardDeviationRank2Year;
		
	}

	/**
	 * @param standardDeviationRank2Year
	 *            Ҫ���õ� standardDeviationRank2Year��
	 */
	public void setStandardDeviationRank2Year(String standardDeviationRank2Year) {
		if (standardDeviationRank2Year.equals("null")) {
			StandardDeviationRank2Year ="";
		} else {				
			StandardDeviationRank2Year = standardDeviationRank2Year;
		}
	}

	/**
	 * @return ���� standardDeviationText2Year��
	 */
	public String getStandardDeviationText2Year() {
		return StandardDeviationText2Year;
	}

	/**
	 * @param standardDeviationText2Year
	 *            Ҫ���õ� standardDeviationText2Year��
	 */
	public void setStandardDeviationText2Year(String standardDeviationText2Year) {
		StandardDeviationText2Year = standardDeviationText2Year;
	}

	/**
	 * @return ���� fundDateDate��
	 */
	public String getFundDateDate() {
		return FundDateDate;
	}

	/**
	 * @param fundDateDate
	 *            Ҫ���õ� fundDateDate��
	 */
	public void setFundDateDate(String fundDateDate) {
		FundDateDate = fundDateDate;
	}

	/**
	 * @return ���� fundMDCode��
	 */
	public String getFundMDCode() {
		return FundMDCode;
	}

	/**
	 * @param fundMDCode
	 *            Ҫ���õ� fundMDCode��
	 */
	public void setFundMDCode(String fundMDCode) {
		FundMDCode = fundMDCode;
	}

	/**
	 * @return ���� fundNameLabel��
	 */
	public String getFundNameLabel() {
		return FundNameLabel;
	}

	/**
	 * @param fundNameLabel
	 *            Ҫ���õ� fundNameLabel��
	 */
	public void setFundNameLabel(String fundNameLabel) {
		FundNameLabel = fundNameLabel;
	}

	/**
	 * @return ���� label2��
	 */
	public String getLabel2() {
		return Label2;
	}

	/**
	 * @param label2
	 *            Ҫ���õ� label2��
	 */
	public void setLabel2(String label2) {
		Label2 = label2;
	}

	/**
	 * 
	 *  
	 */
	public void Save() {
		DatabaseOperate os = new DatabaseOperate(
				"jdbc:oracle:thin:@127.0.0.1:1521:orcl",
				"oracle.jdbc.driver.OracleDriver", "lb", "lb");
		String strSql = "insert into T_FUND_DATA (FundMDCode,fundcode,fundName,FundDateDate,MeanText2Year,MeanRank2Year,MeanText3Year,MeanRank3Year,MeanText5Year,MeanRank5Year,StandardDeviationText2Year,StandardDeviationRank2Year,StandardDeviationText3Year,StandardDeviationRank3Year,StandardDeviationText5Year,StandardDeviationRank5Year,DR2Year,DRRank2Year,DR3Year,DRRank3Year,DR5Year,DRRank5Year,SharpeRatioText2Year,SharpeRatioRank2Year,SharpeRatioText3Year,SharpeRatioRank3Year,SharpeRatioText5Year,SharpeRatioRank5Year,AlphaText1,AlphaText2,BetaText1,BetaText2,RSquaredText1,RSquaredText2) VALUES ("
				+ "'"
				+ FundMDCode
				+ "','"
				+ Label2
				+ "','"
				+ FundNameLabel
				+ "','"
				+ FundDateDate
				+ "',"
				+ MeanText2Year
				+ ",'"
				+ MeanRank2Year
				+ "',"
				+ MeanText3Year
				+ ",'"
				+ MeanRank3Year
				+ "',"
				+ MeanText5Year
				+ ",'"
				+ MeanRank5Year
				+ "',"
				+ StandardDeviationText2Year
				+ ",'"
				+ StandardDeviationRank2Year
				+ "',"
				+ StandardDeviationText3Year
				+ ",'"
				+ StandardDeviationRank3Year
				+ "',"
				+ StandardDeviationText5Year
				+ ",'"
				+ StandardDeviationRank5Year
				+ "',"
				+ DR2Year
				+ ",'"
				+ DRRank2Year
				+ "',"
				+ DR3Year
				+ ",'"
				+ DRRank3Year
				+ "',"
				+ DR5Year
				+ ",'"
				+ DRRank5Year
				+ "',"
				+ SharpeRatioText2Year
				+ ",'"
				+ SharpeRatioRank2Year
				+ "',"
				+ SharpeRatioText3Year
				+ ",'"
				+ SharpeRatioRank3Year
				+ "',"
				+ SharpeRatioText5Year
				+ ",'"
				+ SharpeRatioRank5Year
				+ "',"
				+ AlphaText1
				+ ","
				+ AlphaText2
				+ ","
				+ BetaText1
				+ ","
				+ BetaText2
				+ ","
				+ RSquaredText1 + "," + RSquaredText2 + ")";
		System.out.println(strSql);
		os.executeDML(strSql);
	}

}