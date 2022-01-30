public class ABCThreads {
    private Object monitor = new Object();
    private char letterForChangingThreads = 'A';

    public void printLetter(char currentLetter,char nextLetter){
        synchronized (monitor){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letterForChangingThreads != currentLetter) {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    letterForChangingThreads = nextLetter;
                    monitor.notifyAll();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
