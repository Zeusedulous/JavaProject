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
     * *** ??????????????????ID(?????????????????????????????????????????????,????????????,??????????????????) ****
     */
    private long marketAppID; // optional
    /**
     * ????????????
     */
    private  java.lang.String imageMark; // required
    /**
     * ????????????????????????????????????????????????????????????????????????
     */
    private int isSearch; // required
    /**
     * ??????????????????????????? *
     */
    private java.lang.String createTime; // required
    /**
     * ?????????????????????????????????*
     */
    private  java.lang.String createPassTime; // required
    /**
     * ????????????????????????????????? *
     */
    private  java.lang.String updatePassTime; // required
    /**
     * ?????????????????? *
     */
    private java.lang.String roleCode; // required
    /**
     * ????????????????????? *
     */
    private  java.lang.String appAdminStatus; // required
}
