package common.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * ログ出力を行う
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
    	
        // FileHandlerを生成
    	FileHandler fh = null;
		try {
			fh = new FileHandler("C:\\log\\performanceLog.csv");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        // Formatterを設定します
    	fh.setFormatter(new KankokujinFormatter());
        // ログの出力先を追加
        logger.addHandler(fh);
        // ログの出力レベルを設定（ここではすべて出力するように設定)
        //logger.setLevel(Level.INFO);
        logger.setLevel(Level.ALL);
    	
    }
    /**
     * debugレベルのログ出力を行う
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
     * errorレベルのログ出力を行う
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
     * infoレベルのログ出力を行う
     */	
	public void info(String input) {
		logger.log(Level.INFO, input);
	}
}
