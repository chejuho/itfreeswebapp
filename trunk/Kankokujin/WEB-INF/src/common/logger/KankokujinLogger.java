package common.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.constant.Const;
/**
 * ログ出力を行う
 */
public class KankokujinLogger {
	private static Logger logger = Logger.getLogger("Kankokujin");
	private static KankokujinLogger instance = null;
    public static KankokujinLogger getInstance() {
        if (instance == null) {
            synchronized (KankokujinLogger.class) {
                if (instance == null) {
                    instance = new KankokujinLogger();
                }
            }
        }

        return instance;
    }
	private KankokujinLogger(){
    	
    	FileHandler fh = null;
		try {
			fh = new FileHandler(Const.LOG_PATH, 1000000, 1);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	fh.setFormatter(new KankokujinFormatter());
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
    	
    }
    /**
     * debugレベルのログ出力を行う
     */
	public void debug(String input) {
		logger.log(Level.FINER, input);
		Runtime rt = Runtime.getRuntime();
		long totalmemory = rt.totalMemory();
		long freememory = rt.freeMemory();
		long heapsize = rt.totalMemory()-rt.freeMemory();
		logger.log(Level.FINER, "total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
	}
    /**
     * errorレベルのログ出力を行う
     */	
	public void error(String input) {
		logger.log(Level.SEVERE, input);
	}
    /**
     * infoレベルのログ出力を行う
     */	
	public void info(String input) {
		logger.log(Level.INFO, input);
	}
}
