package cn.jeeweb.modules.fund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import cn.jeeweb.core.common.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**   
 * @Title: 基金列表
 * @Description: 基金列表
 * @author key
 * @date 2018-05-13 12:47:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "tinfo_fund")
@DynamicUpdate(false)
@DynamicInsert(false)
@SuppressWarnings("serial")
public class Fund extends AbstractEntity<String> {

    /**主键*/
	private String id;
    /**基金名称*/
	private String fundName;
    /**基金代码*/
	private String fundCode;
    /**英文长名*/
	private String fundEnLongName;
    /**英文短名*/
	private String fundEnSortName;
    /**基金类型*/
	private String fundType;
    /**创建时间*/
	private Date createTime;
    /**更新时间*/
	private Date updateTime;
    /**行业*/
	private String industry;
	
	/**
	 * 获取  id
	 *@return: String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,length=32,scale=0)
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  fundName
	 *@return: String  基金名称
	 */
	@Column(name ="fund_name",nullable=false,length=150,scale=0)
	public String getFundName(){
		return this.fundName;
	}

	/**
	 * 设置  fundName
	 *@param: fundName  基金名称
	 */
	public void setFundName(String fundName){
		this.fundName = fundName;
	}
	/**
	 * 获取  fundCode
	 *@return: String  基金代码
	 */
	@Column(name ="fund_code",nullable=false,length=20,scale=0)
	public String getFundCode(){
		return this.fundCode;
	}

	/**
	 * 设置  fundCode
	 *@param: fundCode  基金代码
	 */
	public void setFundCode(String fundCode){
		this.fundCode = fundCode;
	}
	/**
	 * 获取  fundEnLongName
	 *@return: String  英文长名
	 */
	@Column(name ="fund_en_long_name",nullable=false,length=150,scale=0)
	public String getFundEnLongName(){
		return this.fundEnLongName;
	}

	/**
	 * 设置  fundEnLongName
	 *@param: fundEnLongName  英文长名
	 */
	public void setFundEnLongName(String fundEnLongName){
		this.fundEnLongName = fundEnLongName;
	}
	/**
	 * 获取  fundEnSortName
	 *@return: String  英文短名
	 */
	@Column(name ="fund_en_sort_name",nullable=false,length=30,scale=0)
	public String getFundEnSortName(){
		return this.fundEnSortName;
	}

	/**
	 * 设置  fundEnSortName
	 *@param: fundEnSortName  英文短名
	 */
	public void setFundEnSortName(String fundEnSortName){
		this.fundEnSortName = fundEnSortName;
	}
	/**
	 * 获取  fundType
	 *@return: String  基金类型
	 */
	@Column(name ="fund_type",nullable=true,length=30,scale=0)
	public String getFundType(){
		return this.fundType;
	}

	/**
	 * 设置  fundType
	 *@param: fundType  基金类型
	 */
	public void setFundType(String fundType){
		this.fundType = fundType;
	}
	/**
	 * 获取  createTime
	 *@return: Date  创建时间
	 */
	@Column(name ="create_time",nullable=false,length=20,scale=0)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 * 设置  createTime
	 *@param: createTime  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 * 获取  updateTime
	 *@return: Date  更新时间
	 */
	@Column(name ="update_time",nullable=false,length=20,scale=0)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 * 设置  updateTime
	 *@param: updateTime  更新时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 * 获取  industry
	 *@return: String  行业
	 */
	@Column(name ="industry",nullable=true,length=100,scale=0)
	public String getIndustry(){
		return this.industry;
	}

	/**
	 * 设置  industry
	 *@param: industry  行业
	 */
	public void setIndustry(String industry){
		this.industry = industry;
	}
}