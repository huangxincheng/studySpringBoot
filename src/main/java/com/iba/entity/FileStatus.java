package com.iba.entity;

public class FileStatus {

	private int state;

	private String msg;

	public static final int success = 0;

	public static final int error = -1;

	public static final String fileIsNull = "文件为空";

	public static final String uploadError = "上传失败";

	public static final String uploadSuccess = "上传成功";
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public FileStatus() {
	}

	public FileStatus(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public static FileStatus toResult(int state, String msg) {
		return new FileStatus(state, msg);
	}

	public static FileStatus toSuccess(String msg) {
		return new FileStatus(success, msg);
	}

	public static FileStatus toError(String msg) {
		return new FileStatus(error, msg);
	}
}