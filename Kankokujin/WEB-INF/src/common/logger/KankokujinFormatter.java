package common.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/**
 * ���O�̏o�̓t�H�[�}�b�g
 */
class KankokujinFormatter extends Formatter {

  /**
   * �w�肳�ꂽ���O���R�[�h���t�H�[�}�b�g���A�t�H�[�}�b�g���ꂽ�������Ԃ��܂�
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