package engmgn.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class DownLoadAction extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("DownLoadAction.START");
		ServletOutputStream out = null;
		try {
			String targetFilename = "";
			if(request.getParameterValues("downcheck")!=null){
				String[] downcheck = request.getParameterValues("downcheck");
				System.out.println("downcheck : "+downcheck.length);
				int size = downcheck.length;
				if(size>1){
					targetFilename = fileZipComplex(downcheck);
				}else{
					targetFilename = downcheck[0];
				}
			}else{
				targetFilename = request.getParameter("filename");				
			}
			response.setHeader("Content-disposition", "attachment;filename=\""+ targetFilename +"\";");
			out = response.getOutputStream();		
			downLoad(targetFilename,out);
		} catch (Exception e) {
			throw new KankokujinException("InterpretDownLoadAction.service.Exception", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}	
	}
//	ÉtÉ@ÉCÉãÇÃà≥èk
	public  String fileZipComplex(String[] downcheck) throws IOException{

		byte[] bytes = new byte[4096];
		String path = Const.DOWNLOAD_FOLDER_PATH ;
		String targetFilename=Const.ZIPFILE_NAME;
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path+targetFilename));
	  
		 try {			 
		  for(int i=0; i<downcheck.length; i++)
			{
			    FileInputStream fis = new FileInputStream(path+downcheck[i]);
			    zos.putNextEntry(new ZipEntry(downcheck[i]));
			            
			    int len = 0;
			    while((len = fis.read(bytes)) > 0)
			    {
			        zos.write(bytes, 0, len);
			    }
			    zos.closeEntry();
			    fis.close();
			}
			zos.close();
			
	
		  }catch (IOException e){
		   e.printStackTrace();
		  }finally {
		   try { zos.close(); } catch ( Exception e) {}
		   
		  }
		  return targetFilename;
	}
	public static void downLoad(String fname, OutputStream out) throws FileNotFoundException, IOException{ 
        
        FileInputStream fis = null; 
        String file = Const.DOWNLOAD_FOLDER_PATH + fname;
        try{ 
             
            fis = new FileInputStream(file); 
            byte[] buf = new byte[4*1024]; 
             
            int bytesRead; 
             
            while( (bytesRead=fis.read(buf)) != -1) 
            { 
                out.write(buf, 0, bytesRead);     
            } 
             
             
        }finally{ 
            if(fis!=null){
            	fis.close();     
            }
			KankokujinLogger.getInstance().debug("DownLoadAction.END");
        } 
    } 
}


	

