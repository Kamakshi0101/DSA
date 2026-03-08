class CharacterCount
{
    int count;
    char c;

    public CharacterCount(int _count, char _c)
    {
        count=_count;
        c=_c;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharacterCount> maxheap= new PriorityQueue<CharacterCount>((x,y)-> y.count-x.count);

        if(a>0)
        {
            maxheap.add(new CharacterCount(a,'a'));
        }
        if(b>0)
        {
            maxheap.add(new CharacterCount(b,'b'));
        }
        if(c>0)
        {
            maxheap.add(new CharacterCount(c,'c'));
        }
        StringBuilder res= new StringBuilder();

        while(!maxheap.isEmpty())
        {
            CharacterCount maxEle= maxheap.poll();
            int count= maxEle.count;
            char _c=maxEle.c;
            if(res.length()>=2 && res.charAt(res.length()-1)==_c && res.charAt(res.length()-2)==_c)
            {
                if(maxheap.isEmpty()) break;
                CharacterCount second= maxheap.poll();
                int sc=second.count;
                char sch= second.c;

                res.append(sch);
                sc--;

                if(sc>0) maxheap.add(new CharacterCount(sc,sch));
            }
            else
            {
                res.append(_c);
                count--;
            }
            if(count>0) maxheap.add(new CharacterCount(count,_c));
        }
        return res.toString();
    }
}