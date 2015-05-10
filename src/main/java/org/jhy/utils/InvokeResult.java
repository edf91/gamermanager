package org.jhy.utils;

/**
 * 返回结果集
 */
public class InvokeResult<T> {
	private String errorMsg;
	private boolean hasError;
	private T data;
	private InvokeResult(){
		
	}
	private InvokeResult(T data){
		this.hasError = false;
		this.data = data;
	}
	private InvokeResult(String errorMsg){
		this.hasError = true;
		this.errorMsg = errorMsg;
	}
	public static <T> InvokeResult<T> failure(String errorMsg){
		return new InvokeResult<T>(errorMsg);
	}
	public static <T> InvokeResult<T> success(T data){
		return new InvokeResult<T>(data);
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public boolean isHasError() {
		return hasError;
	}
	public T getData() {
		return data;
	}
	
	
}
