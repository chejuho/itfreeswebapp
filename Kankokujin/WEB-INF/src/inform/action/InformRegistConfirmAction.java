package inform.action;

import interpret.bean.InterpretBean;
import interpret.handler.InterpretRegistHandler;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.handler.MemberRegistHandler;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InformRegistConfirmAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KankokujinLogger.getInstance().debug(
				"InterpretRegistConfirmAction.start");
		InterpretBean interpretBean = new InterpretBean();
		HttpSession session = request.getSession();
		boolean result = false;
		boolean userIdMatch = false;
		boolean registCheck = false;
		String ContentId = "";
		InterpretRegistHandler interpretRegistHandler = new InterpretRegistHandler();
		MemberRegistHandler handler = new MemberRegistHandler();
		try {

			interpretBean = setInterpretBean(interpretBean, request);
		} catch (AppException e) {
			throw new KankokujinException(
					"InterpretRegistConfirmAction.service.Exception", e);
		} catch (Exception e) {
			throw new KankokujinException(
					"InterpretRegistConfirmAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug(
					"InterpretRegistConfirmAction.end");
		}
		if (!Util.isEmpty(interpretBean.getPassword())) {
			try {
				result = handler.isExistIdMail(interpretBean.getUser_id(),
						interpretBean.getEmail1(), interpretBean.getEmail2());
			} catch (SysException e) {
				throw new KankokujinException(
						"InterpretRegistConfirmAction.service.Exception", e);
			} catch (Exception e) {
				throw new KankokujinException(
						"SYE0009", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InterpretRegistConfirmAction.end");
			}
			if (!result) {
				try {
					userIdMatch = handler.userMatch(interpretBean.getUser_id(),
							interpretBean.getEmail1(), interpretBean
									.getEmail2());
				} catch (AppException e) {
					throw new KankokujinException(
							"InterpretRegistConfirmAction.service.Exception", e);
				} catch (Exception e) {
					throw new KankokujinException(
							"InterpretRegistConfirmAction.service.Exception", e);
				} finally {
					KankokujinLogger.getInstance().debug(
							"InterpretRegistConfirmAction.end");
				}
				if (userIdMatch) {
					try {
						registCheck = interpretRegistHandler
								.registCheck(interpretBean.getUser_id());
					} catch (AppException e) {
						throw new KankokujinException(
								"InterpretRegistConfirmAction.service.Exception",
								e);
					} catch (Exception e) {
						throw new KankokujinException(
								"InterpretRegistConfirmAction.service.Exception",
								e);
					} finally {
						KankokujinLogger.getInstance().debug(
								"InterpretRegistConfirmAction.end");
					}
					if (!registCheck) {
						try {
							ContentId = interpretRegistHandler
									.getContentId(interpretBean.getUser_id());
						} catch (AppException e) {
							throw new KankokujinException(
									"InterpretRegistConfirmAction.service.Exception",
									e);
						} catch (Exception e) {
							throw new KankokujinException(
									"InterpretRegistConfirmAction.service.Exception",
									e);
						} finally {
							KankokujinLogger.getInstance().debug(
									"InterpretRegistConfirmAction.end");
						}
						request.setAttribute("Message", "MSG0003");
						session.setAttribute("InterpretBean", null);
						request.setAttribute("ContentId", ContentId);
						this.getServletContext().getRequestDispatcher(
								"/InterpretDetail?id=" + ContentId).forward(
								request, response);
					} else {
						request.setAttribute("Message", "MSG0013");
						session.setAttribute("InterpretBean", null);
						this.getServletContext().getRequestDispatcher(
								"/InterpretRegistOpen").forward(request,
								response);
					}
				} else {
					request.setAttribute("Message", "WAR0002");
					session.setAttribute("InterpretBean", interpretBean);
					this.getServletContext().getRequestDispatcher(
							"/InterpretRegistOpen").forward(request, response);
				}
			} else {
				session.setAttribute("InterpretBean", interpretBean);
				this.getServletContext().getRequestDispatcher(
						"/jsp/interpret/interpretRegistConfirm.jsp").forward(
						request, response);
			}
		} else {
			try {
				registCheck = interpretRegistHandler.registCheck(interpretBean
						.getUser_id());
			} catch (AppException e) {
				throw new KankokujinException(
						"InterpretRegistConfirmAction.service.Exception", e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InterpretRegistConfirmAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InterpretRegistConfirmAction.end");
			}
			if (!registCheck) {
				try {
					ContentId = interpretRegistHandler
							.getContentId(interpretBean.getUser_id());
				} catch (AppException e) {
					throw new KankokujinException(
							"InterpretRegistConfirmAction.service.Exception", e);
				} catch (Exception e) {
					throw new KankokujinException(
							"InterpretRegistConfirmAction.service.Exception", e);
				} finally {
					KankokujinLogger.getInstance().debug(
							"InterpretRegistConfirmAction.end");
				}
				request.setAttribute("Message", "MSG0003");
				session.setAttribute("InterpretBean", null);
				request.setAttribute("ContentId", ContentId);
				this.getServletContext().getRequestDispatcher(
						"/InterpretDetail?id=" + ContentId).forward(request,
						response);
			} else {
				session.setAttribute("InterpretBean", interpretBean);
				this.getServletContext().getRequestDispatcher(
						"/jsp/interpret/interpretRegistConfirm.jsp").forward(
						request, response);
			}
		}
	}

	private InterpretBean setInterpretBean(InterpretBean bean,
			HttpServletRequest request) throws ServletException, IOException,
			AppException {
		KankokujinLogger.getInstance().debug(
				"InterpretRegistConfirmAction.setInterpretBean.start");
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		String saveFolder2 = Const.DOWNLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());

		bean.setId(Util.changeNullStr(multi.getParameter("id")));
		bean.setUser_id(Util.changeNullStr(multi.getParameter("userid")));
		bean.setUser_name(Util.changeNullStr(multi.getParameter("user_name")));
		bean.setPassword(Util.changeNullStr(multi.getParameter("password")));
		bean.setEmail1(Util.changeNullStr(multi.getParameter("email1")));
		bean.setEmail2(Util.changeNullStr(multi.getParameter("email2")));

		if (!Util.isEmpty(multi.getFilesystemName("resume_path"))) {
			File resume = new File(multi.getFile("resume_path")
					.getAbsolutePath());
			File resumename = new File(saveFolder2
					+ multi.getFilesystemName("resume_path"));
			if (resume.exists()) {
				resume.renameTo(resumename);
				resume.delete();
			}
		}
		String birthday = "";
		if (!Util.isEmpty(multi.getParameter("birth_month"))) {
			String month = "01";
			int _month = Integer.valueOf(multi.getParameter("birth_month"));
			if (_month < 10) {
				month = "0" + String.valueOf(_month);
			} else {
				month = String.valueOf(_month);
			}
			birthday = Util.changeNullStr(multi.getParameter("birth_year"))
					+ month;

			String year = birthday.substring(0, 4);
			bean.setYear(year);
			month = birthday.substring(4);
			bean.setMonth(month);
			bean.setBirthday(birthday);
			String age = Util.getKoreanAge(bean.getBirthday());
			bean.setAge(age);
		}

		bean.setCertification(Util.changeNullStr(multi
				.getParameter("certification")));
		bean.setCertification_open(Util.changeNullStr(multi
				.getParameter("certification_open")));
		bean.setIntroduction(Util.changeNullStr(multi
				.getParameter("introduction")));
		bean.setIntroduction_open(Util.changeNullStr(multi
				.getParameter("introduction_open")));

		String language1 = Util.changeNullStr(multi.getParameter("language1"));
		String language2 = Util.changeNullStr(multi.getParameter("language2"));
		String language3 = Util.changeNullStr(multi.getParameter("language3"));
		String language = language1 + language2 + language3;
		bean.setLanguage(language);
		String sign = "/";
		language = Util.changeData(request, language, sign);
		bean.setLanguage_name(language);

		bean.setLanguage_etc(Util.changeNullStr(multi
				.getParameter("language_etc")));
		bean.setName_open(Util.changeNullStr(multi.getParameter("name_open")));

		String nationNo = Util.changeNullStr(multi.getParameter("nation"));
		bean.setNation(nationNo);
		bean.setNation_name(Util.changeNation(request, nationNo));

		bean
				.setNation_etc(Util.changeNullStr(multi
						.getParameter("nation_etc")));
		bean.setNation_no(Util.changeNullStr(multi.getParameter("nation_no")));
		bean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		String pay_unit = Util.changeNullStr(multi.getParameter("pay_unit"));
		bean.setPay_unit(pay_unit);
		bean.setPay_unit_name(Util.changePayUnit(request, pay_unit));
		bean.setPay_unit_etc(Util.changeNullStr(multi
				.getParameter("pay_unit_etc")));
		bean
				.setPhoto(Util.changeNullStr(multi
						.getFilesystemName("photo_path")));
		bean.setPhoto_path_open(Util.changeNullStr(multi
				.getParameter("photo_path_open")));
		bean.setPhoto_path(Util.getSecurityInfo(bean.getPhoto(), bean
				.getPhoto_path_open()));
		bean.setResume(Util.changeNullStr(multi
				.getFilesystemName("resume_path")));
		bean.setResume_path_open(Util.changeNullStr(multi
				.getParameter("resume_path_open")));

		String service_area_1 = Util.changeNullStr(multi
				.getParameter("service_area_1"));
		bean.setService_area_1(service_area_1);
		bean.setService_area_1_name(Util.changeNation(request,
				service_area_1));

		bean.setService_area_2(Util.changeNullStr(multi
				.getParameter("service_area_2")));
		bean.setService_area_1_etc(Util.changeNullStr(multi
				.getParameter("service_area_1_etc")));
		bean.setService_day(Util.changeNullStr(multi
				.getParameter("service_day")));
		bean.setService_day_open(Util.changeNullStr(multi
				.getParameter("service_day_open")));
		bean.setEtc(Util.changeNullStr(multi.getParameter("etc")));
		bean.setEtc_open(Util.changeNullStr(multi.getParameter("etc_open")));

		String sexNo = Util.changeNullStr(multi.getParameter("sex"));
		bean.setSex(sexNo);
		bean.setSex_name(Util.changeSex(request, sexNo));
		bean.setSkill(Util.changeNullStr(multi.getParameter("skill")));
		bean
				.setSkill_open(Util.changeNullStr(multi
						.getParameter("skill_open")));
		String tel1 = Util.changeNullStr(multi.getParameter("tel1"));
		String tel2 = Util.changeNullStr(multi.getParameter("tel2"));
		String tel3 = Util.changeNullStr(multi.getParameter("tel3"));
		String tell = tel1 + "-" + tel2 + "-" + tel3;
		if (!Util.isEmpty(tel1)) {
			bean.setTel_no_1(tell);
		} else {
			bean.setTel_no_1("");
		}
		bean.setTel_no_1_open(Util.changeNullStr(multi
				.getParameter("tel_no_1_open")));

		String mobile1 = Util.changeNullStr(multi.getParameter("mobile1"));
		String mobile2 = Util.changeNullStr(multi.getParameter("mobile2"));
		String mobile3 = Util.changeNullStr(multi.getParameter("mobile3"));
		String mobile = mobile1 + "-" + mobile2 + "-" + mobile3;
		if (!Util.isEmpty(mobile1)) {
			bean.setTel_no_2(mobile);
		} else {
			bean.setTel_no_2("");
		}
		bean.setTel_no_2_open(Util.changeNullStr(multi
				.getParameter("tel_no_2_open")));

		return bean;
	}
}
