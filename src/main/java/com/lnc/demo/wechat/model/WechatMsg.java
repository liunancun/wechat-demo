package com.lnc.demo.wechat.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatMsg {

	/**
	 * 开发者微信号
	 */
	@XmlElement(name = "ToUserName")
	private String toUserName;

	/**
	 * 发送方帐号（一个OpenID）
	 */
	@XmlElement(name = "FromUserName")
	private String fromUserName;

	/**
	 * 消息创建时间 （整型）
	 */
	@XmlElement(name = "CreateTime")
	private String createTime;

	/**
	 * 消息类型
	 */
	@XmlElement(name = "MsgType")
	private String msgType;

	/**
	 * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 */
	@XmlElement(name = "Event")
	private String event;

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	@XmlElement(name = "EventKey")
	private String eventKey;

	/**
	 * 消息id，64位整型
	 */
	@XmlElement(name = "MsgId")
	private String msgId;

	/**
	 * 消息密文
	 */
	@XmlElement(name = "Encrypt")
	private String encrypt;

	/**
	 * 文本消息内容
	 */
	@XmlElement(name = "Content")
	private String content;

	/**
	 * 图片链接
	 */
	@XmlElement(name = "PicUrl")
	private String picUrl;

	/**
	 * 消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@XmlElement(name = "MediaId")
	private String mediaId;

	/**
	 * 缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@XmlElement(name = "ThumbMediaId")
	private String thumbMediaId;

	/**
	 * 语音格式，如amr，speex等
	 */
	@XmlElement(name = "Format")
	private String format;

	/**
	 * 语音识别结果，UTF8编码
	 */
	@XmlElement(name = "Recognition")
	private String Recognition;

	/**
	 * 地理位置维度
	 */
	@XmlElement(name = "Location_X")
	private String locationX;

	/**
	 * 地理位置经度
	 */
	@XmlElement(name = "Location_Y")
	private String locationY;

	/**
	 * 地图缩放大小
	 */
	@XmlElement(name = "Scale")
	private String scale;

	/**
	 * 地理位置信息
	 */
	@XmlElement(name = "Label")
	private String label;

	/**
	 * 消息标题
	 */
	@XmlElement(name = "Title")
	private String title;

	/**
	 * 消息描述
	 */
	@XmlElement(name = "Description")
	private String description;

	/**
	 * 消息链接
	 */
	@XmlElement(name = "Url")
	private String url;

	/**
	 * 图文消息个数，限制为10条以内
	 */
	@XmlElement(name = "ArticleCount")
	private int articleCount;

	/**
	 * 图片
	 */
	@XmlElement(name = "Image")
	private ImageMsg imageMsg;

	/**
	 * 视频
	 */
	@XmlElement(name = "Voice")
	private VoiceMsg voiceMsg;

	/**
	 * 语音
	 */
	@XmlElement(name = "Video")
	private VideoMsg videoMsg;

	/**
	 * 音乐
	 */
	@XmlElement(name = "Music")
	private MusicMsg musicMsg;

	/**
	 * 图文
	 */
	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	private List<NewsMsg> newsMsgs;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public ImageMsg getImageMsg() {
		return imageMsg;
	}

	public void setImageMsg(ImageMsg imageMsg) {
		this.imageMsg = imageMsg;
	}

	public VoiceMsg getVoiceMsg() {
		return voiceMsg;
	}

	public void setVoiceMsg(VoiceMsg voiceMsg) {
		this.voiceMsg = voiceMsg;
	}

	public VideoMsg getVideoMsg() {
		return videoMsg;
	}

	public void setVideoMsg(VideoMsg videoMsg) {
		this.videoMsg = videoMsg;
	}

	public MusicMsg getMusicMsg() {
		return musicMsg;
	}

	public void setMusicMsg(MusicMsg musicMsg) {
		this.musicMsg = musicMsg;
	}

	public List<NewsMsg> getNewsMsgs() {
		return newsMsgs;
	}

	public void setNewsMsgs(List<NewsMsg> newsMsgs) {
		this.newsMsgs = newsMsgs;
	}

}
