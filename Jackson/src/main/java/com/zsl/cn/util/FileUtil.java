package com.zsl.cn.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.zsl.cn.pojo.Menu;
import lombok.val;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

	public static byte[] readByte(InputStream is) {
		try {
			byte[] r = new byte[is.available()];
			is.read(r);
			return r;
		} catch (Exception e) {
		}
		return null;
	}


	public static String readText(File f) {
		return readText(f, "UTF-8");
	}

	public static String readText(File f, String encoding) {
		try {
			InputStream is = new FileInputStream(f);
			String str = readText(is, encoding);
			is.close();
			return str;
		} catch (Exception e) {
		}
		return null;
	}

	public static String readText(InputStream is, String encoding) {
		try {
			String code = "UpgradeManagementSave,feedback_tab_content,feedback_tab_setting,secret_security_add,secret_security_edit,secret_security_save,secret_security_delete,secret_security_setting,appManageConfig,appType,app_authority,dcApp,publicNumberManageConfig,operatorApply,changeAudit,PublicNumberAudit,appManageToAdd,appManageDelApp,appEnable,appManagerJumpPage,gotoBackstage,appEditStatus,Subscription_no,Company_no,app_number,thirdApply,emctionPackageToCreate,emctionPackagePreEmotion,emctionPackageUpdate,emctionPackageDel,emoticonEnable,emciton_edit,uploadEmoticonZip,operatorApply_detail,orgPermissionConfigSave,orgPermissionConfigAdd,orgPermissionConfigStart,orgPermissionConfigStop,orgPermissionConfigToEdit,orgPermissionConfigDel,orgPermissEnable,expendAdd,upExpendField,badWordAdd,badWordUpdate,appManageCreateApp,publicNumberEdit,publicDismissed,emotionSubmit,orgPermissionConfigAddOrgPer,appManagerAddApp,saveSecuritycenterConfig,saveVrvXinConfig,saveLoginConfig,saveClientConfig,welcome,batchBadWord,appTypeAdd,appTypeEdit,appTypeDel,publicNumberJumpToView,publicLocking,publicUnlock,follow_no,follow_off,upgrade,public_authorization,enterpriseEdit,enterpriseFail,orgPermissionConfig,tacticsConfig,policy_tab_employee_level,enterpriseLocking,enterpriseUnlock,enterpriseUpdate,enterpriseNumberJumpToView,ent_authorization,transferPage,toViewUserPage,transfer,tacticsConfigAdd,tacticsConfigDel,tacticsConfigEdit,app_authorization,app_num_details,app_num_approve,app_num_reject,app_num_grounding,app_num_undercarriage,app_num_delete,app_authority_add,app_authority_edit,app_authority_del,account_statistics_export,enterprise_list,app_list,third_list,enterprise_details,app_details,approve_audit_ent_pass,approve_audit_ent_reject,app_audit_ent_pass,app_audit_ent_reject,inviting_code_add,inviting_code_del,inviting_code_save,desk_add,desk_update_status,desk_update_order,desk_del_banner,desk_edit_banner,saveDeskData,help_add,help_edit,help_del,help_save,operatorApply_pass,operatorApply_fail,third_details,thirdAppApply_view,approve_audit_third_pass,approve_audit_third_reject,thirdAppApply_pass,thirdAppApply_failed,staffGrade_del,staffGrade_edit,staffGrade_add,feedback_search,feedback_export,feedback_detail,feedback_download,feedback_save,feedback_select,welcome_upload,welcome_del,welcome_activate,welcome_stop,sysConfigToUpdate,Subscription_no_new,Company_no_new,app_number_new,third_app_number_new,Subscription_no_newDetail,Subscription_no_newPassed,Subscription_no_newFailed,Company_no_newDetail,Company_no_newPassed,Company_no_newFailed,app_number_newDetail,app_number_level,app_level,third_app_number_newDetail,third_app_number_newPassed,third_app_number_newFailed,app_number_newPassed,app_number_newFailed,app_number_apply_newPassed,app_number_apply_newFailed,emctionPackage,clientConfig,desk,help,clientMenu,shortcut,audioVideo,groupDoc,clientMenuEdit,clientMenuDelete,clientMenuSort,clientMenuSave,userTag_group,userTag_tag,userTag_group_add,userTag_group_edit,userTag_group_delete,userTag_tag_addTag,userTag_tag_edit,userTag_tag_set,userTag_tag_deleteTag,userTag_user_addUser,userTag_strategy_save,userTag_user_deleteUser,thirdOAuthAdd,thirdOAuthEdit,thirdOAuthDelete,editThirdLogin,getThirdLogin,delThirdLogin,badWordToAdd,badWordToUpdate,badWordBatchDel,batchAddBadWord,updateShortcut,cancel_apply_approved,cancel_apply_refused,cancel_apply_delete,saveAudioVideoConfig,exportShareStatistics,exportAudioVideoStatistics,groupDocSave,UpgradeManagement,FeedbackManagement,badWord,appService,publicNumberManage,expendToAdd,expendToEdit,expendToDel,secConfig,xinConfig,loginConfig,Strategy_Management,loginExtendToAdd,loginExtendDel,account_statistics,inviting_code,account_rule_config,clientPersonalization,userTag,thirdOAuth,cancelApply,ShareStatistics,AUDIO_VIDEO_STATISTICS";
			List<String> codeLsit = Arrays.asList(code.split(","));

			int count = 0;
			System.out.println(codeLsit.size());
			BufferedReader br = new BufferedReader(new InputStreamReader(is, encoding));
			StringBuffer sb = new StringBuffer();
			StringBuffer sqls = new StringBuffer();
			List<Menu> menuList = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				String [] str = line.split("'");
				String id = str[1];
				line = line.substring(line.indexOf("'IM_ENTERPRISE',") + 17,line.length()-3);
				line = StringEscapeUtils.unescapeJavaScript(line);
				Menu menu = JacksonUtil.str2pojo(line, Menu.class);
				if(codeLsit.contains(menu.getCode())){
					menuList.add(menu);
					if(!menu.getName().startsWith("{\\")){
						menu.setName(JacksonUtil.obj2JsonStr(menu.getName()));
						System.out.println(menu.getName());
						menu.setName(menu.getName().substring(1,menu.getName().length()-3) + "\"}" ) ;
						System.out.println(menu.getName());
					}
					menu.setStatus("2");
					String sql = "update `TableInitData_6.0.1_handa`" +
							" set `initFieldsJSONData` = '" + JacksonUtil.obj2JsonStr(menu) + "'" +
							" where `id`=" + id + ";";
					sqls.append(sql).append("\n");
				}

				sb.append(line);
				sb.append("\n");
			}
			System.out.println(menuList.size());
			br.close();
			return sqls.toString();
		} catch (Exception e) {
		}
		return null;
	}

	public static String readText(String fileName) {
		return readText(fileName, "UTF-8");
	}

	public static String readText(String fileName, String encoding) {
		try(InputStream is = new FileInputStream(fileName);
			InputStreamReader reader = new InputStreamReader(is, encoding);
			BufferedReader br = new BufferedReader(reader)) {
			StringBuffer sb = new StringBuffer();
			String line;
			int c = br.read();
			if (!encoding.equalsIgnoreCase("UTF-8") || c != 65279) {
				sb.append((char) c);
			}
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	public static String readURLText(String urlPath) {
		return readURLText(urlPath, "UTF-8");
	}

	/**
	 * 根据urlPath读取网页数据
	 *
	 * @param urlPath
	 * @param encoding
	 * @return
	 */
	public static String readURLText(String urlPath, String encoding) {
		try {
			URL url = new URL(urlPath);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = in.readLine()) != null) {
				sb.append(line + "\n");
			}
			in.close();
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}


	public static void main(String[] args) throws Exception {
		File file = new File("L://MENU.sql");
		String s = readText(file);
		System.out.println(s);
	}


}
