package com.woniuxy.oasystem.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oasystem.entity.AnnouncementFile;
import com.woniuxy.oasystem.entity.ResponseResult;
import com.woniuxy.oasystem.service.AnnouncementFileService;

@Controller
public class AnnouncementFileController {


	@Autowired
	AnnouncementFileService announcementFileService;
	@RequiresPermissions("announcement:select")
	@RequestMapping("/downloadFile")
	public String downloadFile2(AnnouncementFile annf, HttpServletResponse response ,Model model) {
		String downloadFilePath = annf.getAfAddress();// 被下载的文件在服务器中的路径,
		String fileName = annf.getAfName();// 被下载文件的名称
		File file = new File(downloadFilePath);
		if (file.exists()) {
			response.setContentType("application/force-download");// 设置强制下载不打开            
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			byte[] buffer = new byte[1024];
			FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("errorcode", 500);
				model.addAttribute("error","文件下载出错请联系管理员");
				return "lyear_pages_error";
			}finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
	
	/*
	 *软删除公告
	 */
	@RequiresPermissions("announcement:manage")
	@ResponseBody
	@RequestMapping("/deletefiles")
	public ResponseResult<AnnouncementFile> deleteannouncementFile(HttpServletRequest req, AnnouncementFile af,
			Model model) {
		
		try {// 软删除公告文件
			Integer afId = af.getAfId();
			System.out.println(afId);
			announcementFileService.deleteFileById(afId);
			return new ResponseResult<AnnouncementFile>(200, "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult<AnnouncementFile>(500, "failed", null);
		}
	}
	
	
}