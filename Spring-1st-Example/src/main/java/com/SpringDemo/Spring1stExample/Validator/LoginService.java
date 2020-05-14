package com.SpringDemo.Spring1stExample.Validator;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoginService {
	public boolean validateMail(String mail)
	{
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	     return mail.matches(EMAIL_REGEX);	
	}
	public boolean validatePassword(String pass1,String pass2){
		return pass1.equals(pass2);
		
	}
	
}
