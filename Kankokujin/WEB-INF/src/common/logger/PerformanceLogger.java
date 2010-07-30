package common.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * ���O�o�͂��s��
 */
public class PerformanceLogger {
	private static Logger logger = Logger.getLogger("Kankokujin");
	private static PerformanceLogger instance = null;
    public static PerformanceLogger getInstance() {
        if (instance == null) {
            synchronized (KankokujinLogger.class) {
                if (instance == null) {
                    instance = new PerformanceLogger();
                }
            }
        }

        return instance;
    }
	private PerformanceLogger(){
    	
        // FileHandler�𐶐�
    	FileHandler fh = null;
		try {
			fh = new FileHandler("C:\\log\\performanceLog.csv");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        // Formatter��ݒ肵�܂�
    	fh.setFormatter(new KankokujinFormatter());
        // ���O�̏o�͐��ǉ�
        logger.addHandler(fh);
        // ���O�̏o�̓��x����ݒ�i�����ł͂��ׂďo�͂���悤�ɐݒ�)
        //logger.setLevel(Level.INFO);
        logger.setLevel(Level.ALL);
    	
    }
    /**
     * debug���x���̃��O�o�͂��s��
     */
	public void debug(String input) {
		//logger.log(Level.FINER, input);
		Runtime rt = Runtime.getRuntime();
		long totalmemory = rt.totalMemory();
		long freememory = rt.freeMemory();
		long heapsize = rt.totalMemory()-rt.freeMemory();
		logger.log(Level.FINER, input + "," + "total=" + totalmemory/1000 + "K" + ",free=" + freememory/1000 + "K"+ ",heap=" + heapsize/1000 + "K");
	}
    /**
     * error���x���̃��O�o�͂��s��
     */	
	public void error(String input) {
		logger.log(Level.FINER, input);
		Runtime rt = Runtime.getRuntime();
		long totalmemory = rt.totalMemory();
		long freememory = rt.freeMemory();
		long heapsize = rt.totalMemory()-rt.freeMemory();
		logger.log(Level.FINER, "total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
	}
    /**
     * info���x���̃��O�o�͂��s��
     */	
	public void info(String input) {
		logger.log(Level.INFO, input);
	}
}
