<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>JS-SDK Demo</title>
<link rel="stylesheet" href="css/weui.min.css" />
</head>
<body>
	<div class="weui_cells_title">基础接口</div>
	<button class="weui_btn weui_btn_primary" id="checkJsApi">判断当前客户端版本是否支持指定JS接口</button>

	<div class="weui_cells_title">分享接口</div>
	<button class="weui_btn weui_btn_primary" id="onMenuShareTimeline">分享到朋友圈</button>
	<button class="weui_btn weui_btn_primary" id="onMenuShareAppMessage">分享给朋友</button>
	<button class="weui_btn weui_btn_primary" id="onMenuShareQQ">分享到QQ</button>
	<button class="weui_btn weui_btn_primary" id="onMenuShareWeibo">分享到腾讯微博</button>
	<button class="weui_btn weui_btn_primary" id="onMenuShareQZone">分享到QQ空间</button>

	<div class="weui_cells_title">图像接口</div>
	<button class="weui_btn weui_btn_primary" id="chooseImage">拍照或从手机相册中选图接口</button>
	<button class="weui_btn weui_btn_primary" id="previewImage">预览图片接口</button>
	<button class="weui_btn weui_btn_primary" id="uploadImage">上传图片接口</button>
	<button class="weui_btn weui_btn_primary" id="downloadImage">下载图片接口</button>

	<div class="weui_cells_title">音频接口</div>
	<button class="weui_btn weui_btn_primary" id="startRecord">开始录音接口</button>
	<button class="weui_btn weui_btn_primary" id="stopRecord">停止录音接口</button>
	<button class="weui_btn weui_btn_primary" id="onVoiceRecordEnd">监听录音自动停止接口</button>
	<button class="weui_btn weui_btn_primary" id="playVoice">播放语音接口</button>
	<button class="weui_btn weui_btn_primary" id="pauseVoice">暂停播放接口</button>
	<button class="weui_btn weui_btn_primary" id="stopVoice">停止播放接口</button>
	<button class="weui_btn weui_btn_primary" id="onVoicePlayEnd">监听语音播放完毕接口</button>
	<button class="weui_btn weui_btn_primary" id="uploadVoice">上传语音接口</button>
	<button class="weui_btn weui_btn_primary" id="downloadVoice">下载语音接口</button>

	<div class="weui_cells_title">智能接口</div>
	<button class="weui_btn weui_btn_primary" id="translateVoice">识别音频并返回识别结果接口</button>

	<div class="weui_cells_title">设备信息</div>
	<button class="weui_btn weui_btn_primary" id="getNetworkType">获取网络状态接口</button>

	<div class="weui_cells_title">地理位置</div>
	<button class="weui_btn weui_btn_primary" id="openLocation">使用微信内置地图查看位置接口</button>
	<button class="weui_btn weui_btn_primary" id="getLocation">获取地理位置接口</button>

	<div class="weui_cells_title">摇一摇周边</div>
	<button class="weui_btn weui_btn_primary" id="startSearchBeacons">开启查找周边ibeacon设备接口</button>
	<button class="weui_btn weui_btn_primary" id="stopSearchBeacons">关闭查找周边ibeacon设备接口</button>
	<button class="weui_btn weui_btn_primary" id="onSearchBeacons">监听周边ibeacon设备接口</button>

	<div class="weui_cells_title">界面操作</div>
	<button class="weui_btn weui_btn_primary" id="hideOptionMenu">隐藏右上角菜单接口</button>
	<button class="weui_btn weui_btn_primary" id="showOptionMenu">显示右上角菜单接口</button>
	<button class="weui_btn weui_btn_primary" id="closeWindow">关闭当前网页窗口接口</button>
	<button class="weui_btn weui_btn_primary" id="hideMenuItems">批量隐藏功能按钮接口</button>
	<button class="weui_btn weui_btn_primary" id="showMenuItems">批量显示功能按钮接口</button>
	<button class="weui_btn weui_btn_primary" id="hideAllNonBaseMenuItem">隐藏所有非基础按钮接口</button>
	<button class="weui_btn weui_btn_primary" id="showAllNonBaseMenuItem">显示所有功能按钮接口</button>

	<div class="weui_cells_title">微信扫一扫</div>
	<button class="weui_btn weui_btn_primary" id="scanQRCode">调起微信扫一扫接口</button>

	<div class="weui_cells_title">微信小店</div>
	<button class="weui_btn weui_btn_primary" id="openProductSpecificView">跳转微信商品页接口</button>

	<div class="weui_cells_title">微信卡券</div>
	<button class="weui_btn weui_btn_primary" id="chooseCard">拉取适用卡券列表并获取用户选择信息</button>
	<button class="weui_btn weui_btn_primary" id="addCard">批量添加卡券接口</button>
	<button class="weui_btn weui_btn_primary" id="openCard">查看微信卡包中的卡券接口</button>
	<button class="weui_btn weui_btn_primary" id="consumeAndShareCard">核销后再次赠送卡券接口</button>

	<div class="weui_cells_title">微信支付</div>
	<button class="weui_btn weui_btn_primary" id="chooseWXPay">发起一个微信支付请求</button>
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="js/app.js"></script>

<script>
	wx.config({
		debug : true,
		appId : '${appId}',
		timestamp : '${timestamp}',
		nonceStr : '${nonceStr}',
		signature : '${signature}',
		jsApiList : [ 'checkJsApi', 'onMenuShareTimeline',
				'onMenuShareAppMessage', 'onMenuShareQQ', 'onMenuShareWeibo',
				'onMenuShareQZone', 'hideMenuItems', 'showMenuItems',
				'hideAllNonBaseMenuItem', 'showAllNonBaseMenuItem',
				'translateVoice', 'startRecord', 'stopRecord',
				'onVoiceRecordEnd', 'playVoice', 'onVoicePlayEnd',
				'pauseVoice', 'stopVoice', 'uploadVoice', 'downloadVoice',
				'chooseImage', 'previewImage', 'uploadImage', 'downloadImage',
				'getNetworkType', 'openLocation', 'getLocation',
				'hideOptionMenu', 'showOptionMenu', 'closeWindow',
				'scanQRCode', 'chooseWXPay', 'openProductSpecificView',
				'addCard', 'chooseCard', 'openCard' ]
	});
</script>

</html>