package com.yanbh.ssm.util;

public enum ResultType {
	SUCCESS        ("succ",      "成功"), 
	FAIL_VALIDATION("fail",      "校验错误"), 
	EXCEPTION      ("exce",      "应用异常"), 
	PARTIAL_SUCCESS("part_fail", "部分处理失败"); // 批量处理时部分成功部分失败
	
	private String resultCode; //返回结果类型（成功，校验失败，应用异常）
	private String resultMesg; //返回结果描述
	
	private ResultType(String resultCode, String resultMesg) {
		this.resultCode = resultCode;
		this.resultMesg = resultMesg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMesg() {
		return resultMesg;
	}
}
