package stringspra;


	import java.util.HashMap;

	public class IsomorphicStrings {
	    public static void main(String[] args) {
	        String str1 = "egg";
	        String str2 = "add";
	        
	        boolean isIsomorphic = checkIsomorphic(str1, str2);
	        
	        if(isIsomorphic) {
	            System.out.println(str1 + " and " + str2 + " are isomorphic.");
	        } else {
	            System.out.println(str1 + " and " + str2 + " are not isomorphic.");
	        }
	    }

	    public static boolean checkIsomorphic(String str1, String str2) {
	        if (str1.length() != str2.length()) {
	            return false;
	        }

	        HashMap<Character, Character> map = new HashMap<>();

	        for (int i = 0; i < str1.length(); i++) {
	            char char1 = str1.charAt(i);
	            char char2 = str2.charAt(i);

	            if (map.containsKey(char1)) {
	                if (map.get(char1) != char2) {
	                    return false;
	                }
	            } else {
	                if (map.containsValue(char2)) {
	                    return false;
	                }
	                map.put(char1, char2);
	            }
	        }

	        return true;
	    }
	}



