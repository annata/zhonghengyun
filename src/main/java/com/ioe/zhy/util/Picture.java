/**
 * 
 */
package com.ioe.zhy.util;

import java.io.File;
import java.nio.file.AccessDeniedException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hq
 *
 */
public class Picture {

//    @Resource
//    ServletContext servletContext;
//
//    @Transactional
//    public void uploads(MultipartFile multipartFile) {
//        String realPath = servletContext.getRealPath("/Uploads");
//        File file = new File(realPath);
//        if (!file.exists()) file.mkdir();
//    }
//
//    public static final String OSSAccessKeyId = "LTAIFzoyBADuj037";
//
//    public static final String OSSAccessKeySecret;
//
//    public static final String callbackUrl = "http://report.xiyoukeji.com/upload_success";
//
//    public static final String ossUrl = "http://xiyou-report.oss-cn-hangzhou.aliyuncs.com";
//
//    public static final Map<String, String> mimeType = new HashMap<>();
//
//    public Picture() {
//        mimeType.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
//        mimeType.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
//        mimeType.put("application/msword", "doc");
//        mimeType.put("application/vnd.ms-excel", "xls");
//        mimeType.put("application/pdf", "pdf");
//        mimeType.put("video/mp4", "mp4");
//        mimeType.put("audio/mp3", "mp3");
//        mimeType.put("image/jpeg", "jpeg");
//        mimeType.put("image/png", "png");
//        mimeType.put("image/gif", "gif");
//        mimeType.put("image/jpg", "jpg");
//    }
//
//    @Transactional
//    public Map ossUpload(String type) {
//        if (type == null || !mimeType.containsKey(type)) throw new AccessDeniedException();
//        String name = UUID.randomUUID().toString() + "." + mimeType.get(type);
//        String callback = Base64.encode(new Gson().toJson(MapTool.Map().put("callbackUrl", callbackUrl)
//                .put("callbackBody", "mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}&id=" + createResources(name, type))).getBytes());
//        String policy = getPolicy(name, callback);
//        return MapTool.Map().put("policy", policy).put("key", name).put("OSSAccessKeyId", OSSAccessKeyId)
//                .put("Signature", DecriptTest.encryptHMAC_SHA1byBASE64(policy, OSSAccessKeySecret))
//                .put("callback", callback);
//    }
//
//    private int createResources(String name, String type) {
//        User my = userService.get();
//        Resources resources = new Resources();
//        resources.setUser(my);
//        resources.setType(type);
//        resources.setUrl(ossUrl + "/" + name);
//        return save(resources);
//    }
//
//    private String getPolicy(String key, String callback) {
//        try {
//            List<Object> conditions = new ArrayList<>(), content_length_range = new ArrayList<>();
//            content_length_range.add("content-length-range");
//            content_length_range.add(0);
//            content_length_range.add(104857600);
//            conditions.add(MapTool.Map().put("key", key));
//            conditions.add(content_length_range);
//            conditions.add(MapTool.Map().put("callback", callback));
//            Map put = MapTool.Map().put("expiration", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//                    .format(new Date(System.currentTimeMillis() + 120000L))).put("conditions", conditions);
//            String s = new Gson().toJson(put);
//            return cn.wqy.pay.alipay.Base64.encode(s.getBytes("utf8"));
//        } catch (UnsupportedEncodingException e) {
//            throw new SystemErrorException();
//        }
//    }
//
//    @Transactional
//    public void success(int id, String mimeType, String height, String width) {
//        Resources resources = get(id);
//        resources.setType(mimeType);
//        resources.setHeight(height);
//        resources.setWidth(width);
//        if(!resources.getType().equals(mimeType)){
//            throw new AccessDeniedException();
//        }
//        resources.setSuccess(true);
//    }

}
