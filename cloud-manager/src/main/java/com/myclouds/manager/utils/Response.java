
package com.myclouds.manager.utils;

public class Response {

	//执行是否正确
	private boolean result;
	//信息
	private String message;
	//返回数据
	private Object object;
	private Object object1;

	public Response(){
		this.result = true;
	}


	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}


	public Object getObject1() {
		return object1;
	}


	public void setObject1(Object object1) {
		this.object1 = object1;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Result:" + result + "          message:" + message;
	}



}
