import java.util.concurrent.TimeUnit;

public class SpinLoad {
    private byte stage;

    public void animate() { // Sequence for printing a spinning loading bar
        switch (stage) {
            case 1:
                System.out.print("\r\\");    // 2nd
                break;
            case 2:
                System.out.print("\r|");    // 3rd
                break;
            case 3:
                System.out.print("\r/");    // 4th
                break;
            default:
                stage = 0;
                System.out.print("\r— Loading");    // 1st
        }
        stage++;
    }

    public void showLoad(SpinLoad load, int times, int speed) throws InterruptedException {
        for (int i = 0; i < times; i++) {   // times = # of times to spin, speed = time between each redraw
            load.animate();
            TimeUnit.MILLISECONDS.sleep(speed); // Sleep for x miliseconds to simulate loading
        }
        System.out.println();
    }
}