package com.qinchy.weixin4jdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.Configuration;
import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.normal.*;
import org.weixin4j.message.output.TextOutputMessage;
import org.weixin4j.spi.DefaultNormalMessageHandler;

public class WeixinNormalMessageHandler extends DefaultNormalMessageHandler {

    private Logger log = LoggerFactory.getLogger(WeixinNormalMessageHandler.class);

    private OutputMessage allType(NormalMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        String content="";
        if(msg instanceof TextInputMessage){
            content = " 消息内容："+((TextInputMessage)msg).getContent();
        }else if(msg instanceof LocationInputMessage){
            content = " 位置信息："+((LocationInputMessage)msg).getLabel();
        }else if(msg instanceof LinkInputMessage){
            content = " 消息内容："+((LinkInputMessage)msg).getDescription();
        }else if(msg instanceof ShortVideoInputMessage){
            content = " mediaId："+((ShortVideoInputMessage)msg).getMediaId();
        }else if(msg instanceof ImageInputMessage){
            content = " mediaId："+((ImageInputMessage)msg).getMediaId();
        }else if(msg instanceof VoiceInputMessage){
            content = " mediaId："+((VoiceInputMessage)msg).getMediaId();
        }else if(msg instanceof VideoInputMessage){
            content = " mediaId："+((VideoInputMessage)msg).getMediaId();
        }
        out.setContent("你的消息已经收到！消息类型是：" + msg.getMsgType() + content);
        return out;
    }

    @Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到文本消息：" + msg.getContent());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到图片消息：" + msg.getMediaId());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到语音消息：" + msg.getMediaId());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到视频消息：" + msg.getMediaId());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到短视频消息：" + msg.getMediaId());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到位置消息：" + msg.getLabel());
        }
        return allType(msg);
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage msg) {
        if (Configuration.isDebug()) {
            log.debug("收到链接消息：" + msg.getDescription());
        }
        return allType(msg);
    }
}
