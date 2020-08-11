import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers2 implements Seat {

    private ReentrantLock leftFork;
    private ReentrantLock rightFork;

    @Override
    public void askFork1() {

            rightFork.lock();

    }

    @Override
    public void askFork2() {

            leftFork.lock();

    }

    @Override
    public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {

        this.leftFork = reentrantLock;
        this.rightFork = reentrantLock1;

    }
}
