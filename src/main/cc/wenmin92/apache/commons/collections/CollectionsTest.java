package cc.wenmin92.apache.commons.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(IterableUtils.toString(ListUtils.select(list, i -> i>3)));
        System.out.println(IterableUtils.toString(ListUtils.predicatedList(list, i -> i>0)));
    }
}
