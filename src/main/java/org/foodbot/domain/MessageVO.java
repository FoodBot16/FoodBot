package org.foodbot.domain;

import com.google.gson.Gson;

// 연습 클래스
public class MessageVO {

	public static MessageVO converMessage(String source) {
	    MessageVO message = new MessageVO();
	    Gson gson = new Gson();
	    message = gson.fromJson(source, MessageVO.class);
	 
	    return message;
	}
}
