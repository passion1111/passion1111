package personal;


public class BasketTest {

	public static void main(String arg[]) {

		Buyer b = new Buyer();

		b.buy(new Tv());

		b.buy(new Computer());

		b.buy(new Audio());

		// 100+200+50 = 350



		b.buy(new Computer());

		b.buy(new Audio());

		b.buy(new Computer());

		b.buy(new Tv());

		// 200+50+200+100 = 550

		b.summary();

	}

}



	class Product {

	int price;



	Product(int price) {

		this.price = price;

	}

}



class Tv extends Product {



	Tv() {

		super(100);

	}



	public String toString() {

		return "tv";

	}

}







	public String toString() {

		return "Audio";

	}

}





	public String toString() {

		return "Computer";

	}

}





	void buy(Product p) {

		int money;
		if (money < p.price) {

			System.out.println("잔액이 부족하여 " + p.toString() + "를 살 수 없습니다.");

			return;

		} else {

			money -= p.price;

			add(p);

		}

	}



	void add(Product p) {



		if (cart.length == i) {

			Product[] temp = new Product[cart.length * 2];



			for (int i = 0; i < cart.length; i++) {

				temp[i] = cart[i];

			}

			cart = temp;

		}

		cart[i++] = p;

	}



	void summary() {

		int temp = 0;

		for (int j = 0; j < i; j++) {

			temp += cart[j].price;

		}

		System.out.print("구입한 물건 : ");

		for (int j = 0; j < i; j++) {

			System.out.print(cart[j].toString() + ",");

		}

		System.out.println("\n장바구니에 담긴 물건들의 총 가격은 " + temp);

		System.out.println("남은 돈은 " + money);

	}

}

