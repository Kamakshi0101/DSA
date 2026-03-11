class Solution {
    private class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        private Map<Integer, Integer> map;
        private int maxSize;
        private int minSize;
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            minHeap = new PriorityQueue<>();
            map = new HashMap<>();
            maxSize = 0;
            minSize = 0;
        }
        public void addNum(int num) {
            if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
                maxSize++;
            } else {
                minHeap.offer(num);
                minSize++;
            }
            balance();
        }
        public void removeNum(int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(num <= maxHeap.peek()) {
                maxSize--;
                if(num == maxHeap.peek()) {
                    remove(maxHeap);
                }
            } else {
                minSize--;
                if(!minHeap.isEmpty() && num == minHeap.peek()) {
                    remove(minHeap);
                }
            }
            balance();
        }
        private void remove(PriorityQueue<Integer> pq) {
            while(!pq.isEmpty()) {
                int num = pq.peek();
                if(map.containsKey(num)) {
                    map.put(num, map.get(num) - 1);
                    if(map.get(num) == 0)
                        map.remove(num);
                    pq.poll();
                }
                else break;
            }
        }
        private void balance() {
            if(maxSize > minSize + 1) {
                minHeap.offer(maxHeap.poll());
                maxSize--;
                minSize++;
                remove(maxHeap);
            } else if(maxSize < minSize) {
                maxHeap.offer(minHeap.poll());
                maxSize++;
                minSize--;
                remove(minHeap);
            }
        }
        public double findMedian() {
            remove(maxHeap);
            remove(minHeap);
            if(maxSize > minSize)
                return maxHeap.peek();
            return ((double)maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MedianFinder mdf = new MedianFinder();
        double[] result = new double[n - k + 1];
        for(int i = 0; i < k; i++)
            mdf.addNum(nums[i]);
        int idx = 0;
        result[idx++] = mdf.findMedian();
        for(int i = k; i < n; i++) {
            mdf.addNum(nums[i]);
            mdf.removeNum(nums[i - k]);
            result[idx++] = mdf.findMedian();
        }
        return result;
    }
}