package com.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

// Can be used in Notify-Me in Amazon
public class ObserverDesign {

	public static void main(String[] args) {

		new ObserverDesign().design();
	}

	private void design() {

		Observer observer = new Observer();
		observer.addListener(new SMSListener());
		observer.addListener(new EMailListener());
		
		observer.onChange();

	}

	class Observer {

		List<Listener> listeners = new ArrayList<>();

		void addListener(Listener listener) {
			listeners.add(listener);
		}

		void onChange() {
			System.out.println("CHANGE in Observer");
			listeners.forEach(a -> a.listen());
		}

	}

	interface Listener {

		void listen();
	}

	class SMSListener implements Listener {

		@Override
		public void listen() {
			System.out.println("Sending SMS");

		}

	}

	class EMailListener implements Listener {

		@Override
		public void listen() {
			System.out.println("Sending EMAIL");

		}

	}
}