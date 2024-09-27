import java.util.Scanner;

public class UI {

    private static final Scanner _in = new Scanner(System.in);

    public UI(){};

    public void Run(){
        System.out.println("Введите строку");
        String inp = _in.nextLine();
        if(inp.isEmpty()){
            System.out.println("Строка пуста");
            return;
        }
        if(inp.matches("^[1234]+$")){
            Machine at = new Machine();
            for(char i:inp.toCharArray()) {
                int stepRes = at.changeState(i);
                if(stepRes == -1){
                    System.out.println("Нет прохода");
                    return;
                }
            }
            if(at.getCurrentState() == State.Z){
                System.out.println("Цепочка входит в язык");
            }else{
                System.out.println("Конечное состояние не достигнуто");
            }
        }else {
            System.out.println("Строка содержит недопустимые символы");
        }
    }
}
