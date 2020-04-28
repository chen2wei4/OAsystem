/**
 * @author liuwenpeng
 * @createDate 2020年4月28日
 */
package com.woniuxy.oasystem.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Description  TODO
 * @author liuwenpeng
 * @changeLog 	1. 创建 (2020年4月28日 下午9:05:03 [liuwenpeng])
 * 				2.文件上传工具类
 */
public class FileUtil {
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
