package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 완주하지못한선수 {

	public static void main(String[] args) {

		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		String answer = 완주하지못한선수.solution(participant, completion);
		System.out.println(answer);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		List<String> pList = new ArrayList<>(Arrays.asList(participant));
		List<String> cList = new ArrayList<>(Arrays.asList(completion));
		cList.add("");
		for(int i = 0; i < cList.size(); i++) {
			for(int j = i; j < pList.size();) {
				if(cList.get(i).equals(pList.get(j))) {
					break;
				} else {
					answer = pList.get(j);
					return answer;
				}
			}
		}
		
		return answer;
	}
}
