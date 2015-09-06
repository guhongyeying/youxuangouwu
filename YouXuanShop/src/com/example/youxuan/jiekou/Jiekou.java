package com.example.youxuan.jiekou;

public class Jiekou {
	// 一下10个接口共用一个实体类（JinPin）
	public static final String shuma = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=1";
	public static final String nvzhuang = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=2";
	public static final String nanzhuang = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=3";
	public static final String jiaju = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=4";
	public static final String muying = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=5";
	public static final String xiebao = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=6";
	public static final String peishi = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=7";
	public static final String meizhuang = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=8";
	public static final String meishi = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=9";
	public static final String qita = "http://jkjby.repaiapp.com/jkjby/view/list_api.php?cid=10";
	// 使用实体类（JinPin）
	public static final String jingpingouwu = "http://jkjby.repaiapp.com/jkjby/view/list_api.php";
	// 使用实体类（ZhuTi）
	public static final String zhutijiedao = "http://app.api.repaiapp.com/zkb/api/zhuanti.php";
	// 主题详情
	public static final String zhutixiangqing = "http://app.api.repaiapp.com/zkb/api/zhuanti.php?zid=%s";
	// 主题详情里的webview
	public static final String zhutixiangqingwebview = "http://cloud.yijia.com/goto/item.php?app_id=1&app_oid=2152241206bae92a&app_version=3.7.0&app_channel=91com&id=%s&sche=pashley";
	// 使用实体类（JinPin）(自带分页)
	public static final String tiantiantejia = "http://app.api.yijia.com/newapps/tttj/api/index.php?model=tttj_data&page=%s";
	public static final String xianshimiaoshabiaoti = "http://app.api.repai.com/zkb/api/zhekoubao.php?model=miaosha_cate&time=";
	// 使用实体类（XianShi）(%s替换时间点)
	public static final String xianshimiaoshatupian = "http://app.api.repai.com/zkb/api/zhekoubao.php?model=miaosha_data&time=0&id=%s";
	// 文字写死
	public static final String search = "http://app.api.repaiapp.com/zkb/api/hot_keyword.php";
	// 使用实体类（BinnerViewPager）
	public static final String viewpager = "http://app.api.repaiapp.com/zkb/api/ad.php?app_id=1&cid=0&app_oid=2152241206bae92a&app_channel=91com&sche=pashley";
	// 天天特价侧边栏(page翻页 cid选中的项目)
	public static final String tiantiancelan = "http://app.api.yijia.com/newapps/tttj/api/index.php?model=tttj_data&page=%s&cid=%s";
	/** 首页 上的 3D翻页 */
	public static final String SHOUYE_TOP2 = "http://app.api.repaiapp.com/zkb/api/zhekoubao.php?model=xihuan";
	/** 首页上的3d翻页的商品详情 */
	public static final String SHOUYE_TOP3 = "http://cloud.yijia.com/goto/item.php?app_id=1&app_oid=339a89d33add74b4&app_version=3.5.8&app_channel=91com&id=";

	// 我的淘宝
	public static final String wodetaobao = "http://h5.m.taobao.com/awp/mtb/mtb.htm#!/awp/mtb/mtb.htm";
	// 查物流
	public static final String chawuliu = "http://h5.m.taobao.com/awp/mtb/mtb.htm#!/awp/mtb/olist.htm?sta=5";
	// 购物车
	public static final String gouwuche = "http://h5.m.taobao.com/awp/base/cart.htm?spm=0.0.0.0#!/awp/base/cart.htm?spm=0.0.0.0";
	// 查订单

	public static final String chadingdan = "http://h5.m.taobao.com/awp/mtb/mtb.htm#!/awp/mtb/olist.htm?sta=4";
	// 收藏
	public static final String shoucang = "http://h5.m.taobao.com/fav/index.htm?spm=0.0.0.0#!goods/queryColGood-1";

	//搜索
	public static final String sousuo = "http://jkjby.repaiapp.com/jkjby/view/tmzk_api.php?price=0,9999&keyword=";
}
