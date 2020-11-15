package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void rxJavaTest() {

        Observable.create(new Observable.OnSubscribe<String>() {


            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("Observable  call");
                subscriber.onNext("hello rxjava");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>(){
            @Override
            public void onCompleted() {
                System.out.println("Subscriber  onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Subscriber  onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber  onNext =" +s);
            }
        });


    }
    @Test
    public void rxjavaJust(){
        Observable.just("天气真好").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber  onNext =" +s);
            }
        });
    }@Test
    public void rxjavaFrom(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Observable.from(list).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer s) {
                System.out.println("Subscriber  onNext =" +s);
            }
        });
    }
    @Test
    public void rxjavaDeffer(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Observable.range(1,5).repeat(3).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer s) {
                System.out.println("Subscriber  onNext =" +s);
            }
        });
    }@Test
    public void rxjavaFlatmap(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Observable.from(list).flatMap(new Func1<Integer, Observable<?extends Integer>>() {

            @Override
            public Observable<Integer> call(Integer integer) {
                return Observable.just(integer+1);
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer s) {
                System.out.println("Subscriber  onNext =" +s);
            }
        });
    }
}