package net.asaken1021.websocket_testserver;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class Server {

	private static Set<Session> sessions = new CopyOnWriteArraySet<>();

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("セッション確立: " + session.getId());
		sessions.add(session);
	}

	@OnMessage
	public String onMessage(String Message, Session session) {
		System.out.println("メッセージ受信: \"" + Message + "\"");
//		try {
//			session.getBasicRemote().sendText(Message);
//		} catch (Exception e) {
//			System.out.println("");
//		}
		return Message;
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("セッション切断: " + session.getId());
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable th) {
		System.out.println("セッションエラー: " + session.getId() + ", 理由: " + th.getLocalizedMessage());
	}

//	public void executeCommand(String command) {
//		System.out.println("command block");
//		String cmd = command.substring(5, command.indexOf(" "));
//		if (cmd == "broadcast") {
//			System.out.println("コマンド受信: \"/" + cmd + "\"");
//			messageBroadcast(command.substring(command.indexOf(" ") + 1));
//		}
//	}
//
//	public void messageBroadcast(String Message) {
//		try {
//			for (Session session : sessions) {
//				session.getAsyncRemote().sendText("Message");
//			}
//		} catch (Exception e) {	
//		}
//		System.out.println("ブロードキャスト: \"" + Message + "\"");
//	}
}