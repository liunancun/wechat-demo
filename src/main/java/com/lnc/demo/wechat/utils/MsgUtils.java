package com.lnc.demo.wechat.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.codec.digest.DigestUtils;

import com.lnc.demo.wechat.model.WechatMsg;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class MsgUtils {

	/**
	 * 应用ID
	 */
	private static String APP_ID = "wx54f579e2ae097908";

	/**
	 * 令牌
	 */
	private static String TOKEN = "liunancun";

	/**
	 * 消息加解密密钥
	 */
	private static String ENCODING_AES_KEY = "ZI9XTPdKOxD9XM8bfZHesL9cBVkM26oFfFeqUbHaeZj";

	/**
	 * 检查签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {

		if (signature != null && timestamp != null && nonce != null) {

			// 将三个参数进行字典序排序
			String[] array = new String[] { TOKEN, timestamp, nonce };
			Arrays.sort(array);

			// 将三个参数字符串拼接成一个字符串进行sha1加密
			String shaHex = DigestUtils.sha1Hex(array[0] + array[1] + array[2]);

			// 验证加密后的字符串是否跟signature一致
			return signature.equals(shaHex);
		}

		return false;
	}

	/**
	 * 将消息对象解析成XML
	 * 
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static String parse(Object obj) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(obj.getClass());

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);

		return writer.toString();
	}

	/**
	 * 将XML解析成消息对象
	 * 
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	public static WechatMsg parse(String xml) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(WechatMsg.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		StringReader reader = new StringReader(xml);
		Object obj = unmarshaller.unmarshal(reader);

		return (WechatMsg) obj;
	}

	/**
	 * 解密报文
	 * 
	 * @param msgSignature
	 * @param timestamp
	 * @param nonce
	 * @param postData
	 * @return
	 * @throws AesException
	 */
	public static String decrypt(String msgSignature, String timestamp, String nonce, String postData)
			throws AesException {

		WXBizMsgCrypt msgCrypt = new WXBizMsgCrypt(TOKEN, ENCODING_AES_KEY, APP_ID);

		return msgCrypt.decryptMsg(msgSignature, timestamp, nonce, postData);
	}

	/**
	 * 加密报文
	 * 
	 * @param replyMsg
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException
	 */
	public static String encrypt(String replyMsg, String timestamp, String nonce) throws AesException {

		WXBizMsgCrypt msgCrypt = new WXBizMsgCrypt(TOKEN, ENCODING_AES_KEY, APP_ID);

		return msgCrypt.encryptMsg(replyMsg, timestamp, nonce);
	}

}
