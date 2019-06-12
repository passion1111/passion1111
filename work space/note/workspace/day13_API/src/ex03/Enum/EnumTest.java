package ex03.Enum;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}

public class EnumTest {
	  Day day;  //열거형 변수 선언
	    
	    public EnumTest(Day day) {  //생성자함수
	        this.day = day;
	    }
	    
	    public void tellItLikeItIs() {  
	        switch (day) {
	            case MONDAY:
	                System.out.println("Mondays are bad.");
	                break;
	                    
	            case FRIDAY:
	                System.out.println("Fridays are better.");
	                break;
	                         
	            case SATURDAY: case SUNDAY:
	                System.out.println("Weekends are best.");
	                break;
	                        
	            default:
	                System.out.println("Midweek days are so-so.");
	                break;
	        }
	    }
	    
	    public static void main(String[] args) {
	        EnumTest firstDay = new EnumTest(Day.MONDAY);
	        firstDay.tellItLikeItIs();
	        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
	        thirdDay.tellItLikeItIs();
	        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
	        fifthDay.tellItLikeItIs();
	        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
	        sixthDay.tellItLikeItIs();
	        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
	        seventhDay.tellItLikeItIs();
	        Point pt =new Point();
	       
	    }   
}
class Point extends Object {
	
}






