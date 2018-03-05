package com.app.util.page;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义分页标签
 * 
 * @author kcy
 * 
 */
public class PageTag extends TagSupport {
	private static final long serialVersionUID = -9039794122089833258L;

	private String url = null;
	private String params = null;
	private int pageIndex;
	private int pageSize;
	private int recordCount;
	private int pageCount;
	private int pre, next;

	public void setParams(String params) {
		this.params = params;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = Integer.parseInt(pageIndex);
	}

	public void setPageSize(String pageSize) {
		this.pageSize = Integer.parseInt(pageSize);
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = Integer.parseInt(recordCount);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int doStartTag() throws JspException {
		if (recordCount % pageSize == 0)
			pageCount = recordCount / pageSize;
		else
			pageCount = recordCount / pageSize + 1;

		if (pageCount >= 10 && pageIndex > 10)
			if (pageIndex % 10 == 0)
				pre = pageIndex - 20 + 1;
			else
				pre = (pageIndex - 10) / 10 * 10 + 1;
		else
			pre = 1;
		if (pageIndex % 10 == 0)
			next = (pageIndex / 10) * 10 + 1;
		else
			next = (pageIndex / 10 + 1) * 10 + 1;
		StringBuffer sb = null;
		// 显示每页多少条记录
		sb = new StringBuffer("");
		// sb = new
		// StringBuffer("<select name='goToPage' onchange='javascript:goPage2(this.value)'>");
		// if (pageSize == 10)
		// sb.append("<option value=10 selected='selected'>每页10条</option>");
		// else
		// sb.append("<option value=10>每页10条</option>");
		// if (pageSize == 20)
		// sb.append("<option value=20 selected='selected'>每页20条</option>");
		// else
		// sb.append("<option value=20>每页20条</option>");
		// if (pageSize == 30)
		// sb.append("<option value=30 selected='selected'>每页30条</option>");
		// else
		// sb.append("<option value=30>每页30条</option>");
		// if (pageSize == 50)
		// sb.append("<option value=50 selected='selected'>每页50条</option>");
		// else
		// sb.append("<option value=50>每页50条</option>");
		// sb.append("</select>");

		sb.append(" 第").append(pageIndex).append("页/共").append(pageCount).append("页  | ");
		// 首页
		sb.append("<a title='第一页' href='");
		sb.append(url).append("?pageIndex=1");
		sb.append("&pageSize=").append(pageSize);
		if (params != null)
			sb.append(params);
		sb.append("'>");
		sb.append("<font face=webdings>9</font></a> ");

		// 上十页
		if (pageIndex <= 10)
			sb.append("<font face=webdings>7</font> ");
		else {
			sb.append("<a title='上十页' href='").append(url).append("?&pageIndex=").append(pre);
			sb.append("&pageSize=").append(pageSize);
			if (params != null)
				sb.append(params);
			sb.append("'><font face=webdings>7</font></a> ");
		}

		// 上一页
		/*
		 * if (pageIndex <= 1) { sb.append("上一页").append(" | "); } else {
		 * sb.append("<a href='"); sb.append(url).append("?pageIndex=");
		 * sb.append(pageIndex - 1); sb.append("&pageSize=").append(pageSize);
		 * if (params != null) sb.append(params); sb.append("'>");
		 * sb.append("上一页</a>").append(" | "); }
		 */
		// 第几页
		if (pageIndex > 10) {
			for (int i = pre + 10; i <= pageCount; i++) {
				sb.append("<a title='第").append(i).append("页' href='");
				sb.append(url).append("?pageIndex=");
				sb.append(i);
				sb.append("&pageSize=").append(pageSize);
				if (params != null)
					sb.append(params);
				sb.append("'>");
				if (pageIndex == i)
					sb.append("<font color='#FF7700'>[" + i + "]</font>");
				else
					sb.append("[" + i + "]");
				sb.append("</a> ");

				if (i > pageCount || i > pre + 18)
					break;
			}
		} else if (pageIndex <= 10) {
			for (int i = pre; i <= pageCount; i++) {
				sb.append("<a title='第").append(i).append("页' href='");
				sb.append(url).append("?pageIndex=");
				sb.append(i);
				sb.append("&pageSize=").append(pageSize);
				if (params != null)
					sb.append(params);
				sb.append("'>");
				if (pageIndex == i)
					sb.append("<font color='#FF7700'>[" + i + "]</font>");
				else
					sb.append("[" + i + "]");
				sb.append("</a> ");
				if (i > pageCount || i > pre + 8)
					break;
			}
		}

		/*
		 * // 下一页 if (pageIndex >= pageCount) { sb.append("下一页").append(" | "); }
		 * else { sb.append("<a href='"); sb.append(url).append("?pageIndex=");
		 * sb.append(pageIndex + 1); sb.append("&pageSize=").append(pageSize);
		 * if (params != null) sb.append(params); sb.append("'>");
		 * sb.append("下一页</a>").append(" | "); }
		 */
		// 下十页
		if (next >= pageCount)
			sb.append("<font face=webdings>8</font> ");
		else {
			sb.append("<a title='下十页' href='").append(url).append("?&pageIndex=").append(next);
			sb.append("&pageSize=").append(pageSize);
			if (params != null)
				sb.append(params);
			sb.append("'><font face=webdings>8</font></a> ");
		}
		// 末页
		sb.append("<a title='末页' href='");
		sb.append(url).append("?pageIndex=");
		sb.append(pageCount);
		sb.append("&pageSize=").append(pageSize);
		if (params != null)
			sb.append(params);
		sb.append("'>");
		sb.append("<font face=webdings>:</font></a>").append(" | ");

		// 跳转到
		sb.append(" 跳转到:<select name='goToPage' onchange='javascript:goPage(this.value)'>");

		for (int i = 1; i <= pageCount; i++) {
			sb.append("<option value=").append(i);
			if (pageIndex == i)
				sb.append(" selected");
			sb.append(">第").append(i).append("页</option>");
		}
		sb.append("</select>");
		sb.append("<script language=javascript>");
		sb.append("function goPage(page){").append("window.location='").append(url);
		sb.append("?pageIndex='+").append("page");
		sb.append("+'");
		sb.append("&pageSize=").append(pageSize);
		sb.append("&params=").append(params);
		sb.append("';");
		sb.append("}");
		sb.append("</script>");
		sb.append("<script language=javascript>");
		sb.append("function goPage2(pageSize){").append("window.location='").append(url);
		sb.append("?pageIndex=1");
		sb.append("&pageSize='+").append("pageSize").append("+'");
		sb.append("&params=").append(params);
		sb.append("';");
		sb.append("}");
		sb.append("</script>");

		try {
			if (sb != null) {
				JspWriter out = pageContext.getOut();
				out.print(sb);
			}
		} catch (Exception e) {
			throw new JspException(e);
		}
		return 1;
	}
}
