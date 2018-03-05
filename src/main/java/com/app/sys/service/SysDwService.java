package com.app.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.vo.ComboboxVO;
import com.app.sys.dao.SysDwDao;
import com.app.sys.model.SysDw;
import com.app.sys.vo.SysDwSearchVO;
import com.app.util.string.StringUtil;


/**
 * 系统单位Service
 * @author chykong
 * @date 2016年12月6日
 */
@Service
public class SysDwService {
	@Autowired
	private SysDwDao sysDwDao;
	/*@Autowired
	private DicPcodeDao dicPcodeDao;*/

	/**
	 * 新增单位
	 * @param sysDw
	 * @return
	 */
	public int add(SysDw sysDw) {
		// 判断单位代码是否冲突
		SysDw sysDwExist = sysDwDao.getByDwdm(sysDw.getDwdm());
		if (sysDwExist != null)
			return 2;
		return sysDwDao.add(sysDw);
	}

	/**
	 * 修改单位
	 * @param sysUser
	 * @return
	 */
	public int update(SysDw sysDw) {
		return sysDwDao.update(sysDw);
	}

	/**
	 * 删除单位
	 * @param id
	 * @return
	 */
	public int delete(int dwid) {
		int childrenCount = sysDwDao.getChildrenCount(dwid);
		if (childrenCount > 0)
			return 2;
		else
			return sysDwDao.delete(dwid);
	}

	/**
	 * 根据id获取单位信息
	 * @param id
	 * @return
	 */
	public SysDw get(int id) {
		return sysDwDao.get(id);
	}

	/**
	 * 查询单位
	 * 
	 * @return
	 */
	public List<SysDw> list(SysDwSearchVO sysDwSearchVO, int pageIndex, int pageSize) {
		return sysDwDao.list(sysDwSearchVO, pageIndex, pageSize);
	}

	/**
	 * 查询下级单位数
	 * 
	 * @param sysUserSearchVO
	 * @return
	 */
	public int getChildrenCount(int dwid) {
		return sysDwDao.getChildrenCount(dwid);
	}

	/**
	 * 查询用户总数
	 * 
	 * @param sysUserSearchVO
	 * @return
	 */
	public int listCount(SysDwSearchVO sysDwSearchVO) {
		return sysDwDao.listCount(sysDwSearchVO);
	}

	/**
	 * 系统单位树
	 * @param dwid
	 * @return
	 *//*
		public String getDwTreeGridJson(int dwid) {
		StringBuffer sb = new StringBuffer();
		List<SysDw> list = sysDwDao.listAll();
		List<DicPcode> listDwlx = dicPcodeDao.list(GlobalConst.pcodeGgDwlx);
		//总公司
		sb.append("[{\"dwid\":1,\"dwmc\":\"总公司\",\"dwdm\":\"ZGS\",\"sjdw\":1,\"expanded\":true,\"children\":[");
		//路局
		for (SysDw sysDw : list) {
			if (sysDw.getDwlx().equals(EnumGgDwlx.JJG.getCode()) && sysDw.getSjdw() == 1) {//局机关
				sb.append("{\"dwid\":" + sysDw.getDwid() + ",\"dwmc\":\"" + sysDw.getDwmc() + "\",\"dwdm\":\""
						+ sysDw.getDwdm() + "\",\"sjdw\":" + sysDw.getSjdw() + ",\"expanded\":false,\"children\":[");
				for (DicPcode dwlx : listDwlx) {
					
				}
				sb.append("],");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]}]");
		return sb.toString();
		}
		*/

	/**
	 * 取得单位树的combobox列表
	 * 
	 * @return
	 */
	public String getComboboxTreeJson(int dwid) {
		SysDw sysDw = get(dwid);
		List<SysDw> list = sysDwDao.listAll();
		String parent = "[{\"id\":\"" + sysDw.getDwid() + "\",\"parent_id\":\"" + sysDw.getSjdw() + "\",\"text\":\""
				+ sysDw.getDwmc() + "\",\"expanded\":" + true + ",\"children\":";
		String json = createComboboxTreeJson(list, dwid);
		return parent + "[" + json + "]}]";
	}

	private String createComboboxTreeJson(List<SysDw> list, int sjdw) {
		String str = "";
		for (SysDw sysDw : list) {
			if (sysDw.getSjdw() == sjdw) {
				str += "{\"id\":\"" + sysDw.getDwid() + "\",\"parent_id\":\"" + sysDw.getSjdw() + "\",\"text\":\""
						+ sysDw.getDwmc() + "\"";
				if (sysDw.getSjdw() == 0) {
					str += ",\"expanded\":" + true + "";
				} else {
					str += ",\"expanded\":" + false + "";
				}
				if (sysDw.getCnt() > 0)
					str += ",\"children\":[" + createComboboxTreeJson(list, sysDw.getDwid()) + "]";
				else {
					str += ",\"leaf\":true";
				}
				str += "},";
			}
		}
		str = StringUtil.subTract(str);
		return str;
	}
	
	/**
	 * 下拉框列表公共方法
	 * @return
	 */
	public List<ComboboxVO> getComboboxTree(String dwid) {
		return sysDwDao.getComboboxTree(dwid);
	}


}
