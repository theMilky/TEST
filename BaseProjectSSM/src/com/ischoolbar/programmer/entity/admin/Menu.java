package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/**
 * �˵�ʵ����
 * @author Cxs
 *
 */
@Component
public class Menu {
	private Long id;
	private Long parentId;  //����id
	private String name;  //�˵���
	private String url;   //������url
	private String icon;  //�˵�iconͼ��
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
