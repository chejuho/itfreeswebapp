package eigyoumail.action;

import interpret.bean.InterpretBean;
import interpret.handler.InterpretDetailHandler;
import interpret.handler.InterpretUpdateHandler;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class EigyouMailUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 権限チェック
		if (Util.isLogin(request)) {
			KankokujinLogger.getInstance().debug("InterpretUpdateAction.start");
			InterpretUpdateHandler interpretUpdateHandler = new InterpretUpdateHandler();
			InterpretBean interpretBean = new InterpretBean();
			InterpretDetailHandler interpretDetailHandler = new InterpretDetailHandler();
			boolean result = false;
			try {

				interpretBean = setInterpretBean(interpretBean, request);

				result = interpretUpdateHandler
						.updateInterpretBean(interpretBean);
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InterpretUpdateAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InterpretUpdateAction.end");
			}
			if (result) {
				try {

					interpretBean = interpretDetailHandler.getInterpretBean(
							request, interpretBean.getId());

				} catch (AppException e) {
					throw new KankokujinException(e.getMessage(), e);
				} catch (Exception e) {
					throw new KankokujinException(
							"InterpretUpdateAction.service.Exception", e);
				} finally {
					KankokujinLogger.getInstance().debug(
							"InterpretUpdateAction.end");
				}
				request.setAttribute("interpretBean", interpretBean);
				request.setAttribute("Message", "MSG0004");
				this.getServletContext().getRequestDispatcher(
						"/jsp/interpret/interpretDetail.jsp").forward(request,
						response);
			} else {
				throw new KankokujinException("ERR0004");
			}
		} else {
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher(Const.INDEX_PATH)
					.forward(request, response);
		}

	}

	private InterpretBean setInterpretBean(InterpretBean bean,
			HttpServletRequest request) throws ServletException, IOException {
		KankokujinLogger.getInstance().debug(
				"InterpretUpdateAction.setInterpretBean.start");
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		String saveFolder2 = Const.DOWNLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());

		bean.setId(Util.changeNullStr(multi.getParameter("id")));

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

		if (!Util.isEmpty(multi.getParameter("birth_month"))) {
			String month = "01";
			int _month = Integer.valueOf(multi.getParameter("birth_month"));
			if (_month < 10) {
				month = "0" + String.valueOf(_month);
			} else {
				month = String.valueOf(_month);
			}
			String birthday = Util.changeNullStr(multi
					.getParameter("birth_year"))
					+ month;
			bean.setBirthday(birthday);
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

		bean.setLanguage_etc(Util.changeNullStr(multi
				.getParameter("language_etc")));
		bean.setName_open(Util.changeNullStr(multi.getParameter("name_open")));
		bean.setNation(Util.changeNullStr(multi.getParameter("nation")));
		bean
				.setNation_etc(Util.changeNullStr(multi
						.getParameter("nation_etc")));
		bean.setNation_no(Util.changeNullStr(multi.getParameter("nation_no")));
		bean.setPay(Util.changeNullStr(multi.getParameter("pay")));
		bean.setPay_unit(Util.changeNullStr(multi.getParameter("pay_unit")));
		bean.setPay_unit_etc(Util.changeNullStr(multi
				.getParameter("pay_unit_etc")));
		bean
				.setPhoto(Util.changeNullStr(multi
						.getFilesystemName("photo_path")));
		bean.setPhoto_path_open(Util.changeNullStr(multi
				.getParameter("photo_path_open")));
		bean.setResume(Util.changeNullStr(multi
				.getFilesystemName("resume_path")));
		bean.setResume_path_open(Util.changeNullStr(multi
				.getParameter("resume_path_open")));
		bean.setService_area_1(Util.changeNullStr(multi
				.getParameter("service_area_1")));
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
		bean.setSex(Util.changeNullStr(multi.getParameter("sex")));
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
		bean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));

		return bean;
	}
}
