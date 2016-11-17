<%@page import="org.foodbot.domain.ChatVO"%>
<%@page import="java.util.List"%>
<%@page import="org.foodbot.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String cp = request.getContextPath();
%>
<%
  MemberVO memberVO = (MemberVO) session.getAttribute("login");
  List<ChatVO> chatList = (List<ChatVO>) session.getAttribute("chat");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=cp%>/resources/js/jquery.js"></script>
<script src="<%=cp%>/resources/js/sockjs.js"></script>

<script type="text/javascript">
  var wsocket;

  function connect() {
    //wsocket = new WebSocket("ws://localhost:9999/chat-ws");
    wsocket = new SockJS("<c:url value="/chat-ws"/>");
    wsocket.onopen = onOpen;
    wsocket.onmessage = onMessage;
    wsocket.onclose = onClose;
  }
  function disconnect() {
    wsocket.close();
  }
  function onOpen(evt) {
    //appendMessage("연결되었습니다");
  }
  function onMessage(evt) {
    var data = evt.data;
    console.log(data.substring(4));
    if (data.substring(0, 4) == "msg:") {
      appendMessage(data.substring(4));
    }
  }

  function onClose(evt) {
    //appendMessage("연결을 끊었습니다");
  }

  function send() {
    var nickname = $("#nickname").val();
    var msg = $("#message").val();
    wsocket.send("msg:" + nickname + ":" + msg);
    $("#message").val("");
  }

  function appendMessage(msg) {
    $('#chatMessageArea').append(msg + "<br>");
    var chatAreaHeight = $("#chatArea").height();
    var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
    $("#chatArea").scrollTop(maxScroll);
  }

  $(document).ready(function() {
    $('#message').keypress(function(event) {
      var keycode = (event.keyCode ? event.keyCode : event.which);
      if (keycode == '13') {
        send();
      }
      event.stopPropagation();
    });
    $('#sendBtn').click(function() {
      send();
    });
    $('#enterBtn').click(function() {
      connect();
    });
    $('#exitBtn').click(function() {
      disconnect();
    });

    connect();

  });
</script>
<style>
#chatArea {
  width: 500px;
  height: 300px;
  overflow-y: auto;
  border: 1px solid black;
}
</style>
</head>
<body>

  <%
    if (memberVO != null) {
  %>
  <%=memberVO.getUid()%>
  이름 :
  <input type="text" id="nickname" value=<%=memberVO.getUid()%>></input>

  <input type="button" id="enterBtn" value="입장" />
  <input type="button" id="exitBtn" value="나가기" />

  <h1>대화 영역</h1>
  <div id="chatArea">
    <div id="chatMessageArea">
      <%
        for (int i = 0; i < chatList.size(); i++) {
      %>
      <%=chatList.get(i).getUid()%> : 
      <%=chatList.get(i).getContent()%>
      <br>
      <%
        }
      %>
    </div>
  </div>

  <br>
  <input type="text" id="message">
  <input type="button" id="sendBtn" value="전송">
  <%
    }
  %>
</body>
</html>