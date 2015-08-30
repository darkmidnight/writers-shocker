package writersblock;

import java.util.ArrayList;
import java.util.List;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class WiimoteThread extends Thread {

    private List<Mote> motes = new ArrayList<>();
    private int timeout;
    private MoteFinderListener listener;
    
    public WiimoteThread() {
        listener = new MoteFinderListener() {
            @Override
            public void moteFound(Mote mote) {
                System.out.println("Found mote: " + mote.getBluetoothAddress());
                motes.add(mote);
                timeout = 30;
            }
        };
        this.start();
    }
    @Override
    public void run() {

        MoteFinder finder = MoteFinder.getMoteFinder();
        finder.addMoteFinderListener(listener);

        System.out.println("Starting discovery..");
        finder.startDiscovery();
        
        timeout = 0;
        System.out.println("Putting thread to sleep..");
        try {
            while (timeout <30) {
                Thread.sleep(1000l);
                timeout++;
            }
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println("Stopping discovery..");
        finder.stopDiscovery();
    }
    
    public void buzz() {
        motes.get(0).rumble(1000l);
    }

}
