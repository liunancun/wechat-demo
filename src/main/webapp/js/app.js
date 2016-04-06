var link_1 = "http://movie.douban.com/subject/25785114/";
var link_2 = "http://demo.open.weixin.qq.com/jssdk/images/p2166127561.jpg";

var img_1 = "http://liunancun.xicp.net:8080/wechat/images/1.jpg";
var img_2 = "http://liunancun.xicp.net:8080/wechat/images/2.jpg";
var img_3 = "http://liunancun.xicp.net:8080/wechat/images/3.jpg";

var images = {
	localIds : [],
	serverIds : []
};
var voice = {
	localId : '',
	serverId : ''
};

/**
 * 摇一摇周边 微信小店 微信卡券 微信支付
 */
wx.ready(function() {

	// 基础接口
	// 判断当前客户端版本是否支持指定JS接口
	document.getElementById('checkJsApi').onclick = function() {
		wx.checkJsApi({
			jsApiList : [ 'getNetworkType', 'previewImage' ],
			success : function(res) {

			}
		});
	};

	// 分享接口
	// 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
	document.getElementById('onMenuShareTimeline').onclick = function() {
		wx.onMenuShareTimeline({
			title : '互联网之子',
			link : link_1,
			imgUrl : link_2,
			success : function() {
				alert('已分享');
			},
			cancel : function() {
				alert('已取消');
			}
		});
	};
	// 获取“分享给朋友”按钮点击状态及自定义分享内容接口
	document.getElementById('onMenuShareAppMessage').onclick = function() {
		wx.onMenuShareAppMessage({
			title : '互联网之子',
			desc : '在长大的过程中，我才慢慢发现...',
			link : link_1,
			imgUrl : link_2,
			success : function() {
				alert('已分享');
			},
			cancel : function() {
				alert('已取消');
			}
		});
	};
	// 获取“分享到QQ”按钮点击状态及自定义分享内容接口
	document.getElementById('onMenuShareQQ').onclick = function() {
		wx.onMenuShareQQ({
			title : '互联网之子',
			desc : '在长大的过程中，我才慢慢发现...',
			link : link_1,
			imgUrl : link_2,
			success : function() {
				alert('已分享');
			},
			cancel : function() {
				alert('已取消');
			}
		});
	};
	// 获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口
	document.getElementById('onMenuShareWeibo').onclick = function() {
		wx.onMenuShareWeibo({
			title : '互联网之子',
			desc : '在长大的过程中，我才慢慢发现...',
			link : link_1,
			imgUrl : link_2,
			success : function() {
				alert('已分享');
			},
			cancel : function() {
				alert('已取消');
			}
		});
	};
	// 获取“分享到QQ空间”按钮点击状态及自定义分享内容接口
	document.getElementById('onMenuShareQZone').onclick = function() {
		wx.onMenuShareQZone({
			title : '互联网之子',
			desc : '在长大的过程中，我才慢慢发现...',
			link : link_1,
			imgUrl : link_2,
			success : function() {
				alert('已分享');
			},
			cancel : function() {
				alert('已取消');
			}
		});
	};

	// 图像接口
	// 拍照或从手机相册中选图接口
	document.getElementById('chooseImage').onclick = function() {
		wx.chooseImage({
			count : 1,
			sizeType : [ 'original', 'compressed' ],
			sourceType : [ 'album', 'camera' ],
			success : function(res) {
				images.localIds = res.localIds;
			}
		});
	};
	// 预览图片接口
	document.getElementById('previewImage').onclick = function() {
		wx.previewImage({
			current : img_2,
			urls : [ img_1, img_2, img_3 ]
		});
	};
	// 上传图片接口
	document.getElementById('uploadImage').onclick = function() {
		wx.uploadImage({
			localId : images.localIds[0],
			isShowProgressTips : 1,
			success : function(res) {
				images.serverIds.push(res.serverId);
			}
		});
	};
	// 下载图片接口
	document.getElementById('downloadImage').onclick = function() {
		wx.downloadImage({
			serverId : images.serverIds[0],
			isShowProgressTips : 1,
			success : function(res) {
				images.localIds.push(res.localId);
			}
		});
	};

	// 音频接口
	// 开始录音接口
	document.getElementById('startRecord').onclick = function() {
		wx.startRecord();
	};
	// 停止录音接口
	document.getElementById('stopRecord').onclick = function() {
		wx.stopRecord({
			success : function(res) {
				voice.localId = res.localId;
			}
		});
	};
	// 监听录音自动停止接口
	document.getElementById('onVoiceRecordEnd').onclick = function() {
		wx.onVoiceRecordEnd({
			complete : function(res) {
				voice.localId = res.localId;
			}
		});
	};
	// 播放语音接口
	document.getElementById('playVoice').onclick = function() {
		wx.playVoice({
			localId : voice.localId
		});
	};
	// 暂停播放接口
	document.getElementById('pauseVoice').onclick = function() {
		wx.pauseVoice({
			localId : voice.localId
		});
	};
	// 停止播放接口
	document.getElementById('stopVoice').onclick = function() {
		wx.stopVoice({
			localId : voice.localId
		});
	};
	// 监听语音播放完毕接口
	document.getElementById('onVoicePlayEnd').onclick = function() {
		wx.onVoicePlayEnd({
			success : function(res) {
				voice.localId = res.localId;
			}
		});
	};
	// 上传语音接口
	document.getElementById('uploadVoice').onclick = function() {
		wx.uploadVoice({
			localId : voice.localId,
			isShowProgressTips : 1,
			success : function(res) {
				voice.serverId = res.serverId;
			}
		});
	};
	// 下载语音接口
	document.getElementById('downloadVoice').onclick = function() {
		wx.downloadVoice({
			serverId : voice.serverId,
			isShowProgressTips : 1,
			success : function(res) {
				voice.localId = res.localId;
			}
		});
	};

	// 智能接口
	// 识别音频并返回识别结果接口
	document.getElementById('translateVoice').onclick = function() {
		wx.translateVoice({
			localId : voice.localId,
			isShowProgressTips : 1,
			success : function(res) {
				alert(res.translateResult);
			}
		});
	};

	// 设备信息
	// 获取网络状态接口
	document.getElementById('getNetworkType').onclick = function() {
		wx.getNetworkType({
			success : function(res) {
				alert(res.networkType);
			}
		});
	};

	// 地理位置
	// 使用微信内置地图查看位置接口
	document.getElementById('openLocation').onclick = function() {
		wx.openLocation({
			latitude : 23.099994,
			longitude : 113.324520,
			name : 'TIT 创意园',
			address : '广州市海珠区新港中路 397 号',
			scale : 14,
			infoUrl : 'http://weixin.qq.com'
		});
	};
	// 获取地理位置接口
	document.getElementById('getLocation').onclick = function() {
		wx.getLocation({
			type : 'gcj02',
			success : function(res) {
				var latitude = res.latitude;
				var longitude = res.longitude;
				var speed = res.speed;
				var accuracy = res.accuracy;
			}
		});
	};
	
	// 摇一摇周边
	// 开启查找周边ibeacon设备接口
	document.getElementById('startSearchBeacons').onclick = function() {
		wx.startSearchBeacons({
			ticket:"",  //摇周边的业务ticket, 系统自动添加在摇出来的页面链接后面
			complete:function(argv){
				//开启查找完成后的回调函数
			}
		});
	};
	// 关闭查找周边ibeacon设备接口
	document.getElementById('stopSearchBeacons').onclick = function() {
		wx.stopSearchBeacons({
			complete:function(res){
				//关闭查找完成后的回调函数
			}
		});
	};
	// 监听周边ibeacon设备接口
	document.getElementById('onSearchBeacons').onclick = function() {
		wx.onSearchBeacons({
			complete:function(argv){
				//回调函数，可以数组形式取得该商家注册的在周边的相关设备列表
			}
		});
	};

	// 界面操作
	// 隐藏右上角菜单接口
	document.getElementById('hideOptionMenu').onclick = function() {
		wx.hideOptionMenu();
	};
	// 显示右上角菜单接口
	document.getElementById('showOptionMenu').onclick = function() {
		wx.showOptionMenu();
	};
	// 关闭当前网页窗口接口
	document.getElementById('closeWindow').onclick = function() {
		wx.closeWindow();
	};
	// 批量隐藏功能按钮接口
	document.getElementById('hideMenuItems').onclick = function() {
		wx.hideMenuItems({
			menuList : [ 'menuItem:readMode', 'menuItem:share:timeline',
					'menuItem:copyUrl' ]
		});
	};
	// 批量显示功能按钮接口
	document.getElementById('showMenuItems').onclick = function() {
		wx.showMenuItems({
			menuList : [ 'menuItem:readMode', 'menuItem:share:timeline',
					'menuItem:copyUrl' ]
		});
	};
	// 隐藏所有非基础按钮接口
	document.getElementById('hideAllNonBaseMenuItem').onclick = function() {
		wx.hideAllNonBaseMenuItem();
	};
	// 显示所有功能按钮接口
	document.getElementById('showAllNonBaseMenuItem').onclick = function() {
		wx.showAllNonBaseMenuItem();
	};

	// 微信扫一扫
	// 调起微信扫一扫接口
	document.getElementById('scanQRCode').onclick = function() {
		wx.scanQRCode({
			needResult : 0,
			scanType : [ "qrCode", "barCode" ],
			success : function(res) {
				alert(res.resultStr);
			}
		});
	};

	// 微信小店
	// 跳转微信商品页接口
	document.getElementById('openProductSpecificView').onclick = function() {
		wx.openProductSpecificView({
			productId : 'pDF3iY_m2M7EQ5EKKKWd95kAxfNw',
			viewType : '0'
		});
	};

	// 微信卡券
	// 拉取适用卡券列表并获取用户选择信息
	document.getElementById('chooseCard').onclick = function() {
		wx.chooseCard({
			timestamp : 1437997723,
			nonceStr : 'k0hGdSXKZEj3Min5',
			cardSign : '8ef8aa071f1d2186cb1355ec132fed04ebba1c3f',
			success : function(res) {
				var cardList = res.cardList; // 用户选中的卡券列表信息
			}
		});
	};
	// 批量添加卡券接口
	document.getElementById('addCard').onclick = function() {
		wx.addCard({
			cardList : [ {
				cardId : 'pDF3iY9tv9zCGCj4jTXFOo1DxHdo',
				cardExt : ''
			} ],
			success : function(res) {
				var cardList = res.cardList;
			}
		});
	};
	// 查看微信卡包中的卡券接口
	document.getElementById('openCard').onclick = function() {
		wx.openCard({
			cardList : [ {
				cardId : 'pDF3iY9tv9zCGCj4jTXFOo1DxHdo',
				code : ''
			} ]
		});
	};
	// 核销后再次赠送卡券接口
	document.getElementById('consumeAndShareCard').onclick = function() {
		wx.consumeAndShareCard({
			cardId : '',
			code : ''
		});
	};

	// 微信支付
	// 发起一个微信支付请求
	document.getElementById('chooseWXPay').onclick = function() {
		wx.chooseWXPay({
			timestamp : 1414723227,
			nonceStr : 'noncestr',
			package : 'addition=action_id%3dgaby1234%26limit_pay%3d&bank_type=WX&body=innertest&fee_type=1&input_charset=GBK&notify_url=http%3A%2F%2F120.204.206.246%2Fcgi-bin%2Fmmsupport-bin%2Fnotifypay&out_trade_no=1414723227818375338&partner=1900000109&spbill_create_ip=127.0.0.1&total_fee=1&sign=432B647FE95C7BF73BCD177CEECBEF8D',
			signType : 'SHA1', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
			paySign : 'bd5b1933cda6e9548862944836a9b52e8c9a2b69',
			success : function(res) {
				// 支付成功后的回调函数
			}
		});
	};

});