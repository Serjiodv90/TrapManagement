package trapManagementServer.ftp;

import javax.validation.OverridesAttribute;

import org.apache.commons.net.SocketClient;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.impl.DefaultFtpHandler;
import org.apache.ftpserver.listener.nio.FtpServerProtocolCodecFactory;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.ietf.jgss.Oid;

public class FtpServerHandler extends IoHandlerAdapter {
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("\n\n\n\n" + session.getRemoteAddress().toString() + " SERGEI RULES \n\n\n\n");
		
		System.out.println("\n\nAttachment: " + session.getAttachment() + "\n\n");
	//	session.write("hiiiii");
		
//		SocketClient
		FTPClient ftpSocketClient = new FTPClient();
		ftpSocketClient.connect(FtpUploadDownloadUtilTest.FTP_HOST, FtpUploadDownloadUtilTest.FTP_PORT);
		System.out.println("\n\n\nFtp cliend response: " + ftpSocketClient.getReplyString());
		System.out.println("Session: " + session);
		session.write(FTPReply.SERVICE_READY);
		
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)throws Exception {
		String msgString = message.toString();
		System.out.println("kukuMessage from client: " + msgString);
		session.write("Hi Client");
	}
	
	@Override
	public void messageSent(IoSession session, Object message) {
		System.out.println("\n\nMessage from client: " + message.toString());
	}

}
