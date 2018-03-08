package com.app.party.controller;

import com.app.party.model.PartySingle;
import com.app.party.service.PartySingleService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-03-07.
 * Description: 独立的三个模块
 */
@Controller
@RequestMapping(value = "/partySingle")
public class PartySingleController {
    @Autowired
    private PartySingleService partySingleService;

    /**
     * 模块一 规范建设
     * kinds 1
     */

    /**
     * 列表查询
     * @param request
     * @param response
     * @param build_id
     * @param user_id
     */
    @RequestMapping(value = "/js/list")
    public void listJS(HttpServletRequest request, HttpServletResponse response,String build_id,String user_id){
        int kinds = 1;
        List<PartySingle> list = partySingleService.list(build_id,user_id,kinds);
        String json = "";
        if (list != null && list.size()>0) {
            json = JsonUtil.toJsonStr(list, true, "");
        }else {
            json = JsonUtil.toJsonStr(list, false, "暂无数据！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 详细信息
     * @param request
     * @param response
     * @param partySinge_id
     */
    @RequestMapping(value = "/js/getOne")
    public void getOneJS(HttpServletRequest request, HttpServletResponse response,String partySinge_id){
        int kinds = 1;
        PartySingle partySingle = partySingleService.getOne(partySinge_id,kinds);
        String json = "";
        if (partySingle != null) {
            json = JsonUtil.toStr(partySingle);
        }else {
            json = JsonUtil.toJsonStr(partySingle, false, "暂无数据！");
        }
        WebUtil.out(response, json);

    }

    /**
     * 添加
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/js/add")
    public void addJS (HttpServletRequest request, HttpServletResponse response, PartySingle partySingle){
        int kinds = 1;
        int flag = partySingleService.add(partySingle,kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "添加成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "添加失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/js/update")
    public void updateJS (HttpServletRequest request, HttpServletResponse response,PartySingle partySingle){
        int kinds = 1;
        int flag = partySingleService.update(partySingle,kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "修改成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "修改失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @param party_single_id
     */
    @RequestMapping(value = "/js/delete")
    public void deleteJS(HttpServletRequest request, HttpServletResponse response,String party_single_id){
        int kinds = 1;
        int flag = partySingleService.delete(party_single_id,kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "删除成功！");
        } else {
            json = JsonUtil.createOperaStr(false, "删除失败，请重新操作。");
        }
        WebUtil.out(response, json);
    }


    /**
     * 模块二 联系服务
     * kind 2
     */

    /**
     * 列表查询
     * @param request
     * @param response
     * @param build_id
     * @param user_id
     */
    @RequestMapping(value = "/fw/list")
    public void listFW(HttpServletRequest request, HttpServletResponse response,String build_id,String user_id){
        int kinds = 2;
        List<PartySingle> list = partySingleService.list(build_id,user_id, kinds);
        String json = "";
        if (list != null && list.size()>0) {
            json = JsonUtil.toJsonStr(list, true, "");
        }else {
            json = JsonUtil.toJsonStr(list, false, "暂无数据！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 详细信息
     * @param request
     * @param response
     * @param partySinge_id
     */
    @RequestMapping(value = "/fw/getOne")
    public void getOneFW(HttpServletRequest request, HttpServletResponse response,String partySinge_id){
        int kinds = 2;
        PartySingle partySingle = partySingleService.getOne(partySinge_id, kinds);
        String json = "";
        if (partySingle != null) {
            json = JsonUtil.toStr(partySingle);
        }else {
            json = JsonUtil.toJsonStr(partySingle, false, "暂无数据！");
        }
        WebUtil.out(response, json);

    }

    /**
     * 添加
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/fw/add")
    public void addFW (HttpServletRequest request, HttpServletResponse response, PartySingle partySingle){
        int kinds = 2;
        int flag = partySingleService.add(partySingle, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "添加成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "添加失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/fw/update")
    public void updateFW (HttpServletRequest request, HttpServletResponse response,PartySingle partySingle){
        int kinds = 2;
        int flag = partySingleService.update(partySingle, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "修改成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "修改失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @param party_single_id
     */
    @RequestMapping(value = "/fw/delete")
    public void deleteFW(HttpServletRequest request, HttpServletResponse response,String party_single_id){
        int kinds = 2;
        int flag = partySingleService.delete(party_single_id, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "删除成功！");
        } else {
            json = JsonUtil.createOperaStr(false, "删除失败，请重新操作。");
        }
        WebUtil.out(response, json);
    }


    /**
     * 模块三 组织覆盖
     * kind 3
     */

    /**
     * 列表查询
     * @param request
     * @param response
     * @param build_id
     * @param user_id
     */
    @RequestMapping(value = "/fg/list")
    public void listFG(HttpServletRequest request, HttpServletResponse response,String build_id,String user_id){
        int kinds = 3;
        List<PartySingle> list = partySingleService.list(build_id,user_id, kinds);
        String json = "";
        if (list != null && list.size()>0) {
            json = JsonUtil.toJsonStr(list, true, "");
        }else {
            json = JsonUtil.toJsonStr(list, false, "暂无数据！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 详细信息
     * @param request
     * @param response
     * @param partySinge_id
     */
    @RequestMapping(value = "/fg/getOne")
    public void getOneFG(HttpServletRequest request, HttpServletResponse response,String partySinge_id){
        int kinds = 3;
        PartySingle partySingle = partySingleService.getOne(partySinge_id, kinds);
        String json = "";
        if (partySingle != null) {
            json = JsonUtil.toStr(partySingle);
        }else {
            json = JsonUtil.toJsonStr(partySingle, false, "暂无数据！");
        }
        WebUtil.out(response, json);

    }

    /**
     * 添加
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/fg/add")
    public void addFG(HttpServletRequest request, HttpServletResponse response, PartySingle partySingle){
        int kinds = 3;
        int flag = partySingleService.add(partySingle, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "添加成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "添加失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @param partySingle
     */
    @RequestMapping(value = "/fg/update")
    public void updateFG(HttpServletRequest request, HttpServletResponse response,PartySingle partySingle){
        int kinds = 3;
        int flag = partySingleService.update(partySingle, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "修改成功！");
        }else{
            json = JsonUtil.createOperaStr(false, "修改失败！");
        }
        WebUtil.out(response, json);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @param party_single_id
     */
    @RequestMapping(value = "/fg/delete")
    public void deleteFG(HttpServletRequest request, HttpServletResponse response,String party_single_id){
        int kinds = 3;
        int flag = partySingleService.delete(party_single_id, kinds);
        String json = "";
        if (flag == 1) {
            json = JsonUtil.createOperaStr(true, "删除成功！");
        } else {
            json = JsonUtil.createOperaStr(false, "删除失败，请重新操作。");
        }
        WebUtil.out(response, json);
    }
}
