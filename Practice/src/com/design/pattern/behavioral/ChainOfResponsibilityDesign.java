package com.design.pattern.behavioral;

import static com.design.pattern.behavioral.ChainOfResponsibilityDesign.LogProcessor.*;

public class ChainOfResponsibilityDesign {

	public static void main(String[] args) {

		new ChainOfResponsibilityDesign().test();

	}

	private void test() {
		LogProcessor logger = new DebugLogProcessor(new InfoLogProcessor(new ErrorLogProcessor(null)));

		logger.log(DEBUG, "MY name is Nikhil");
		logger.log(INFO, "MY name is Nikhil");
		logger.log(ERROR, "MY name is Nikhil");

	}

	// Base Processor and its implementations.
	// Each processor contains reference of next responsibility processor , making it a chain.
	abstract class LogProcessor {

		public static final String INFO = "INFO";
		public static final String DEBUG = "DEBUG";
		public static final String ERROR = "ERROR";

		LogProcessor nextProcessor;

		public LogProcessor(LogProcessor nexLogProcessor) {
			this.nextProcessor = nexLogProcessor;
		}

		void log(String loggerType, String message) {
			if (nextProcessor != null) {
				nextProcessor.log(loggerType, message);
			}
		}

	}

	class InfoLogProcessor extends LogProcessor {

		public InfoLogProcessor(LogProcessor nexLogProcessor) {
			super(nexLogProcessor);
		}

		@Override
		void log(String loggerType, String message) {
			if (loggerType == INFO) {
				System.out.println("INFO Processor");
				System.out.println(message);
			} else {
				super.log(loggerType, message);
			}
		}

	}

	class ErrorLogProcessor extends LogProcessor {

		public ErrorLogProcessor(LogProcessor nexLogProcessor) {
			super(nexLogProcessor);
		}

		@Override
		void log(String loggerType, String message) {
			if (loggerType == ERROR) {
				System.out.println("ERROR Processor");
				System.out.println(message);
			} else {
				super.log(loggerType, message);
			}
		}

	}

	class DebugLogProcessor extends LogProcessor {

		public DebugLogProcessor(LogProcessor nexLogProcessor) {
			super(nexLogProcessor);
		}

		@Override
		void log(String loggerType, String message) {
			if (loggerType == DEBUG) {
				System.out.println("DEBUG Processor");
				System.out.println(message);
			} else {
				super.log(loggerType, message);
			}
		}

	}

}
