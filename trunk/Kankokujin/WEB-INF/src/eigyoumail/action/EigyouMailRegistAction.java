package eigyoumail.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.AppException;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.handler.EigyouMailRegistHandler;
import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class EigyouMailRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		EigyoumailBean bean = new EigyoumailBean();
		//bean.setMail_id(mail_id);
		bean.setTitle(title);
		bean.setContents(content);
		bean.setUpdate_by_user_id("jeong");
		
		EigyouMailRegistHandler eigyouMailRegistHandler = new EigyouMailRegistHandler();
		if (eigyouMailRegistHandler.insertEigyou_email(bean)) {
			this.getServletContext().getRequestDispatcher(
			"/EigyouMailList").forward(request,
			response);
		} else {
			System.out.println("insert error");
		}

/*		KankokujinLogger.getInstance().debug("InterpretRegistAction.start");
		boolean result = false;
		boolean flg = false;
		String userId = "";
		MemberBean memberBean = new MemberBean();
		MemberLoginHandler member = new MemberLoginHandler();
		InterpretBean interpretBean = new InterpretBean();
		SendMailHandler sendMailHandler = new SendMailHandler();
		MemberRegistHandler memberRegistHandler = new MemberRegistHandler();
		InterpretRegistHandler interpretRegistHandler = new InterpretRegistHandler();
		HttpSession session = request.getSession();
		interpretBean = (InterpretBean) session.getAttribute("InterpretBean");
		if (!"".equals(interpretBean.getPassword())) {
			interpretBean.setViewflg("1");
		} else {
			interpretBean.setViewflg("0");
		}

		try {

			result = interpretRegistHandler.insertInterpretBean(interpretBean);

			if (result) {
				if (!"".equals(interpretBean.getPassword())) {
					memberBean.setUserid(interpretBean.getUser_id());
					memberBean.setPassword(interpretBean.getPassword());

					String mail1 = interpretBean.getEmail1();
					String mail2 = interpretBean.getEmail2();
					memberBean.setEmail1(mail1);
					memberBean.setEmail2(mail2);
					memberBean.setName(interpretBean.getUser_name());
					memberBean.setTelephone1(interpretBean.getTel_no_1());
					memberBean.setMobile1(interpretBean.getTel_no_2());
					String StartChar = "I";
					String registnum = Util.getRND(StartChar);
					memberBean.setRegistnum(registnum);
					flg = memberRegistHandler.insert(memberBean);

					if (flg) {
						String userName = "";
						EmailBean emailBean = setEmailBean(request, memberBean);
						sendMailHandler.sendmail(emailBean);
						MemberBean mBean = member.getMemberInfo(userId);
						userName = mBean.getName();
						session.setAttribute("InterpretBean", null);
						request.setAttribute("userName", userName);
						request.setAttribute("Message", "MSG0002");
					} else {
						throw new AppException("ERR0005");
					}
				} else {
					session.setAttribute("InterpretBean", null);
				}
			} else {
				throw new AppException("ERR0003");
			}
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"InterpretRegistAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("InterpretRegistAction.end");
		}

		if (!"".equals(interpretBean.getPassword())) {// Member Regist &
														// Interpret Regist
			this.getServletContext().getRequestDispatcher(
					"/jsp/member/member_regist_result.jsp").forward(request,
					response);
		} else { // Interpret Regist
			this.getServletContext().getRequestDispatcher("/InterpretList")
					.forward(request, response);
		}*/
	}

	private EmailBean setEmailBean(HttpServletRequest request, MemberBean bean)
			throws AppException {

		String filename = "registmail.xml";
		SendMailHandler handler = new SendMailHandler();
		HashMap mailMap = handler.getFileContents(filename);

		String subject = (String) mailMap.get("subject");
		String contents = (String) mailMap.get("contents");

		contents = contents.replace("USERID_X", bean.getUserid());
		contents = contents.replace("PASSWORD_X", bean.getUserid());
		contents = contents.replace("REGISTNUM_X", bean.getRegistnum());
		contents = contents.replace("SERVER_DOMAIN", Const.SERVER_DOMAIN);
		EmailBean emailBean = new EmailBean();
		emailBean.setToId(bean.getUserid());
		emailBean.setFromId(Const.ADMIN_ID);
		emailBean.setSubject(subject);
		emailBean.setContents(contents);
		return emailBean;
	}

	// private InterpretBean setInterpretBean(InterpretBean bean,
	// HttpServletRequest request)
	// throws ServletException, IOException {
	// KankokujinLogger.getInstance().debug(
	// "InterpretRegistAction.setInterpretBean.start");
	// String saveFolder = Const.UPLOAD_FOLDER_PATH;
	// String saveFolder2 = Const.DOWNLOAD_FOLDER_PATH;
	// int maxSize = 10 * 1024 * 1024;
	//
	// MultipartRequest multi = new MultipartRequest(request, saveFolder,
	// maxSize, "UTF-8", new DefaultFileRenamePolicy());
	//		
	// if(!Util.isEmpty(multi.getFilesystemName("resume_path"))){
	// File resume = new File(multi.getFile("resume_path").getAbsolutePath());
	// File resumename = new
	// File(saveFolder2+multi.getFilesystemName("resume_path"));
	// if(resume.exists()){
	// resume.renameTo(resumename);
	// resume.delete();
	// }
	// }
	// if(!Util.isEmpty(multi.getParameter("birth_month"))){
	// String month = "01";
	// int _month = Integer.valueOf(multi.getParameter("birth_month"));
	// if(_month<10){
	// month = "0"+String.valueOf(_month);
	// }else{
	// month = String.valueOf(_month);
	// }
	// String birthday =
	// Util.changeNullStr(multi.getParameter("birth_year"))+month;
	// bean.setBirthday(birthday);
	// }
	// bean.setCertification(Util.changeNullStr(multi.getParameter("certification")));
	// bean.setCertification_open(Util.changeNullStr(multi.getParameter("certification_open")));
	// bean.setEmail1(Util.changeNullStr(multi.getParameter("email1")));
	// bean.setEmail2(Util.changeNullStr(multi.getParameter("email2")));
	// bean.setIntroduction(Util.changeNullStr(multi.getParameter("introduction")));
	// bean.setIntroduction_open(Util.changeNullStr(multi.getParameter("introduction_open")));
	//		
	// String language1 = Util.changeNullStr(multi.getParameter("language1"));
	// String language2 = Util.changeNullStr(multi.getParameter("language2"));
	// String language3 = Util.changeNullStr(multi.getParameter("language3"));
	// String language = language1+language2+language3;
	// bean.setLanguage(language);
	// bean.setLanguage_etc(Util.changeNullStr(multi.getParameter("language_etc")));
	// bean.setName_open(Util.changeNullStr(multi.getParameter("name_open")));
	// bean.setNation(Util.changeNullStr(multi.getParameter("nation")));
	// bean.setNation_etc(Util.changeNullStr(multi.getParameter("nation_etc")));
	// bean.setNation_no(Util.changeNullStr(multi.getParameter("nation_no")));
	// bean.setPay(Util.changeNullStr(multi.getParameter("pay")));
	// bean.setPay_unit(Util.changeNullStr(multi.getParameter("pay_unit")));
	// bean.setPay_unit_etc(Util.changeNullStr(multi.getParameter("pay_unit_etc")));
	// bean.setPhoto(Util.changeNullStr(multi.getFilesystemName("photo_path")));
	// bean.setPhoto_path_open(Util.changeNullStr(multi.getParameter("photo_path_open")));
	// bean.setResume(Util.changeNullStr(multi.getFilesystemName("resume_path")));
	// bean.setResume_path_open(Util.changeNullStr(multi.getParameter("resume_path_open")));
	// bean.setService_area_1(Util.changeNullStr(multi.getParameter("service_area_1")));
	// bean.setService_area_2(Util.changeNullStr(multi.getParameter("service_area_2")));
	// bean.setService_area_1_etc(Util.changeNullStr(multi.getParameter("service_area_1_etc")));
	// bean.setService_day(Util.changeNullStr(multi.getParameter("service_day")));
	// bean.setService_day_open(Util.changeNullStr(multi.getParameter("service_day_open")));
	// bean.setEtc(Util.changeNullStr(multi.getParameter("etc")));
	// bean.setEtc_open(Util.changeNullStr(multi.getParameter("etc_open")));
	// bean.setSex(Util.changeNullStr(multi.getParameter("sex")));
	// bean.setSkill(Util.changeNullStr(multi.getParameter("skill")));
	// bean.setSkill_open(Util.changeNullStr(multi.getParameter("skill_open")));
	//		
	// String tel1 = Util.changeNullStr(multi.getParameter("tel1"));
	// String tel2 = Util.changeNullStr(multi.getParameter("tel2"));
	// String tel3 = Util.changeNullStr(multi.getParameter("tel3"));
	// String tell = tel1+"-"+tel2+"-"+tel3;
	// if(!Util.isEmpty(tel1)){
	// bean.setTel_no_1(tell);
	// }else{
	// bean.setTel_no_1("");
	// }
	// bean.setTel_no_1_open(Util.changeNullStr(multi.getParameter("tel_no_1_open")));
	//
	// String mobile1 = Util.changeNullStr(multi.getParameter("mobile1"));
	// String mobile2 = Util.changeNullStr(multi.getParameter("mobile2"));
	// String mobile3 = Util.changeNullStr(multi.getParameter("mobile3"));
	// String mobile = mobile1+"-"+mobile2+"-"+mobile3;
	// if(!Util.isEmpty(mobile1)){
	// bean.setTel_no_2(mobile);
	// }else{
	// bean.setTel_no_2("");
	// }
	// bean.setTel_no_2_open(Util.changeNullStr(multi.getParameter("tel_no_2_open")));
	//		
	// bean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
	// bean.setUser_name(Util.changeNullStr(multi.getParameter("user_name")));
	// bean.setPassword(Util.changeNullStr(multi.getParameter("password")));
	// return bean;
	// }
}