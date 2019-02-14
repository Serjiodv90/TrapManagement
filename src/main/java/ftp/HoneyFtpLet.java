package ftp;

import java.io.IOException;

import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletResult;

//http://javadox.com/org.apache.ftpserver/ftplet-api/1.0.5/org/apache/ftpserver/ftplet/package-summary.html

public class HoneyFtpLet extends DefaultFtplet{

	@Override
	 public FtpletResult onLogin(FtpSession session, FtpRequest request) throws FtpException, IOException {
		
			System.out.println("\n\nUser loging in: " + request.getCommand() + ", " + request.getArgument() + "\n\n");
		
	        return null;
	    }
	
	@Override
	public FtpletResult beforeCommand(FtpSession session, FtpRequest request) throws FtpException, IOException {
		
		System.out.println("\n\nUser's command: " + request.getCommand() + ", " + request.getArgument() + "\n\n");
		
		return null;
		
		
	}
	
	
}
