package common.category;

import common.exception.SysException;

public class Test {

	/**
	 * @param args
	 * @throws SysException 
	 */
	public static void main(String[] args) throws SysException {
//		Category root = new Category("ROOT","");
//		
//		Category subRoot1 = new Category("���{��","");
//		Category subRoot2 = new Category("������","");
//		Category subRoot3 = new Category("�؍���","");
//		
//		Category subRoot1_1 = new Category("����","");
//		BookMark subRoot1_2 = new BookMark("����","");
//		BookMark subRoot1_3 = new BookMark("����","");
//		
//		BookMark subRoot1_1_1 = new BookMark("�`�e��","");
//		BookMark subRoot1_1_2 = new BookMark("����","");
//		BookMark subRoot1_1_3 = new BookMark("����","");
//		
//		subRoot1_1.addBookMark(subRoot1_1_1);
//		subRoot1_1.addBookMark(subRoot1_1_2);
//		subRoot1_1.addBookMark(subRoot1_1_3);
//		
//		subRoot1.addCategory(subRoot1_1);
//		subRoot1.addBookMark(subRoot1_2);
//		subRoot1.addBookMark(subRoot1_3);
//		
//		root.addCategory(subRoot1);
//		root.addCategory(subRoot2);
//		root.addCategory(subRoot3);
//		root.rootSet();
//		System.out.println(CategoryUtil.makeHtml(root));
//		
		//System.out.println(CategoryUtil.codeFormat("00", 4));
		//System.out.println(root.makeHtml());
//		CategoryUtil.insertCategory("sallamang", "0001", "test1");
//		CategoryUtil.insertCategory("sallamang", "0001", "test2");
//		CategoryUtil.insertCategory("sallamang", "0001", "test3");
//		CategoryUtil.insertCategory("sallamang", "0015", "test4");
//		CategoryUtil.insertCategory("sallamang", "0016", "test5");
//		CategoryUtil.insertCategory("sallamang", "0017", "test6");
		
		CategoryUtil.insertCategory("sallamang", "0015", "newCategory1");

	}

}
