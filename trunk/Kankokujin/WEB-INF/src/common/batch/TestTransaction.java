package common.batch;

import member.handler.MemberRegistHandler;

import common.bean.MemberBean;

public class TestTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MemberRegistHandler memberRegistHandler = new MemberRegistHandler();
		MemberBean memberBean1 = new MemberBean();
		memberBean1.setUserid("test1");		
		memberBean1.setEmail1("jjaekwan");
		memberBean1.setEmail2("hotmail.com");
//		MemberBean memberBean2 = new MemberBean();
//		memberBean2.setUserid("test2");
		
		try {
			memberRegistHandler.insert(memberBean1);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		

	}

}
