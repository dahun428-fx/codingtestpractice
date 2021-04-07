package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class 신규아이디추천 {

	public static void main(String[] args) {

		String new_id = ".abcdefghijklm....";
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String answer = 신규아이디추천.solution(new_id);
		System.out.println(answer);
	}

	/*
	 * 아이디의 길이는 3자 이상 15자 이하여야 합니다. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수
	 * 있습니다. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	 * 
	 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다. 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_),
	 * 마침표(.)를 제외한 모든 문자를 제거합니다. 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로
	 * 치환합니다. 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. 5단계 new_id가 빈 문자열이라면,
	 * new_id에 "a"를 대입합니다. 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을
	 * 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. 7단계
	 * new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */
	public static String solution(String new_id) {
		String answer = "";
		String emptyStr = "a";
		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		String savedId = new_id.toLowerCase();
		String regExp = "[^-_.a-z0-9]";
		// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		savedId = savedId.replaceAll(regExp, "");
		System.out.println(savedId);
		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		savedId = savedId.replaceAll("[.]{2,}", ".");
		System.out.println(savedId);
		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		savedId = savedId.replaceAll("^[.]|[.]$", "");
		System.out.println(savedId);
		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(savedId.isEmpty()) {
			savedId += emptyStr;
		}
		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을
		// 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(savedId.length() >= 16) {
			savedId = savedId.substring(0,15);
			savedId = savedId.replaceAll("^[.]|[.]$", "");
		}
		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(savedId.length() < 3) {
			while(savedId.length() < 3) {
				savedId += savedId.charAt(savedId.length() - 1);
			}
		}
		answer = savedId;
//		String emptyStr = "a";
//		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//		savedId = savedId.toLowerCase();
//		// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//		String regExp = "[a-z0-9-_.]";
//		String[] arr = savedId.split("");
//		List<String> strList = Arrays.asList(arr);
//		List<String> filteredStrList = new ArrayList<>();
//		for (String value : strList) {
//			if (value.matches(regExp)) {
//				filteredStrList.add(value);
//			}
//		}
//		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//		List<String> noHipenList = new ArrayList<>();
//		for (int i = 0; i < filteredStrList.size(); i++) {
//			if (filteredStrList.get(i).equals(".")) {
//				if((i+1) == filteredStrList.size()) {
//					break;
//				}
//				if (!filteredStrList.get(i).equals(filteredStrList.get(i + 1))) {
//					noHipenList.add(filteredStrList.get(i));
//				}
//			} else {
//				noHipenList.add(filteredStrList.get(i));
//			}
//		}
//		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//		List<String> noFirstAndLastDotList = new ArrayList<>();
//		for (int i = 0; i < noHipenList.size(); i++) {
//			String value = noHipenList.get(i);
//			if (i == 0 && ".".equals(value)) {
//			} else {
//				noFirstAndLastDotList.add(value);
//			}
//		}
//		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//		if (noFirstAndLastDotList.isEmpty()) {
//			noFirstAndLastDotList.add(emptyStr);
//		}
//		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을
//		// 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//		String fifteenStr = "";
//		for(int i = 0; i < noFirstAndLastDotList.size(); i++) {
//			fifteenStr += noFirstAndLastDotList.get(i);
//			if(i > 13) {
//				break;
//			}
//		}
//		String lastStr = fifteenStr.substring(fifteenStr.length() - 1, fifteenStr.length());
//		if(".".equals(lastStr)) {
//			StringBuffer sb = new StringBuffer(fifteenStr);
//			fifteenStr = sb.replace(sb.length() - 1, sb.length(), "").toString();
//		}
//		
//		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
//		if (fifteenStr.length() < 3) {
//			int len = fifteenStr.length();
//			while (len < 3) {
//				String last3 = fifteenStr.substring(fifteenStr.length() - 1, fifteenStr.length());
//				fifteenStr += last3;
//				len++;
//			}
//		}
//		answer = fifteenStr;

		return answer;
	}
}
