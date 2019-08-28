package cc.wenmin92.rxjava;

@SuppressWarnings("ALL")
public class AggregationTest {
    // public static void main(String[] args) {
    //     // testSingle();
    //     // testReduce();
    // }
    //
    // private static void testReduce() {
    //     Observable<Integer> values = Observable.range(0, 5);
    //
    //     values.reduce((i1, i2) -> i1 + i2).subscribe(new PrintSubscriber("sum"));
    //     values.reduce((i1, i2) -> (i1 < i2) ? i1 : i2).subscribe(new PrintSubscriber("min"));
    //     values.reduce(0, (acc, next) -> ++acc).subscribe(new PrintSubscriber("count"));
    // }
    //
    // private static Subscription testSingle() {
    //     return Observable.just(1, 1, 2, 3).singleOrDefault(0, i -> i > 1).subscribe(new PrintSubscriber("single"));
    // }
    //
    // static class PrintSubscriber extends Subscriber {
    //     private String tag;
    //
    //     public PrintSubscriber(String tag) {
    //         this.tag = tag;
    //     }
    //
    //     @Override
    //     public void onCompleted() {
    //         System.out.println(tag + ": completed");
    //     }
    //
    //     @Override
    //     public void onError(Throwable e) {
    //         System.out.println(tag + ": " + e.getMessage());
    //     }
    //
    //     @Override
    //     public void onNext(Object o) {
    //         System.out.println(tag + ": " + o);
    //     }
    // }
}
