package com.qinchy.weixin4jdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.Configuration;
import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.event.*;
import org.weixin4j.message.output.TextOutputMessage;
import org.weixin4j.spi.DefaultEventMessageHandler;

public class WeixinEventMessageHandler extends DefaultEventMessageHandler {

    private Logger log = LoggerFactory.getLogger(WeixinEventMessageHandler.class);

    private OutputMessage allType(EventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！消息类型："+msg.getMsgType()+" 事件类型："+msg.getEvent());
        return out;
    }

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到订阅消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到取消订阅消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到扫描带参数二维码消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到扫描带参数二维码消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到上报地理位置消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到点击菜单拉取消息时的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到点击菜单跳转链接时的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到扫码推事件的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到扫码推事件且弹出“消息接收中”提示框的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到扫码推事件的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到弹出拍照或者相册发图的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到弹出微信相册发图器的事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到上报地理位置事件消息：" + msg.getMsgType());
        }
        return allType(msg);
    }

}
