package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

	private String netWorkAddress_1;
	private String mask_1;
	private String interf_1;
	private String defaultGetWay_1;
	private String group_1;

	private String netWorkAddress_2;
	private String mask_2;
	private String interf_2;
	private String defaultGetWay_2;
	private String group_2;

	public PropertiesService(){
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream("conf.properties"));

			netWorkAddress_1 = properties.getProperty("netWorkAddress_1");
			mask_1 = properties.getProperty("mask_1");
			defaultGetWay_1 = properties.getProperty("defaultGetWay_1");
			interf_1 = properties.getProperty("interf_1");
			group_1 = properties.getProperty("group_1");

			netWorkAddress_2 = properties.getProperty("netWorkAddress_2");
			mask_2 = properties.getProperty("mask_2");
			defaultGetWay_2 = properties.getProperty("defaultGetWay_2");
			interf_2 = properties.getProperty("interf_2");
			group_2 = properties.getProperty("group_2");

		} catch (IOException exception) {
			System.err.println("[service-properties]-[error]: " + exception.getMessage());
		}
	}

	public String getNetWorkAddress_1() {
		return netWorkAddress_1;
	}
	public String getMask_1() {
		return mask_1;
	}
	public String getDefaultGetWay_1() {
		return defaultGetWay_1;
	}
	public String getInterf_1(){
		return interf_1;
	}
	public String getGroup_1() {
		return group_1;
	}


	public String getNetWorkAddress_2() {
		return netWorkAddress_2;
	}
	public String getMask_2() {
		return mask_2;
	}
	public String getDefaultGetWay_2() {
		return defaultGetWay_2;
	}
	public String getInterf_2(){
		return interf_2;
	}
	public String getGroup_2() {
		return group_2;
	}


}
