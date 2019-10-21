package com.tx.zhongxun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.zhongxun.mapper.UltrasoundMapper;
import com.tx.zhongxun.pojo.Ultrasound;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UltrasoundController {
    @Resource
    private UltrasoundMapper ultrasoundMapper;

    //添加页面
    @RequestMapping("add")
    public String add() {
        return "add";
    }

    //查找(用于查询)
    @RequestMapping("getUltrasound")
    public String getUltrasound(int id, Model model) throws Exception {
        Ultrasound ultrasound = ultrasoundMapper.getUltrasound(id);
        model.addAttribute("ultrasound", ultrasound);
        return "ultrasoundShow";
    }

    //添加
    @RequestMapping("addUltrasound")
    public String listUltrasound(Ultrasound ultrasound, BindingResult bindingResult) throws Exception {
        boolean flag = ultrasoundMapper.add(ultrasound) > 0;
        return "redirect:listUltrasound";
    }

    //删除
    @RequestMapping("deleteUltrasound")
    public String deleteUltrasound(Ultrasound ultrasound) throws Exception {
        ultrasoundMapper.del(ultrasound.getId());
        return "redirect:listUltrasound";
    }

    //修改
    @RequestMapping("updateUltrasound")
    public String updateUltrasound(Ultrasound ultrasound) throws Exception {
        boolean flag = ultrasoundMapper.update(ultrasound) > 0;
        return "redirect:listUltrasound";
    }

    //查找(用于修改)
    @RequestMapping("findUltrasound")
    public String findUltrasound(int id, Model model) throws Exception {
        Ultrasound ultrasound = ultrasoundMapper.getUltrasound(id);
        model.addAttribute("ultrasound", ultrasound);
        return "modify";
    }

    //遍历
    @RequestMapping({"/","listUltrasound"})
    public String listUltrasound(@RequestParam(value = "id",defaultValue = "") String id,
                           Model model, @RequestParam(value = "start", defaultValue = "1") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id asc");
        List<Ultrasound> ultrasoundList = ultrasoundMapper.getUltrasoundList(id);
        PageInfo<Ultrasound> page = new PageInfo<>(ultrasoundList);
        model.addAttribute("pages", page);
        model.addAttribute("id", id);
        return "index";
    }
}