package com.ischoolbar.programmer.controller.admin;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.admin.User;
import com.ischoolbar.programmer.sevice.admin.UserService;
import com.ischoolbar.programmer.util.CpachaUtil;


/**
 * ϵͳ�����������
 * @author Cxs
 *
 */

@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserService UserService;
	
	/**
	 * ϵͳ��½�����ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		model.setViewName("system/index");
		model.addObject("name", "С��׳ʿ");
		return model;
	}
	
	/**
	 * ϵͳ��½��Ļ�ӭҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView welcome(ModelAndView model) {
		model.setViewName("system/welcome");
		return model;
	}
	
	/**
	 * ��¼ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		model.setViewName("system/login");
		return model;
	}
	
	/**
	 * ��½���ύ���������
	 * @param user
	 * @param cpacha
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String, String> loginAct(User user,String cpacha,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		if(user == null){
			ret.put("type", "error");
			ret.put("msg", "����д�û���Ϣ");
			return ret;	
		}
		if(StringUtils.isEmpty(cpacha)) {
			ret.put("type", "error");
			ret.put("msg", "����д��֤��");
			return ret;
		}	
		if(StringUtils.isEmpty(user.getUsername())) {
			ret.put("type", "error");
			ret.put("msg", "����д�û���");
			return ret;
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", "����д����");
			return ret;
		}
		Object loginCpacha = request.getSession().getAttribute("loginCpacha");
		if(loginCpacha == null) {
			ret.put("type", "error");
			ret.put("msg", "�Ự��ʱ����ˢ��ҳ�棡");
			return ret;
		}
		if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "��֤�����");
			return ret;
		};
		User findByUsername = UserService.findByUsername(user.getUsername());
		if(findByUsername == null){
			ret.put("type", "error");
			ret.put("msg", "���û��������ڣ�");	
			return ret;
		}
		if(!user.getPassword().equals(findByUsername.getPassword())){
			ret.put("type", "error");
			ret.put("msg", "�������");	
			return ret;
		}
		request.getSession().setAttribute("admin", findByUsername);
		ret.put("type", "success");
		ret.put("msg", "��½�ɹ���");
		return ret;
	}
	
	/**
	 * ��ϵͳ�����е���֤������ô˷���
	 * @param vcodeLen
	 * @param width
	 * @param height
	 * @param cpachaType������������֤������ͣ������ַ���
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/get_cpacha", method=RequestMethod.GET)
	public void generateCpacha(
			@RequestParam(name="vl",required=false,defaultValue="4") Integer vcodeLen,
			@RequestParam(name="w",required=false,defaultValue="100") Integer width,
			@RequestParam(name="h",required=false,defaultValue="30") Integer height,
			@RequestParam(name="type",required=true,defaultValue="loginCpacha") String cpachaType,
			HttpServletRequest request,
			HttpServletResponse response) {
		CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
		String generatorVCode = cpachaUtil.generatorVCode();
		request.getSession().setAttribute(cpachaType, generatorVCode);
		BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		try {
			ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
