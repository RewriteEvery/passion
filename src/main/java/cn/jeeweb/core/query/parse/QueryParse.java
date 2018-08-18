
package cn.jeeweb.core.query.parse;

import cn.jeeweb.core.query.data.Queryable;

/**
 * 动态拼 where、group by having
 * 
 * @author key
 *
 * @param <T>
 */
public interface QueryParse<T> {
	/**
	 * 解析查询条件
	 * 
	 * @param target
	 * @param queryable
	 */
	public void parseCondition(T target, Queryable queryable);

	/**
	 * 解析排序
	 * 
	 * @param target
	 * @param queryable
	 */
	public void parseSort(T target, Queryable queryable);

}
