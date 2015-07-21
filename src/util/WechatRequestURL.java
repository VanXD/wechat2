package util;

public class WechatRequestURL {
	//新增永久多媒体文件
	public static final String ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
	//新增永久图文
	public static final String ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
	//删除永久素材
	public static final String DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
	//获取永久素材
	public static final String GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
	//更新永久图文素材
	public static final String UPDATE_ARTICLE = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";
	//添加临时素材
	public static final String ADD_TEMP_MATERIAL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";
	//获取素材列表
	public static final String BATCH_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
	//获取永久素材的总数
	public static final String GET_MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
	
}
