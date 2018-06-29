package com.neuedu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/dept"})
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = {"/deptlist"})
    public String deptList(ModelMap modelMap, @RequestParam(name = "pageNum",defaultValue = "1")int pageNum , HttpSession httpSession){
        PageHelper.startPage(pageNum,10);
        List<Dept> deptList = deptService.listDept();
        PageInfo pageInfo = new PageInfo<>(deptList,5);
        modelMap.put("pageInfo",pageInfo);
        httpSession.setAttribute("deptPageNum",pageInfo.getPageNum());
        return "deptlist";
    }

    @RequestMapping(value = {"/deleteDeptById"})
    public String deleteDeptById(int[] id , HttpSession httpSession){
        deptService.deleteDeptById(id);

        Integer pageNum = (Integer) httpSession.getAttribute("deptPageNum");
        return "redirect:/dept/deptlist?pageNum=" + pageNum;
    }

    @RequestMapping(value = {"/addDeptView"})
    public String addDeptView(){
        return "adddept";
    }

    @RequestMapping(value = ("/addDept") )
    public String addDept(Dept dept){
        int pageNum = deptService.addDept(dept);
        return"redirect:/dept/deptlist?pageNum=" + pageNum;
    }

    @RequestMapping(value = {"/updataDeptView"})
    public String updataDeptView(ModelMap modelMap,int id){
        modelMap.put("dept",deptService.getDeptById(id));
        return "updatadept";
    }

    @RequestMapping(value = {"/updataDept"})
    public String updataDept(Dept dept,HttpSession httpSession){
        deptService.updataDept(dept);
        Integer pageNum = (Integer) httpSession.getAttribute("deptPageNum");
        return "redirect:/dept/deptlist?pageNum=" + pageNum;
    }

}
