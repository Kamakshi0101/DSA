class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<nums.length();i++)
        {
            char c= nums.charAt(i);
            while(true)
            {
                if(k==0)
                {
                    stack.push(c);
                    break;
                }
                if(stack.isEmpty())
                {
                    stack.push(c);
                    break;
                }
                char idx= stack.peek();
                if(c< idx)
                {
                    stack.pop();
                    k--;
                }
                else
                {
                    stack.push(c);
                    break;
                }
            }
        }
        while(k>0)
        {
            if(stack.isEmpty()) break;
            stack.pop();
            k--;
        }
        char[] res= new char[stack.size()];
        int i= stack.size()-1;
        while(i>=0)
        {
            res[i]= stack.pop();
            i--;
        }
        i=0;
        while(i<res.length && res[i]=='0') i++;
        StringBuilder sb= new StringBuilder();
        while(i<res.length)
        {
            sb.append(res[i]);
            i++;
        }
        return sb.length()==0?"0": sb.toString();
    }
}