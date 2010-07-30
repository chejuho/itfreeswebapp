package board;

import java.io.UnsupportedEncodingException;

public class JapaneseConn
{
   public JapaneseConn()
   {
   }
   
   public static String toJapanese(String s)
     {
          try
           {
             if(s != null)
                return new String(s.getBytes("8859_1"),"UTF-8");
              else
                 return s;
            }
             catch(UnsupportedEncodingException ex)
               {
					
                    String k = ex.getMessage();
					 return k;
                }
      }
	
   public static String toEnglish(String s)
     {
          try
           {
             if(s != null)
                return new String(s.getBytes("UTF-8"),"8859_1");
              else
                 return s;
            }
             catch(UnsupportedEncodingException ex)
               {
					
                    String k = ex.getMessage();
					 return k;
                }
      }

  }