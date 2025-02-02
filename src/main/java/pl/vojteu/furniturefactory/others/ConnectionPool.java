package pl.vojteu.furniturefactory.others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private final int poolSize;
    private final Queue<Connection> availableConnections;
    private final Semaphore semaphore;

    public ConnectionPool(int size) {
        this.poolSize = size;
        this.availableConnections = new LinkedList<>();
        this.semaphore = new Semaphore(size, true);

        for (int i = 0; i < size; i++) {
            availableConnections.add(new Connection());
        }
    }

    public Connection acquireConnection() throws InterruptedException {
        semaphore.acquire();
        synchronized (availableConnections) {
            return availableConnections.poll();
        }
    }

    public void releaseConnection(Connection conn) {
        synchronized (availableConnections) {
            availableConnections.add(conn);
        }
        semaphore.release();
    }
}
