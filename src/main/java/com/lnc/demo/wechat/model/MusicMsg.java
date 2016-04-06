package com.lnc.demo.wechat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 微信音乐消息载体类
 * 
 * @author liunancun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicMsg {

	/**
	 * 音乐标题
	 */
	@XmlElement(name = "Title")
	private String title;

	/**
	 * 音乐描述
	 */
	@XmlElement(name = "Description")
	private String description;

	/**
	 * 音乐链接
	 */
	@XmlElement(name = "MusicUrl")
	private String musicUrl;

	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	@XmlElement(name = "HQMusicUrl")
	private String hqMusicUrl;

	/**
	 * 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
	 */
	@XmlElement(name = "ThumbMediaId")
	private String thumbMediaId;

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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

}
