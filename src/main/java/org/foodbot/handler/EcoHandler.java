


package org.foodbot.handler;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EcoHandler extends TextWebSocketHandler{

	private Logger logger = LoggerFactory.getLogger(EcoHandler.class);

	private List<WebSocketSession> connectedUsers;

	public EcoHandler() {
		logger.info("echohandler 생성");
		connectedUsers = new ArrayList<WebSocketSession>();
	}
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		connectedUsers.add(session);

		logger.info(session.getId());
		logger.info("연결 IP : " + session.getRemoteAddress().getHostName());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		for (WebSocketSession webSocketSession : connectedUsers) {

			if( !session.getId().equals(webSocketSession)) {
				webSocketSession.sendMessage(new TextMessage("echo : " + message.getPayload()));
			}
		}
  
		logger.info(session.getId() + "님의 메시지 : " + message.getPayload());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		connectedUsers.remove(session);
		logger.info(session.getId() + "님이 퇴장했습니다.");
	}
}