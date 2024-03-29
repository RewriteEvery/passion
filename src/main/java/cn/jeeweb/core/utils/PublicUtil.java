package cn.jeeweb.core.utils;

import java.util.Date;

/**
 * 公共方法
 * 
 * @author key
 *
 */
public class PublicUtil {
	/**
	 * 表格一般通用字段createDate,createBy,createName updateDate,updateBy,updateName
	 * 
	 * @param obj
	 * @param isUpdate
	 */
	public static void setCommonForTable(Object obj, boolean isCreate) {
		ReflectHelper reflectHelper = new ReflectHelper(obj);
		if (isCreate) {
			reflectHelper.setMethodValue("createDate", new Date());
			//reflectHelper.setMethodValue("createBy", ResourceUtil.getSessionUserName().getId());
			//reflectHelper.setMethodValue("createName", ResourceUtil.getSessionUserName().getUserName());
		}
		reflectHelper.setMethodValue("updateDate", new Date());
		//reflectHelper.setMethodValue("updateBy", ResourceUtil.getSessionUserName().getId());
		//reflectHelper.setMethodValue("updateName", ResourceUtil.getSessionUserName().getUserName());
	}

	/**
	 * 设置checkbox的值 -- Y/N
	 * 
	 * @param obj
	 * @param params
	 *            以逗号隔开 "isNull,isShow,isQuery,isKey"
	 */
	public static void judgeCheckboxValue(Object obj, String params) {
		ReflectHelper reflectHelper = new ReflectHelper(obj);
		String[] paramsArr = params.split(",");
		for (int i = 0; i < paramsArr.length; i++) {
			String checked = "N";
			if (reflectHelper.getMethodValue(paramsArr[i]) != null
					&& !"N".equalsIgnoreCase((String) reflectHelper.getMethodValue(paramsArr[i]))) {
				checked = "Y";
			}
			reflectHelper.setMethodValue(paramsArr[i], checked);
		}

	}

	/**
	 * 对比值是否相同 return true(相同) false(不同)
	 */
	public static boolean compareValue(Object oldvalue, Object newvalue) {
		if (oldvalue == null) {
			if (newvalue != null) {
				return false;
			}
		} else {
			if (newvalue == null) {
				return false;
			} else {
				if (!oldvalue.equals(newvalue)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 通过sql获取表名
	 * 
	 * @param s
	 * @return
	 */
	public static String getTableName(String s) {
		s = s.substring(s.indexOf("from") + 4);
		if (s.indexOf("where") > 1) {
			s = s.substring(0, s.indexOf("where"));
		}
		return s.trim();
	}
}
