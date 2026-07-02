package QuizApplication;



public class LiveTimer extends Thread {



    private volatile boolean running = true;

    public int timeLeft = 15;



    public void stopTimer() {

        running = false;

    }



    @Override

    public void run() {



        while (running && timeLeft >= 0) {



            System.out.print("\r⏳ Time Left: " + timeLeft + " sec   ");



            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                return;

            }



            timeLeft--;

        }



        if (timeLeft < 0) {

            System.out.print("\r⏰ Time Over!           \n");

        } else {

            System.out.println();

        }

    }

}

