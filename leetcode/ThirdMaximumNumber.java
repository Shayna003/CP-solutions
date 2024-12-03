class Solution {

public int thirdMax(int[] nums) {
	PriorityQueue<Integer> heap = new PriorityQueue<>();
	for (int num : nums) {
		if (heap.contains(num)) continue;
		heap.add(num);
		if (heap.size() > 3) heap.remove();
	}

	if (heap.size() < 3) 
		while (heap.size() > 1) heap.poll();
	
	return heap.peek();
	}
}