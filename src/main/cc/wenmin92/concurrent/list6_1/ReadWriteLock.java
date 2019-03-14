package cc.wenmin92.concurrent.list6_1;

public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingWriters = 0;
    private int writingWriters = 0;
    private boolean preferWrite = true;


    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (waitingWriters > 0 && preferWrite)) {
            wait();
        }
        readingReaders++;
    }

    public synchronized void readUnlock() {
        readingReaders--;
        preferWrite = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWrite = false;
        notifyAll();
    }
}
