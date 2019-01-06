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
		System.out.println("�Z�b�V�����m��: " + session.getId());
		sessions.add(session);
	}

	@OnMessage
	public String onMessage(String Message, Session session) {
		System.out.println("���b�Z�[�W��M: \"" + Message + "\"");
//		try {
//			session.getBasicRemote().sendText(Message);
//		} catch (Exception e) {
//			System.out.println("");
//		}
		return Message;
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("�Z�b�V�����ؒf: " + session.getId());
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable th) {
		System.out.println("�Z�b�V�����G���[: " + session.getId() + ", ���R: " + th.getLocalizedMessage());
	}

//	public void executeCommand(String command) {
//		System.out.println("command block");
//		String cmd = command.substring(5, command.indexOf(" "));
//		if (cmd == "broadcast") {
//			System.out.println("�R�}���h��M: \"/" + cmd + "\"");
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
//		System.out.println("�u���[�h�L���X�g: \"" + Message + "\"");
//	}
}