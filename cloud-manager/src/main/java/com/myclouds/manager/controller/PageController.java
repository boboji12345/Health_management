package com.myclouds.manager.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import net.sf.json.JSONObject;
import com.myclouds.manager.pojo.*;
import com.myclouds.manager.service.*;
import com.myclouds.manager.utils.PageBean;
import com.myclouds.manager.utils.RequestParasUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

@Controller
public class PageController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RusersService rusersService;
    @Autowired
    private RtypesService rtypesService;
    @Autowired
    private RnewsService rnewsService;
    @Autowired
    private RdailyclocksService rdailyclocksService;
    @Autowired
    private RinoutsignsService rinoutsignsService;
    @Autowired
    private RknowledgesService rknowledgesService;
    @Autowired
    private RclasssService rclasssService;
    @Autowired
    private RteachersService rteachersService;
    @Autowired
    private RholidaysService rholidaysService;
    @Autowired
    private RclocknotificatsService rclocknotificatsService;



    @ResponseBody
    @RequestMapping(value="/requestDataAddRholidays", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String requestDataAddRholidays(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            String acont = request.getParameter("acont").toString().trim();

            Rusers users = rusersService.findUserByUstuids(utel).get(0);

            Rholidays rholidays = new Rholidays();
            rholidays.setHuid(users.getUid());
            rholidays.setHdate(new Date());
            rholidays.setHflag(0);
            rholidays.setHbid(users.getUbid());
            rholidays.setHcont(acont);

            List<Rholidays> checkdatas = rholidaysService.checkholidays(rholidays);
            if(checkdatas.size() == 0){
                rholidaysService.insertRholidaysInfo(rholidays);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetHolidaysForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetHolidaysForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            List<Rusers> usersBeans = rusersService.findUserByUstuids(utel);
            Rholidays bean = new Rholidays();
            bean.setHuid(usersBeans.get(0).getUid());
            List<Rholidays> rholidays = rholidaysService.selectAllByUidSize(bean);
            if(rholidays.size() > 0){
                response.setObject(rholidays);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetDailyclocksForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetDailyclocksForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            List<Rusers> usersBeans = rusersService.findUserByUstuids(utel);
            List<Rdailyclocks> rdailyclocks = rdailyclocksService.getRdailyclocksByUidSize(usersBeans.get(0).getUid());
            if(rdailyclocks.size() > 0){
                response.setObject(rdailyclocks);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetclocksusersForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetclocksusersForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            List<Rteachers> usersBeans = rteachersService.findRteachersByTuids(utel);
            Rusers bean = new Rusers();
            bean.setUbid(usersBeans.get(0).getTubid());
            bean.setUflag(1);
            List<Rusers> rdailyclocks = rusersService.selectAllByBidAndFlagSize(bean);
            if(rdailyclocks.size() > 0){
                response.setObject(rdailyclocks);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetnoclocksusersForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetnoclocksusersForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            List<Rteachers> usersBeans = rteachersService.findRteachersByTuids(utel);
            Rusers bean = new Rusers();
            bean.setUbid(usersBeans.get(0).getTubid());
            bean.setUflag(0);
            List<Rusers> rdailyclocks = rusersService.selectAllByBidAndFlagSize(bean);
            if(rdailyclocks.size() > 0){
                response.setObject(rdailyclocks);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/requestDataAddDailyclocks", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String requestDataAddDailyclocks(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            String aptemperature = request.getParameter("aptemperature").toString().trim();
            String apattr = request.getParameter("apattr").toString().trim();
            String shentizhuangkuang = request.getParameter("shentizhuangkuang").toString().trim();
            String apuzhengjianhaoma = request.getParameter("apuzhengjianhaoma").toString().trim();
            String aplaiyuan = request.getParameter("aplaiyuan").toString().trim();

            Rusers users = rusersService.findUserByUstuids(utel).get(0);

            Rdailyclocks rdailyclocks = new Rdailyclocks();
            rdailyclocks.setPuid(users.getUid());
            rdailyclocks.setPshentizhuangkuang(shentizhuangkuang);
            rdailyclocks.setPlaiyuan(aplaiyuan);
            rdailyclocks.setPuzhengjianhaoma(apuzhengjianhaoma);
            rdailyclocks.setPattr(apattr);
            rdailyclocks.setPtemperature(aptemperature);
            rdailyclocks.setPdate(getyearmonthdate());

            List<Rdailyclocks> checkdatas = rdailyclocksService.checkRdailyclocks(rdailyclocks);
            if(checkdatas.size() == 0){

                rdailyclocksService.insertRdailyclocksInfo(rdailyclocks);

                users.setUdailyclockdate(getyearmonthdate());
                users.setUflag(1);
                rusersService.updateUserFlagInfo(users);

                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetrclocknotificatsInfoForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetrclocknotificatsInfoForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();

            List<Rusers> users = rusersService.findUserByUstuids(utel);

            List<Rclocknotificats> rclocknotificats =
                    rclocknotificatsService.finddatasbycurrdates(getyearmonthdate());
            if(rclocknotificats.size() > 0){
                response.setResult(true);

                rclocknotificats.get(0).setUflag(users.get(0).getUflag());

                response.setObject(rclocknotificats.get(0));
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetKnowledgesDetailForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetKnowledgesDetailForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String id = request.getParameter("id").toString().trim();
            List<Rknowledges> rknowledges = rknowledgesService.getKnowledgesById(Integer.parseInt(id));
            if(rknowledges.size() > 0){
                response.setObject(rknowledges.get(0));
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetKnowledgesForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetKnowledgesForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            List<Rknowledges> rknowledges = rknowledgesService.findAllKnowledgesSize();
            if(rknowledges.size() > 0){
                response.setObject(rknowledges);
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetNewsByIdForWechat", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetNewsByIdForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            String id = request.getParameter("id").toString().trim();
            String utel = request.getParameter("utel").toString().trim();

            System.out.println(id);
            List<Rnews> rnews =
                    rnewsService.getNewsById(Integer.parseInt(id));
            if(rnews.size() > 0){
                rnews.get(0).setRnums(rnews.get(0).getRnums()+1);
                rnewsService.updateNewsnums(rnews.get(0));

                response.setObject(rnewsService.getNewsById(Integer.parseInt(id)).get(0));

                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/GetNewsInfoForWechat", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetNewsInfoForWechat(HttpServletRequest request){
        Response response = new Response();
        try {
            List<Rnews> rnews = rnewsService.findAllNewsSize();
            if(rnews.size() > 0){
                response.setResult(true);
                response.setObject(rnews);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/findUserbyUtelForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String findUserbyUtelForXiao(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();

            int uid = 0;
            List<Rusers> checkusers = rusersService.findUserByUstuids(utel);
            if(checkusers.size() > 0){
                response.setObject(checkusers.get(0));
                response.setResult(true);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }else{
                response.setResult(false);
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/UpdateMyOneInfosidForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String UpdateMyOneInfosidForXiao(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            String uname = request.getParameter("uname").toString().trim();
            String upwd = request.getParameter("upwd").toString().trim();
            String uutel = request.getParameter("uutel").toString().trim();
            String usex = request.getParameter("usex").toString().trim();
            String uage = request.getParameter("uage").toString().trim();
            String uids = request.getParameter("uids").toString().trim();
            String ushen = request.getParameter("ushen").toString().trim();

            int uid = 0;
            List<Rusers> usersBeans = rusersService.findUserByUstuids(utel);
            if(usersBeans.size() > 0)
                uid = usersBeans.get(0).getUid();

            Rusers userBean = rusersService.getUserByUid(uid).get(0);
            if(!uname.equals(""))
                userBean.setUname(uname);
            if(!uutel.equals(""))
                userBean.setUtel(uutel);
            if(!upwd.equals(""))
                userBean.setUpwd(upwd);
            if(uage.equals(""))
                userBean.setUage(uage);
            if(!usex.equals(""))
                userBean.setUsex(usex);
            if(!uids.equals(""))
                userBean.setUstuids(uids);
            if(!ushen.equals(""))
                userBean.setUshen(ushen);

            rusersService.updateUserInfo(userBean);
            response.setObject(userBean);
            response.setResult(true);
            JSONObject json = JSONObject.fromObject(response);
            return json.toString();

        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/loginForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String loginForXiao(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            String pwd = request.getParameter("pwd").toString().trim();

            List<Rusers> checkUserdatas = rusersService.findUserByUstuids(utel);
            if(checkUserdatas.size() > 0){
                if(checkUserdatas.get(0).getUpwd().equals(pwd)){
                    response.setResult(true);
                    response.setObject(checkUserdatas.get(0));
                    JSONObject json = JSONObject.fromObject(response);
                    return json.toString();
                }else{
                    response.setResult(false);
                    response.setMessage("2");
                    JSONObject json = JSONObject.fromObject(response);
                    return json.toString();
                }
            }else{
                response.setResult(false);
                response.setMessage("1");
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }

    @ResponseBody
    @RequestMapping(value="/teacherloginForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String teacherloginForXiao(HttpServletRequest request){
        Response response = new Response();
        try {
            String utel = request.getParameter("utel").toString().trim();
            String pwd = request.getParameter("pwd").toString().trim();

            List<Rteachers> checkUserdatas = rteachersService.findRteachersByTuids(utel);
            if(checkUserdatas.size() > 0){
                if(checkUserdatas.get(0).getTupwd().equals(pwd)){
                    response.setResult(true);
                    response.setObject(checkUserdatas.get(0));
                    JSONObject json = JSONObject.fromObject(response);
                    return json.toString();
                }else{
                    response.setResult(false);
                    response.setMessage("2");
                    JSONObject json = JSONObject.fromObject(response);
                    return json.toString();
                }
            }else{
                response.setResult(false);
                response.setMessage("1");
                JSONObject json = JSONObject.fromObject(response);
                return json.toString();
            }
        } catch (Exception e) {
            response.setResult(false);
            response.setMessage(e.toString());
        }
        response.setResult(false);
        JSONObject json = JSONObject.fromObject(response);
        return json.toString();
    }


    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        System.out.println(page);
        return page;
    }

    @RequestMapping("admin/findAllAdmins")
    public String findAllAdmins(Model model){
        List<Radmins> adminList = adminService.getAllAdminsList();
        model.addAttribute("adminList",adminList);
        return "adminmana";
    }

    @RequestMapping("admin/adminknowledgesmana")
    public String adminknowledgesmana(Model model, HttpServletRequest request, HttpSession session,
                                @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rknowledges bean = new Rknowledges();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rknowledges> rknowledges = new ArrayList<>();
            List<Rknowledges> rknowledgessize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRktitle(endname);
                bean.setRkinstroduces(endname);

                rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
                rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rknowledges = rknowledgesService.getAllKnowledgesList(bean);
                rknowledgessize = rknowledgesService.findAllKnowledgesSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rknowledges> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
            model.addAttribute("admininfo", myPager);
            return "adminknowledgesmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdminRknowledgesInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdminRknowledgesInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String rinstroduces = RequestParasUtils.getJspStringParameters("rinstroduces", request);
            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);
            String rimg = RequestParasUtils.getJspStringParameters("rimg", request);

            Rknowledges bean = new Rknowledges();
            bean.setRkcont(rcont);
            bean.setRkinstroduces(rinstroduces);
            bean.setRktitle(rntitle);
            bean.setRkimg(rimg);
            bean.setRdate(new Date());

            List<Rknowledges> checkdatas = rknowledgesService.checkKnowledges(rntitle);
            if(checkdatas.size() == 0){
                rknowledgesService.insertKnowledgesInfo(bean);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminRknowledgesInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminRknowledgesInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String rinstroduces = RequestParasUtils.getJspStringParameters("rinstroduces", request);
            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);
            String rimg = RequestParasUtils.getJspStringParameters("rimg", request);

            Rknowledges bean = rknowledgesService.getKnowledgesById(Integer.parseInt(id)).get(0);
            bean.setRkcont(rcont);
            bean.setRkinstroduces(rinstroduces);
            bean.setRktitle(rntitle);
            if(!rimg.equals(""))
                bean.setRkimg(rimg);

            List<Rknowledges> checkdatas = rknowledgesService.checkKnowledges(rntitle);
            if(checkdatas.size() == 0 || checkdatas.size() == 1){
                rknowledgesService.updateKnowledgesInfo(bean);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @RequestMapping(value="admin/selectknowledgesInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectknowledgesInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rknowledges bean = new Rknowledges();
        bean.setRktitle(endname);
        bean.setRkinstroduces(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rknowledges> rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
        List<Rknowledges> rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminknowledgesmana";
    }

    @RequestMapping(value="admin/deleteknowledgesInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteknowledgesInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rknowledgesService.deleteKnowledgesById(id);
        return "redirect:/admin/adminknowledgesmana";
    }

    @RequestMapping(value="admin/deleteknowledgesInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteknowledgesInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rknowledgesService.deleteKnowledgesById(Integer.parseInt(endids[i]));
        }else
            rknowledgesService.deleteKnowledgesById(Integer.parseInt(ids));
        return "redirect:/admin/adminknowledgesmana";
    }

    @RequestMapping("admin/adminrinoutsignsmana")
    public String adminrinoutsignsmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rinoutsigns bean = new Rinoutsigns();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rinoutsigns> rinoutsigns = new ArrayList<>();
            List<Rinoutsigns> rinoutsignssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setCuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setCtypename(endname);
                bean.setUtel(endname);
                bean.setCfromattrs(endname);
                bean.setUroomnumber(endname);

                rinoutsigns = rinoutsignsService.findRinoutsignsByFuzzyquery(bean);
                rinoutsignssize = rinoutsignsService.findRinoutsignsByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rinoutsigns = rinoutsignsService.getAllRinoutsignsList(bean);
                rinoutsignssize = rinoutsignsService.findAllRinoutsignsSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
            model.addAttribute("admininfo", myPager);
            return "adminrinoutsignsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/userrinoutsignsmana")
    public String userrinoutsignsmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers =(Rusers) session.getAttribute("oneuser");
            Rinoutsigns bean = new Rinoutsigns();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setCuid(rusers.getUid());

            List<Rinoutsigns> rinoutsigns = new ArrayList<>();
            List<Rinoutsigns> rinoutsignssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setCuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setCtypename(endname);
                bean.setUtel(endname);
                bean.setCfromattrs(endname);
                bean.setUroomnumber(endname);

                rinoutsigns = rinoutsignsService.findRinoutsignsByFuzzyqueryByUid(bean);
                rinoutsignssize = rinoutsignsService.findRinoutsignsByFuzzyqueryByUidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rinoutsigns = rinoutsignsService.getRinoutsignsByUid(bean);
                rinoutsignssize = rinoutsignsService.getRinoutsignsByUidSize(rusers.getUid());
                request.setAttribute("selectName", "");
            }
            PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
            model.addAttribute("admininfo", myPager);
            return "userrinoutsignsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherrinoutsignsmana")
    public String teacherrinoutsignsmana(Model model, HttpServletRequest request, HttpSession session,
                                      @RequestParam(name = "page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "key",defaultValue = "") String key,
                                      @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            Rinoutsigns bean = new Rinoutsigns();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setBid(rusers.getTubid());

            List<Rinoutsigns> rinoutsigns = new ArrayList<>();
            List<Rinoutsigns> rinoutsignssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setCuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setCtypename(endname);
                bean.setUtel(endname);
                bean.setCfromattrs(endname);
                bean.setUroomnumber(endname);

                rinoutsigns = rinoutsignsService.selectAllByFuzzyqueryByBid(bean);
                rinoutsignssize = rinoutsignsService.selectAllByFuzzyqueryByBidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rinoutsigns = rinoutsignsService.selectByBid(bean);
                rinoutsignssize = rinoutsignsService.selectByBidSize(rusers.getTubid());
                request.setAttribute("selectName", "");
            }
            PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
            model.addAttribute("admininfo", myPager);
            return "teacherrinoutsignsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherRinoutsignsInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherRinoutsignsInfo(Model model, HttpServletRequest request, HttpSession session,
                                            @RequestParam(name = "page",defaultValue = "1") Integer page,
                                            @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rinoutsigns bean = new Rinoutsigns();
            bean.setCuzhengjianhaoma(endname);
            bean.setUname(endname);
            bean.setUtel(endname);
            bean.setUroomnumber(endname);
            bean.setCtypename(endname);
            bean.setCfromattrs(endname);
            bean.setBid(rusers.getTubid());
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rinoutsigns> rinoutsigns = rinoutsignsService.selectAllByFuzzyqueryByBid(bean);
            List<Rinoutsigns> rinoutsignssize = rinoutsignsService.selectAllByFuzzyqueryByBidSize(bean);
            PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", name);
            return "teacherrinoutsignsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdmininoutsignsInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdmininoutsignsInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers =(Rusers) session.getAttribute("oneuser");

            String ctemperature = RequestParasUtils.getJspStringParameters("ctemperature", request);
            String ctype = RequestParasUtils.getJspStringParameters("ctype", request);
            String cfromattrs = RequestParasUtils.getJspStringParameters("cfromattrs", request);
            String cshentizhuangkuang = RequestParasUtils.getJspStringParameters("cshentizhuangkuang", request);
            String ctoattrs = RequestParasUtils.getJspStringParameters("ctoattrs", request);

            Rinoutsigns rinoutsigns = new Rinoutsigns();
            rinoutsigns.setCtype(Integer.parseInt(ctype));
            rinoutsigns.setCtemperature(ctemperature);
            rinoutsigns.setCuid(rusers.getUid());
            if(ctype.equals("0"))
                rinoutsigns.setCtypename("进");
            else
                rinoutsigns.setCtypename("入");
            rinoutsigns.setCuzhengjianhaoma(rusers.getUshen());
            rinoutsigns.setCfromattrs(cfromattrs);
            rinoutsigns.setCshentizhuangkuang(cshentizhuangkuang);
            rinoutsigns.setCtoattrs(ctoattrs);
            rinoutsigns.setCdate(new Date());

            rinoutsignsService.insertRinoutsignsInfo(rinoutsigns);
            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdmininoutsignsInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdmininoutsignsInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers =(Rusers) session.getAttribute("oneuser");

            String ctemperature = RequestParasUtils.getJspStringParameters("ctemperature", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);
            String ctype = RequestParasUtils.getJspStringParameters("ctype", request);
            String cfromattrs = RequestParasUtils.getJspStringParameters("cfromattrs", request);
            String cshentizhuangkuang = RequestParasUtils.getJspStringParameters("cshentizhuangkuang", request);
            String ctoattrs = RequestParasUtils.getJspStringParameters("ctoattrs", request);

            Rinoutsigns rinoutsigns = rinoutsignsService.getRinoutsignsById(Integer.parseInt(id)).get(0);
            rinoutsigns.setCtype(Integer.parseInt(ctype));
            rinoutsigns.setCtemperature(ctemperature);
            if(ctype.equals("0"))
                rinoutsigns.setCtypename("进");
            else
                rinoutsigns.setCtypename("入");
            rinoutsigns.setCfromattrs(cfromattrs);
            rinoutsigns.setCshentizhuangkuang(cshentizhuangkuang);
            rinoutsigns.setCtoattrs(ctoattrs);

            rinoutsignsService.updateRinoutsignsInfo(rinoutsigns);
            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @RequestMapping(value="admin/selectUserRinoutsignsInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectUserRinoutsignsInfo(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers =(Rusers) session.getAttribute("oneuser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rinoutsigns bean = new Rinoutsigns();
            bean.setCuzhengjianhaoma(endname);
            bean.setUname(endname);
            bean.setUtel(endname);
            bean.setUroomnumber(endname);
            bean.setCtypename(endname);
            bean.setCfromattrs(endname);
            bean.setCuid(rusers.getUid());
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rinoutsigns> rinoutsigns = rinoutsignsService.findRinoutsignsByFuzzyqueryByUid(bean);
            List<Rinoutsigns> rinoutsignssize = rinoutsignsService.findRinoutsignsByFuzzyqueryByUidSize(bean);
            PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", name);
            return "userrinoutsignsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/deleteUserRinoutsignsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteUserRinoutsignsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rinoutsignsService.deleteRinoutsignsById(id);
        return "redirect:/admin/userrinoutsignsmana";
    }

    @RequestMapping(value="admin/deleteUserRinoutsignsInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteUserRinoutsignsInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rinoutsignsService.deleteRinoutsignsById(Integer.parseInt(endids[i]));
        }else
            rinoutsignsService.deleteRinoutsignsById(Integer.parseInt(ids));
        return "redirect:/admin/userrinoutsignsmana";
    }

    @ResponseBody
    @RequestMapping(value="admin/getRinoutsignsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rinoutsigns getRinoutsignsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rinoutsigns.getJsonResult(200, "", rinoutsignsService.getRinoutsignsById(id).get(0));
    }

    @RequestMapping(value="admin/selectRinoutsignsInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectRinoutsignsInfo(Model model, HttpServletRequest request, HttpSession session,
                                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                                         @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rinoutsigns bean = new Rinoutsigns();
        bean.setCuzhengjianhaoma(endname);
        bean.setUname(endname);
        bean.setUtel(endname);
        bean.setUroomnumber(endname);
        bean.setCtypename(endname);
        bean.setCfromattrs(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rinoutsigns> rinoutsigns = rinoutsignsService.findRinoutsignsByFuzzyquery(bean);
        List<Rinoutsigns> rinoutsignssize = rinoutsignsService.findRinoutsignsByFuzzyquerySize(bean);
        PageBean<Rinoutsigns> myPager = new PageBean(page,pagesize,rinoutsignssize.size(),rinoutsigns);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminrinoutsignsmana";
    }

    @RequestMapping(value="admin/deleteRinoutsignsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteRinoutsignsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rinoutsignsService.deleteRinoutsignsById(id);
        return "redirect:/admin/adminrinoutsignsmana";
    }

    @RequestMapping(value="admin/deleteRinoutsignsInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteRinoutsignsInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rinoutsignsService.deleteRinoutsignsById(Integer.parseInt(endids[i]));
        }else
            rinoutsignsService.deleteRinoutsignsById(Integer.parseInt(ids));
        return "redirect:/admin/adminrinoutsignsmana";
    }

    @RequestMapping("admin/adminrdailyclocksmana")
    public String adminrdailyclocksmana(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "key",defaultValue = "") String key,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rdailyclocks bean = new Rdailyclocks();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rdailyclocks> rdailyclocks = new ArrayList<>();
            List<Rdailyclocks> rdailyclockssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setPuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setPlaiyuan(endname);
                bean.setUtel(endname);
                bean.setPshentizhuangkuang(endname);
                bean.setUroomnumber(endname);

                rdailyclocks = rdailyclocksService.findRdailyclocksByFuzzyquery(bean);
                rdailyclockssize = rdailyclocksService.findRdailyclocksByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rdailyclocks = rdailyclocksService.getAllRdailyclocksList(bean);
                rdailyclockssize = rdailyclocksService.findAllRdailyclocksSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
            model.addAttribute("admininfo", myPager);
            return "adminrdailyclocksmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/adminrholidaysmana")
    public String adminrholidaysmana(Model model, HttpServletRequest request, HttpSession session,
                                     @RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "key",defaultValue = "") String key,
                                     @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rholidays bean = new Rholidays();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rholidays> rholidays = new ArrayList<>();
            List<Rholidays> rholidayssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setTuname(endname);
                bean.setBname(endname);

                rholidays = rholidaysService.selectAllByFuzzyquery(bean);
                rholidayssize = rholidaysService.selectAllByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rholidays = rholidaysService.selectAll(bean);
                rholidayssize = rholidaysService.selectAllSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rholidays> myPager = new PageBean(page,pagesize,rholidayssize.size(),rholidays);
            model.addAttribute("admininfo", myPager);
            return "adminrholidaysmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherholidaysmana")
    public String teacherholidaysmana(Model model, HttpServletRequest request, HttpSession session,
                                     @RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "key",defaultValue = "") String key,
                                     @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            Rholidays bean = new Rholidays();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setHbid(rusers.getTubid());

            List<Rholidays> rholidays = new ArrayList<>();
            List<Rholidays> rholidayssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setTuname(endname);
                bean.setBname(endname);

                rholidays = rholidaysService.selectAllByFuzzyqueryByTid(bean);
                rholidayssize = rholidaysService.selectAllByFuzzyqueryByTidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rholidays = rholidaysService.selectAllByTid(bean);
                rholidayssize = rholidaysService.selectAllByTidSize(bean);
                request.setAttribute("selectName", "");
            }
            PageBean<Rholidays> myPager = new PageBean(page,pagesize,rholidayssize.size(),rholidays);
            model.addAttribute("admininfo", myPager);
            return "teacherholidaysmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherRholidaysInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherRholidaysInfo(Model model, HttpServletRequest request, HttpSession session,
                                      @RequestParam(name = "page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rholidays bean = new Rholidays();
            bean.setUname(endname);
            bean.setUtel(endname);
            bean.setTuname(endname);
            bean.setBname(endname);
            bean.setHbid(rusers.getTubid());
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rholidays> rholidays = rholidaysService.selectAllByFuzzyqueryByTid(bean);
            List<Rholidays> rholidayssize = rholidaysService.selectAllByFuzzyqueryByTidSize(bean);
            PageBean<Rholidays> myPager = new PageBean(page,pagesize,rholidayssize.size(),rholidays);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", name);
            return "teacherholidaysmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/deleteTeacherRholidaysInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteTeacherRholidaysInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rholidaysService.deleteRholidaysById(id);
        return "redirect:/admin/teacherholidaysmana";
    }

    @RequestMapping(value="admin/deleteTeacherRholidaysInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteTeacherRholidaysInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rholidaysService.deleteRholidaysById(Integer.parseInt(endids[i]));
        }else
            rholidaysService.deleteRholidaysById(Integer.parseInt(ids));
        return "redirect:/admin/teacherholidaysmana";
    }

    @RequestMapping(value="admin/selectRholidaysInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectRholidaysInfo(Model model, HttpServletRequest request, HttpSession session,
                                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                                         @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rholidays bean = new Rholidays();
        bean.setUname(endname);
        bean.setUtel(endname);
        bean.setTuname(endname);
        bean.setBname(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rholidays> rholidays = rholidaysService.selectAllByFuzzyquery(bean);
        List<Rholidays> rholidayssize = rholidaysService.selectAllByFuzzyquerySize(bean);
        PageBean<Rholidays> myPager = new PageBean(page,pagesize,rholidayssize.size(),rholidays);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminrholidaysmana";
    }

    @RequestMapping(value="admin/deleteRholidaysInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteRholidaysInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rholidaysService.deleteRholidaysById(id);
        return "redirect:/admin/adminrholidaysmana";
    }

    @RequestMapping(value="admin/deleteRholidaysInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteRholidaysInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rholidaysService.deleteRholidaysById(Integer.parseInt(endids[i]));
        }else
            rholidaysService.deleteRholidaysById(Integer.parseInt(ids));
        return "redirect:/admin/adminrholidaysmana";
    }

    @RequestMapping("admin/userrholidaysmana")
    public String userrholidaysmana(Model model, HttpServletRequest request, HttpSession session,
                                    @RequestParam(name = "page",defaultValue = "1") Integer page,
                                    @RequestParam(name = "key",defaultValue = "") String key,
                                    @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            Rholidays bean = new Rholidays();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setHuid(rusers.getUid());

            List<Rholidays> rholidays = new ArrayList<>();
            List<Rholidays> rholidayssize = new ArrayList<>();

            if(!key.equals("")){
            } else {
                rholidays = rholidaysService.selectAllByUid(bean);
                rholidayssize = rholidaysService.selectAllByUidSize(bean);
                request.setAttribute("selectName", "");
            }
            PageBean<Rholidays> myPager = new PageBean(page,pagesize,rholidayssize.size(),rholidays);
            model.addAttribute("admininfo", myPager);
            return "userrholidaysmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addUserHolidaysInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addUserHolidaysInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            Rusers a = rusersService.getUserByUid(rusers.getUid()).get(0);
            Rteachers rteachers = rteachersService.getRteachersByBid(a.getUbid()).get(0);

            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);

            Rholidays bean = new Rholidays();
            bean.setHcont(rcont);
            bean.setHuid(rusers.getUid());
            bean.setHdate(new Date());
            bean.setHcont(rcont);
            bean.setHflag(0);
            bean.setHbid(rteachers.getTuid());

            List<Rholidays> checkdatas = rholidaysService.checkholidays(bean);
            if(checkdatas.size() == 0 ){
                rholidaysService.insertRholidaysInfo(bean);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "已申请中，不能重复申请！");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upUserHolidaysInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upUserHolidaysInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);

            Rholidays bean = rholidaysService.selectById(Integer.parseInt(id)).get(0);
            bean.setHcont(rcont);

            List<Rholidays> checkdatas = rholidaysService.checkholidays(bean);
            if(checkdatas.size() == 0 || checkdatas.size() == 1){
                rholidaysService.updateRholidaysInfo(bean);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @RequestMapping(value="admin/deleteUserRholidaysInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteUserRholidaysInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rholidaysService.deleteRholidaysById(id);
        return "redirect:/admin/userrholidaysmana";
    }

    @RequestMapping(value="admin/deleteUserRholidaysInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteUserRholidaysInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rholidaysService.deleteRholidaysById(Integer.parseInt(endids[i]));
        }else
            rholidaysService.deleteRholidaysById(Integer.parseInt(ids));
        return "redirect:/admin/userrholidaysmana";
    }

    @RequestMapping("admin/userrdailyclocksmana")
    public String userrdailyclocksmana(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");
            Rdailyclocks bean = new Rdailyclocks();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setPuid(rusers.getUid());

            List<Rdailyclocks> rdailyclocks = new ArrayList<>();
            List<Rdailyclocks> rdailyclockssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setPuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setPlaiyuan(endname);
                bean.setUtel(endname);
                bean.setPshentizhuangkuang(endname);
                bean.setUroomnumber(endname);

                rdailyclocks = rdailyclocksService.findRdailyclocksByFuzzyqueryByUid(bean);
                rdailyclockssize = rdailyclocksService.findRdailyclocksByFuzzyqueryByUidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rdailyclocks = rdailyclocksService.getRdailyclocksByUid(bean);
                rdailyclockssize = rdailyclocksService.getRdailyclocksByUidSize(rusers.getUid());
                request.setAttribute("selectName", "");
            }

            Rusers curruser = rusersService.getUserByUid(rusers.getUid()).get(0);
            List<Rclocknotificats> rclocknotificats =
                    rclocknotificatsService.finddatasbycurrdates(getyearmonthdate());
            if(rclocknotificats.size() > 0){
                if(curruser.getUflag() == 0){
                    request.setAttribute("ntitle", rclocknotificats.get(0).getNtitle());
                }
            }else{
                request.setAttribute("ntitle", "");
            }

            PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
            model.addAttribute("admininfo", myPager);
            return "userrdailyclocksmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherrdailyclocksmana")
    public String teacherrdailyclocksmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            Rdailyclocks bean = new Rdailyclocks();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setBid(rusers.getTubid());

            List<Rdailyclocks> rdailyclocks = new ArrayList<>();
            List<Rdailyclocks> rdailyclockssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setPuzhengjianhaoma(endname);
                bean.setUname(endname);
                bean.setPlaiyuan(endname);
                bean.setUtel(endname);
                bean.setPshentizhuangkuang(endname);
                bean.setUroomnumber(endname);

                rdailyclocks = rdailyclocksService.selectAllByFuzzyqueryByBid(bean);
                rdailyclockssize = rdailyclocksService.selectAllByFuzzyqueryByBidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rdailyclocks = rdailyclocksService.selectByBid(bean);
                rdailyclockssize = rdailyclocksService.selectByBidSize(rusers.getTubid());
                request.setAttribute("selectName", "");
            }
            PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
            model.addAttribute("admininfo", myPager);
            return "teacherrdailyclocksmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherRdailyclocksInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherRdailyclocksInfo(Model model, HttpServletRequest request, HttpSession session,
                                             @RequestParam(name = "page",defaultValue = "1") Integer page,
                                             @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rdailyclocks bean = new Rdailyclocks();
            bean.setPuzhengjianhaoma(endname);
            bean.setUname(endname);
            bean.setPlaiyuan(endname);
            bean.setUtel(endname);
            bean.setPshentizhuangkuang(endname);
            bean.setUroomnumber(endname);
            bean.setBid(rusers.getTubid());
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rdailyclocks> rdailyclocks = rdailyclocksService.selectAllByFuzzyqueryByBid(bean);
            List<Rdailyclocks> rdailyclockssize = rdailyclocksService.selectAllByFuzzyqueryByBidSize(bean);
            PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", name);
            return "teacherrdailyclocksmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdminDailyclocksInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdminDailyclocksInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            String pattr = RequestParasUtils.getJspStringParameters("pattr", request);
            String ptemperature = RequestParasUtils.getJspStringParameters("ptemperature", request);
            String puzhengjianhaoma = RequestParasUtils.getJspStringParameters("puzhengjianhaoma", request);
            String plaiyuan = RequestParasUtils.getJspStringParameters("plaiyuan", request);
            String pshentizhuangkuang = RequestParasUtils.getJspStringParameters("pshentizhuangkuang", request);

            Rdailyclocks rdailyclocks = new Rdailyclocks();
            rdailyclocks.setPuid(rusers.getUid());
            rdailyclocks.setPshentizhuangkuang(pshentizhuangkuang);
            rdailyclocks.setPlaiyuan(plaiyuan);
            rdailyclocks.setPuzhengjianhaoma(puzhengjianhaoma);
            rdailyclocks.setPattr(pattr);
            rdailyclocks.setPtemperature(ptemperature);
            rdailyclocks.setPdate(getyearmonthdate());

            List<Rdailyclocks> checkdatas = rdailyclocksService.checkRdailyclocks(rdailyclocks);
            if(checkdatas.size() == 0){
                rdailyclocksService.insertRdailyclocksInfo(rdailyclocks);

                rusers.setUdailyclockdate(getyearmonthdate());
                rusers.setUflag(1);
                rusersService.updateUserFlagInfo(rusers);

                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "今天已打卡，不能重复打卡");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminDailyclocksInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminDailyclocksInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            String pattr = RequestParasUtils.getJspStringParameters("pattr", request);
            String ptemperature = RequestParasUtils.getJspStringParameters("ptemperature", request);
            String puzhengjianhaoma = RequestParasUtils.getJspStringParameters("puzhengjianhaoma", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);
            String plaiyuan = RequestParasUtils.getJspStringParameters("plaiyuan", request);
            String pshentizhuangkuang = RequestParasUtils.getJspStringParameters("pshentizhuangkuang", request);

            Rdailyclocks rdailyclocks = rdailyclocksService.getRdailyclocksById(Integer.parseInt(id)).get(0);
            rdailyclocks.setPuid(rusers.getUid());
            rdailyclocks.setPshentizhuangkuang(pshentizhuangkuang);
            rdailyclocks.setPlaiyuan(plaiyuan);
            rdailyclocks.setPuzhengjianhaoma(puzhengjianhaoma);
            rdailyclocks.setPattr(pattr);
            rdailyclocks.setPtemperature(ptemperature);

            List<Rdailyclocks> checkdatas = rdailyclocksService.checkRdailyclocks(rdailyclocks);
            if(checkdatas.size() == 0 || checkdatas.size() == 1){
                rdailyclocksService.updateRdailyclocksInfo(rdailyclocks);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @RequestMapping(value="admin/selectUserRdailyclocksInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectUserRdailyclocksInfo(Model model, HttpServletRequest request, HttpSession session,
                                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                                         @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        Rusers rusers = (Rusers)session.getAttribute("oneuser");
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rdailyclocks bean = new Rdailyclocks();
        bean.setPuzhengjianhaoma(endname);
        bean.setUname(endname);
        bean.setPlaiyuan(endname);
        bean.setUtel(endname);
        bean.setPshentizhuangkuang(endname);
        bean.setUroomnumber(endname);
        bean.setPuid(rusers.getUid());
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rdailyclocks> rdailyclocks = rdailyclocksService.findRdailyclocksByFuzzyqueryByUid(bean);
        List<Rdailyclocks> rdailyclockssize = rdailyclocksService.findRdailyclocksByFuzzyqueryByUidSize(bean);
        PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "userrdailyclocksmana";
    }

    @RequestMapping(value="admin/deleteUserRdailyclocksInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteUserRdailyclocksInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rdailyclocksService.deleteRdailyclocksById(id);
        return "redirect:/admin/userrdailyclocksmana";
    }

    @RequestMapping(value="admin/deleteUserRdailyclocksInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteUserRdailyclocksInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rdailyclocksService.deleteRdailyclocksById(Integer.parseInt(endids[i]));
        }else
            rdailyclocksService.deleteRdailyclocksById(Integer.parseInt(ids));
        return "redirect:/admin/userrdailyclocksmana";
    }

    @ResponseBody
    @RequestMapping(value="admin/getRdailyclocksInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rdailyclocks getRdailyclocksInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rdailyclocks.getJsonResult(200, "", rdailyclocksService.getRdailyclocksById(id).get(0));
    }

    @RequestMapping(value="admin/selectRdailyclocksInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectRdailyclocksInfo(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rdailyclocks bean = new Rdailyclocks();
        bean.setPuzhengjianhaoma(endname);
        bean.setUname(endname);
        bean.setPlaiyuan(endname);
        bean.setUtel(endname);
        bean.setPshentizhuangkuang(endname);
        bean.setUroomnumber(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rdailyclocks> rdailyclocks = rdailyclocksService.findRdailyclocksByFuzzyquery(bean);
        List<Rdailyclocks> rdailyclockssize = rdailyclocksService.findRdailyclocksByFuzzyquerySize(bean);
        PageBean<Rdailyclocks> myPager = new PageBean(page,pagesize,rdailyclockssize.size(),rdailyclocks);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminrdailyclocksmana";
    }

    @RequestMapping(value="admin/deleteRdailyclocksInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteRdailyclocksInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rdailyclocksService.deleteRdailyclocksById(id);
        return "redirect:/admin/adminrdailyclocksmana";
    }

    @RequestMapping(value="admin/deleteRdailyclocksInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteRdailyclocksInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rdailyclocksService.deleteRdailyclocksById(Integer.parseInt(endids[i]));
        }else
            rdailyclocksService.deleteRdailyclocksById(Integer.parseInt(ids));
        return "redirect:/admin/adminrdailyclocksmana";
    }

    @RequestMapping("admin/adminnewsmana")
    public String adminnewsmana(Model model, HttpServletRequest request, HttpSession session,
                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                @RequestParam(name = "key",defaultValue = "") String key,
                                  @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rnews bean = new Rnews();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rnews> newss = new ArrayList<>();
            List<Rnews> newsssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRntitle(endname);
                bean.setRinstroduces(endname);
                bean.setRtname(endname);

                newss = rnewsService.findNewsByFuzzyquery(bean);
                newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                newss = rnewsService.getAllNewsList(bean);
                newsssize = rnewsService.findAllNewsSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
            model.addAttribute("admininfo", myPager);
            return "adminnewsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/usernewsmana")
    public String usernewsmana(Model model, HttpServletRequest request, HttpSession session,
                                @RequestParam(name = "page",defaultValue = "1") Integer page,
                               @RequestParam(name = "key",defaultValue = "") String key,
                                @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rnews bean = new Rnews();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rnews> newss = new ArrayList<>();
            List<Rnews> newsssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRntitle(endname);
                bean.setRinstroduces(endname);
                bean.setRtname(endname);

                newss = rnewsService.findNewsByFuzzyquery(bean);
                newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                newss = rnewsService.getAllNewsList(bean);
                newsssize = rnewsService.findAllNewsSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", "");
            return "usernewsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teachernewsmana")
    public String teachernewsmana(Model model, HttpServletRequest request, HttpSession session,
                               @RequestParam(name = "page",defaultValue = "1") Integer page,
                               @RequestParam(name = "key",defaultValue = "") String key,
                               @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rnews bean = new Rnews();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rnews> newss = new ArrayList<>();
            List<Rnews> newsssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRntitle(endname);
                bean.setRinstroduces(endname);
                bean.setRtname(endname);

                newss = rnewsService.findNewsByFuzzyquery(bean);
                newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                newss = rnewsService.getAllNewsList(bean);
                newsssize = rnewsService.findAllNewsSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", "");
            return "teachernewsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherUserNewsInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherUserNewsInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                            @RequestParam(name = "page",defaultValue = "1") Integer page,
                                            @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();

        Rnews bean = new Rnews();
        bean.setRntitle(name);
        bean.setRinstroduces(name);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rnews> newss = rnewsService.findNewsByFuzzyquery(bean);
        List<Rnews> newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "teachernewsmana";
    }

    @RequestMapping("admin/userknowledgesmana")
    public String userknowledgesmana(Model model, HttpServletRequest request, HttpSession session,
                               @RequestParam(name = "page",defaultValue = "1") Integer page,
                               @RequestParam(name = "key",defaultValue = "") String key,
                               @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rknowledges bean = new Rknowledges();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rknowledges> rknowledges = new ArrayList<>();
            List<Rknowledges> rknowledgessize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRktitle(endname);
                bean.setRkinstroduces(endname);

                rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
                rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rknowledges = rknowledgesService.getAllKnowledgesList(bean);
                rknowledgessize = rknowledgesService.findAllKnowledgesSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rknowledges> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", "");
            return "userknowledgesmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherknowledgesmana")
    public String teacherknowledgesmana(Model model, HttpServletRequest request, HttpSession session,
                                     @RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "key",defaultValue = "") String key,
                                     @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rknowledges bean = new Rknowledges();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rknowledges> rknowledges = new ArrayList<>();
            List<Rknowledges> rknowledgessize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRktitle(endname);
                bean.setRkinstroduces(endname);

                rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
                rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rknowledges = rknowledgesService.getAllKnowledgesList(bean);
                rknowledgessize = rknowledgesService.findAllKnowledgesSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rknowledges> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
            model.addAttribute("admininfo", myPager);
            request.setAttribute("selectName", "");
            return "teacherknowledgesmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectteacherknowledgesInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectteacherknowledgesInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                  @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rknowledges bean = new Rknowledges();
        bean.setRktitle(endname);
        bean.setRkinstroduces(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rknowledges> rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
        List<Rknowledges> rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "teacherknowledgesmana";
    }

    @RequestMapping(value="admin/selectuserknowledgesInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectuserknowledgesInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                              @RequestParam(name = "page",defaultValue = "1") Integer page,
                                              @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rknowledges bean = new Rknowledges();
        bean.setRktitle(endname);
        bean.setRkinstroduces(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rknowledges> rknowledges = rknowledgesService.findKnowledgesByFuzzyquery(bean);
        List<Rknowledges> rknowledgessize = rknowledgesService.findKnowledgesByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,rknowledgessize.size(),rknowledges);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "userknowledgesmana";
    }

    @RequestMapping(value="admin/goknowledgedetailById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String goknowledgedetailById(Model model, HttpServletRequest request, HttpSession session,
                                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                  @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String id = RequestParasUtils.getJspStringParameters("id", request).trim();

        List<Rknowledges> rknowledges = rknowledgesService.getKnowledgesById(Integer.parseInt(id));
        PageBean<Rnews> myPager = new PageBean(page,pagesize,100,rknowledges);
        model.addAttribute("admininfo", myPager);
        return "userknowledgesdetail";
    }

    @RequestMapping(value="admin/goteacherknowledgedetailById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String goteacherknowledgedetailById(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String id = RequestParasUtils.getJspStringParameters("id", request).trim();

        List<Rknowledges> rknowledges = rknowledgesService.getKnowledgesById(Integer.parseInt(id));
        PageBean<Rnews> myPager = new PageBean(page,pagesize,100,rknowledges);
        model.addAttribute("admininfo", myPager);
        return "teacherknowledgesdetail";
    }

    @RequestMapping(value="admin/selectUserNewsInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectUserNewsInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();

        Rnews bean = new Rnews();
        bean.setRntitle(name);
        bean.setRinstroduces(name);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);

        List<Rnews> newss = rnewsService.findNewsByFuzzyquery(bean);
        List<Rnews> newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "usernewsmana";
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdminNewssInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdminNewssInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String rinstroduces = RequestParasUtils.getJspStringParameters("rinstroduces", request);
            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);
            String rimg = RequestParasUtils.getJspStringParameters("rimg", request);
            String rtname = RequestParasUtils.getJspStringParameters("rtname", request);

            int rtid = 0;
            Rtypes rtypes = new Rtypes();
            rtypes.setRtname(rtname);
            List<Rtypes> checkrtypes = rtypesService.checkTypes(rtypes);
            if(checkrtypes.size() > 0)
                rtid = checkrtypes.get(0).getRtid();

            Rnews news = new Rnews();
            news.setRdate(new Date());
            news.setRcont(rcont);
            news.setRinstroduces(rinstroduces);
            news.setRntitle(rntitle);
            news.setRtid(rtid);
            news.setRimg(rimg);
            news.setRnums(0);

            List<Rnews> checkdatas = rnewsService.checkNews(rntitle);
            if(checkdatas.size() == 0){
                rnewsService.insertNewsInfo(news);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }
    @ResponseBody
    @RequestMapping(value="admin/upAdminNewssInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminNewssInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String rinstroduces = RequestParasUtils.getJspStringParameters("rinstroduces", request);
            String rcont = RequestParasUtils.getJspStringParameters("rcont", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);
            String rimg = RequestParasUtils.getJspStringParameters("rimg", request);
            String rtname = RequestParasUtils.getJspStringParameters("rtname", request);

            int rtid = 0;
            Rtypes rtypes = new Rtypes();
            rtypes.setRtname(rtname);
            List<Rtypes> checkrtypes = rtypesService.checkTypes(rtypes);
            if(checkrtypes.size() > 0)
                rtid = checkrtypes.get(0).getRtid();

            Rnews news = new Rnews();
            news.setRnid(Integer.parseInt(id));
            news.setRcont(rcont);
            news.setRinstroduces(rinstroduces);
            news.setRntitle(rntitle);
            news.setRtid(rtid);
            if(!rimg.equals(""))
                news.setRimg(rimg);

            List<Rnews> checkdatas = rnewsService.checkNews(rntitle);
            if(checkdatas.size() == 0 || checkdatas.size() == 1){
                rnewsService.updateNewsInfo(news);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminHolidaysInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminHolidaysInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);

            Rholidays bean = rholidaysService.selectById(Integer.parseInt(id)).get(0);
            bean.setHflag(3);
            bean.setHadminresult(rntitle);

            rholidaysService.updateRholidaysInfo(bean);

            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upTeacherHolidaysInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upTeacherHolidaysInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);

            Rholidays bean = rholidaysService.selectById(Integer.parseInt(id)).get(0);
            bean.setHflag(1);
            bean.setHteacherresult(rntitle);

            rholidaysService.updateRholidaysInfo(bean);

            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upTeacherHolidaysInfo1", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upTeacherHolidaysInfo1(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);

            Rholidays bean = rholidaysService.selectById(Integer.parseInt(id)).get(0);
            bean.setHflag(2);
            bean.setHteacherresult(rntitle);

            rholidaysService.updateRholidaysInfo(bean);

            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminHolidaysInfo1", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminHolidaysInfo1(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String rntitle = RequestParasUtils.getJspStringParameters("rntitle", request);
            String id = RequestParasUtils.getJspStringParameters("id", request);

            Rholidays bean = rholidaysService.selectById(Integer.parseInt(id)).get(0);
            bean.setHflag(4);
            bean.setHadminresult(rntitle);

            rholidaysService.updateRholidaysInfo(bean);

            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }
    //身体状况 0 非常健康 1 良好 2 身体不适 4 感冒发烧
    @ResponseBody
    @RequestMapping(value="admin/selectdailyclocsecharts",produces="application/json;charset=utf-8")
    public Rdailyclocks selectdailyclocsecharts(HttpServletRequest request){
        Rdailyclocks bean = new Rdailyclocks();
        bean.setPshentizhuangkuang("非常健康");
        bean.setPdate(getyearmonthdate());
        List<Rdailyclocks> rdailyclocks1 = rdailyclocksService.findDatasForEcharts(bean);
        bean.setPshentizhuangkuang("良好");
        List<Rdailyclocks> rdailyclocks2 = rdailyclocksService.findDatasForEcharts(bean);
        bean.setPshentizhuangkuang("身体不适");
        List<Rdailyclocks> rdailyclocks3 = rdailyclocksService.findDatasForEcharts(bean);
        bean.setPshentizhuangkuang("感冒发烧");
        List<Rdailyclocks> rdailyclocks4 = rdailyclocksService.findDatasForEcharts(bean);

        List<Integer> returndatas = new ArrayList<>();
        returndatas.add(rdailyclocks1.size());
        returndatas.add(rdailyclocks2.size());
        returndatas.add(rdailyclocks3.size());
        returndatas.add(rdailyclocks4.size());
        return Rdailyclocks.getJsonResult(200, "", returndatas);
    }

    @ResponseBody
    @RequestMapping(value="admin/selectteacherdailyclocsecharts",produces="application/json;charset=utf-8")
    public Rdailyclocks selectteacherdailyclocsecharts(HttpServletRequest request, HttpSession session){
        if(session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")){
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");

            Rdailyclocks bean = new Rdailyclocks();
            bean.setBid(rusers.getTubid());
            bean.setPshentizhuangkuang("非常健康");
            bean.setPdate(getyearmonthdate());
            List<Rdailyclocks> rdailyclocks1 = rdailyclocksService.findTeacherDatasForEcharts(bean);
            bean.setPshentizhuangkuang("良好");
            List<Rdailyclocks> rdailyclocks2 = rdailyclocksService.findTeacherDatasForEcharts(bean);
            bean.setPshentizhuangkuang("身体不适");
            List<Rdailyclocks> rdailyclocks3 = rdailyclocksService.findTeacherDatasForEcharts(bean);
            bean.setPshentizhuangkuang("感冒发烧");
            List<Rdailyclocks> rdailyclocks4 = rdailyclocksService.findTeacherDatasForEcharts(bean);

            List<Integer> returndatas = new ArrayList<>();
            returndatas.add(rdailyclocks1.size());
            returndatas.add(rdailyclocks2.size());
            returndatas.add(rdailyclocks3.size());
            returndatas.add(rdailyclocks4.size());
            return Rdailyclocks.getJsonResult(200, "", returndatas);
        }else{
            return Rdailyclocks.getJsonResult(201, "", null);
        }
    }

    @RequestMapping(value="admin/selectNewsInfoByTname",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectNewsInfoByTname(Model model, HttpServletRequest request, HttpSession session,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rnews bean = new Rnews();
        bean.setRntitle(endname);
        bean.setRinstroduces(endname);
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);
                
        List<Rnews> newss = rnewsService.findNewsByFuzzyquery(bean);
        List<Rnews> newsssize = rnewsService.findNewsByFuzzyquerySize(bean);
        PageBean<Rnews> myPager = new PageBean(page,pagesize,newsssize.size(),newss);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminnewsmana";
    }

    @RequestMapping(value="admin/deleteNewsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteNewsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rnewsService.deleteNewsById(id);
        return "redirect:/admin/adminnewsmana";
    }

    @RequestMapping(value="admin/deleteNewsInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteNewsInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rnewsService.deleteNewsById(Integer.parseInt(endids[i]));
        }else
            rnewsService.deleteNewsById(Integer.parseInt(ids));
        return "redirect:/admin/adminnewsmana";
    }

    @ResponseBody
    @RequestMapping(value="admin/getNewsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rnews getNewsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rnews.getJsonResult(200, "", rnewsService.getNewsById(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getRholidaysInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rholidays getRholidaysInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rholidays.getJsonResult(200, "", rholidaysService.selectById(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getRknowledgesInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rknowledges getRknowledgesInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rknowledges.getJsonResult(200, "", rknowledgesService.getKnowledgesById(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getAllTypes",produces="application/json;charset=utf-8")
    public Rtypes getAllTypes(HttpServletRequest request){
        return Rtypes.getJsonResult(200, "", rtypesService.findAllTypesSize());
    }

    @ResponseBody
    @RequestMapping(value="admin/getAllRclasss",produces="application/json;charset=utf-8")
    public Rclasss getAllRclasss(HttpServletRequest request){
        return Rclasss.getJsonResult(200, "", rclasssService.findAllRclasss() );
    }

    @RequestMapping("admin/admintypesmana")
    public String admintypesmana(Model model, HttpServletRequest request, HttpSession session,
                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                 @RequestParam(name = "key",defaultValue = "") String key,
                                  @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rtypes bean = new Rtypes();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rtypes> rtypes = new ArrayList<>();
            List<Rtypes> rtypessize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setRtname(endname);

                rtypes = rtypesService.findTypesByFuzzyquery(bean);
                rtypessize = rtypesService.findTypesByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rtypes = rtypesService.getAllTypesList(bean);
                rtypessize = rtypesService.findAllTypesSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rtypes> myPager = new PageBean(page,pagesize,rtypessize.size(),rtypes);
            model.addAttribute("admininfo", myPager);
            return "admintypesmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/adminrclocknotificatsmana")
    public String adminrclocknotificatsmana(Model model, HttpServletRequest request, HttpSession session,
                                 @RequestParam(name = "page",defaultValue = "1") Integer page,
                                 @RequestParam(name = "key",defaultValue = "") String key,
                                 @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rclocknotificats bean = new Rclocknotificats();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rclocknotificats> rclocknotificats = new ArrayList<>();
            List<Rclocknotificats> rclocknotificatssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setNtitle(endname);
                bean.setNdate(endname);

                rclocknotificats = rclocknotificatsService.selectAllFuzzyquery(bean);
                for(int i=0; i<rclocknotificats.size();i++){
                    rclocknotificats.get(i).setNcurrdate(getyearmonthdate());
                }
                rclocknotificatssize = rclocknotificatsService.selectAllFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rclocknotificats = rclocknotificatsService.selectAll(bean);
                for(int i=0; i<rclocknotificats.size();i++){
                    rclocknotificats.get(i).setNcurrdate(getyearmonthdate());
                }
                rclocknotificatssize = rclocknotificatsService.selectAllSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rclocknotificats> myPager = new PageBean(page,pagesize,rclocknotificatssize.size(),rclocknotificats);
            model.addAttribute("admininfo", myPager);
            return "adminrclocknotificatsmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdminRclocknotificatsInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdminRclocknotificatsInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String tname = RequestParasUtils.getJspStringParameters("tname", request);
            String nstarthour = RequestParasUtils.getJspStringParameters("nstarthour", request);
            String nendhour = RequestParasUtils.getJspStringParameters("nendhour", request);

            Rclocknotificats bean = new Rclocknotificats();
            bean.setNtitle(tname);
            bean.setNdate(getyearmonthdate());
            bean.setNstarthour(nstarthour);
            bean.setNendhour(nendhour);

            List<Rclocknotificats> checkdatas = rclocknotificatsService.checkdatas(bean);
            if(checkdatas.size() == 0 ){
                rclocknotificatsService.insertRclocknotificatsInfo(bean);
                return Radmins.getJsonResult(200, "一键开启打卡成功");
            }else{
                return Radmins.getJsonResult(200, "今日已开启健康打卡");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminRclocknotificatsInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminRclocknotificatsInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String tid = RequestParasUtils.getJspStringParameters("tid", request);
            String tname = RequestParasUtils.getJspStringParameters("tname", request);

            Rclocknotificats rclocknotificats = rclocknotificatsService.selectById(Integer.parseInt(tid)).get(0);
            rclocknotificats.setNtitle(tname);

            rclocknotificatsService.updateRclocknotificatsInfo(rclocknotificats);
            return Radmins.getJsonResult(200, "操作成功");
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @RequestMapping(value="admin/selectrclocknotificatsInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectrclocknotificatsInfo(Model model, HttpServletRequest request, HttpSession session,
                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                  @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request);
        String endname = "%"+name+"%";

        Rclocknotificats bean = new Rclocknotificats();
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);
        bean.setNdate(endname);
        bean.setNtitle(endname);

        List<Rclocknotificats> rclocknotificats = rclocknotificatsService.selectAllFuzzyquery(bean);
        for(int i=0; i<rclocknotificats.size();i++){
            rclocknotificats.get(i).setNcurrdate(getyearmonthdate());
        }
        List<Rclocknotificats> rclocknotificatssize = rclocknotificatsService.selectAllFuzzyquerySize(bean);
        PageBean<Rclocknotificats> myPager = new PageBean(page,pagesize,rclocknotificatssize.size(),rclocknotificats);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "adminrclocknotificatsmana";
    }

    @RequestMapping(value="admin/deleterclocknotificatsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleterclocknotificatsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rclocknotificatsService.deleteRclocknotificatsById(id);
        return "redirect:/admin/adminrclocknotificatsmana";
    }

    @RequestMapping(value="admin/deleterclocknotificatsInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleterclocknotificatsInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rclocknotificatsService.deleteRclocknotificatsById(Integer.parseInt(endids[i]));
        }else
            rclocknotificatsService.deleteRclocknotificatsById(Integer.parseInt(ids));
        return "redirect:/admin/adminrclocknotificatsmana";
    }

    @RequestMapping(value="admin/selectTypesInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTypesInfo(Model model, HttpServletRequest request, HttpSession session,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request);
        String endname = "%"+name+"%";

        Rtypes bean = new Rtypes();
        bean.setCurrpage((page-1)*5);
        bean.setCurrpagenums(5);
        bean.setRtname(endname);

        List<Rtypes> types = rtypesService.findTypesByFuzzyquery(bean);
        List<Rtypes> typessize = rtypesService.findTypesByFuzzyquerySize(bean);
        PageBean<Rtypes> myPager = new PageBean(page,pagesize,typessize.size(),types);
        model.addAttribute("admininfo", myPager);
        request.setAttribute("selectName", name);
        return "admintypesmana";
    }

    @RequestMapping(value="admin/deleteTypesInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteTypesInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rtypesService.deleteTypeById(id);
        return "redirect:/admin/admintypesmana";
    }

    @RequestMapping(value="admin/deleteTypesInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteTypesInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rtypesService.deleteTypeById(Integer.parseInt(endids[i]));
        }else
            rtypesService.deleteTypeById(Integer.parseInt(ids));
        return "redirect:/admin/admintypesmana";
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminTypesInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminTypesInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String tid = RequestParasUtils.getJspStringParameters("tid", request);
            String tname = RequestParasUtils.getJspStringParameters("tname", request);
            String timg = RequestParasUtils.getJspStringParameters("timg", request);

            Rtypes types = rtypesService.getTypesById(Integer.parseInt(tid)).get(0);
            types.setRtname(tname);
            if(!timg.equals(""))
                types.setRtimg(timg);

            List<Rtypes> checktypes = rtypesService.checkTypes(types);
            if(checktypes.size() == 0 || checktypes.size() == 1){
                rtypesService.updateTypesInfo(types);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addAdminTypesInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins addAdminTypesInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String tname = RequestParasUtils.getJspStringParameters("tname", request);
            String timg = RequestParasUtils.getJspStringParameters("timg", request);

            Rtypes types = new Rtypes();
            types.setRtname(tname);
            types.setRtimg(timg);

            List<Rtypes> checktypes = rtypesService.checkTypes(types);
            if(checktypes.size() == 0 ){
                rtypesService.insertTypesInfo(types);
                return Radmins.getJsonResult(200, "操作成功");
            }else{
                return Radmins.getJsonResult(200, "操作失败");
            }
        }else{
            return Radmins.getJsonResult(200, "未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/getTypesInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rtypes getTypesInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rtypes.getJsonResult(200, "", rtypesService.getTypesById(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getRclocknotificatsInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rclocknotificats getRclocknotificatsInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rclocknotificats.getJsonResult(200, "",
                rclocknotificatsService.selectById(id).get(0));
    }

    @RequestMapping(path = "admin/exportusers", produces = "application/json;charset=utf-8")
    public void exportusers( HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
        List<Rusers> rusers = rusersService.findAllUsersSize();
        exportExcel(rusers,"学生信息列表",
                "学生信息",Rusers.class,"users.xls",response);
    }

    @RequestMapping(path = "admin/importusers", produces = "application/json;charset=utf-8")
    public String importusers( HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
        String filePath = "D:\\bishe1\\users.xls";
        List<Rusers> userList = importExcel(filePath,1,1,Rusers.class);
        for(int i =0; i<userList.size();i++) {
            if(rusersService.checkUsers(userList.get(i)).size() == 0) {
                userList.get(i).setUpwd("123");
                userList.get(i).setUdailyclockdate("");
                rusersService.insert(userList.get(i));
            }
        }
        return "redirect:/admin/adminmemberusersmana";
    }

    @RequestMapping("admin/adminmemberusersmana")
    public String adminmemberusersmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.findUserByFuzzyquery(bean);
                ruserssize = rusersService.findUserByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.getAllUsersList(bean);
                ruserssize = rusersService.findAllUsersSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "adminmemberusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/adminnoclockedusersmana")
    public String adminnoclockedusersmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setUflag(0);

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.selectAllByFuzzyqueryFlag(bean);
                ruserssize = rusersService.selectAllByFuzzyqueryFlagSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.selectAllSizeByFlag(bean);
                ruserssize = rusersService.selectAllSizeByFlagSize(1);
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "adminnoclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectNoUsersByFlagInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectNoUsersByFlagInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                                    @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rusers rusers = new Rusers();
        rusers.setUroomnumber(endname);
        rusers.setUname(endname);
        rusers.setUtel(endname);
        rusers.setCurrpage((page-1)*5);
        rusers.setCurrpagenums(5);
        rusers.setUflag(0);

        List<Rusers> memberusers = rusersService.selectAllByFuzzyqueryFlag(rusers);
        List<Rusers> memberuserssize = rusersService.selectAllByFuzzyqueryFlagSize(rusers);
        PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
        model.addAttribute("memberusers", myPager);
        request.setAttribute("selectName", name);
        return "adminnoclockedusersmana";
    }

    @RequestMapping("admin/adminclockedusersmana")
    public String adminclockedusersmana(Model model, HttpServletRequest request, HttpSession session,
                                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                                        @RequestParam(name = "key",defaultValue = "") String key,
                                        @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setUflag(1);

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.selectAllByFuzzyqueryFlag(bean);
                ruserssize = rusersService.selectAllByFuzzyqueryFlagSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.selectAllSizeByFlag(bean);
                ruserssize = rusersService.selectAllSizeByFlagSize(1);
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "adminclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectUsersByFlagInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectUsersByFlagInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                              @RequestParam(name = "page",defaultValue = "1") Integer page,
                                              @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rusers rusers = new Rusers();
        rusers.setUroomnumber(endname);
        rusers.setUname(endname);
        rusers.setUtel(endname);
        rusers.setCurrpage((page-1)*5);
        rusers.setCurrpagenums(5);
        rusers.setUflag(1);

        List<Rusers> memberusers = rusersService.selectAllByFuzzyqueryFlag(rusers);
        List<Rusers> memberuserssize = rusersService.selectAllByFuzzyqueryFlagSize(rusers);
        PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
        model.addAttribute("memberusers", myPager);
        request.setAttribute("selectName", name);
        return "adminclockedusersmana";
    }

    @RequestMapping("admin/teachermemberusersmana")
    public String teachermemberusersmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setUbid(myteacher.getTubid());

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.selectAllByFuzzyqueryByBid(bean);
                ruserssize = rusersService.selectAllByFuzzyqueryByBidSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.selectAllByBid(bean);
                ruserssize = rusersService.selectAllByBidSize(bean);
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "teachermemberusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teachernoclockedusersmana")
    public String teachernoclockedusersmana(Model model, HttpServletRequest request, HttpSession session,
                                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                                         @RequestParam(name = "key",defaultValue = "") String key,
                                         @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setUbid(myteacher.getTubid());
            bean.setUflag(0);

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.selectAllByFuzzyqueryByBidFlag(bean);
                ruserssize = rusersService.selectAllByFuzzyqueryByBidFlagSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.selectAllByBidAndFlag(bean);
                ruserssize = rusersService.selectAllByBidAndFlagSize(bean);
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "teachernoclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectNoTeacherUsersFlagInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectNoTeacherUsersFlagInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                         @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rusers rusers = new Rusers();
            rusers.setUroomnumber(endname);
            rusers.setUname(endname);
            rusers.setUtel(endname);
            rusers.setUbid(myteacher.getTubid());
            rusers.setCurrpage((page-1)*5);
            rusers.setCurrpagenums(5);
            rusers.setUflag(0);

            List<Rusers> memberusers = rusersService.selectAllByFuzzyqueryByBidFlag(rusers);
            List<Rusers> memberuserssize = rusersService.selectAllByFuzzyqueryByBidFlagSize(rusers);
            PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
            model.addAttribute("memberusers", myPager);
            request.setAttribute("selectName", name);
            return "teacherclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherclockedusersmana")
    public String teacherclockedusersmana(Model model, HttpServletRequest request, HttpSession session,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "key",defaultValue = "") String key,
                                          @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            Rusers bean = new Rusers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);
            bean.setUbid(myteacher.getTubid());
            bean.setUflag(1);

            List<Rusers> rusers = new ArrayList<>();
            List<Rusers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setUname(endname);
                bean.setUtel(endname);
                bean.setUroomnumber(endname);

                rusers = rusersService.selectAllByFuzzyqueryByBidFlag(bean);
                ruserssize = rusersService.selectAllByFuzzyqueryByBidFlagSize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rusersService.selectAllByBidAndFlag(bean);
                ruserssize = rusersService.selectAllByBidAndFlagSize(bean);
                request.setAttribute("selectName", "");
            }
            PageBean<Rusers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "teacherclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherUsersFlagInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherUsersFlagInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                                     @RequestParam(name = "page",defaultValue = "1") Integer page,
                                                     @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rusers rusers = new Rusers();
            rusers.setUroomnumber(endname);
            rusers.setUname(endname);
            rusers.setUtel(endname);
            rusers.setUbid(myteacher.getTubid());
            rusers.setCurrpage((page-1)*5);
            rusers.setCurrpagenums(5);
            rusers.setUflag(1);

            List<Rusers> memberusers = rusersService.selectAllByFuzzyqueryByBidFlag(rusers);
            List<Rusers> memberuserssize = rusersService.selectAllByFuzzyqueryByBidFlagSize(rusers);
            PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
            model.addAttribute("memberusers", myPager);
            request.setAttribute("selectName", name);
            return "teacherclockedusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping(value="admin/selectTeacherUsersInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeacherUsersInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                              @RequestParam(name = "page",defaultValue = "1") Integer page,
                                              @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers myteacher = (Rteachers)session.getAttribute("teacheruser");
            String name = RequestParasUtils.getJspStringParameters("name", request).trim();
            String endname = "%"+name+"%";

            Rusers rusers = new Rusers();
            rusers.setUroomnumber(endname);
            rusers.setUname(endname);
            rusers.setUtel(endname);
            rusers.setUbid(myteacher.getTubid());
            rusers.setCurrpage((page-1)*5);
            rusers.setCurrpagenums(5);

            List<Rusers> memberusers = rusersService.selectAllByFuzzyqueryByBid(rusers);
            List<Rusers> memberuserssize = rusersService.selectAllByFuzzyqueryByBidSize(rusers);
            PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
            model.addAttribute("memberusers", myPager);
            request.setAttribute("selectName", name);
            return "teachermemberusersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/adminteachersmana")
    public String adminteachersmana(Model model, HttpServletRequest request, HttpSession session,
                                       @RequestParam(name = "page",defaultValue = "1") Integer page,
                                       @RequestParam(name = "key",defaultValue = "") String key,
                                       @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        if (session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")) {
            Rteachers bean = new Rteachers();
            bean.setCurrpage((page-1)*5);
            bean.setCurrpagenums(5);

            List<Rteachers> rusers = new ArrayList<>();
            List<Rteachers> ruserssize = new ArrayList<>();

            if(!key.equals("")){
                String endname = "%"+key+"%";
                bean.setTuname(endname);
                bean.setTutel(endname);
                bean.setTushen(endname);
                bean.setBname(endname);

                rusers = rteachersService.findRteachersByFuzzyquery(bean);
                ruserssize = rteachersService.findRteachersByFuzzyquerySize(bean);
                request.setAttribute("selectName", key);
            } else {
                rusers = rteachersService.getAllRteachersList(bean);
                ruserssize = rteachersService.findAllRteachersSize();
                request.setAttribute("selectName", "");
            }
            PageBean<Rteachers> myPager = new PageBean(page,pagesize,ruserssize.size(),rusers);
            model.addAttribute("memberusers", myPager);
            return "adminteachersmana";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addTeacherUserInfo", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public Radmins addTeacherUserInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
            String utel = RequestParasUtils.getJspStringParameters("utel", request);
            String uname = RequestParasUtils.getJspStringParameters("uname", request);
            String uage = RequestParasUtils.getJspStringParameters("uage", request);
            String usex = RequestParasUtils.getJspStringParameters("usex", request);
            String uimg = RequestParasUtils.getJspStringParameters("uimg", request);
            String ushen = RequestParasUtils.getJspStringParameters("ushen", request);
            String bname = RequestParasUtils.getJspStringParameters("bname", request);
            String uids = RequestParasUtils.getJspStringParameters("uids", request);

            int bid = 0;
            List<Rclasss> rclassses = rclasssService.findAllRclassByName(bname);
            if(rclassses.size() > 0)
                bid = rclassses.get(0).getBid();

            String endage = "0";
            if(!uage.equals(""))
                endage = uage;

            Rteachers user = new Rteachers();
            user.setTupwd(upwd);
            user.setTutel(utel);
            user.setTuname(uname);
            user.setTuage(endage);
            user.setTuimg(uimg);
            user.setTusex(usex);
            user.setTushen(ushen);
            user.setTubid(bid);
            user.setTuids(uids);

            List<Rteachers> checkdata = rteachersService.checkRteachers(user);
            if(checkdata.size() == 0) {
                rteachersService.insert(user);
                return Radmins.getJsonResult(200, "操作成功");
            }else {
                return Radmins.getJsonResult(200, "该数据已经添加");
            }
        }else{
            return Radmins.getJsonResult(200, "修改失败未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upTeacherUserInfo", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public Radmins upTeacherUserInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
            String utel = RequestParasUtils.getJspStringParameters("utel", request);
            String uname = RequestParasUtils.getJspStringParameters("uname", request);
            String uage = RequestParasUtils.getJspStringParameters("uage", request);
            String usex = RequestParasUtils.getJspStringParameters("usex", request);
            String uimg = RequestParasUtils.getJspStringParameters("uimg", request);
            String ushen = RequestParasUtils.getJspStringParameters("ushen", request);
            String bname = RequestParasUtils.getJspStringParameters("bname", request);
            String uid = RequestParasUtils.getJspStringParameters("uid", request);
            String uids = RequestParasUtils.getJspStringParameters("uids", request);

            int bid = 0;
            List<Rclasss> rclassses = rclasssService.findAllRclassByName(bname);
            if(rclassses.size() > 0)
                bid = rclassses.get(0).getBid();

            String endage = "0";
            if(!uage.equals(""))
                endage = uage;

            Rteachers user = rteachersService.getRteachersByUid(Integer.parseInt(uid)).get(0);
            user.setTupwd(upwd);
            user.setTutel(utel);
            user.setTuname(uname);
            user.setTuage(endage);
            if(!uimg.equals(""))
                user.setTuimg(uimg);
            user.setTusex(usex);
            user.setTushen(ushen);
            user.setTubid(bid);
            user.setTuids(uids);

            List<Rteachers> checkdata = rteachersService.checkRteachers(user);
            if(checkdata.size() == 0 || checkdata.size() == 1) {
                rteachersService.updateRteachersInfo(user);
                return Radmins.getJsonResult(200, "操作成功");
            }else {
                return Radmins.getJsonResult(200, "该数据已经添加");
            }
        }else{
            return Radmins.getJsonResult(200, "修改失败未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upTeacherOneUserInfo", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public Radmins upTeacherOneUserInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")){

            String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
            String utel = RequestParasUtils.getJspStringParameters("utel", request);
            String uname = RequestParasUtils.getJspStringParameters("uname", request);
            String uage = RequestParasUtils.getJspStringParameters("uage", request);
            String usex = RequestParasUtils.getJspStringParameters("usex", request);
            String uimg = RequestParasUtils.getJspStringParameters("uimg", request);
            String ushen = RequestParasUtils.getJspStringParameters("ushen", request);
            String uid = RequestParasUtils.getJspStringParameters("uid", request);
            String uids = RequestParasUtils.getJspStringParameters("uids", request);

            String endage = "0";
            if(!uage.equals(""))
                endage = uage;

            Rteachers user = rteachersService.getRteachersByUid(Integer.parseInt(uid)).get(0);
            user.setTupwd(upwd);
            user.setTutel(utel);
            user.setTuname(uname);
            user.setTuage(endage);
            if(!uimg.equals(""))
                user.setTuimg(uimg);
            user.setTusex(usex);
            user.setTushen(ushen);
            user.setTuids(uids);

            List<Rteachers> checkdata = rteachersService.checkRteachers(user);
            if(checkdata.size() == 0 || checkdata.size() == 1) {
                rteachersService.updateRteachersInfo(user);
                return Radmins.getJsonResult(200, "操作成功");
            }else {
                return Radmins.getJsonResult(200, "该数据已经添加");
            }
        }else{
            return Radmins.getJsonResult(200, "修改失败未登录");
        }
    }

    @RequestMapping(value="admin/selectTeachersInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectTeachersInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                              @RequestParam(name = "page",defaultValue = "1") Integer page,
                                              @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rteachers rusers = new Rteachers();
        rusers.setTuname(endname);
        rusers.setTutel(endname);
        rusers.setTushen(endname);
        rusers.setBname(endname);
        rusers.setCurrpage((page-1)*5);
        rusers.setCurrpagenums(5);

        List<Rteachers> memberusers = rteachersService.findRteachersByFuzzyquery(rusers);
        List<Rteachers> memberuserssize = rteachersService.findRteachersByFuzzyquerySize(rusers);
        PageBean<Rteachers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
        model.addAttribute("memberusers", myPager);
        request.setAttribute("selectName", name);
        return "adminteachersmana";
    }

    @RequestMapping(value="admin/deleteTeachersInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteTeachersInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rteachersService.deleteRteachersById(id);
        return "redirect:/admin/adminteachersmana";
    }

    @RequestMapping(value="admin/deleteTeachersInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteTeachersInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rteachersService.deleteRteachersById(Integer.parseInt(endids[i]));
        }else
            rteachersService.deleteRteachersById(Integer.parseInt(ids));
        return "redirect:/admin/adminteachersmana";
    }

    @RequestMapping(value="admin/selectUsersInfoByFuzzyquery",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String selectUsersInfoByFuzzyquery(Model model, HttpServletRequest request, HttpSession session,
                                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                                          @RequestParam(name = "pagesize",defaultValue = "5") Integer pagesize) throws Exception {
        String name = RequestParasUtils.getJspStringParameters("name", request).trim();
        String endname = "%"+name+"%";

        Rusers rusers = new Rusers();
        rusers.setUroomnumber(endname);
        rusers.setUname(endname);
        rusers.setUtel(endname);
        rusers.setCurrpage((page-1)*5);
        rusers.setCurrpagenums(5);

        List<Rusers> memberusers = rusersService.findUserByFuzzyquery(rusers);
        List<Rusers> memberuserssize = rusersService.findUserByFuzzyquerySize(rusers);
        PageBean<Rusers> myPager = new PageBean(page,pagesize,memberuserssize.size(),memberusers);
        model.addAttribute("memberusers", myPager);
        request.setAttribute("selectName", name);
        return "adminmemberusersmana";
    }

    @RequestMapping(value="admin/deleteUsersInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public String deleteUsersInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("Id", request);
        rusersService.deleteUserById(id);
        return "redirect:/admin/adminmemberusersmana";
    }

    @RequestMapping(value="admin/deleteUsersInfoById2",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String deleteUsersInfoById2(HttpServletRequest request){
        String ids = request.getParameter("Id");
        if(ids.contains(",")){
            String []endids = ids.split(",");
            for(int i = 0; i<endids.length;i++)
                rusersService.deleteUserById(Integer.parseInt(endids[i]));
        }else
            rusersService.deleteUserById(Integer.parseInt(ids));
        return "redirect:/admin/adminmemberusersmana";
    }

    @RequestMapping("admin/index")
    public String adminindex(Model model, HttpServletRequest request, HttpSession session){

        List<Rusers> Rusers = rusersService.findAllUsersSize();
        request.setAttribute("Rusersnums", Rusers.size()+"");

        List<Rdailyclocks> rdailyclocks = rdailyclocksService.findAllRdailyclocksSize();
        request.setAttribute("rdailyclocksnums", rdailyclocks.size()+"");

        List<Rinoutsigns> rinoutsigns = rinoutsignsService.findAllRinoutsignsSize();
        request.setAttribute("rinoutsignsnums", rinoutsigns.size()+"");

        List<Rnews> snews = rnewsService.findAllNewsSize();
        request.setAttribute("snewsnums", snews.size()+"");

        List<Rtypes> rtypes = rtypesService.findAllTypesSize();
        request.setAttribute("rtypesnums", rtypes.size()+"");

        List<Radmins> radmins = adminService.getAllAdminsList();
        request.setAttribute("radminsnums", radmins.size()+"");

        return "adminindex";
    }

    @RequestMapping("admin/userindex")
    public String userindex(Model model, HttpServletRequest request, HttpSession session){
        if (session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")) {
            Rusers rusers = (Rusers)session.getAttribute("oneuser");

            List<Rdailyclocks> rdailyclocks = rdailyclocksService.getRdailyclocksByUidSize(rusers.getUid());
            request.setAttribute("rdailyclocksnums", rdailyclocks.size() + "");

            List<Rinoutsigns> rinoutsigns = rinoutsignsService.getRinoutsignsByUidSize(rusers.getUid());
            request.setAttribute("rinoutsignsnums", rinoutsigns.size() + "");

            List<Rnews> snews = rnewsService.findAllNewsSize();
            request.setAttribute("snewsnums", snews.size() + "");

            List<Rtypes> rtypes = rtypesService.findAllTypesSize();
            request.setAttribute("rtypesnums", rtypes.size() + "");

            return "userindex";
        } else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacherindex")
    public String teacherindex(Model model, HttpServletRequest request, HttpSession session){
        if (session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")) {
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");

            List<Rdailyclocks> rdailyclocks = rdailyclocksService.selectByBidSize(rusers.getTubid());
            request.setAttribute("rdailyclocksnums", rdailyclocks.size() + "");

            List<Rinoutsigns> rinoutsigns = rinoutsignsService.selectByBidSize(rusers.getTubid());
            request.setAttribute("rinoutsignsnums", rinoutsigns.size() + "");

            List<Rnews> snews = rnewsService.findAllNewsSize();
            request.setAttribute("snewsnums", snews.size() + "");

            List<Rtypes> rtypes = rtypesService.findAllTypesSize();
            request.setAttribute("rtypesnums", rtypes.size() + "");

            return "teacherindex";
        } else {
            return "redirect:/admin/login";
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/getAdminOneInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins getAdminOneInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Radmins.getJsonResult(200, "",
                adminService.getAdminByAid(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getUserOneInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rusers getUserOneInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rusers.getJsonResult(200, "",
                rusersService.getUserByUid(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/getRteachersOneInfoById",method=RequestMethod.GET,produces="application/json;charset=utf-8")
    public Rteachers getRteachersOneInfoById(HttpServletRequest request){
        int id = RequestParasUtils.getJspIntegerParameters("id", request);
        return Rteachers.getJsonResult(200, "",
                rteachersService.getRteachersByUid(id).get(0));
    }

    @ResponseBody
    @RequestMapping(value="admin/upAdminUserInfo", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public Radmins upAdminUserInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
            Radmins user= (Radmins)session.getAttribute("adminuser");

            String uname = RequestParasUtils.getJspStringParameters("uname", request);
            String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
            String utel = RequestParasUtils.getJspStringParameters("utel", request);

            user.setRname(uname);
            user.setRpwd(upwd);
            user.setRtel(utel);

            adminService.updateAdminInfo(user);

            return Radmins.getJsonResult(200, "修改成功");
        }else{
            return Radmins.getJsonResult(200, "修改失败未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/addMemberUserInfo", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public Radmins addMemberUserInfo(HttpServletRequest request, HttpSession session) throws Exception{
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

            String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
            String utel = RequestParasUtils.getJspStringParameters("utel", request);
            String uname = RequestParasUtils.getJspStringParameters("uname", request);
            String uage = RequestParasUtils.getJspStringParameters("uage", request);
            String uroomnumber = RequestParasUtils.getJspStringParameters("uroomnumber", request);
            String usex = RequestParasUtils.getJspStringParameters("usex", request);
            String uimg = RequestParasUtils.getJspStringParameters("uimg", request);
            String ustuids = RequestParasUtils.getJspStringParameters("ustuids", request);
            String ushen = RequestParasUtils.getJspStringParameters("ushen", request);
            String bname = RequestParasUtils.getJspStringParameters("bname", request);

            int bid = 0;
            List<Rclasss> rclassses = rclasssService.findAllRclassByName(bname);
            if(rclassses.size() > 0)
                bid = rclassses.get(0).getBid();

            String endage = "0";
            if(!uage.equals(""))
                endage = uage;

            Rusers user = new Rusers();
            user.setUpwd(upwd);
            user.setUtel(utel);
            user.setUname(uname);
            user.setUage(endage);
            user.setUimg(uimg);
            user.setUroomnumber(uroomnumber);
            user.setUsex(usex);
            user.setUstuids(ustuids);
            user.setUshen(ushen);
            user.setUbid(bid);
            user.setUdailyclockdate("");

            List<Rusers> checkdata = rusersService.checkUsers(user);
            if(checkdata.size() == 0) {
                rusersService.insert(user);
                return Radmins.getJsonResult(200, "操作成功");
            }else {
                return Radmins.getJsonResult(200, "该数据已经添加");
            }
        }else{
            return Radmins.getJsonResult(200, "修改失败未登录");
        }
    }

    @ResponseBody
    @RequestMapping(value="admin/upMemberUserInfo", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public Radmins upUserInfo(HttpServletRequest request, HttpSession session) throws Exception{

        String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
        String utel = RequestParasUtils.getJspStringParameters("utel", request);
        String uid = RequestParasUtils.getJspStringParameters("uid", request);
        String uname = RequestParasUtils.getJspStringParameters("uname", request);

        String uage = RequestParasUtils.getJspStringParameters("uage", request);
        String uroomnumber = RequestParasUtils.getJspStringParameters("uroomnumber", request);
        String usex = RequestParasUtils.getJspStringParameters("usex", request);
        String uimg = RequestParasUtils.getJspStringParameters("uimg", request);
        String ustuids = RequestParasUtils.getJspStringParameters("ustuids", request);
        String ushen = RequestParasUtils.getJspStringParameters("ushen", request);
        String bname = RequestParasUtils.getJspStringParameters("bname", request);


        System.out.println(bname);

        int bid = 0;
        if(bname.equals("")){
            System.out.println("11"+bname);
            List<Rusers> rusers = rusersService.getUserByUid(Integer.parseInt(uid));
            if(rusers.size() > 0)
                bid = rusers.get(0).getUbid();
        }else{
            System.out.println("22"+bname);
            List<Rclasss> rclassses = rclasssService.findAllRclassByName(bname.trim());
            System.out.println("aa"+rclassses.size());
            if(rclassses.size() > 0)
                bid = rclassses.get(0).getBid();
        }


        String endage = "0";
        if(!uage.equals(""))
            endage = uage;

        Rusers user = rusersService.getUserByUid(Integer.parseInt(uid)).get(0);
        user.setUpwd(upwd);
        user.setUtel(utel);
        user.setUname(uname);
        user.setUage(endage);
        if(!uimg.equals(""))
            user.setUimg(uimg);
        user.setUroomnumber(uroomnumber);
        user.setUsex(usex);
        user.setUstuids(ustuids);
        user.setUshen(ushen);

        System.out.println(bid);

        user.setUbid(bid);

        List<Rusers> checkdata = rusersService.checkUsers(user);
        if(checkdata.size() == 0 || checkdata.size() == 1) {
            rusersService.updateUserInfo(user);
            return Radmins.getJsonResult(200, "操作成功");
        }else {
            return Radmins.getJsonResult(200, "该数据已经添加");
        }
    }

    @RequestMapping("admin/adminoneinfomana")
    public String adminoneinfomana(Model model, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
            Radmins user= (Radmins)session.getAttribute("adminuser");
            List<Radmins> admins = adminService.getAdminByAid(user.getRid());
            if(admins.size() > 0) {
                request.setAttribute("requestadminuser", admins.get(0));
                return "adminoneinfomana";
            }else
                return "redirect:/admin/login";
        }else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/useroneinfomana")
    public String useroneinfomana(Model model, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("oneuser") != null && !session.getAttribute("oneuser").equals("")){
            Rusers user= (Rusers)session.getAttribute("oneuser");
            List<Rusers> admins = rusersService.getUserByUid(user.getUid());
            if(admins.size() > 0) {
                PageBean<Rusers> myPager = new PageBean(1,100,admins.size(),admins);
                model.addAttribute("memberusers", myPager);
                return "useroneinfomana";
            }else
                return "redirect:/admin/login";
        }else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/teacheroneinfomana")
    public String teacheroneinfomana(Model model, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("teacheruser") != null && !session.getAttribute("teacheruser").equals("")){
            Rteachers rusers = (Rteachers)session.getAttribute("teacheruser");
            List<Rteachers> admins = rteachersService.getRteachersByUid(rusers.getTuid());
            if(admins.size() > 0) {
                PageBean<Rusers> myPager = new PageBean(1,100,admins.size(),admins);
                model.addAttribute("memberusers", myPager);
                return "teacheroneinfomana";
            }else
                return "redirect:/admin/login";
        }else {
            return "redirect:/admin/login";
        }
    }

    @RequestMapping("admin/login")
    public String adminlogin(Model model, HttpSession session) throws Exception {
        session.invalidate();

        List<Rusers> users = rusersService.findAllUsersSize();
        if(users.size()>0){
            for(int i =0; i<users.size(); i++){
                if(!users.get(i).getUdailyclockdate().equals("")){
                    if(!users.get(i).getUdailyclockdate().equals(getyearmonthdate())){
                        users.get(i).setUflag(0);
                        users.get(i).setUdailyclockdate("");
                        rusersService.updateUserFlagInfo(users.get(i));
                    }
                }
            }
        }

        return "adminLogin";
    }

    @ResponseBody
    @RequestMapping(value = "admin/adminLogin",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Radmins adminLogin(HttpSession session, HttpServletRequest request) throws Exception{

        String tel = RequestParasUtils.getJspStringParameters("tel", request).trim();
        String pwd = RequestParasUtils.getJspStringParameters("pwd", request).trim();
        String userType = RequestParasUtils.getJspStringParameters("userType", request).trim();

        if(userType.equals("1")){
            Radmins user = new Radmins();
            user.setRtel(tel);
            user.setRpwd(pwd);

            if(adminService.findAdminByAtel(tel).size() == 0) {
                return Radmins.getJsonResult(300, "用户名输入错误");
            }else {
                Radmins admins = adminService.findAdminByAtel(tel).get(0);
                if(admins.getRpwd().equals(pwd)) {
                    Radmins adminuser= adminService.login(user).get(0);
                    if(adminuser != null){
                        session.setAttribute("adminuser", adminuser);
                        request.setAttribute("requestadminuser", adminuser);

                        return Radmins.getJsonResult(200, "登录成功");
                    }else{
                        return Radmins.getJsonResult(500, "登录失败");
                    }
                }else {
                    return Radmins.getJsonResult(400, "用户密码输入错误");
                }

            }
        } else if(userType.equals("2")){
            if(rteachersService.findRteachersByTuids(tel).size() == 0) {
                return Radmins.getJsonResult(300, "用户名输入错误");
            }else {
                Rteachers admins = rteachersService.findRteachersByTuids(tel).get(0);
                if(admins.getTupwd().equals(pwd)) {
                    session.setAttribute("teacheruser", admins);
                    return Radmins.getJsonResult(201, "登录成功");
                }else {
                    return Radmins.getJsonResult(400, "用户密码输入错误");
                }
            }
        }else{
            if(rusersService.findUserByUstuids(tel).size() == 0) {
                return Radmins.getJsonResult(300, "用户名输入错误");
            }else {
                Rusers admins = rusersService.findUserByUstuids(tel).get(0);
                if(admins.getUpwd().equals(pwd)) {
                    session.setAttribute("oneuser", admins);
                    request.setAttribute("requestadminuser", admins);

                    return Radmins.getJsonResult(202, "登录成功");
                }else {
                    return Radmins.getJsonResult(400, "用户密码输入错误");
                }

            }
        }
    }

    @RequestMapping("admin/uploadphoto")
    @ResponseBody
    public Map<String, Object> updatePhoto(HttpServletRequest request,
                                           HttpServletResponse response, @RequestParam("myFile") MultipartFile myFile){
        Map<String, Object> json = new HashMap<String, Object>();
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String name = df.format(new Date());

            Random r = new Random();
            for(int i = 0 ;i<3 ;i++){
                name += r.nextInt(10);
            }

            String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());

            String url =  "D:\\bishe";

            String path = "/"+name + "." + ext;
            File file = new File(url);
            if(!file.exists()){
                file.mkdirs();
            }

            myFile.transferTo(new File(url+path));
            json.put("success",path);

            System.out.println(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json ;
    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,String fileName,boolean isCreateHeader, HttpServletResponse response) throws Exception{
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,String fileName, HttpServletResponse response) throws Exception{
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }
    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws Exception{
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) throws Exception {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws Exception {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
    }
    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws Exception {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath,Integer titleRows,Integer headerRows, Class<T> pojoClass) throws Exception{
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new Exception("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return list;
    }
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) throws Exception{
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new Exception("excel文件不能为空");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return list;
    }

    public String shijianchuo() {
        return System.currentTimeMillis()+"";
    }

    public String getyearmonthdate() {
        Calendar c = Calendar.getInstance();
        String months = c.get(Calendar.MONTH)+1+"";
        String end = c.get(Calendar.YEAR)+"-"+ months +"-"+c.get(Calendar.DATE);
        return end;
    }

}
