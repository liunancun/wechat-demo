package com.lnc.demo.wechat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnc.demo.wechat.model.ImageMsg;
import com.lnc.demo.wechat.model.MusicMsg;
import com.lnc.demo.wechat.model.NewsMsg;
import com.lnc.demo.wechat.model.VideoMsg;
import com.lnc.demo.wechat.model.VoiceMsg;
import com.lnc.demo.wechat.model.WechatMsg;
import com.lnc.demo.wechat.utils.Constants;
import com.lnc.demo.wechat.utils.MsgType;
import com.lnc.demo.wechat.utils.MsgUtils;

@Controller
@RequestMapping("encryptMsg")
public class EncryptMsgController {

	/**
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	public String doGet(String signature, String timestamp, String nonce, String echostr) {

		if (MsgUtils.checkSignature(signature, timestamp, nonce)) {

			System.out.println("认证成功");

			// 返回随机字符串
			return echostr;
		}

		System.out.println("认证失败");

		return "认证失败";
	}

	/**
	 * 
	 * @param timestamp
	 * @param nonce
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public String doPost(String timestamp, String nonce, HttpServletRequest request) throws Exception {

		// 请求XML
		String requestXml = IOUtils.toString(request.getInputStream(), "utf-8");

		// 加密类型
		String encryptType = request.getParameter("encrypt_type");

		// 判断是否需要进行AES解密
		if (Constants.ENCRYPT_TYPE_AES.equalsIgnoreCase(encryptType)) {

			// 消息签名
			String msgSignature = request.getParameter("msg_signature");

			// 解密报文
			requestXml = MsgUtils.decrypt(msgSignature, timestamp, nonce, requestXml);
		}

		// 将请求XML解析成请求消息对象
		WechatMsg msg = MsgUtils.parse(requestXml);

		// 响应消息对象
		WechatMsg responseMsg = new WechatMsg();
		responseMsg.setCreateTime(String.valueOf(System.currentTimeMillis()));
		responseMsg.setToUserName(msg.getFromUserName());
		responseMsg.setFromUserName(msg.getToUserName());
		responseMsg.setMsgType(MsgType.TEXT.toCode());

		// 请求消息类型
		String msgType = msg.getMsgType();
		if (MsgType.TEXT.toCode().equals(msgType)) {

			// 文本消息
			switch (msg.getContent()) {
			// 回复文本消息
			case "1":
				responseMsg.setContent("回复文本消息");
				break;
			// 回复图片消息
			case "2":
				responseMsg.setMsgType(MsgType.IMAGE.toCode());
				ImageMsg imageMsg = new ImageMsg();
				imageMsg.setMediaId("WbS1ZqXN03zWTQV0BvKVKR8eImwXLma_Q1OZd7Fu8mhsGLTphnTlsfbc2KLWzCUI");
				responseMsg.setImageMsg(imageMsg);
				break;
			// 回复语音消息
			case "3":
				responseMsg.setMsgType("voice");
				VoiceMsg voiceMsg = new VoiceMsg();
				voiceMsg.setMediaId("pr2ufvmpmuCOcxAa29kO_r8YJL5yYJkIj9eIp6ZxCwk0KfjxrSpzWwi1n-UjgMcy");
				responseMsg.setVoiceMsg(voiceMsg);
				break;
			// 回复视频消息
			case "4":
				responseMsg.setMsgType("video");
				VideoMsg videoMsg = new VideoMsg();
				videoMsg.setMediaId("I9yEh13si7uvnpK6HB2hgeRZLDmZK5-CoKS6nHwioBo-2HI5SDFs3_42X6LN4ru_");
				videoMsg.setTitle("视频标题");
				videoMsg.setDescription("视频描述");
				responseMsg.setVideoMsg(videoMsg);
				break;
			// 回复音乐消息
			case "5":
				responseMsg.setMsgType("music");
				MusicMsg musicMsg = new MusicMsg();
				musicMsg.setTitle("音乐标题");
				musicMsg.setDescription("音乐描述");
				musicMsg.setMusicUrl(
						"http://so1.111ttt.com:8282/2016/5/02/25/195251254501.mp3?tflag=1458142551&pin=67b9b1fdca84d3d4b551ee6ce086b125");
				musicMsg.setHqMusicUrl(
						"http://so1.111ttt.com:8282/2016/5/02/25/195251254501.mp3?tflag=1458142551&pin=67b9b1fdca84d3d4b551ee6ce086b125");
				musicMsg.setThumbMediaId("v7goTKRYf3lhTcUj4TiovyHyaiOP9hXhsXx-kxo8VC374vTFhqhjQSUl56YE71aM");
				responseMsg.setMusicMsg(musicMsg);
				break;
			// 回复图文消息
			case "6":
				responseMsg.setMsgType("news");
				List<NewsMsg> newsMsgs = new ArrayList<NewsMsg>();
				NewsMsg newsMsg = new NewsMsg();
				newsMsg.setTitle("图文标题1");
				newsMsg.setDescription("图文描述1");
				newsMsg.setPicUrl(
						"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
				newsMsg.setUrl("https://www.baidu.com/");
				newsMsgs.add(newsMsg);
				responseMsg.setArticleCount(1);
				responseMsg.setNewsMsgs(newsMsgs);
				break;
			// 回复多图文消息
			case "7":
				responseMsg.setMsgType("news");
				List<NewsMsg> items = new ArrayList<NewsMsg>();
				NewsMsg newsMsg1 = new NewsMsg();
				newsMsg1.setTitle("图文标题1");
				newsMsg1.setDescription("图文描述1");
				newsMsg1.setPicUrl(
						"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
				newsMsg1.setUrl("https://www.baidu.com/");
				items.add(newsMsg1);
				NewsMsg newsMsg2 = new NewsMsg();
				newsMsg2.setTitle("图文标题2");
				newsMsg2.setDescription("图文描述2");
				newsMsg2.setPicUrl(
						"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
				newsMsg2.setUrl("https://www.baidu.com/");
				items.add(newsMsg2);
				responseMsg.setArticleCount(items.size());
				responseMsg.setNewsMsgs(items);
				break;
			// 回复JS-SDK演示
			case "8":
				String url = "https://liunancun.xicp.net/wechat-demo/sdk.action";
				responseMsg.setContent("JS-SDK Demo：\n" + url);
				break;
			// 回复帮助菜单
			default:
				responseMsg.setContent(Constants.MENU_CONTENT);
				break;
			}
		} else if ("event".equals(msgType)) {
			// 事件消息
			switch (msg.getEvent()) {
			// 订阅事件
			case "subscribe":
				responseMsg.setContent(Constants.MENU_CONTENT);
				break;
			// 取消订阅
			case "unsubscribe":
				responseMsg.setContent("取消订阅");
				break;
			// 菜单点击
			case "CLICK":
				responseMsg.setContent("菜单点击");
				break;
			// 其他事件
			default:
				responseMsg.setContent("其他事件");
				break;
			}
		} else if (MsgType.IMAGE.toCode().equals(msgType)) {
			// 图片消息
			String content = "图片消息:";
			content += "\nPicUrl: " + msg.getPicUrl();
			content += "\nMediaId: " + msg.getMediaId();
			responseMsg.setContent(content);
		} else if (MsgType.VOICE.toCode().equals(msgType)) {
			// 语音消息
			String content = "语音消息:";
			content += "\nMediaId: " + msg.getMediaId();
			content += "\nFormat: " + msg.getFormat();
			content += "\nRecognition: " + msg.getRecognition();
			responseMsg.setContent(content);
		} else if (MsgType.VIDEO.toCode().equals(msgType)) {
			// 视频消息
			String content = "视频消息:";
			content += "\nMediaId: " + msg.getMediaId();
			content += "\nThumbMediaId: " + msg.getThumbMediaId();
			responseMsg.setContent(content);
		} else if (MsgType.SHORTVIDEO.toCode().equals(msgType)) {
			// 小视频消息
			String content = "小视频消息:";
			content += "\nMediaId: " + msg.getMediaId();
			content += "\nThumbMediaId: " + msg.getThumbMediaId();
			responseMsg.setContent(content);
		} else if (MsgType.LOCATION.toCode().equals(msgType)) {
			// 地理位置消息
			String content = "地理位置消息:";
			content += "\nLocation_X: " + msg.getLocationX();
			content += "\nLocation_Y: " + msg.getLocationY();
			content += "\nScale: " + msg.getScale();
			content += "\nLabel: " + msg.getLabel();
			responseMsg.setContent(content);
		} else if (MsgType.LINK.toCode().equals(msgType)) {
			// 链接消息
			String content = "链接消息:";
			content += "\nTitle: " + msg.getTitle();
			content += "\nDescription: " + msg.getDescription();
			content += "\nUrl: " + msg.getUrl();
			responseMsg.setContent(content);
		} else {
			responseMsg.setContent("未知请求");
		}

		// 将响应消息对象解析成响应XML
		String responseXml = MsgUtils.parse(responseMsg);

		System.out.println(responseXml);

		// 判断是否需要进行AES加密
		if (Constants.ENCRYPT_TYPE_AES.equalsIgnoreCase(encryptType)) {

			// 加密报文
			responseXml = MsgUtils.encrypt(responseXml, timestamp, nonce);
		}

		return responseXml;
	}

}
