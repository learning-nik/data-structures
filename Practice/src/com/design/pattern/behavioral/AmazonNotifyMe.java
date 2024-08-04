package com.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonNotifyMe {

	ProductObserver observer = new ProductObserver();

	public static void main(String[] args) {

		new AmazonNotifyMe().startDesign();

	}

	void startDesign() {

		// add Listener i.e notifyMe API
		List<Listener> listOfListeners = notifyMe("nikhil.pandita@gmail.com", NOTIFICATION_TYPE.SMS);
		listOfListeners.forEach(listener -> observer.addListeners("product1", listener));

		// product is available
		// get all the listeners from the products
		observer.onChange("product2");

	}

	private static List<Listener> notifyMe(String string, NOTIFICATION_TYPE type) {

		List<Listener> list = new ArrayList<>();

		if (NOTIFICATION_TYPE.SMS.equals(type)) {
			// get userDetails from DB and get the mobileNumber
			list.add(new SMSListener("1234567890"));
		}

		if (NOTIFICATION_TYPE.SMS.equals(type)) {
			// get userDetails from DB and get the emailAddress
			list.add(new EmailListener("nikhil09ec060@gmail.com"));
		}

		if (NOTIFICATION_TYPE.ALL.equals(type)) {
			// get userDetails from DB and get the emailAddress
			list.add(new EmailListener("nikhil09ec060@gmail.com"));
			list.add(new SMSListener("1234567890"));

		}
		return list;
	}

}

enum NOTIFICATION_TYPE {

	SMS, EMAIL, ALL
}

class ProductObserver {

	Map<String, List<Listener>> productVsListeners = new HashMap<>();

	void addListeners(String productId, final Listener listener) {
		if (productVsListeners.containsKey(productId)) {
			List<Listener> list = productVsListeners.get(productId);
			list.add(listener);
			productVsListeners.put(productId, list);
		} else {
			List<Listener> list = new ArrayList<>();
			list.add(listener);
			productVsListeners.put(productId, list);
		}
	}

	void onChange(String productId) {

		List<Listener> listeners = productVsListeners.get(productId);
		if (listeners != null) {
			listeners.forEach(listener -> listener.listen(productId));
		}
	}

}

abstract class Listener {

	private String listenerAddress;

	public Listener(String listenerAddress) {
		this.listenerAddress = listenerAddress;
	}

	public String getListenerAddress() {
		return listenerAddress;
	}

	abstract public void listen(String productId);

}

class EmailListener extends Listener {

	public EmailListener(String listenerAddress) {
		super(listenerAddress);
	}

	@Override
	public void listen(String productId) {
		System.out.println("Sending Email for productId:" + productId);
	}
}

class SMSListener extends Listener {

	public SMSListener(String listenerAddress) {
		super(listenerAddress);
	}

	@Override
	public void listen(String productId) {
		System.out.println("Sending SMS for productId:" + productId);

	}

}