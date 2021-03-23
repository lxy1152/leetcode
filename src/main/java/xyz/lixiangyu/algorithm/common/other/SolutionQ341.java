package xyz.lixiangyu.algorithm.common.other;

import xyz.lixiangyu.AbstractSolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionQ341 extends AbstractSolution {

}

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        iterator = list.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }
}
