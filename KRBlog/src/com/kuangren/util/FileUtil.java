package com.kuangren.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.kuangren.exception.CustomException;

public class FileUtil {

	/**
	 * 创建保存图片的目录，并返回文件在服务端的真实存储路径
	 * @param request
	 * @param uploadFileName	完整的文件名称，包含后缀的
	 * @param basePathFile	保存进硬盘的分类的文件夹名称
	 * @return 你要保存的物理硬盘路径和保存进数据库里面的图片的路径（用于页面显示）
	 * @throws CustomException 
	 */
	public static Map<String, String> saveUploadFile(HttpServletRequest request, String uploadFileName, String... basePathFile) throws Exception {
		//BMP、JPG、JPEG、PNG、GIF
		if (uploadFileName.endsWith(".bmp") || 
				uploadFileName.endsWith(".jpg") || 
				uploadFileName.endsWith(".jpeg") || 
				uploadFileName.endsWith(".png") || 
				uploadFileName.endsWith(".gif")) {
			
			// 可以存放到你指定的文件底下
			String baseDir = "uploadFiles";
			if (basePathFile.length > 0) {
				baseDir = baseDir + "/" + basePathFile[0];
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
			// >> 获取路径
			String basePath = request.getServletContext().getRealPath("/" + baseDir);
			String subPath = sdf.format(new Date());
			
			// >> 如果文件夹不存在，就创建
			File dir = new File(basePath + subPath);
			if (!dir.exists()) {
				dir.mkdirs(); // 递归的创建不存在的文件夹
			}
			
			// >> 截取出后缀名（包含 .）
			String prefix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
			// >> 文件名
			String pictureName = UUID.randomUUID().toString() + prefix;
			// >> 拼接路径
			String path = basePath + subPath + pictureName;// 构建出实际的硬盘路径是为了，在硬盘上保存上传上来的图片
			// >> 移动文件

			String picturePath = baseDir + subPath + pictureName;// 这个图片路径是为了储存进数据库，用来在页面显示的路径
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", path);
			map.put("picturePath", picturePath);
			
			return map;
		}
//		return null;
		throw new CustomException("图片格式不正确！");
		
	}
	/**
	 * 删除指定文件路径的文件（硬盘上的）
	 * @param filePath	文件路径
	 */
	public static void deleteFile(HttpServletRequest request, String filePath) {
		String basePath = request.getServletContext().getRealPath("/" + filePath);
		File file = new File(basePath);
		if (file.exists()) {
			file.delete();
		}
	}
}
