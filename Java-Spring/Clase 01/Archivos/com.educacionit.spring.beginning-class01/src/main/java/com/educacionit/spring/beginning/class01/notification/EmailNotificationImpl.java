

package com.educacionit.spring.beginning.class01.notification;


import org.apache.log4j.Logger;


public class EmailNotificationImpl implements INotification {

	
	private static final Logger logger = Logger.getLogger (EmailNotificationImpl.class);
	
	
	public EmailNotificationImpl () {
		
		super ();
	}

	
	/* (non-Javadoc)
	 * @see com.byte21.educacionit.spring.beginning.class01.notification.INotification#send (java.lang.String)
	 */
	@Override
	public void send (String m) {

		logger.info ("Sending notification by email to ".concat (m));
	}
}