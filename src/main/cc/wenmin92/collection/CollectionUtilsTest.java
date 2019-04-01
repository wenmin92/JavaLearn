package cc.wenmin92.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUtilsTest {
    public static void main(String[] args) {
        final List<Integer> o1 = Arrays.asList(1, 2, 3, 3, 4);
        final List<Integer> o2 = Arrays.asList(3, 4, 4, 5, 6);

        // 并
        log("union(o1, o2)", CollectionUtils.union(o1, o2));
        log("union(o2, o1)", CollectionUtils.union(o2, o1)); 
        // 交
        log("intersection(o1, o2)", CollectionUtils.intersection(o1, o2));
        log("intersection(o2, o1)", CollectionUtils.intersection(o2, o1)); 
        // 差
        log("subtract(o1, o2)", CollectionUtils.subtract(o1, o2));
        log("subtract(o2, o1)", CollectionUtils.subtract(o2, o1));
        // 对称差
        log("disjunction(o1, o2)", CollectionUtils.disjunction(o1, o2));
        log("disjunction(o2, o1)", CollectionUtils.disjunction(o2, o1));
    }

    private static void log(String method, Collection collection) {
        method = StringUtils.rightPad(method, 30);
        String size = StringUtils.leftPad(String.valueOf(collection.size()), 2);
        System.out.println(String.format("%s%s: %s", method, size, collection));
    }
}
