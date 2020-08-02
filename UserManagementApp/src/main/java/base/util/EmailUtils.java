package base.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import base.entity.UserAccounts;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;

	public Boolean sendUserUnlockEmail(UserAccounts userAcc) {
		boolean isSent=false;
		try {
			//Using Mime we can send extra Functioned Emails which is better than using SimpleMail
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

			mimeMessageHelper.setTo(userAcc.getEmail());
			mimeMessageHelper.setSubject("Unlock Your Account");
			mimeMessageHelper.setText(getUnlockAccEmailBody(userAcc),true);

			mailSender.send(mimeMessage);
			isSent=true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

	private String getUnlockAccEmailBody(UserAccounts userAcc) throws IOException {
		StringBuffer sb=new StringBuffer();

		FileReader fr=new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br=new BufferedReader(fr);

		String line=br.readLine();
		while(line!=null) {
			sb.append(line);
			line=br.readLine();
		}
		br.close();
		//FORMAT MAIL BODY
		String mailBody=sb.toString();
		mailBody = mailBody.replace("{FNAME}", userAcc.getFirstName());
		mailBody = mailBody.replace("{LNAME}", userAcc.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", userAcc.getPassword());
		mailBody = mailBody.replace("{EMAIL}", userAcc.getEmail());

		return mailBody;
	}
}
