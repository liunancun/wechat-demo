package com.lnc.demo.wechat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 微信图文消息载体类
 * 
 * @author liunancun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsMsg {

	/**
	 * 图文消息标题
	 */
	@XmlElement(name = "Title")
	private String title;

	/**
	 * 图文消息描述
	 */
	@XmlElement(name = "Description")
	private String description;

	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	@XmlElement(name = "PicUrl")
	private String picUrl;

	/**
	 * 点击图文消息跳转链接
	 */
	@XmlElement(name = "Url")
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
