package com.design.pattern.creational;

public class TestFactory {

	public static void main(String[] args) {

		AttestationFormat format = AttestationFactory.getAttestationInstance("mobile");
		format.attestData();

		AttestationFormat format2 = AttestationFactory.getAttestationInstance("desktop");
		format2.attestData();
	}

}

abstract class AttestationFormat {

	abstract void attestData();
}

class MobileAttestation extends AttestationFormat {

	@Override
	void attestData() {
		System.out.println("Mobile Attestation started");
	}

}

class DesktopAttestation extends AttestationFormat {

	@Override
	void attestData() {
		System.out.println("Desktop Attestation started");
	}
}

class AttestationFactory {

	public static AttestationFormat getAttestationInstance(String type) {

		if ("mobile".equals(type)) {
			return new MobileAttestation();
		} else {
			return new DesktopAttestation();
		}
	}

}
