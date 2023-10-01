package com.design.pattern.structural;
// Can be used in Making Pizza
// Coffee machine  ,making base coffee and then adding extra things like milk , etc
public class DecoratorDesign {

	public static void main(String[] args) {

		new DecoratorDesign().testDesign();
	}

	private void testDesign() {
		
		// pizza with extra cheese 
		ExtraCheeseDecorator extraCheeseDecorator = new ExtraCheeseDecorator(new BasicPizza());
		extraCheeseDecorator.makePizza();

		// pizza with extra cheese and extra toppings
		ExtraToppingWithCheese extraToppingWithCheese = new ExtraToppingWithCheese(extraCheeseDecorator);
		extraToppingWithCheese.makePizza();
	}

	interface Pizza {

		void makePizza();
	}

	// Simple basic pizza
	class BasicPizza implements Pizza {

		@Override
		public void makePizza() {
			System.out.println("Simple basic Pizza is made");

		}
	}

	
	// Base Decorator 	
	class BasicPizzaDecorator extends BasicPizza {

		protected Pizza pizza;

		public BasicPizzaDecorator(Pizza pizza) {
			this.pizza = pizza;

		}

		@Override
		public void makePizza() {
			pizza.makePizza();
		}
	}

	// add extra cheese to basicPizza
	class ExtraCheeseDecorator extends BasicPizzaDecorator {

		public ExtraCheeseDecorator(Pizza pizza) {
			super(pizza);
		}

		@Override
		public void makePizza() {
			pizza.makePizza();
			addExtraCheeze();

		}

		private void addExtraCheeze() {
			System.out.println("Adding Extra Cheese");

		}

	}

	//add extra toppings to extra cheese pizza
	class ExtraToppingWithCheese extends ExtraCheeseDecorator {

		public ExtraToppingWithCheese(Pizza pizza) {
			super(pizza);

		}

		@Override
		public void makePizza() {
			pizza.makePizza();
			addExtraToppings();

		}

		private void addExtraToppings() {
			System.out.println("Adding extra Toppings");

		}

	}

}
