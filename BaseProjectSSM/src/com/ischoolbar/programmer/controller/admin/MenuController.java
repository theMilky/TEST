package com.ischoolbar.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.sevice.admin.MenuService;

/**
 * 菜单管理控制器
 * @author Cxs
 *
 */
@RequestMapping("/admin/menu")
@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	/**
	 * 菜单管理列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("menu/list");
		return model;
	}
	/**
	 * 菜单添加
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Menu menu){
		Map<String, String> ret = new HashMap<String, String>();
		if(menu == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的菜单信息！");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getName())){
			ret.put("type", "error");
			ret.put("msg", "请填写菜单名称！");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getIcon())){
			ret.put("type", "error");
			ret.put("msg", "请填写菜单图标类！");
			return ret;
		}
		if(menuService.add(menu) <= 0) {
			ret.put("type", "error");
			ret.put("msg", "添加失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "添加成功！");
		return ret;
	}
}
