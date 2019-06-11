package ex05_continue_break;
//break,continue22

//식별자:{      }
//	식별자:{   } 식별자는 변수명만드는 규칙과 똑같음.
public class Ex05_multibreak2 {
		public static void main(String[] args) {
			boolean flag=true;
			
			
			first:{
					second: {
						third:{
							int k=100;
							System.out.println("Before the break;");
							if(flag)  break first;//break써놓고 빠져나가길 원하는 식별자까지 적어주면 해당하는
//															블럭까지 빠져나감.
							System.out.println("This won't execute ");
		}//third
			System.out.println("화이팅");
		}//se
		System.out.println("This is after second block");
		}//fir
			System.out.println("마지막");

			
			
			
}
}

