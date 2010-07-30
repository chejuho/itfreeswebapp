package admin.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.bean.StoreBean;

import common.constant.Const;
import common.exception.KankokujinException;
import common.util.Util;

public class TestComAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean result = false;
		StoreBean storeBean = new StoreBean();
/*			KankokujinLogger.getInstance().debug("TestComAction.service.start");
			
			TestComHandler testComHandler = new TestComHandler();
			
		    result = testComHandler.insertCom();*/
			Properties prop = createProperties("Const.AREA_1_XML");
			if(!Util.isEmpty(prop.getProperty("01"))){
				throw new KankokujinException("01="+ prop.getProperty("01"));
			}
			
//		} catch (SysException e) {
//			throw new KankokujinException(e.getMessage(), e);
//		} catch (Exception e) {
//			throw new KankokujinException("SYE0020", e);
	}
	private Properties createProperties(String filePath) throws InvalidPropertiesFormatException, IOException {
		
		Properties prop = new Properties();
		
		InputStream stream;
			stream = new BufferedInputStream(new FileInputStream(filePath));
			prop.loadFromXML(stream);

		return prop;
	}
}