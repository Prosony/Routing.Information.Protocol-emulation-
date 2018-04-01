package table.model;

public class RoutingTable {

	private String netWorkAddress;
	private String mask;
	private String defaultGetWay;
	private String interf;
	private int metric;

	public RoutingTable(String netWorkAddress, String mask, String defaultGetWay, String interf, int metric) {
		this.netWorkAddress = netWorkAddress;
		this.mask = mask;
		this.defaultGetWay = defaultGetWay;
		this.interf = interf;
		this.metric = metric;
	}

	public int getMetric() {
		return metric;
	}
	public void setMetric(int metric) {
		this.metric = metric;
	}

	public String getNetWorkAddress() {
		return netWorkAddress;
	}
	public void setNetWorkAddress(String netWorkAddress) {
		this.netWorkAddress = netWorkAddress;
	}

	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getDefaultGetWay() {
		return defaultGetWay;
	}
	public void setDefaultGetWay(String defaultGetWay) {
		this.defaultGetWay = defaultGetWay;
	}

	public String getInterf() {
		return interf;
	}
	public void setInterf(String interf) {
		this.interf = interf;
	}


	@Override
	public String toString() {
		return
				"[СЕТЕВОЙ АДРЕС:"+netWorkAddress+", МАСКА СЕТИ:" +mask+" АДРЕС ШЛЮЗА: "+defaultGetWay+" ИНТЕРФЕЙС: "+interf+" МЕТРИКА: "+metric+"]";
	}

}
