package omake.chapter08.section006.modify01;

import java.util.Observable;

class Interval extends Observable {
    private String _end    = "";
    private String _start  = "";
    private String _length = "";

    String getEnd(){
        return _end;
    }
    void setEnd(String arg){
        _end = arg;
        if(isNotNumeric(_end)){_end = "";} //たぶんココが適切
        calculateLength(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }
    String getStart(){
        return _start;
    }
    void setStart(String arg){
        _start = arg;
        if(isNotNumeric(_start)){_start = "";} //たぶんココが適切
        calculateLength(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }
    String getLength(){
        return _length;
    }
    void setLength(String arg){
        _length = arg;
        if(isNotNumeric(_length)){_length = "0";} //たぶんココが適切
        calculateEnd(); //たぶんココが適切
        setChanged();
        notifyObservers();
    }
    void calculateLength(){
        try{
            int start = _start.length();
            int end = _end.length();
            int length = end - start;
            _length = (String.valueOf(length));
        }catch (StringIndexOutOfBoundsException e){
            throw new RuntimeException("予期しない文字列形式のエラー");
        }
    }
    void calculateEnd(){
        try{
            int start = _start.length();
            int length = Integer.parseInt(_length);
            int end = start + length;

            // endの文字数を増やす場合、ゼロを右埋め
            // ALL0なら先頭に1をつける
            if( _end.length() < end ) {
                // %   ・・・書式文字列であることを表す指示子
                // -end・・・桁数(マイナスなので右埋め)
                // s   ・・・出力する値の型(String)
                String padRightString = "%" + ("-" + end) + "s";
                _end = String.format(padRightString, _end);

                _end = _end.replace(" ", "0");

                if( _end.matches("^00+")){
                    _end = _start;
                }
            }
            // endの文字数を減らす場合、右側削除
            // 減らす量が多すぎる場合、すべて削除
            else if( _end.length() > end ){
                if(end <= 0){_end = "";}
                else{_end = _end.substring(0,end);}
            }
        }catch (StringIndexOutOfBoundsException e){
            throw new RuntimeException("予期しない文字列形式のエラー");
        }
    }
    boolean isNotNumeric(String yourInput) {
        try {
            //文字列の引数を正規表現で確認する。
            // 違ってたらNumberFormatExceptionへ。
            boolean isNumeric = yourInput.matches("[+-]?\\d*(\\.\\d+)?");
            if(yourInput.isEmpty()){isNumeric=false;}
            if(yourInput.matches("^00+")){isNumeric=false;}
            return !isNumeric;
        } catch (NumberFormatException ex) {
            //メソッド名は「isNotNumeric」なのでこっちがTrue。
            return true;
        }
    }
}