package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapTestAction extends HttpServlet {
	/**
	 * InteroretList���J��
	 * 
	 * @param request
	 *            response
	 * @return BuySellBean�ABuySellSortBean�APageBean�ABuySellBeanList�̏��𑗂�
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		StringBuffer sb = new StringBuffer();
		sb.append("moveAddress('�����s�������4-17-5');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��3-18-25');\n");
//		sb.append("moveAddress('�V�h��l�J4-25-6');\n");
//		sb.append("moveAddress('�V�h��V�h1-29-12');\n");
//		sb.append("moveAddress('�V�h�搼�V�h7-18-16');\n");
//		sb.append("moveAddress('�V�h��g�꒬2-16');\n");		
//		sb.append("moveAddress('�V�h��S�l��1-8-10');\n");
//		sb.append("moveAddress('�V�h���v��1-15-18');\n");
//		sb.append("moveAddress('�V�h��S�l��2-2-10');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��4-9-9');\n");
//		
//		sb.append("moveAddress('�V�h��k�V�h1-7-20');\n");
//		sb.append("moveAddress('�V�h�摁��c��27-3');\n");
//		sb.append("moveAddress('�V�h��S�l��2-7-11');\n");
//		sb.append("moveAddress('�V�h��k�V�h4-1-1');\n");		
//		sb.append("moveAddress('�V�h���v��2-2-9');\n");
//		sb.append("moveAddress('�V�h�搼����c1-23-14');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��4-41-1');\n");
//		sb.append("moveAddress('�V�h�搼�V�h6-26-11');\n");
//		sb.append("moveAddress('�V�h���v��2-10-2');\n");
//		sb.append("moveAddress('�V�h��g�꒬2-14');\n");
//		sb.append("moveAddress('�V�h��V�h1-26-12');\n");
//		sb.append("moveAddress('�V�h��S�l��1-22-25');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��2-9-7');\n");
//		sb.append("moveAddress('�V�h��V�h7-18-7');\n");
//		sb.append("moveAddress('�V�h�撆����1-1-29');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��1-23-9');\n");
//		sb.append("moveAddress('�V�h��l�J4-25-13');\n");
//		sb.append("moveAddress('�V�h��k�V�h1-8-15');\n");
//		sb.append("moveAddress('�V�h�搼�V�h7-3-8');\n");
//		sb.append("moveAddress('�V�h�捂�c�n��1-32-14');\n");		
//		sb.append("moveAddress('�V�h��V�h2-13-6');\n");
//		sb.append("moveAddress('�V�h��S�l��2-1-52');\n");
//		sb.append("moveAddress('�V�h��k�V�h3-22-7');\n");
//		sb.append("moveAddress('�V�h���v��2-16-25');\n");
		
//		sb.append("moveAddress('���c�扎�y��2-5-5');\n");
//		sb.append("moveAddress('���c��_�c�_�ے�3-2-1');\n");
//		sb.append("moveAddress('���c���{��2-13-12');\n");
//		sb.append("moveAddress('���c��ѓc��4-4-6');\n");
//		sb.append("moveAddress('���c��O�_�c6-13-2');\n");		
		sb.append("moveAddress('�����V��5-28-4');\n");
//		sb.append("moveAddress('����撆��2-36-9');\n");
//		sb.append("moveAddress('�������3-26-13');\n");
//		sb.append("moveAddress('����擌����2-22-21');\n");
//		sb.append("moveAddress('�����퐶��1-27-3');\n");
//		sb.append("moveAddress('����擌����4-6-6');\n");
//		sb.append("moveAddress('������{�2-12-13');\n");
//		sb.append("moveAddress('�������y1-5-3');\n");		
//		sb.append("moveAddress('�`��Z�{��3-7-23');\n");
//		sb.append("moveAddress('�`��ԍ�7-10-9');\n");
//		sb.append("moveAddress('�`��V��1-5-5');\n");
//		sb.append("moveAddress('�`��ԍ�2-17-47');\n");
//		sb.append("moveAddress('�`���R3-8-40');\n");
//		sb.append("moveAddress('�`���5-10-10');\n");
//		sb.append("moveAddress('�`��C��3-1-12');\n");
//		sb.append("moveAddress('�`��Ō���3-5-4');\n");		
//		sb.append("moveAddress('������V����1-33-9');\n");
//		sb.append("moveAddress('������V����1-17-10');\n");
//		sb.append("moveAddress('�����您�Ԓ���1-6-12');\n");
//		sb.append("moveAddress('�����搼�T�L1-26-15');\n");
//		sb.append("moveAddress('�]�ː�搐�]2-1-22');\n");
//		sb.append("moveAddress('�]�ː�敽��4-13-4');\n");
//		sb.append("moveAddress('�]�ː�擌����1-7-8');\n");
//		sb.append("moveAddress('�]�ː�擌����5-15-2');\n");
//		sb.append("moveAddress('�]�ː�搼����8-3-13');\n");
//		sb.append("moveAddress('�]����哇4-2-4');\n");
//		sb.append("moveAddress('�]����哇3-4-7');\n");
//		sb.append("moveAddress('�]����؏�2-19-2');\n");
//		sb.append("moveAddress('�]����T��6-32-7');\n");
//		sb.append("moveAddress('�r��搼���闢2-51-8');\n");
//		sb.append("moveAddress('�r��搼���闢2-54-4');\n");
//		sb.append("moveAddress('�r��擌���闢6-39-12');\n");
//		sb.append("moveAddress('�r��搼���闢5-16-2');\n");
//		sb.append("moveAddress('�a�J��a�J2-14-7');\n");
//		sb.append("moveAddress('�a�J��a�J2-1-13');\n");
//		sb.append("moveAddress('�a�J��L��5-19-2');\n");
//		sb.append("moveAddress('�a�J��약�䒬16-26');\n");
//		sb.append("moveAddress('�a�J���ʃ��J3-10-6');\n");
//		sb.append("moveAddress('�a�J����u��8-18');\n");
//		sb.append("moveAddress('�a�J��x�P�J1-5-5');\n");
//		sb.append("moveAddress('�a�J���ʃ��J5-30-16');\n");
//		sb.append("moveAddress('�a�J���ʃ��J4-30-3');\n");
//		sb.append("moveAddress('�a�J���X��3-22-1');\n");
//		sb.append("moveAddress('�����捂�~���k1-21-3');\n");
//		sb.append("moveAddress('������{�V��1-25-15');\n");
//		sb.append("moveAddress('�����扺�䑐2-14-16');\n");
//		sb.append("moveAddress('������x�m��3-49-9');\n");
//		sb.append("moveAddress('������㍂���1-3-14');\n");
//		sb.append("moveAddress('���c�J��k��2-29-7');\n");
//		sb.append("moveAddress('������|�̒�5-6-18');\n");
//		sb.append("moveAddress('�����掭�l3-8-22');\n");
//		sb.append("moveAddress('�䓌�擌���4-1-11');\n");
//		sb.append("moveAddress('�䓌��䓌2-20-9');\n");
//		sb.append("moveAddress('�䓌��󑐋�3-21-7');\n");
//		sb.append("moveAddress('�䓌��󑐋�5-15-10');\n");
//		sb.append("moveAddress('�䓌�����2-7-5');\n");
//		sb.append("moveAddress('�䓌�����2-18-9');\n");
//		sb.append("moveAddress('�䓌��Ԑ��2-2-5');\n");
//		sb.append("moveAddress('�䓌�摠�O2-13-2');\n");
//		sb.append("moveAddress('��c�擌�䒬35-13');\n");
//		sb.append("moveAddress('��c��璹3-9-6');\n");
//		sb.append("moveAddress('��c�搼���c5-22-11');\n");
//		sb.append("moveAddress('��������{���l��3-36-4');\n");
//		sb.append("moveAddress('����u��2-10-5');\n");
//		sb.append("moveAddress('����O�쒬5-24-8');\n");
//		sb.append("moveAddress('�L���搼�r��3-22-13');\n");
//		sb.append("moveAddress('�L�����r��2-41-19');\n");
//		sb.append("moveAddress('�L���擌�r��2-45-7');\n");
//		sb.append("moveAddress('�L���擌�r��4-23-4');\n");
//		sb.append("moveAddress('�L����ڔ�5-18-17');\n");
//		sb.append("moveAddress('�L����r��3-28-1');\n");
//		sb.append("moveAddress('�L���捂�c3-18-14');\n");
//		sb.append("moveAddress('�L���摃��3-8-1');\n");
//		sb.append("moveAddress('�L���捂�c3-10-12');\n");
//		sb.append("moveAddress('�L����r��3-26-16');\n");
//		sb.append("moveAddress('�L����쒷��6-18-1');\n");
//		sb.append("moveAddress('�L����1-13-11');\n");
//		sb.append("moveAddress('�k��c�[�V��1-27-12');\n");
//		sb.append("moveAddress('�k�����7-8-9');\n");
//		sb.append("moveAddress('�k�擌�c�[1-6-6');\n");
//		sb.append("moveAddress('�k�扤�q2-23-1');\n");
//		sb.append("moveAddress('�k�敂��3-19-21');\n");
//		sb.append("moveAddress('�n�c��]����1-11-7');\n");
//		sb.append("moveAddress('�n�c�旼��1-2-3');\n");
//		sb.append("moveAddress('�n�c����3-4-3');\n");
//		sb.append("moveAddress('�ڍ���S�V��1-21-18');\n");
//		sb.append("moveAddress('�ڍ��掩�R���u1-14-6');\n");
		
		
		
		
		request.setAttribute("MapListStr", sb.toString());
		request.setAttribute("Count", "20");
		this.getServletContext().getRequestDispatcher(
				"/map/map_icon_01.jsp").forward(request, response);

	}

}