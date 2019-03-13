package com.xuwem.show.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xuwem.show.pojo.Employee;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;
import com.xuwem.show.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		System.out.println(page);
		System.out.println(rows);
		return empService.findPage(page, rows);

	}

	@RequestMapping("/uploadFile")
	public Result fileUpload(MultipartFile uploadfile, HttpServletRequest Request) throws Exception, IOException {

		String path = Request.getSession().getServletContext().getRealPath("/img");
		System.out.println("===========================================================================" + path);
		// 示例图片上传
		String fileName = uploadfile.getOriginalFilename();

		// 修改唯一文件名
		int endIndex = fileName.lastIndexOf('.');
		String newFileName = UUID.randomUUID().toString() + fileName.substring(0, endIndex);
		String end = fileName.substring(endIndex);
		// 指定文件上传目录
		File filePath = new File(path + "\\" + newFileName + end);
		System.out.println(filePath);
		// 如果文件夹不存在，则创建文件夹
		if (!filePath.exists()) {
			filePath.mkdir();
		}
		// 写如磁盘
		uploadfile.transferTo(filePath);

		// 将文件路径存到数据库
		String empImg = newFileName + end;
		empService.uploadFile(empImg);

		return new Result(true, "ok");
	}

	/***
	 * 文件下载 基于SpringMVC提供的ResponseEntity 以流的方式写入
	 * 
	 * @param fileNamem
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/fileDownload")
	public ResponseEntity<byte[]> fileDownload(String fileName, HttpServletRequest Request) throws IOException { // 获取文件名
		System.out.println(fileName);
		String path = Request.getSession().getServletContext().getRealPath("/img");
		// 拼接文件路径
		String pathAndFilename = path + "\\" + fileName;
		System.out.println(pathAndFilename);
		// 创建文件对象
		File file = new File(pathAndFilename);
		byte body[] = null;
		ResponseEntity<byte[]> entity = null;
		try {
			// 将文件读入字节数组
			InputStream input = new FileInputStream(file);
			body = new byte[input.available()];
			input.read(body);
			// 设置头信息
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition", "attchement;filename=" + file.getName());
			HttpStatus statusCode = HttpStatus.OK;
			// 创建ResponseEntity对象，返回信息
			entity = new ResponseEntity<byte[]>(body, header, statusCode);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return entity;
	}

	/**
	 * javaweb通用文件下载
	 * 
	 * @throws IOException
	 * 
	 */
	@RequestMapping("/OriDownload")
	public Result OriDownload(String fileName, HttpServletRequest Request, HttpServletResponse Response)
			throws IOException {

		// 获取文件名
		System.out.println(fileName);
		String path = Request.getSession().getServletContext().getRealPath("/img");
		// 拼接文件路径
		String pathAndFilename = path + "\\" + fileName;
		System.out.println(pathAndFilename);

		// 设置响应头和客户端保存文件名
		Response.setCharacterEncoding("utf-8");
		Response.setContentType("multipart/form-data");
		Response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

		// 创建文件对象
		File file = new File(pathAndFilename);
		// 创建字节数组
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(file);

			output = Response.getOutputStream();
			// 循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = input.read(b)) > 0) {
				output.write(b, 0, length);

			}
			return new Result(true, "操作完成");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "操作失败");
		} finally {
			input.close();
			output.close();
		}

	}

	/*
	 * @RequestMapping("test") public void insert() { empService.uploadFile(); }
	 */
}
