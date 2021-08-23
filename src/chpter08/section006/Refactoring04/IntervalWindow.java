package chpter08.section006.Refactoring04;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;

public class IntervalWindow extends JFrame implements Observer {
    private JTextField _startField;
    private JTextField _endField;
    private JTextField _lengthField;
    private JLabel _startLabel;
    private JLabel _endLabel;
    private JLabel _lengthLabel;
    private JPanel _mainPanel;
    private Interval _subject;

    public IntervalWindow() {
        //初期値の設定
        _startField.setText("0");
        _endField.setText("0");
        _lengthField.setText("0");
        _startLabel.setText("開始：");
        _endLabel.setText("終了：");
        _lengthLabel.setText("長さ：");

        _startField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                StartField_FocusLost(e);
            }
        });
        _endField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                EndField_FocusLost(e);
            }
        });
        _lengthField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                LengthField_FocusLost(e);
            }
        });

        _startField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(_startField.getText().equals("0")){
                    _startField.setText("");
                }
            }
        });
        _endField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(_endField.getText().equals("0")){
                    _endField.setText("");
                }
            }
        });
        _lengthField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(_lengthField.getText().equals("0")){
                    _lengthField.setText("");
                }
            }
        });
        _startField.addFocusListener(new FocusAdapter() {
        });

        _subject = new Interval();
        _subject.addObserver(this);
        update(_subject,null);

    }

    public void update(Observable observed, Object arg){
        setEnd(_subject.getEnd()); //違いを比較したいので実装してみる(※StackOverflowErrorになる)。
    }

    String getEnd(){
        return _subject.getEnd();
    }
    void setEnd(String arg){
        _subject.setEnd(arg);
    }

    public static void main(String[] args) {
        int frameWidth  = 300; //このフォームの画面の幅
        int frameHeight = 400; //このフォームの画面の高さ

        JFrame frame = new JFrame("IntervalWindow");

        frame.setContentPane(new IntervalWindow()._mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //コンポーネントの推奨サイズと設定したレイアウトからコンテナーのサイズを決定してくれるというメソッド
        frame.pack();
        //画面をモニタ中央に配置
        frame.setLocationRelativeTo(frame);
        //画面サイズの指定
        frame.setSize(frameWidth,frameHeight);

        frame.setVisible(true);

        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                //[getXOnScreen]→イベントの絶対x座標(水平方向)を返す。
                //[(frameWidth/2)]→ポインタの位置を画面中央にするために微調整。
                int _x = e.getXOnScreen() - (frameWidth/2);
                int _y = e.getYOnScreen() - (frameHeight/2);

                frame.setLocation(_x,_y);
                frame.repaint();
            }
        });
    }

    void StartField_FocusLost(FocusEvent event){
        if(isNotInteger(_startField.getText())){
            _startField.setText("0");
        }
        calculateLength();
    }

    void EndField_FocusLost(FocusEvent event){
        setEnd(_endField.getText());
        if(isNotInteger(getEnd())){
            setEnd("0");
        }
        calculateLength();
    }

    void LengthField_FocusLost(FocusEvent event){
        if(isNotInteger(_lengthField.getText())){
            _lengthField.setText("0");
        }
        calculateEnd();
    }

    boolean isNotInteger(String yourInput) {
        try {
            //文字列の引数を符号付き10進数の整数型として構文解析する。
            // 違ってたらNumberFormatExceptionへ。
            Integer.parseInt(yourInput);
            return false;
        } catch (NumberFormatException ex) {
            //メソッド名は「isNotInteger」なのでこっちがTrue。
            return true;
        }
    }

    void calculateLength(){
        try{
            int start = Integer.parseInt(_startField.getText());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            _lengthField.setText(String.valueOf(length));
        }catch (NumberFormatException e){
            throw new RuntimeException("予期しない数字形式のエラー");
        }
    }

    void calculateEnd(){
        try{
            int start = Integer.parseInt(_startField.getText());
            int length = Integer.parseInt(_lengthField.getText());
            int end = start + length;
            setEnd(String.valueOf(end));
        }catch (NumberFormatException e){
            throw new RuntimeException("予期しない数字形式のエラー");
        }
    }
}