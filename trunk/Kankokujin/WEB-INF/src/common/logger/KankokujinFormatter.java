package common.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/**
 * ログの出力フォーマット
 */
class KankokujinFormatter extends Formatter {

  /**
   * 指定されたログレコードをフォーマットし、フォーマットされた文字列を返します
   */
  public String format(LogRecord rec) {
    StringBuffer buf = new StringBuffer();      
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/hh:mm:ss");
	Date time = new Date();
	buf.append(format.format(time));    
    buf.append(" ");    
    buf.append(formatMessage(rec));
    buf.append("\r\n");
    return buf.toString();
  }
}