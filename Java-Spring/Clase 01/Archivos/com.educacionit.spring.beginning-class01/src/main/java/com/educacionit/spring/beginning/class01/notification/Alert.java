
package com.educacionit.spring.beginning.class01.notification;


import java.util.List;


public class Alert {

	
	private INotification notification = null;
	
	
	public Alert () {
		
		super ();
	}
	
	
	public void setNotification (INotification notification) {
		
		this.notification = notification;
	}
	
	
	public void sendNotification (List<String> list) {
		
		
		list.forEach ( m -> {
			
			notification.send (m);
		});
	}
}