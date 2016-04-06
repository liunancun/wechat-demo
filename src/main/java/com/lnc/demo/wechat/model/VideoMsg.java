package com.lnc.demo.wechat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 微信视频消息载体类
 * 
 * @author liunancun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoMsg {

	/**
	 * 通过素材管理接口上传多媒体文件，得到的id
	 */
	@XmlElement(name = "MediaId")
	private String mediaId;

	/**
	 * 视频消息的标题
	 */
	@XmlElement(name = "Title")
	private String title;

	/**
	 * 视频消息的描述
	 */
	@XmlElement(name = "Description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

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

}
