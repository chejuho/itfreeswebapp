package common.batch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.media.jai.Interpolation;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.RenderedOp;
import javax.swing.ImageIcon;
 
public class Jpeg
{
    public Jpeg()
    {
    }
    public boolean resize(int i, String s, String s1)
    {
    	File file  = null;
    	File file1 = null;
       try
        {
            file  = new File(s);
            file1 = new File(s1);
    
            //Parametrage de la lecture
            ImageIO.setUseCache (true);
            
            BufferedImage src = ImageIO.read(file);
            
            double image_width  = src.getWidth();
            double image_height = src.getHeight();
            double resize_width = i;
            double resize_rate = resize_width / image_width;
    
            if(image_height * resize_rate > resize_width)
            {
            	resize_rate = resize_width / image_height;
            }
    
            if(resize_rate > 0.8D)
            {
            	resize_rate = 1.0D;
            }
    
            int new_image_width = (int)(image_width * resize_rate);
            int new_image_height = (int)(image_height * resize_rate);
 
            AffineTransform  tx = new AffineTransform ();
            tx.scale (resize_rate, resize_rate);
            
            RenderingHints  rh = new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put (RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            rh.put (RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            rh.put (RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            rh.put (RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            rh.put (RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            rh.put (RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
 
            AffineTransformOp  op    = new AffineTransformOp (tx, rh);
            BufferedImage      biNew = new BufferedImage (new_image_width, new_image_height, src.getType ());
 
            op.filter(src, biNew);
 
            ImageIO.write (biNew, "jpg", new File (s1));
        }
        catch (Exception  e)
        {
        	System.out.println(file.getPath());
            e.printStackTrace ();
            return  false;
        }
        
        return  true;
    }
 
    public static void main(String args[])
    {
        Jpeg jpeg = new Jpeg();
        int arg1 = 1000;
        String inputFileName = "D:\\testfrom\\DSC_0215.JPG";
        String outputFileName = "D:\\testto\\s_DSC_0215.JPG";
        ImageIcon newImg = new ImageIcon("D:\\testto\\new.gif");
        newImg.setDescription("test");
        //newImg.paintIcon(c, g, x, y);
        //jpeg.writeCharacterInImage(arg1, inputFileName, outputFileName);
        jpeg.resize (arg1, inputFileName, outputFileName);
    }

    private void thumbnail (String img, String thumb, OutputStream stream, int w, int h) throws Exception
    {
     String filename = img;
     String dest = thumb;
     OutputStream out = stream;
     int tw = w;
     int th = h;
     int width = 0;
     int height = 0;
     double widthRatio = 0.0f;
     double heightRatio = 0.0f;
     double ratio = 1.0f;
     int sharpen = 150;
     float quality = 0.95f;

     if (tw <= 0 || th <= 0) throw new Exception("width, height must be > 0");

     RenderedOp im = JAI.create("fileload", filename);
     widthRatio = (double)tw / (double)im.getWidth();
     heightRatio = (double)th / (double)im.getHeight();


     if (widthRatio < heightRatio) 
     {
      ratio = widthRatio; 
      width = tw;
      height = (int)(ratio * im.getHeight());
     }
     else if (widthRatio == heightRatio)
     {
      ratio = widthRatio;
      width = (int)(ratio * im.getWidth());
      height = (int)(ratio * im.getHeight());
     }
     else // if (widthRatio > heightRatio)
     {
      ratio = heightRatio;
      width = (int)(ratio * im.getWidth());
      height = th;
     }

     BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     Graphics2D destGd = destImage.createGraphics();

     // sharpen
     float kData[] = new float[9];
     float alpha;
     ParameterBlock pbSharpen = new ParameterBlock();
     pbSharpen.addSource(im);
     if (sharpen > 150) alpha = (sharpen - 125.0f) / 25.0f;
     else               alpha = sharpen / 150.0f;
     float beta = (1.0f - alpha) / 8.0f;
     for (int i = 0; i < 9; i++) kData[i] = beta;
     kData[4] = alpha;
     KernelJAI k = new KernelJAI(3, 3, 1, 1, kData);
     pbSharpen.add(k);

     // scale
     RenderedOp sharpenOp  = JAI.create("convolve", pbSharpen, null);
     Interpolation interp = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
     ParameterBlock scalePb = new ParameterBlock();
     scalePb.addSource(sharpenOp);
     scalePb.add((float)ratio);
     scalePb.add((float)ratio);
     scalePb.add(0.0f);
     scalePb.add(0.0f);
     scalePb.add(interp);

     RenderedOp scaleOp = JAI.create("scale",  scalePb);
     BufferedImage scaleImage = scaleOp.getAsBufferedImage();

     destGd.drawImage(scaleImage, 0, 0, width, height, null);  // 0, 0 alignWidth, alignHeight

     com.sun.media.jai.codec.JPEGEncodeParam encodeParam = new com.sun.media.jai.codec.JPEGEncodeParam();
     encodeParam.setQuality(quality);

     if (dest != null) JAI.create("filestore", destImage, dest, "JPEG", encodeParam);
     else              JAI.create("encode", destImage, out, "JPEG", encodeParam);
    
   }

}
