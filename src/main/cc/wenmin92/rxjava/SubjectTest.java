package cc.wenmin92.rxjava;

import rx.subjects.*;

public class SubjectTest {
    public static void main(String[] args) {
        // testPublishSubject();
        testReplaySubject();
        // testBehaviorSubject1();
        // testBehaviorSubject2();
        // testBehaviorSubject3();
        // testAsyncSubject();
    }

    private static void testPublishSubject() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("1");
        subject.subscribe(System.out::println);
        subject.onNext("2");
        subject.onNext("3");
        subject.onNext("4");
    }

    private static void testReplaySubject() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.onNext(1);
        subject.subscribe(v -> System.out.println("early " + v));
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribe(v -> System.out.println(" late " + v));
        subject.onNext(4);
        subject.onNext(5);
    }

    private static void testBehaviorSubject1() {
        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
    }

    private static void testBehaviorSubject2() {
        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
        s.subscribe(
                v -> System.out.println("Late: " + v),
                e -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }

    private static void testBehaviorSubject3() {
        BehaviorSubject<Integer> s = BehaviorSubject.create(0);
        s.subscribe(System.out::println);
        s.onNext(1);
    }

    private static void testAsyncSubject() {
        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(System.out::println);
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
    }
}
