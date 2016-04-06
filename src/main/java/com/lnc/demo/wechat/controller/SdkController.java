package com.lnc.demo.wechat.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sdk")
public class SdkController {

	private static final String APP_ID = "wxcd20d9781292bc5c";

	private static final String JSAPI_TICKET = "sM4AOVdWfPE4DxkXGEs8VOXJ0UdLGonWKzoLNxdsYrBYsLxLP6ZWgX_pn85j1irBWfly7k-fWy1JPhnjSC4sWQ";

	@RequestMapping
	public String main(Model model, HttpServletRequest request) {

		String nonceStr = UUID.randomUUID().toString();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String url = request.getRequestURL().toString();
		if (request.getQueryString() != null) {
			url += "?" + request.getQueryString();
		}

		String signature = "jsapi_ticket=" + JSAPI_TICKET + "&noncestr=" + nonceStr + "&timestamp=" + timestamp
				+ "&url=" + url;

		signature = DigestUtils.sha1Hex(signature);

		model.addAttribute("appId", APP_ID);
		model.addAttribute("jsapi_ticket", JSAPI_TICKET);
		model.addAttribute("nonceStr", nonceStr);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("url", url);
		model.addAttribute("signature", signature);

		return "sdk";
	}

}
