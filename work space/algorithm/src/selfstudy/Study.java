package selfstudy;

import java.util.Arrays;
import java.util.HashMap;

public class Study {
	public static void main(String[] args) {
		String[] participant= {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion= {"josipa", "filipa", "marina", "nikola"};
		String result=solution(participant, completion);
		System.out.println(result);
		System.out.println(solution2(participant, completion)+"1");
		
	}
	
	public static  String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
        String answer = "";
        for(int i=0;i<completion.length; i++) {
			if(participant[i]!=completion[i])  return answer=participant[i];
		}
        return participant[participant.length-1];
    }
	
	  public static String solution2(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> hm = new HashMap<>();
	        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
	        for (String player : completion) hm.put(player, hm.get(player) - 1);

	        for (String key : hm.keySet()) {
	            if (hm.get(key) != 0){
	                answer = key;
	            }
	        }
	        return answer;
	    }
}
