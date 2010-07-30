/*
 * Created on 2006. 7. 5.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package stock;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.StockBean;
import common.exception.AppException;
import common.database.DBConnectionMgr;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class AnalizeStock {
	/*
	 */
	public Map getStockList(int limitCount, int beforeday) {
		// limitCount = 5;
		Map map = new HashMap();

		Connection con;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();


			String result = "";

			stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append(" select code, ");// 1
			sql.append(" Cast(replace(endprice, ',', '') as UNSIGNED), ");// 2
			sql.append(" compareyest, ");// 3
			sql.append(" Cast(replace(startprice, ',', '') as UNSIGNED), ");// 4
			sql.append(" Cast(replace(highprice, ',', '') as UNSIGNED), ");// 5
			sql.append(" Cast(replace(lowprice, ',', '') as UNSIGNED), ");// 6
			sql.append(" Cast(replace(highprice, ',', '') as UNSIGNED)- ");
			sql
					.append(" Cast(replace(endprice, ',', '') as UNSIGNED) as highend, ");// 7
			sql.append(" Cast(replace(endprice, ',', '') as UNSIGNED)- ");
			sql
					.append(" Cast(replace(lowprice, ',', '') as UNSIGNED) as endlow, ");// 8
			sql.append(" DATE_FORMAT(stockdate, '%y%m%d') as stockdate ");// 9
			sql.append(" from stockinfo ");			
			sql.append(" where (DATE_SUB(now(), INTERVAL " + (beforeday + 10) + " DAY) <= stockdate and stockdate <= DATE_SUB(now(), INTERVAL " + beforeday + " DAY)) ");
			sql.append(" order by code , stockdate desc");
			//System.out.println("" + sql.toString());
			rs = stmt.executeQuery(sql.toString());
			String nowCode = "";
			String beforeCode = "";
			List oldList = new ArrayList();
			List newList = new ArrayList();
			BigDecimal average = new BigDecimal(0);
			BigDecimal totalAmount = new BigDecimal(0);
			int count = 0;
			while (rs.next()) {

				StockBean bean = new StockBean();
				// if ("".equals(nowCode) && "".equals(beforeCode)) {
				// nowCode = rs.getString(1);
				// } else if ("".equals(nowCode)) {
				//						
				// }
				nowCode = rs.getString(1);
				// if (!"".equals(beforeCode) && !nowCode.equals(beforeCode)) {
				if (!"".equals(beforeCode) && !nowCode.equals(beforeCode)) {
					// if (oldList.size() == 0) {
					// beforeCode = nowCode;
					// }
					// if (oldList.size() != 0) {
					// map.put(beforeCode, oldList);
					//
					// } else {
					StockBean tempBean = (StockBean) newList.get(0);
					tempBean.setAverage(totalAmount.divide(
							new BigDecimal(newList.size()),
							BigDecimal.ROUND_HALF_UP).toString());
					// newList.add(0, tempBean);
					map.put(beforeCode, newList);
					totalAmount = new BigDecimal(0);
					oldList = newList;
					// }
					oldList = newList;
					newList = new ArrayList();
					count = 0;
					// beforeCode = nowCode;
				} else if (!"".equals(beforeCode) && nowCode.equals(beforeCode)) {
					count++;
				}
				// if (count < 4 || !nowCode.equals(beforeCode)) {
				if (count < limitCount) {
					bean.setCode(rs.getString(1));
					bean.setEndPrice(rs.getString(2));
					totalAmount = totalAmount.add(new BigDecimal(rs
							.getString(2)));
					bean.setCompareYest(rs.getString(3));
					bean.setStartPrice(rs.getString(4));
					bean.setHighPrice(rs.getString(5));
					bean.setLowPrice(rs.getString(6));
					bean.setStockDate(rs.getString(9));
					newList.add(bean);
				}

				beforeCode = nowCode;
			}
			StockBean tempBean = (StockBean) newList.get(0);
			tempBean.setAverage(totalAmount.divide(
					new BigDecimal(newList.size()), BigDecimal.ROUND_HALF_UP)
					.toString());
			// newList.add(0, tempBean);
			totalAmount = new BigDecimal(0);
			map.put(beforeCode, newList);
		} catch (AppException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return map;
	}

	public String makeStockInfoBody() {

		StringBuffer sb = new StringBuffer();
		// getHeader(sb);
		// getJspBody(sb, codeNo);
		// getFooter(sb);
		// fileWrite(fileName, sb.toString());
		return "";
	}
	/**
	 * 
	 * @param i
	 * @param continueDays 
	 * @param limitCount analizedaycount
	 * @param benefits 
	 * @param userfulMoneys
	 * @return
	 */
	public String getUsefulStockMap(int i, int continueDays, int limitCount,
			String benefits, String userfulMoneys) {
		BigDecimal benifit = new BigDecimal(benefits);
		BigDecimal userfulMoney = new BigDecimal(userfulMoneys);
		int beforeday = 0; 
		Map map = getStockList(limitCount, beforeday);

		Set set = map.keySet();
		Iterator it = set.iterator();
		Map newMap = new HashMap();
		while (it.hasNext()) {
			String code = (String) it.next();
			// System.out.println("code =" + code);
			List list = (List) map.get(code);
			Iterator itList = list.iterator();
			BigDecimal danyiKabu = new BigDecimal(100);
			BigDecimal[] finalPrice = new BigDecimal[continueDays + 2];
			BigDecimal[] lowPrice = new BigDecimal[continueDays + 2];
			int count = 0;
			while (itList.hasNext()) {
				if (count > continueDays) {
					break;
				}
				StockBean bean = (StockBean) itList.next();
				try {
					finalPrice[count] = new BigDecimal(bean.getEndPrice());
					lowPrice[count] = new BigDecimal(bean.getLowPrice());
				} catch (Exception e) {
					e.printStackTrace();
				}

				count++;
				// System.out.println(code + "=" + bean.getEndPrice());
				// System.out.println(bean.getEndPrice());
			}
			// System.out.println("finalPrice[0]=" + finalPrice[0] + ",
			// finalPrice[1]=" + finalPrice[1]+ ", finalPrice[2]=" +
			// finalPrice[2]+ ", finalPrice[3]=" + finalPrice[3]);
			// System.out.println("lowPrice[0]=" + lowPrice[0] + ",
			// lowPrice[1]=" + lowPrice[1]+ ", lowPrice[2]=" + lowPrice[2]+ ",
			// lowPrice[3]=" + lowPrice[3]);
			if (i == 3) {
				try {
					boolean noCondition = false;
					for (int j = 0; j < continueDays; j++) {
						if ((finalPrice[j + 1].subtract(finalPrice[j])
								.compareTo(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING)) != 1)
								|| (finalPrice[j + 1].subtract(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING))
										.compareTo(lowPrice[j]) != 1)) {
							noCondition = true;
							break;
						}
					}
					if (!noCondition) {
						newMap.put(code, map.get(code));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (i == 1) {
				try {
					boolean noCondition = false;
					for (int j = 0; j < continueDays; j++) {
						if ((finalPrice[j].subtract(finalPrice[j + 1])
								.compareTo(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING)) != 1)
								|| (finalPrice[j].subtract(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING))
										.compareTo(lowPrice[j + 1]) != 1)) {
							noCondition = true;
							break;
						}
					}
					if (!noCondition) {
						newMap.put(code, map.get(code));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// if ((finalPrice[0].subtract(finalPrice[1]).compareTo(
				// benifit.divide(danyiKabu, BigDecimal.ROUND_CEILING)) == 1)
				// && (finalPrice[1].subtract(finalPrice[2])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1)
				// && (finalPrice[0]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[0]) == 1)
				// && (finalPrice[1]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[1]) == 1)) {
				// newMap.put(code, map.get(code));
				// System.out.println(finalPrice[0]
				// + "-"
				// + finalPrice[1]
				// + ">"
				// + benifit
				// + "/"
				// + danyiKabu
				// + "and "
				// + (finalPrice[0].subtract(finalPrice[1])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1));
				// System.out.println(finalPrice[1]
				// + "-"
				// + finalPrice[2]
				// + ">"
				// + benifit
				// + "/"
				// + danyiKabu
				// + "and "
				// + (finalPrice[1].subtract(finalPrice[2])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1));
				// System.out.println(finalPrice[0]
				// + "-"
				// + benifit
				// + "/"
				// + danyiKabu
				// + ">"
				// + lowPrice[0]
				// + "and "
				// + (finalPrice[0]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[0]) == 1));
				// System.out.println(finalPrice[1]
				// + "-"
				// + benifit
				// + "/"
				// + danyiKabu
				// + ">"
				// + lowPrice[1]
				// + "="
				// + (finalPrice[1]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[1]) == 1));
				// //System.out.println("newMap put=" + code);
				// }
			}

			// if ((finalPrice[1].subtract(finalPrice[0]).compareTo(
			// benifit.divide(danyiKabu, BigDecimal.ROUND_CEILING)) == 1)
			// && (finalPrice[2].subtract(finalPrice[1])
			// .compareTo(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING)) == 1)
			// && (finalPrice[2]
			// .subtract(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING))
			// .compareTo(lowPrice[1]) == 1)
			// && (finalPrice[1]
			// .subtract(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING))
			// .compareTo(lowPrice[0]) == 1)) {
			// newMap.put(code, map.get(code));
			// System.out.println("newMap put=" + code);
			// }
		}

		// return getJspBody(map);
		if (i == 1 || i == 3) {
			return getJspBody(newMap);
		} else if (i == 2) {
			return getJspBody(map);
		} else {
			return getJspBody(map);
		}

	}

	/**
	 * 
	 * @param i
	 * @param continueDays 
	 * @param limitCount analizedaycount
	 * @param benefits 
	 * @param userfulMoneys
	 * @return
	 */
	public Map getUsefulStockMapNew(int i, int beforeday, int continueDays, int limitCount,
			String benefits, String userfulMoneys) {
		BigDecimal benifit = new BigDecimal(benefits);
		BigDecimal userfulMoney = new BigDecimal(userfulMoneys);
		Map map = getStockList(limitCount, beforeday);

		Set set = map.keySet();
		Iterator it = set.iterator();
		Map newMap = new HashMap();
		while (it.hasNext()) {
			String code = (String) it.next();
			// System.out.println("code =" + code);
			List list = (List) map.get(code);
			Iterator itList = list.iterator();
			BigDecimal danyiKabu = new BigDecimal(100);
			BigDecimal[] finalPrice = new BigDecimal[continueDays + 2];
			BigDecimal[] lowPrice = new BigDecimal[continueDays + 2];
			int count = 0;
			while (itList.hasNext()) {
				if (count > continueDays) {
					break;
				}
				StockBean bean = (StockBean) itList.next();
				try {
					finalPrice[count] = new BigDecimal(bean.getEndPrice());
					lowPrice[count] = new BigDecimal(bean.getLowPrice());
				} catch (Exception e) {
					e.printStackTrace();
				}

				count++;
				// System.out.println(code + "=" + bean.getEndPrice());
				// System.out.println(bean.getEndPrice());
			}
			// System.out.println("finalPrice[0]=" + finalPrice[0] + ",
			// finalPrice[1]=" + finalPrice[1]+ ", finalPrice[2]=" +
			// finalPrice[2]+ ", finalPrice[3]=" + finalPrice[3]);
			// System.out.println("lowPrice[0]=" + lowPrice[0] + ",
			// lowPrice[1]=" + lowPrice[1]+ ", lowPrice[2]=" + lowPrice[2]+ ",
			// lowPrice[3]=" + lowPrice[3]);
			if (i == 3) {
				try {
					boolean noCondition = false;
					for (int j = 0; j < continueDays; j++) {
						if ((finalPrice[j + 1].subtract(finalPrice[j])
								.compareTo(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING)) != 1)
								|| (finalPrice[j + 1].subtract(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING))
										.compareTo(lowPrice[j]) != 1)) {
							noCondition = true;
							break;
						}
					}
					if (!noCondition) {
						newMap.put(code, map.get(code));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (i == 1) {
				try {
					boolean noCondition = false;
					for (int j = 0; j < continueDays; j++) {
						if ((finalPrice[j].subtract(finalPrice[j + 1])
								.compareTo(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING)) != 1)
								|| (finalPrice[j].subtract(
										benifit.divide(danyiKabu,
												BigDecimal.ROUND_CEILING))
										.compareTo(lowPrice[j + 1]) != 1)) {
							noCondition = true;
							break;
						}
					}
					if (!noCondition) {
						newMap.put(code, map.get(code));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// if ((finalPrice[0].subtract(finalPrice[1]).compareTo(
				// benifit.divide(danyiKabu, BigDecimal.ROUND_CEILING)) == 1)
				// && (finalPrice[1].subtract(finalPrice[2])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1)
				// && (finalPrice[0]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[0]) == 1)
				// && (finalPrice[1]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[1]) == 1)) {
				// newMap.put(code, map.get(code));
				// System.out.println(finalPrice[0]
				// + "-"
				// + finalPrice[1]
				// + ">"
				// + benifit
				// + "/"
				// + danyiKabu
				// + "and "
				// + (finalPrice[0].subtract(finalPrice[1])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1));
				// System.out.println(finalPrice[1]
				// + "-"
				// + finalPrice[2]
				// + ">"
				// + benifit
				// + "/"
				// + danyiKabu
				// + "and "
				// + (finalPrice[1].subtract(finalPrice[2])
				// .compareTo(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING)) == 1));
				// System.out.println(finalPrice[0]
				// + "-"
				// + benifit
				// + "/"
				// + danyiKabu
				// + ">"
				// + lowPrice[0]
				// + "and "
				// + (finalPrice[0]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[0]) == 1));
				// System.out.println(finalPrice[1]
				// + "-"
				// + benifit
				// + "/"
				// + danyiKabu
				// + ">"
				// + lowPrice[1]
				// + "="
				// + (finalPrice[1]
				// .subtract(
				// benifit.divide(danyiKabu,
				// BigDecimal.ROUND_CEILING))
				// .compareTo(lowPrice[1]) == 1));
				// //System.out.println("newMap put=" + code);
				// }
			}

			// if ((finalPrice[1].subtract(finalPrice[0]).compareTo(
			// benifit.divide(danyiKabu, BigDecimal.ROUND_CEILING)) == 1)
			// && (finalPrice[2].subtract(finalPrice[1])
			// .compareTo(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING)) == 1)
			// && (finalPrice[2]
			// .subtract(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING))
			// .compareTo(lowPrice[1]) == 1)
			// && (finalPrice[1]
			// .subtract(
			// benifit.divide(danyiKabu,
			// BigDecimal.ROUND_CEILING))
			// .compareTo(lowPrice[0]) == 1)) {
			// newMap.put(code, map.get(code));
			// System.out.println("newMap put=" + code);
			// }
		}

		return newMap;

	}
	/*
	 * 
	 */
	public String getJspBody(Map map) {
		StringBuffer sb = new StringBuffer();
		Set set = map.keySet();
		Iterator it = set.iterator();
		sb.append("<TR>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("code");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("endPrice");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("compareYest");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		// sb.append("<TD>");
		// sb.append("\n\r");
		// sb.append("sell");
		// sb.append("\n\r");
		// sb.append("</TD>");
		// sb.append("\n\r");
		//		
		// sb.append("<TD>");
		// sb.append("\n\r");
		// sb.append("buy");
		// sb.append("\n\r");
		// sb.append("</TD>");
		// sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("startPrice");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("highPrice");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("lowPrice");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("average");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("<TD><font face='Comic Sans MS' size=2 color=#800000>");
		sb.append("\n\r");
		sb.append("stock date");
		sb.append("\n\r");
		sb.append("</font></TD>");
		sb.append("\n\r");

		sb.append("</TR>");
		while (it.hasNext()) {
			String code = (String) it.next();
			List list = (List) map.get(code);
			Iterator itList = list.iterator();
			boolean isFirst = true;
			while (itList.hasNext()) {
				StockBean bean = (StockBean) itList.next();
				if (isFirst) {
					isFirst = false;
					sb.append("<TR>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getCode());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getEndPrice());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getCompareYest());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getStartPrice());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getHighPrice());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getLowPrice());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getAverage());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");

					sb
							.append("<TD><font face='Comic Sans MS' size=1 color=#0000CD>");
					sb.append("\n\r");
					sb.append(bean.getStockDate());
					sb.append("\n\r");
					sb.append("</font></TD>");
					sb.append("\n\r");
					sb.append("</TR>");
				} else {
					sb.append("<TR>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getCode());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getEndPrice());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getCompareYest());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getStartPrice());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getHighPrice());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getLowPrice());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getAverage());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");

					sb.append("<TD>");
					sb.append("\n\r");
					sb.append(bean.getStockDate());
					sb.append("\n\r");
					sb.append("</TD>");
					sb.append("\n\r");
					sb.append("</TR>");
				}

			}
		}
		return sb.toString();
	}
	public boolean insertStockBean(StockBean bean) {
		Connection con = null;
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			con = DBConnectionMgr.getInstance().getConnection();


			
			//StringBuffer sql = new StringBuffer();
			String strsqr = "insert into newstockinfo(" +
					"code, endprice, compareyest, sell, buy, " +
					"startprice, highprice, lowprice, stockdate)"+
	        "values(" +
	        "?,?,?,?,?," +
	        "?,?,?,?)";
	        

			stmt = con.prepareStatement(strsqr);
			stmt.setString(1, bean.getCode());
			stmt.setString(2, bean.getEndPrice());
			stmt.setString(3, bean.getCompareYest());
			stmt.setString(4, bean.getSell());
			stmt.setString(5, bean.getBuy());
			stmt.setString(6, bean.getStartPrice());
			stmt.setString(7, bean.getHighPrice());
			stmt.setString(8, bean.getLowPrice());
			stmt.setString(9, bean.getStockDate());

			//System.out.println("getStockList() sql=" + sql.toString());
			//stmt = con.prepareStatement(strsqr);
			int count = stmt.executeUpdate();
			if (count == 1) {
				result = true;
			}
		} catch (AppException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		return result;
	}
	
	public double getPercent(Map before, Map after){
		double totalCount = before.size();
		double count = 0;
		Set set = before.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String tempCode = (String)it.next();
			if (after.containsKey(tempCode)) {
				count++;
			}
		}
		double result = 0;
		if (count != 0) {
			result = count/totalCount * 100;
		}
			
		System.out.println("totalCount=" + totalCount + ", count=" + count + ",result=" + result);
		return result;
	}
}