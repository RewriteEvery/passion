package cn.jeeweb.modules.fund.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;

import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.DateUtils;
import cn.jeeweb.modules.fund.entity.Fund;
import cn.jeeweb.modules.fund.service.IFundService;
import cn.jeeweb.modules.fund.service.impl.FundServiceImpl;
import cn.jeeweb.modules.sys.utils.URLConneUtils;
import freemarker.template.utility.DateUtil;

/**
 * @Title: 基金列表
 * @Description: 基金列表
 * @author key
 * @date 2018-05-13 12:47:02
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/fund/fund")
@RequiresPathPermission("fund:fund")
public class FundController extends BaseCRUDController<Fund, String> {
	@Autowired
	IFundService ifundService;
	
	@RequestMapping(value = "/fund", method = RequestMethod.GET)
	public String getFundList(HttpServletRequest request,
			HttpServletResponse response) {
		return display("fund/list");
	}

	@RequestMapping(value = "/updateFund", method = RequestMethod.POST)
	public String updateFund(HttpServletRequest request,
			HttpServletResponse response) {
		// http://fund.eastmoney.com/js/fundcode_search.js
		// 基金api获取连接
		// 调用接口
		AjaxJson ajaxJson = new AjaxJson();
		String URL = "http://fund.eastmoney.com/js/fundcode_search.js";
		String str = URLConneUtils.getContentFromUrl(URL, "UTF-8");
		String replaceStr = "var r = ";
		String fundCode="";
		String fundName="";
		String fundEnLongName="";
		String fundEnSortName="";
		String fundType="";
		String createTime="";
		String industry="";
		String updateTime= DateUtils.getDateTime();
		try {
			JSONArray jsonarray = new JSONArray();
			if (!"".equals(str) && str != null) {
				if (str.indexOf(replaceStr) > -1) {
					str = str.replace(replaceStr, "");
				}
				str =str.replace("],[", "]@[");
				//处理数据变成jsonArray格式
				str=str.trim();
				String temp = str.substring(1, str.length() - 1);
				String [] strArray=temp.split("@");
				if (strArray != null && strArray.length>0) {
					for (int i = 0; i < strArray.length; i++) {
						System.out.println(strArray[i]);
						String tempArray[]=getDataDetial(strArray[i]);
						if(tempArray!=null&&tempArray.length>0){
							Fund fund = new Fund();
							createTime=DateUtils.getDateTime();
							fund.setFundCode(tempArray[0]);
							fund.setFundEnSortName(tempArray[1]);
							fund.setFundName(tempArray[2]);
							fund.setFundType(tempArray[3]);
							fund.setFundEnLongName(tempArray[4]);
							fund.setCreateTime(DateUtils.parseDate(createTime));
							fund.setIndustry("");
							fund.setUpdateTime(DateUtils.parseDate(updateTime));
							ifundService.save(fund);
						}
					}
				}
				ajaxJson.success("数据库同步成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			ajaxJson.fail("数据库同步失败");
		}
			return display("fund/list");
	}
		
	public String[] getDataDetial(String str) {
		String[] array = null;
		if (str.indexOf("[") >-1 || str.indexOf("]")>-1) {
			str=str.replace("[", "").replace("]", "");
			str=str.replace("\"", "");//去引号
			array = str.split(",");//获取逗号数组数据
		}
		return array;
	}

}
