package chapter08.section006.Refactoring08;

import java.util.Observable;

class Interval extends Observable {
    private String _end    = "0";
    private String _start  = "0";
    private String _length = "0";

    String getEnd(){
        return _end;
    }
    void setEnd(String arg){
        _end = arg;
        calculateLength(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }

    String getStart(){
        return _start;
    }
    void setStart(String arg){
        _start = arg;
        calculateLength(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }

    String getLength(){
        return _length;
    }
    void setLength(String arg){
        _length = arg;
        calculateEnd(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }

    void calculateLength(){
        try{
            int start = Integer.parseInt(_start);
            int end = Integer.parseInt(_end);
            int length = end - start;
            _length = (String.valueOf(length));
        }catch (NumberFormatException e){
            throw new RuntimeException("予期しない数字形式のエラー");
        }
    }

    void calculateEnd(){
        try{
            int start = Integer.parseInt(_start);
            int length = Integer.parseInt(_length);
            int end = start + length;
            _end = (String.valueOf(end));
        }catch (NumberFormatException e){
            throw new RuntimeException("予期しない数字形式のエラー");
        }
    }
}