package ru.rsatu;

public class TestClassGeneric<T> {
    private T id;

    TestClassGeneric(T id){
        this.id = id;
    }

    public T getId() { return id; }
}
