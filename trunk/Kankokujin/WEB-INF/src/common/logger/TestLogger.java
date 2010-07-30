package common.logger;

import java.io.FilePermission;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;

import common.constant.Const;
import common.exception.SysException;
/**
 * ログ出力を行う
 */
public class TestLogger implements PrivilegedAction{
	private static Logger logger = Logger.getLogger("TestLogger");
	private static TestLogger instance = null;
    public static TestLogger getInstance() throws SysException {
        if (instance == null) {
            synchronized (TestLogger.class) {
                if (instance == null) {
                    instance = new TestLogger();
                }
            }
        }

        return instance;
    }
	private TestLogger() throws SysException{
    	
    	FileHandler fh = null;
		try {
			AccessController.doPrivileged(new PrivilegedAction() {
			          public Object run() {
			              return System.getProperty("user.name");
			          }
			        }
			      );

			//if(System.getSecurityManager()!=null){ 
		    FilePermission perm = new FilePermission("C:/log/", "read,write");
		    AccessController.checkPermission(perm);

			//}			
			fh = new FileHandler(Const.LOG_PATH);
		} catch (SecurityException e) {
			throw new SysException("SYE0021", e);
		} catch (IOException e) {
			throw new SysException("SYE0021", e);
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
//		Runtime rt = Runtime.getRuntime();
//		long totalmemory = rt.totalMemory();
//		long freememory = rt.freeMemory();
//		long heapsize = rt.totalMemory()-rt.freeMemory();
		//logger.log(Level.FINER, "total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
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
	public Object run() {
		AccessController.doPrivileged(this);
		return null;
	}
}
