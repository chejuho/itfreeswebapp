package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapTestAction extends HttpServlet {
	/**
	 * InteroretListðJ­
	 * 
	 * @param request
	 *            response
	 * @return BuySellBeanABuySellSortBeanAPageBeanABuySellBeanListÌîñðé
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		StringBuffer sb = new StringBuffer();
		sb.append("moveAddress('sìæìä4-17-5');\n");
//		sb.append("moveAddress('Vhæcnê3-18-25');\n");
//		sb.append("moveAddress('VhælJ4-25-6');\n");
//		sb.append("moveAddress('VhæVh1-29-12');\n");
//		sb.append("moveAddress('Vhæ¼Vh7-18-16');\n");
//		sb.append("moveAddress('Vhægê¬2-16');\n");		
//		sb.append("moveAddress('VhæSl¬1-8-10');\n");
//		sb.append("moveAddress('VhæåvÛ1-15-18');\n");
//		sb.append("moveAddress('VhæSl¬2-2-10');\n");
//		sb.append("moveAddress('Vhæcnê4-9-9');\n");
//		
//		sb.append("moveAddress('VhækVh1-7-20');\n");
//		sb.append("moveAddress('Vhæîc¬27-3');\n");
//		sb.append("moveAddress('VhæSl¬2-7-11');\n");
//		sb.append("moveAddress('VhækVh4-1-1');\n");		
//		sb.append("moveAddress('VhæåvÛ2-2-9');\n");
//		sb.append("moveAddress('Vhæ¼îc1-23-14');\n");
//		sb.append("moveAddress('Vhæcnê4-41-1');\n");
//		sb.append("moveAddress('Vhæ¼Vh6-26-11');\n");
//		sb.append("moveAddress('VhæåvÛ2-10-2');\n");
//		sb.append("moveAddress('Vhægê¬2-14');\n");
//		sb.append("moveAddress('VhæVh1-26-12');\n");
//		sb.append("moveAddress('VhæSl¬1-22-25');\n");
//		sb.append("moveAddress('Vhæcnê2-9-7');\n");
//		sb.append("moveAddress('VhæVh7-18-7');\n");
//		sb.append("moveAddress('Vhæ1-1-29');\n");
//		sb.append("moveAddress('Vhæcnê1-23-9');\n");
//		sb.append("moveAddress('VhælJ4-25-13');\n");
//		sb.append("moveAddress('VhækVh1-8-15');\n");
//		sb.append("moveAddress('Vhæ¼Vh7-3-8');\n");
//		sb.append("moveAddress('Vhæcnê1-32-14');\n");		
//		sb.append("moveAddress('VhæVh2-13-6');\n");
//		sb.append("moveAddress('VhæSl¬2-1-52');\n");
//		sb.append("moveAddress('VhækVh3-22-7');\n");
//		sb.append("moveAddress('VhæåvÛ2-16-25');\n");
		
//		sb.append("moveAddress('çãcæy¬2-5-5');\n");
//		sb.append("moveAddress('çãcæ_c_Û¬3-2-1');\n");
//		sb.append("moveAddress('çãcæâ{¬2-13-12');\n");
//		sb.append("moveAddress('çãcæÑc´4-4-6');\n");
//		sb.append("moveAddress('çãcæO_c6-13-2');\n");		
		sb.append("moveAddress('ìæVä5-28-4');\n");
//		sb.append("moveAddress('ìæ2-36-9');\n");
//		sb.append("moveAddress('ìæìä3-26-13');\n");
//		sb.append("moveAddress('ìæì2-22-21');\n");
//		sb.append("moveAddress('ìæí¶¬1-27-3');\n");
//		sb.append("moveAddress('ìæì4-6-6');\n");
//		sb.append("moveAddress('¶æ{î2-12-13');\n");
//		sb.append("moveAddress('¶æãy1-5-3');\n");		
//		sb.append("moveAddress('`æZ{Ø3-7-23');\n");
//		sb.append("moveAddress('`æÔâ7-10-9');\n");
//		sb.append("moveAddress('`æV´1-5-5');\n");
//		sb.append("moveAddress('`æÔâ2-17-47');\n");
//		sb.append("moveAddress('`æìÂR3-8-40');\n");
//		sb.append("moveAddress('`æÅ5-10-10');\n");
//		sb.append("moveAddress('`æCÝ3-1-12');\n");
//		sb.append("moveAddress('`æÅö3-5-4');\n");		
//		sb.append("moveAddress('üæV¬â1-33-9');\n");
//		sb.append("moveAddress('üæV¬â1-17-10');\n");
//		sb.append("moveAddress('üæ¨Ô®1-6-12');\n");
//		sb.append("moveAddress('üæ¼TL1-26-15');\n");
//		sb.append("moveAddress(']Ëìæ]2-1-22');\n");
//		sb.append("moveAddress(']Ëìæ½ä4-13-4');\n");
//		sb.append("moveAddress(']Ëìæ¼1-7-8');\n");
//		sb.append("moveAddress(']Ëìæ¼5-15-2');\n");
//		sb.append("moveAddress(']Ëìæ¼¼8-3-13');\n");
//		sb.append("moveAddress(']æå4-2-4');\n");
//		sb.append("moveAddress(']æå3-4-7');\n");
//		sb.append("moveAddress(']æØê2-19-2');\n");
//		sb.append("moveAddress(']æTË6-32-7');\n");
//		sb.append("moveAddress('rìæ¼úé¢2-51-8');\n");
//		sb.append("moveAddress('rìæ¼úé¢2-54-4');\n");
//		sb.append("moveAddress('rìæúé¢6-39-12');\n");
//		sb.append("moveAddress('rìæ¼úé¢5-16-2');\n");
//		sb.append("moveAddress('aJæaJ2-14-7');\n");
//		sb.append("moveAddress('aJæaJ2-1-13');\n");
//		sb.append("moveAddress('aJæLö5-19-2');\n");
//		sb.append("moveAddress('aJæì½ä¬16-26');\n");
//		sb.append("moveAddress('aJæçÊJ3-10-6');\n");
//		sb.append("moveAddress('aJæ÷u¬8-18');\n");
//		sb.append("moveAddress('aJæxPJ1-5-5');\n");
//		sb.append("moveAddress('aJæçÊJ5-30-16');\n");
//		sb.append("moveAddress('aJæçÊJ4-30-3');\n");
//		sb.append("moveAddress('aJæãXØ3-22-1');\n");
//		sb.append("moveAddress('Àæ~k1-21-3');\n");
//		sb.append("moveAddress('Àæ{VÀ1-25-15');\n");
//		sb.append("moveAddress('Àæºä2-14-16');\n");
//		sb.append("moveAddress('Àæxmà3-49-9');\n");
//		sb.append("moveAddress('ÀæãäË1-3-14');\n");
//		sb.append("moveAddress('¢cJækò2-29-7');\n");
//		sb.append("moveAddress('«§æ|ÌË5-6-18');\n");
//		sb.append("moveAddress('«§æ­l3-8-22');\n");
//		sb.append("moveAddress('äæãì4-1-11');\n");
//		sb.append("moveAddress('äæä2-20-9');\n");
//		sb.append("moveAddress('äæó´3-21-7');\n");
//		sb.append("moveAddress('äæó´5-15-10');\n");
//		sb.append("moveAddress('äæö´2-7-5');\n");
//		sb.append("moveAddress('äæö´2-18-9');\n");
//		sb.append("moveAddress('äæÔìË2-2-5');\n");
//		sb.append("moveAddress('äæ O2-13-2');\n");
//		sb.append("moveAddress('åcæä¬35-13');\n");
//		sb.append("moveAddress('åcæç¹3-9-6');\n");
//		sb.append("moveAddress('åcæ¼c5-22-11');\n");
//		sb.append("moveAddress('æú{´l¬3-36-4');\n");
//		sb.append("moveAddress('Â´æuº2-10-5');\n");
//		sb.append("moveAddress('Â´æOì¬5-24-8');\n");
//		sb.append("moveAddress('Læ¼rÜ3-22-13');\n");
//		sb.append("moveAddress('LæìrÜ2-41-19');\n");
//		sb.append("moveAddress('LærÜ2-45-7');\n");
//		sb.append("moveAddress('LærÜ4-23-4');\n");
//		sb.append("moveAddress('LæÚ5-18-17');\n");
//		sb.append("moveAddress('LærÜ3-28-1');\n");
//		sb.append("moveAddress('Læc3-18-14');\n");
//		sb.append("moveAddress('Læ3-8-1');\n");
//		sb.append("moveAddress('Læc3-10-12');\n");
//		sb.append("moveAddress('LærÜ3-26-16');\n");
//		sb.append("moveAddress('Læì·è6-18-1');\n");
//		sb.append("moveAddress('Læî1-13-11');\n");
//		sb.append("moveAddress('kæc[V¬1-27-12');\n");
//		sb.append("moveAddress('kæêìì7-8-9');\n");
//		sb.append("moveAddress('kæc[1-6-6');\n");
//		sb.append("moveAddress('kæ¤q2-23-1');\n");
//		sb.append("moveAddress('kæÔ3-19-21');\n");
//		sb.append("moveAddress('ncæ]´1-11-7');\n");
//		sb.append("moveAddress('ncæ¼1-2-3');\n");
//		sb.append("moveAddress('ncæçÎ3-4-3');\n");
//		sb.append("moveAddress('ÚæSV1-21-18');\n");
//		sb.append("moveAddress('Úæ©Rªu1-14-6');\n");
		
		
		
		
		request.setAttribute("MapListStr", sb.toString());
		request.setAttribute("Count", "20");
		this.getServletContext().getRequestDispatcher(
				"/map/map_icon_01.jsp").forward(request, response);

	}

}