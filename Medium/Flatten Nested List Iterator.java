public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int pointer;
    int size;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                NestedIterator itr = new NestedIterator(ni.getList());
                list.addAll(itr.list);
            }
        }
        pointer = 0;
        size = list.size();
    }

    @Override
    public Integer next() {
        return list.get(pointer++);
    }

    @Override
    public boolean hasNext() {
        if (pointer < size) {
            return true;
        }
        return false;
    }
}
