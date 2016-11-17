package org.foodbot.nlp;

public class CodeSeparateVO {

	private String morp;
	// 형태소벡터 코드별 의미
	private  int CODElENGTH = 16;// 16자리
	private  String CODE="";
	private  String CNATION=""; // 1~2
	private  String CSPACE="";	// 
	private  String CMORP="";
	private  String CATTR = "";
	private  String CINGRED1="";
	private  String CINGRED2="";
	private  String CNUM="";
	
	public CodeSeparateVO(String morp) {
		this.morp =morp;
		separate();
	}
		
	private void separate() {
		CODE = morp;
		
		for(int i=0 ;i <CODElENGTH ; i++) {
			if(i==0) 								CNATION += CODE.charAt(i);
			if(i==2 || i==3)						CMORP += CODE.charAt(i);
			if(i==4 || i==5 || i==6 || i==7)		CATTR += CODE.charAt(i);
			if(i==8 || i==9)						CINGRED1 += CODE.charAt(i);
			if(i==10 || i==11)						CINGRED2 += CODE.charAt(i);
			if(i==12 || i==13 || i==14 || i==15)	CNUM += CODE.charAt(i);
		}
	}

	public String getMorp() {
		return morp;
	}

	public void setMorp(String morp) {
		this.morp = morp;
	}

	public int getCODElENGTH() {
		return CODElENGTH;
	}

	public void setCODElENGTH(int cODElENGTH) {
		CODElENGTH = cODElENGTH;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getCNATION() {
		return CNATION;
	}

	public void setCNATION(String cNATION) {
		CNATION = cNATION;
	}

	public String getCSPACE() {
		return CSPACE;
	}

	public void setCSPACE(String cSPACE) {
		CSPACE = cSPACE;
	}

	public String getCMORP() {
		return CMORP;
	}

	public void setCMORP(String cMORP) {
		CMORP = cMORP;
	}

	public String getCATTR() {
		return CATTR;
	}

	public void setCATTR(String cATTR) {
		CATTR = cATTR;
	}

	public String getCINGRED1() {
		return CINGRED1;
	}

	public void setCINGRED1(String cINGRED1) {
		CINGRED1 = cINGRED1;
	}

	public String getCINGRED2() {
		return CINGRED2;
	}

	public void setCINGRED2(String cINGRED2) {
		CINGRED2 = cINGRED2;
	}

	public String getCNUM() {
		return CNUM;
	}

	public void setCNUM(String cNUM) {
		CNUM = cNUM;
	}


}
