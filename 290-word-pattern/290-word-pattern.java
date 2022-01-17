class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        String[] words = s.split(" ");
        // System.out.println(Arrays.toString(words));
        if (pattern.length() != words.length)
            return false;
        int index = 0;
        for (char c : pattern.toCharArray()) {
            if (reverseMap.containsKey(words[index]) && map.containsKey(c)) {
                if (reverseMap.get(words[index]) != c || !map.get(c).equals(words[index]))
                    return false;
            } else if (reverseMap.containsKey(words[index]) || map.containsKey(c)) {
                return false;
            } else {
                reverseMap.put(words[index], c);
                map.put(c, words[index]);
            }
            index++;
            // System.out.println("map: "+map+", reverseMap: "+reverseMap);
        }
        return true;
    }
}