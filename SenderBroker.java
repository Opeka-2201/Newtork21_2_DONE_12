import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * SenderBroker
 */
public class SenderBroker implements Runnable{

    Socket s;
    BlockingQueue<byte[]> queue;
    OutputStream out;

    public SenderBroker(Socket next, BlockingQueue<byte[]> queue) throws IOException {
        this.s = next;
        this.queue = queue;
        this.out=this.s.getOutputStream();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true)
            try {
                this.out.write(this.queue.take());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch (IOException  e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    }
}