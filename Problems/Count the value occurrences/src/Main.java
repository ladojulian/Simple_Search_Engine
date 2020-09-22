class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        var size = Math.max(list1.size(), list2.size());
        var occurs1 = 0;
        var occurs2 = 0;
        for (var i = 0; i < size; i++) {
            if (i < list1.size() && list1.get(i) == elem) {
                occurs1++;
            }
            if (i < list2.size() && list2.get(i) == elem) {
                occurs2++;
            }
        }

        return occurs1 == occurs2;
    }
}