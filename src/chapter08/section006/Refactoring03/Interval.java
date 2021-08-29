package chapter08.section006.Refactoring03;

import java.util.Observable;

class Interval extends Observable {
    private String _end = "0";

    String getEnd(){
        return _end;
    }
    void setEnd(String arg){
        _end = arg;
        setChanged();
        notifyObservers();
    }
}