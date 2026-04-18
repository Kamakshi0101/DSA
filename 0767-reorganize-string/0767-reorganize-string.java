class HeapElement {
    char ch;
    int count;
    public HeapElement(char c, int co) {
        ch = c;
        count = co;
    }
}

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HeapElement> maxheap =
            new PriorityQueue<>((a, b) -> b.count - a.count);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxheap.add(new HeapElement(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            HeapElement max1 = maxheap.poll();
            char c1 = max1.ch;

            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c1) {
                sb.append(c1);
                max1.count--;

                if (max1.count > 0) {
                    maxheap.add(new HeapElement(c1, max1.count));
                }
            } else {
                if (maxheap.isEmpty()) {
                    return "";
                }

                HeapElement max2 = maxheap.poll();
                char c2 = max2.ch;

                sb.append(c2);
                max2.count--;   

                if (max2.count > 0) {
                    maxheap.add(new HeapElement(c2, max2.count));
                }

                if (max1.count > 0) {
                    maxheap.add(new HeapElement(c1, max1.count));
                }
            }
        }

        return sb.toString();
    }
}