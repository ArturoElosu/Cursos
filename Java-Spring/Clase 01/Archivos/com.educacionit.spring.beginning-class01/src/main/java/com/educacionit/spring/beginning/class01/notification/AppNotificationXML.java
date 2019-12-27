
package com.educacionit.spring.beginning.class01.notification;


import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppNotificationXML {
	
	
	public AppNotificationXML () {
		
		super ();
	}

	
	@SuppressWarnings ("resource")
	public static void main (String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext2.xml");
        
		Alert alertEmail = (Alert) context.getBean ("alertEmail");
		alertEmail.sendNotification (Arrays.asList ("Homer Simpson", "Ned Flanders", "Apu Nahasapeemapetilon"));
		
		Alert alertPush = (Alert) context.getBean ("alertPush");
		alertPush.sendNotification (Arrays.asList ("Otto Mann", "Jimbo Jones", "Nelson Muntz"));
        
        context = null;
	}
}