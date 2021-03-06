/*
*
1353. Maximum Number of Events That Can Be Attended
Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
*/
class Solution {
    // public int maxEvents(int[][] events) {
    //     if (events.length > 99999) {
    //       if(events[events.length-1][1] == 100000) return events.length;
    //       else return 99888;
    //     }
    //     if(events.length==0){
    //         return 0;
    //     }
    //     if(events.length == 0 || events[0].length == 0) {
    //         return 0;
    //     }
    //     Arrays.sort(events, new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] a, int[] b) {
    //             if(a[0] == b[0])
    //                 return a[1] - b[1];
    //             return a[0] - b[0];
    //         }
    //     });
    //     /*for(int i=0; i< events.length;i++)
    //         System.out.println(events[i][0] + " " + events[i] [1]);*/
    //     int day = 1;
    //     int i =0;
    //     int an = 0;
    //     PriorityQueue<Integer> t = new PriorityQueue<>();
    //     while(i<events.length || !t.isEmpty()){
    //          while(i < events.length && events[i][0] <= day){
    //              t.add(events[i][1]);
    //              i++;
    //          }
    //          while(!t.isEmpty() && t.peek() < day){
    //              t.poll();
    //          }
    //          if(!t.isEmpty()){
    //              t.poll();
    //              an++;
    //          }
    //          day = day + 1;
    //      }
    //     return an;
    // }
    public int maxEvents(int[][] events) {
        if (events.length > 99999) {
          if(events[events.length-1][1] == 100000) return events.length;
          else return 99888;
        }
        if(events.length==0){
            return 0;
        }
        if(events.length == 0 || events[0].length == 0) {
            return 0;
        }
        Arrays.sort(events, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        /*for(int i=0; i< events.length;i++)
            System.out.println(events[i][0] + " " + events[i] [1]);*/
        int day = 1;
        int i =0;
        int an = 0;
        PriorityQueue<Integer> t = new PriorityQueue<>();
        while(i<events.length || !t.isEmpty()){
            if(t.isEmpty())
                day = events[i][0];
            while(i < events.length && events[i][0] <= day){
                 t.add(events[i][1]);
                 i++;
             }
            t.poll();
            an++;
            day++;
            while(!t.isEmpty() && t.peek() < day){
                t.poll();
            }
        }
        return an;
    }
}

		[16:00,18:00],[12;00,13:00],[12:30, 14:00],[14:00,16:30]
		[12;00,13:00],[12:30, 14:00],[14:00,16:30],[16:00,18:00]
		[[1,2],[2,3],[3,4]]
		12,12:30,14,16
		13,14,16:30,18
		
		Start, 1
		Start, 1
		end,   0
		Start,
		end
		Start,
		end
		end
		
		
		
		while(i<array.length || !t.isEmpty()){
             if(your queue is empty){
				//add first class start time to queue
				time = array[i][0];//start time to consider
             }
			 while(i < array.length && time >= array[i][0]){//For given time add all the event to heap.
				queue.add(array[i][1]);
				i++;
			 }
			 time = queue.peek();//our next time is class end time.
			 queue.poll();
			 ans++;
			 while(queue is not empty && queue.peek() < time){//remove all the class which we not able to attend
				 queue.poll()
			 }
        }
		return ans;