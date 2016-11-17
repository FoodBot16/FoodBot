package org.foodbot.nlp;import java.util.ArrayList;
import java.util.List;

public class MorpProcess {


	private ArrayList<String> morpList;
	private ArrayList<String> attrList;
	private List<CodeSeparateVO> codeVOList;

	// 부사 처리 후의 코드 벡터
	private ArrayList<String> codeList;
	private ArrayList<String> wordList;
	
	public MorpProcess() {
	}
	public MorpProcess(ArrayList<String> morpList, ArrayList<String> wordList) {
		this.morpList = morpList;	
		this.wordList = wordList;
		
		codeList = new ArrayList<String>();
		codeVOList = new ArrayList<CodeSeparateVO>();
		attrList = new ArrayList<String>();

		codeSeparate();
		codeDecision();
		
		
//		System.out.println("codeList");
//		for(int i=0 ; i<codeList.size() ; i++) {
//			System.out.print(codeList.get(i) + " ");
//			System.out.println(wordList.get(i)+" ");
//		}System.out.println();
	}
	
	// 16자리 코드를 최소 의미 단위로 나눔
	public void codeSeparate() {
		for(int i=0 ; i<morpList.size() ; i++) {
			codeVOList.add(new CodeSeparateVO(morpList.get(i)));
			attrList.add(codeVOList.get(i).getCATTR());
			codeList.add(morpList.get(i));
		}
	}
	// 코드의 속성값 파악 후, 처리 여부 결정
	private void codeDecision() {
		for(int i=0 ; i<attrList.size() ; i++) {
			if(codeVOList.get(i).getCATTR().equals(CodeRule.CRATTR_EMPHASIS)) {
				empahsisProcess(i);
			}
//			codeList.add(codeVO.getCODE());
		}
	}
	private void empahsisProcess(int n) {
		//바로 다음 배열에 '맛' 이 있는지 확인 
		boolean flag = false;
		for(int i=n+1 ; i<attrList.size() ; i++) {
			if(attrList.get(i).equals(CodeRule.CRATTR_TASTE)) {
				codeList.set(n,morpList.get(i));
				wordList.set(n, wordList.get(i));
				flag = true;
			}
		}
		// 맛이 없다면, 강조 코드를 음식 코드로 변환
		// 하나의 음식에 해당..
		if(flag == false) {
			for(int i=0 ; i<attrList.size() ; i++) {
				if(attrList.get(i).equals(CodeRule.CRATTR_FOOD)) {
					codeList.set(n,morpList.get(i));
					wordList.set(n, wordList.get(i));
				}
			}
		}
	}
	
	public ArrayList<String> getWordList() {
		return wordList;
	}
	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(ArrayList<String> codeList) {
		this.codeList = codeList;
	}
}
