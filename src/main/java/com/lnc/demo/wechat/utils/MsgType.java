package com.lnc.demo.wechat.utils;

public enum MsgType {

	TEXT("text"), EVENT("event"), IMAGE("image"), VOICE("voice"), VIDEO("video"), SHORTVIDEO("shortvideo"), LOCATION(
			"location"), LINK("link");

	private final String code;

	MsgType(String code) {
		this.code = code;
	}

	public String toCode() {
		return code;
	}

}
