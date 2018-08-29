package cc.wenmin92.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.schedulers.Schedulers;

import java.io.IOException;

public class RxJavaTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Thread.currentThread());
        Observable.just(1).map(i -> just())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(integer -> "test")
                .doOnNext(s -> {
                    try {
                        Thread.sleep(4000);
                        System.out.println("do on next");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .subscribe(result -> System.out.println("result: " + result), throwable -> System.out.println("result: " + throwable.getMessage()));

        System.in.read();
    }

    private static int just() {
        System.out.println("just: " + Thread.currentThread());
        // Exceptions.propagate(new Throwable("test error"));
        return 0;
    }
}
