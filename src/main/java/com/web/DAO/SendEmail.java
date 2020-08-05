package com.web.DAO;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface SendEmail {

	public String sendEmail(String email, int code) throws AddressException, MessagingException, IOException;
}
