package Project;

public class Main {
	
	public static void main(String[] args){
		BikeStore bs = new BikeStore(10);

		Bike bike1 = bs.borrow();
		bs.restore(bike1, true);
		Bike bike2 = bs.borrow();
		System.out.println("The number of borrowed Bikes : " + bs.borrowedCount());
		System.out.println(bike1.equals(bike2));

		Bike bike3 = bs.borrow();
		Bike bike4 = bs.borrow();
		System.out.println("The number of borrowed Bikes : " + bs.borrowedCount());
		System.out.println(bike3.equals(bike4));

		Bike bike5 = bs.borrow();
		System.out.println(bike5);




	}
	
}
