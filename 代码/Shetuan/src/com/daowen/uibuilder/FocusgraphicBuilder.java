//-------------------------请加下面QQ请求远程辅助运行代码  ID:3578--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
package com.daowen.uibuilder;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daowen.entity.Jiaodiantu;
import com.daowen.service.JiaodiantuService;
import com.daowen.util.BeansUtil;


public class FocusgraphicBuilder {

	
	private JiaodiantuService jdtSrv=null;
	public FocusgraphicBuilder(){
		jdtSrv=BeansUtil.getBean("jiaodiantuService", JiaodiantuService.class);
	}
	public  String build()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<div id=\"slide_c\">");
		List<Jiaodiantu> list = jdtSrv.getEntity();
		for (Iterator<Jiaodiantu> it = list.iterator(); it.hasNext();) {
			Jiaodiantu n = it.next();
			sb.append(MessageFormat.format(
					"<a target=\"_blank\" href=''{0}''><img alt=\"\" title=\"\" src=\"{1}\"></a>",
					n.getHref(), n.getTupian()));
			sb.append("\r\n");
		}
		sb.append(" <div class=\"ico_c\">");
		sb.append("\r\n");
		sb.append("</div>");
		sb.append("\r\n");
		sb.append("</div>");
		return sb.toString();
		
	}
	public  String buildFullScreen()
	{
		StringBuffer sb = new StringBuffer();
		StringBuffer imagessb=new StringBuffer();
		StringBuffer titlesb=new StringBuffer();
		sb.append("<div class=\"carousel\" >");
		sb.append("<div class=\"car-big-picture\">");

		List<Jiaodiantu> list = jdtSrv.getTopEntity("", 10);
		int i=0;
		for (Iterator<Jiaodiantu> it = list.iterator(); it.hasNext();) {
			Jiaodiantu n = it.next();
			String style="";
			if(i++==0){
				style=" style='display:block;'";
			}
			imagessb.append(MessageFormat.format(
					"<a target=\"_blank\" href=''{0}''><img  {2}  src=\"{1}\"></a>",
					n.getHref(), n.getTupian(),style));
			imagessb.append("\r\n");
			
			titlesb.append(MessageFormat.format("<p>{0}</p>",n.getTitle()));
			
			
		}
	    sb.append(imagessb);
		sb.append("</div>");
		
		sb.append("\r\n");
		sb.append("<div class=\"car_click\">");
		//БъЬт
		
		sb.append("<div class=\"car_c_title\">");
		sb.append(titlesb);
		sb.append("</div>");
		
		//аЁЭМ
        sb.append("<div class=\"car_c_smallpic\">");
        
        sb.append("<input class=\"car_c_inpt1\" type=\"button\"/>");
		
        sb.append(imagessb);
        
        sb.append("<input class=\"car_c_inpt2\" type=\"button\"/>");
		
		sb.append("</div>");
		//car_click
		sb.append("</div>");
		
		
		//end carousel
		sb.append("</div>");
		
		
		return sb.toString();
		
	}
	
	
}
//-------------------------请加下面QQ请求远程辅助运行代码  ID:3578--------------------------
//-----------------更多毕设, 联系QQ1305637939-------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加作者QQ协助运行: 1305637939-----------------------
//-------------------------请加下面QQ请求远程辅助运行代码----------------------------
