package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		체육복.solution(n, lost, reserve);
	}
	 public static int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        List<Integer> lostList = new ArrayList<>(); //잃어버린학생번호리스트
	        List<Integer> reserveList = new ArrayList<>(); //남은 체육복 갖고 있는 학생 번호리스트
	        List<Integer> availableList = new ArrayList<>(); //빌려줄수 있는 학생 번호 리스트
	        for(int i = 0; i < reserve.length; i++) {
	        	reserveList.add(reserve[i]);
	        }
	        for(int i = 0; i < lost.length; i++) {
	        	lostList.add(lost[i]);
	        }
	        System.out.println("남은 체육복 학생 번호 : "+reserveList);
	        System.out.println("잃어버린 학생 번호 : "+lostList);
	        for(int i = 0; i < lostList.size(); i++) {
	        	System.out.println("잃어버린 학생 : " + lostList.get(i));
	        	int beforeNum = lostList.get(i) - 1;
	        	int afterNum = lostList.get(i) + 1;
	        	if(beforeNum > 0) {
	        		availableList.add(beforeNum);
	        	}
	        	availableList.add(afterNum);
//	        	System.out.println(beforeNum+"||"+afterNum);
	        }
	        System.out.println(availableList);
	        
	        
	        
	        
	        return answer;
	    }
}
