class Solution {
    public void backtrack(int idx,String digits, List<String> res, Map<Character,String> map,
        StringBuilder s)
        {
            if(s.length()==digits.length())
            {
                res.add(s.toString());
                return;
            }
            char c= digits.charAt(idx);
            String choices= map.get(c);
            for(char ch: choices.toCharArray())
            {
                s.append(ch);
                backtrack(idx+1,digits,res,map,s);
                s.deleteCharAt(s.length()-1);
            }
        }
    public List<String> letterCombinations(String digits) {
        
        Map<Character,String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res= new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder s= new StringBuilder();
        backtrack(0,digits,res,map,s);
        return res;
    }
}