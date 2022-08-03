class MyCalendar {
    
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
        if (floorEntry == null && ceilingEntry == null) {
            map.put(start, end);
            return true;
        } else if (floorEntry == null && ceilingEntry.getKey() >= end) {
            map.put(start, end);
            return true;
        } else if (ceilingEntry == null && floorEntry.getValue() <= start) {
            map.put(start, end);
            return true;
        } else if (floorEntry != null && ceilingEntry != null && floorEntry.getValue() <= start && ceilingEntry.getKey() >= end) {
            map.put(start, end);
            return true;
        } else {
            return false;
        }
    }
}
/*

*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */