/**
 * @author liuwenpeng
 * @createDate 2020年4月29日
 */
package com.woniuxy.oasystem.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月29日 上午10:46:35 [liuwenpeng])
 * 				2.文件上传工具类
 */
public class FileUtil {

	/**
	 * TODO
	 * @param file
	 * @param string
	 * @return
	 * @changeLog 	1. 创建 (2020年4月29日 上午10:46:59 [liuwenpeng])
	 *              2.文件上传工具方法
	 */
	public static String uploadFile(MultipartFile file, String uploadPath) {
		//如果文件是空，返回空
        if (file.isEmpty()) {
            return null;
        }
      //获取这个文件的名字，目的是获取这个文件的后缀名
        String fileName = file.getOriginalFilename();
        //获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if(suffixName!=null) {
      //为上传的文件建立一个新名字，避免文件名重复。这里用当前时间戳 加 一个6位随机数 加 文件后缀名
        fileName = System.currentTimeMillis() +""+ ((int)(Math.random()*1000000)) + suffixName;
        }else {
        fileName = System.currentTimeMillis() +""+ ((int)(Math.random()*1000000)) ;
        }
        //在磁盘创建这个文件目录
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
      //创建这个绝对路径的文件对象
        File uploadFile = new File(uploadDir + uploadDir.separator + fileName);
        try {
            //把file转移给uploadFile，上传
            file.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回绝对路径
		return uploadDir + uploadDir.separator + fileName;
	}

}
