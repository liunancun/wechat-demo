package com.lnc.demo.wechat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 微信语音消息载体类
 * 
 * @author liunancun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceMsg {

	/**
	 * 通过素材管理接口上传多媒体文件，得到的id
	 */
	@XmlElement(name = "MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
