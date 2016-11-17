package org.foodbot.nlp;

import java.io.File;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;

@Service
public class KomoranService {

	//코모란 형태소 분석기
	private Komoran komoran;
	private File file;
	private File fileNNG;
	private File[] fileList;
	private File[] fileListNNG;
	private File userfile1,userfile2,userfile3,userfile4;

		
	public Komoran getKomoran() {
		return komoran;
	}


	public void setKomoran(Komoran komoran) {
		this.komoran = komoran;
	}


	public KomoranService() {
		System.out.println("komoran create");
		
		file = new File(getClass().getClassLoader().getResource ("nlp").getPath());
		fileList = file.listFiles();
		// nng 파일 path
		fileNNG = new File(file,"nng");
		fileListNNG = fileNNG.listFiles();

		userfile1 = new File(file,"food_user.txt");
		userfile2 = new File(file,"ingredient_user.txt");
		userfile3 = new File(file,"taste.txt");
		userfile4 = new File(file,"morp.txt");
		

		komoran = new Komoran("C:\\sts\\comoran\\models");

		komoran.setUserDic(userfile1.getAbsolutePath());
		komoran.addUserDic(userfile2.getAbsolutePath());
		komoran.addUserDic(userfile3.getAbsolutePath());
		komoran.addUserDic(userfile4.getAbsolutePath());
		
	}
}
