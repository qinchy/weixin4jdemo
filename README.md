# menu demo
{
    "button": [
        {
            "name": "基础支持", 
            "sub_button": [
                {
                    "type": "click", 
                    "name": "获取access_token", 
                    "key": "getAccessToken", 
                    "sub_button": [ ]
                }, 
                {
                    "type": "view", 
                    "name": "搜索", 
                    "url": "http://www.soso.com/", 
                    "sub_button": [ ]
                }, 
                {
                    "name": "发送位置", 
                    "type": "location_select", 
                    "key": "rselfmenu_2_0"
                }
            ]
        }, 
        {
            "name": "扫码", 
            "sub_button": [
                {
                    "type": "scancode_waitmsg", 
                    "name": "扫码带提示", 
                    "key": "rselfmenu_0_0", 
                    "sub_button": [ ]
                }, 
                {
                    "type": "scancode_push", 
                    "name": "扫码推事件", 
                    "key": "rselfmenu_0_1", 
                    "sub_button": [ ]
                }
            ]
        }, 
        {
            "name": "发图", 
            "sub_button": [
                {
                    "type": "pic_sysphoto", 
                    "name": "系统拍照发图", 
                    "key": "rselfmenu_1_0", 
                    "sub_button": [ ]
                }, 
                {
                    "type": "pic_photo_or_album", 
                    "name": "拍照或者相册发图", 
                    "key": "rselfmenu_1_1", 
                    "sub_button": [ ]
                }, 
                {
                    "type": "pic_weixin", 
                    "name": "微信相册发图", 
                    "key": "rselfmenu_1_2", 
                    "sub_button": [ ]
                }
            ]
        }
    ]
}