package edu.umb.cs681.hw09;

public class RunnableAircraft extends Aircraft implements Runnable{

    public RunnableAircraft(Position pos) {
        super(pos);
    }

    public void run(){
        getPosition();
        setPosition(12,22,345);
    }

    public static void main(String[] args) {
        Position pos1 = new Position(15,26,37);
        Position pos2 = new Position(25,36,47);
        Position pos3 = new Position(35,46,57);

        RunnableAircraft run1 = new RunnableAircraft(pos1);
        RunnableAircraft run2 = new RunnableAircraft(pos2);
        RunnableAircraft run3 = new RunnableAircraft(pos3);

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        Thread t3 = new Thread(run3);

        t1.start();
        t2.start();
        t3.start();



    }


}
