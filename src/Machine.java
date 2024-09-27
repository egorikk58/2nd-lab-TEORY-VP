public class Machine {

    private State currentState;

    //Начальное состояние
    public Machine(){
        currentState = State.S;
    }

    //Если есть проход - {@code return 0}.
    //Если нет - {@code return -1}.
    public int changeState(char st){
        switch (currentState){
            case S -> {
                if(st == '1') currentState = State.B;
                else if(st == '3') currentState = State.A;
                else return -1;
            }
            case A -> {
                if(st == '2') currentState = State.A;
                else if(st == '4') currentState = State.Z;
                else return -1;

            }
            case B -> {
                if(st=='3') currentState = State.B;
                else if(st == '1') currentState = State.Z;
                else return -1;
            }
            case Z -> {
                if(st == '2') currentState = State.A;
                else if(st == '4') currentState = State.B;
                else return -1;
            }
            default -> {
                currentState = State.S;
                return -1;
            }
        }
        return 0;
    }

    public State getCurrentState() {
        return currentState;
    }
}
