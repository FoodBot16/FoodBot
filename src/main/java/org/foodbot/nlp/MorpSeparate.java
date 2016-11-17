package org.foodbot.nlp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.foodbot.domain.FoodVO;
import org.foodbot.domain.IngredVO;
import org.foodbot.domain.MorpVO;
import org.foodbot.domain.TasteVO;
import org.foodbot.service.FoodService;

import kr.co.shineware.util.common.model.Pair;

public class MorpSeparate {

	private FoodVO foodVO;
	private IngredVO ingredVO;
	private MorpVO morpVO;
	private TasteVO tasteVO;
	
	// 형태소 벡터 코드 리스트
	private ArrayList<String> morpList;
	// 형태소 리스트
	private ArrayList<String> wordList;
	
	private MorpProcess mp;

	@Inject
	private FoodService service;
	
	@Inject
	private KomoranService komoranService;

	public MorpSeparate() {}
	public MorpSeparate(FoodService service, KomoranService komoranService) {


		this.service = service;
		this.komoranService = komoranService;
		
		System.out.println("komoranService " + komoranService);

		morpList = new ArrayList<String>();
		wordList = new ArrayList<String>();

	}
	public void setComoran(String msg) throws Exception {

		// 파일 로드 디렉토리 
		//C:\sts\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\FoodBot\WEB-INF\classes\nlp

		List<List<Pair<String,String>>> result = komoranService.getKomoran().analyze(msg);	
		System.out.println(msg);
		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				System.out.println(wordMorph.getFirst() + " " + wordMorph.getSecond());
				String word = wordMorph.getFirst();
				String morp = wordMorph.getSecond();
				char chosung = getFirstElement(word);
				if(morp.equalsIgnoreCase("nng")) {
					getWordNNG(word);
				} else {
					getWordNNG(word);
				}
			}	
			System.out.println();
		}
		//0000 0000 0000 0000
		// 나라1 공란1 형태소2 / 속성4 / 재료(1)2  재료(2)2 / 개수4
		/*
		 * 1. 음식/재료 속성확인 및 처리
		 * 2. 형태소 처리.
		 * 
		 * 0. 예외처리.
		 * 1. 형태소 중에 음식 / 재료 코드 부여
		 * 2. 부사처리
		 * 3. 
		 */

		// morpVector 확인
//		System.out.println("morpVector");
//		for(int i= 0 ; i<morpList.size(); i++) {
//			System.out.print(" "+morpList.get(i));
//		}

		mp = new MorpProcess(morpList,wordList);	
		
		
//		empasisCare();
	}	
	
	
	/*
	 * 음식 / 재료 / NNG / morp 순으로 검색
	 * 모두 사용자 사전에서 검색..
	 */
	private void getWordNNG(String word) throws Exception {
		List<FoodVO> foodVOList = service.readFname(word);
		
		if(foodVOList.size() != 0) {
			morpList.add(foodVOList.get(0).getFcode());
			wordList.add(word);
		}
		else {
			ingredVO  = service.readIngredOne(word);
			if(ingredVO!=null) {
				morpList.add(ingredVO.getIngred_code());
				wordList.add(word);
			} else {
				foodVO  = service.readNNGOne(word);
				if(foodVO!=null) {
					morpList.add(foodVO.getFcode());
					wordList.add(word);
				} else {
					morpVO = service.readMorpOne(word);
					if(morpVO !=null) {
						morpList.add(morpVO.getMorp_code());
						wordList.add(word);
					}
					else {
						tasteVO = service.readTasteOne(word);
						if(tasteVO !=null) {
							morpList.add(tasteVO.getTaste_code());
							wordList.add(word);
						}
					}
				}
			}
		}
		
	}
	private void getWord(String word) throws Exception {
		morpVO  = service.readMorpOne(word);
		if(morpVO != null)
			morpList.add(morpVO.getMorp_code());
	}

	/*
	private void morpVectorNNP(char chosung, String word) {
		switch(chosung) {

		case 'ㄱ':	getFile(fileListNNG[0],word);	break;
		case 'ㄲ':	getFile(fileListNNG[1],word);	break;
		case 'ㄴ':	getFile(fileListNNG[2],word);	break;
		case 'ㄷ':	getFile(fileListNNG[3],word);	break;
		case 'ㄸ':	getFile(fileListNNG[4],word);	break;
		case 'ㄹ':	getFile(fileListNNG[5],word);	break;
		case 'ㅁ':	getFile(fileListNNG[6],word);	break;
		case 'ㅂ':	getFile(fileListNNG[7],word);	break;
		case 'ㅃ':	getFile(fileListNNG[8],word);	break;
		case 'ㅅ':	getFile(fileListNNG[9],word);	break;
		case 'ㅆ':	getFile(fileListNNG[10],word);	break;
		case 'ㅇ':	getFile(fileListNNG[11],word);	break;
		case 'ㅈ':	getFile(fileListNNG[12],word);	break;
		case 'ㅉ':	getFile(fileListNNG[13],word);	break;
		case 'ㅊ':	getFile(fileListNNG[14],word);	break;
		case 'ㅋ':	getFile(fileListNNG[15],word);	break;
		case 'ㅌ':	getFile(fileListNNG[16],word);	break;
		case 'ㅍ':	getFile(fileListNNG[17],word);	break;
		case 'ㅎ':	getFile(fileListNNG[18],word);	break;
		default : 
			break;
		}
	}
	private void morpVector(char chosung ,String word) {
		switch(chosung) {

		case 'ㄱ':	getFile(fileList[1],word);	break;
		case 'ㄲ':	getFile(fileList[2],word);	break;
		case 'ㄴ':	getFile(fileList[3],word);	break;
		case 'ㄷ':	getFile(fileList[4],word);	break;
		case 'ㄸ':	getFile(fileList[5],word);	break;
		case 'ㄹ':	getFile(fileList[6],word);	break;
		case 'ㅁ':	getFile(fileList[7],word);	break;
		case 'ㅂ':	getFile(fileList[8],word);	break;
		case 'ㅃ':	getFile(fileList[9],word);	break;
		case 'ㅅ':	getFile(fileList[10],word);	break;
		case 'ㅆ':	getFile(fileList[11],word);	break;
		case 'ㅇ':	getFile(fileList[12],word);	break;
		case 'ㅈ':	getFile(fileList[13],word);	break;
		case 'ㅉ':	getFile(fileList[14],word);	break;
		case 'ㅊ':	getFile(fileList[15],word);	break;
		case 'ㅋ':	getFile(fileList[16],word);	break;
		case 'ㅌ':	getFile(fileList[17],word);	break;
		case 'ㅍ':	getFile(fileList[18],word);	break;
		case 'ㅎ':	getFile(fileList[19],word);	break;
		default : 
			break;
		}
	}
	 */



	/**  
	 * 초성  
	 */  
	private static final char[] firstSounds = {  
			'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ',  
			'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',  
			'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'  
	};
	/**  
	 * 문자열의 첫번째 요소를 추출 (한글일 경우 초성을 추출)  
	 *  
	 * @param str 첫번째 문자의 요소를 추출할 문자열  
	 * @return 첫번째 요소 (한글일 경우 첫번째 문자의 자음)  
	 */  
	public static char getFirstElement(String str) {  
		if( str == null )  
			return '\u0000';  

		int len = str.length();  
		if( len == 0 )  
			return '\u0000';  

		return getFirstElement(str.charAt(0));  
	}  

	/**  
	 * 한글 문자의 초성을 추출  
	 *  
	 * @param c 첫번째 문자의 요소를 추출할 문자열  
	 * @return 한글 문자의 초성  
	 */  
	public static char getFirstElement(char c) {  
		if( ! isHangul(c) )  
			return c;  
		return firstSounds[(c - 0xAC00) / (21 * 28)];  
	}  
	/**  
	 * 문자 하나가 한글인지 검사  
	 *  
	 * @param c 검사 하고자 하는 문자  
	 * @return 한글 여부에 따라 'true' or 'false'  
	 */  
	public static boolean isHangul(char c) {  
		if( c < 0xAC00 || c > 0xD7A3 )  
			return false;  
		return true;  
	}  
	/*
	public void getFile(File f, String word) {
		File file = new File(f.getPath());
		System.out.println(file.getPath());
		FileReader r = null;
		try {
			r = new FileReader(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "euc-kr")); 

			String line = null;
			String[] splitLine = null;
			while((line = br.readLine())!=null) {
				//				System.out.println(line);
				// 사전에 같은 형태소가 있으면 배열에 저장후 빠져나간다.
				splitLine = splitLine(line);
				if(word.equals(splitLine[0])) {	
					System.out.println("splitLine[1]" + splitLine[1]);
					morpList.add(splitLine[1]);
					break;
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */
	public String[] splitLine(String line) {
		String[] str= line.split(",");
		return str;
	}
	public MorpProcess getMp() {
		return mp;
	}
	public void setMp(MorpProcess mp) {
		this.mp = mp;
	}
	
}
