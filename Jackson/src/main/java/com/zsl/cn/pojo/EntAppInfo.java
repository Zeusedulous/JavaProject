package com.zsl.cn.pojo;

import lombok.Data;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/9 14:54
 * @Desc :
 */
@Data
public class EntAppInfo {
    private String appSign; // required
    private String appName; // required
    private String appIcon; // required
    private long appID; // optional
    private String appSecret; // optional
    private String appUrl; // optional
    private String appToken; // optional
    private java.util.Map<java.lang.String,java.lang.Byte> appSetting;
    private java.util.Map<java.lang.Byte,java.util.Map<java.lang.String,java.lang.String>> configs; // optional
    private long entID; // required
    private java.lang.String entName; // required
    private java.lang.String appHomeUrl; // required
    private java.lang.String appMenus; // optional
    private byte status; // optional
    private java.lang.String appFunctintroduce; // optional
    private byte openIDEncoded; // optional
    private byte sdkType; // optional
    private java.lang.String subAccount; // optional
    private java.lang.String version; // optional
    private long ownerId; // optional
    private byte appType; // optional
    private byte appSubType; // optional
    private byte recommend; // optional
    private byte defaultInstall; // optional
    private byte showInMy; // optional
    private java.lang.String extend; // optional
    private java.lang.String deviceTypes; // optional
    private java.lang.String appUrl2; // optional
    private byte enableRemoveServer; // optional
    private byte useLocal; // optional
    private java.lang.String messageHistoryUrl; // optional
    private java.lang.String menuOpen; // optional
    private java.lang.String replyMenuOpen; // optional
    private java.lang.String description; // optional
    private java.lang.String openIDRemark; // optional
    private byte subOrAppType; // required
    private java.util.List<java.lang.String> orgIdList; // required
    private java.util.List<java.lang.String> delOrgIdList; // required
    private java.lang.String orgCode; // required
    private byte lineStatus; // required
    private int syncOrgAndUserSwitch; // optional
    private byte forceGrant; // required
    private java.lang.String appName_PinYin; // optional
    private java.lang.String highRiskInterfIDs; // optional
    /**
     * *** 应用号下应用ID(后台变更审核分页列表查询时使用,仅仅展示,不操作任何库) ****
     */
    private long marketAppID; // optional
    /**
     * 图片水印
     */
    private  java.lang.String imageMark; // required
    /**
     * 是否允许用户通过公众服务号名称搜索到本公共服务号
     */
    private int isSearch; // required
    /**
     * 公众号创建提交时间 *
     */
    private java.lang.String createTime; // required
    /**
     * 公众号创建审核通过时间*
     */
    private  java.lang.String createPassTime; // required
    /**
     * 公众号修改审核通过时间 *
     */
    private  java.lang.String updatePassTime; // required
    /**
     * 配置查询信息 *
     */
    private java.lang.String roleCode; // required
    /**
     * 运营者审核状态 *
     */
    private  java.lang.String appAdminStatus; // required
}
