package cmmdc.client;
import cmmdc.ICmmdc;

public class CmmdcClient implements Runnable {

    /**
     *  Delay between two invocations. 
     */
    private static final int DELAY = 10000;
    
    //private ICmmdc[] m_cmmdc; // Service Requirement
    private ICmmdc m_cmmdc;
    
    /** 
     * End flag.
     *  */
    private boolean m_end;

    /** 
     * Name property.
     * Injected by the container.
     * */
    //private String m_name;
    private String sm;
    private String sn;

    /**
     * Run method.
     * @see java.lang.Runnable#run()
     */
    public void run() {
        while (!m_end) {
            try {
                invokeCmmdcServices();
                Thread.sleep(DELAY);
            } catch (InterruptedException ie) {
                /* will recheck end */
            }
        }
    }

    /**
     * Invoke hello services.
     */
    public void invokeCmmdcServices() {
        //for (int i = 0; i < m_cmmdc.length; i++) {
            int i=0;
            long m=Long.parseLong(sm);
            long n=Long.parseLong(sn);
            //System.out.println(m_cmmdc[i].cmmdc(m,n));
            System.out.println(m_cmmdc.cmmdc(m,n));
            m_end=true;
        //}
    }

    /**
     * Starting.
     */
    public void starting() {
        Thread thread = new Thread(this);
        m_end = false;
        thread.start();      
    }

    /**
     * Stopping.
     */
    public void stopping() {
        m_end = true;
    }
}
