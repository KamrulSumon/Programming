public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int maxWindow = 0;
        int len = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int rWindow = 0, lWindow = 0; rWindow < len; rWindow++){
            
            if(map.containsKey(s.charAt(rWindow))){
                lWindow = Math.max(lWindow, map.get(s.charAt(rWindow)) + 1);
            }
        
            map.put(s.charAt(rWindow), rWindow);
            
            maxWindow = Math.max(maxWindow, rWindow - lWindow + 1);
        
        }
        
        return maxWindow;
        
    }
}
