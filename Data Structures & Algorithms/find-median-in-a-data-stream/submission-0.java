class MedianFinder {
        private PriorityQueue<Integer> minHeap; // largest numbers
        private PriorityQueue<Integer> maxHeap; // lowest numbers

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }
        
        public void addNum(int num) {
            maxHeap.offer(num); //add to maxHeap
            minHeap.offer(maxHeap.poll()); // move largest of lower half to upper half

            if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());  //balance sizes
            }
            
        }
        
        public double findMedian() {
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }

            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
}
