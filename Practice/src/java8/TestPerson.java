package java8;

public class TestPerson {
	public static void main(String[] args) {

		Person person = new Person() {
			@Override
			public void create() {
				System.out.println("Person is Created Using Annonomous Inner class");

			}

			@Override
			public void put() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Organization organization =(int x)->{
			if(x==1) {
			System.out.println("Organization is Created Using Lambda1");
			}
			else {
				System.out.println("Organization is Created Using Lambda 2");
			}
			return x;
		};
		
		
		person.create();
		System.out.println(organization.create(10));
	}

}
