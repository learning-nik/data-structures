package com.design.pattern.creational;

import java.time.DayOfWeek;

public class RateFactory {

	private DayOfWeek dayOfWeek;

	public RateFactory(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public MetroRate getMetroRate() {

		if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
			return new WeekendRate();
		} else {
			return new WeekdayRate();
		}

	}

	private class WeekdayRate extends MetroRate {

		@Override
		public float getRate() {
			return 5.5f;
		}

	}

	private class WeekendRate extends MetroRate {

		@Override
		public float getRate() {
			return 7.5f;
		}

	}

}
