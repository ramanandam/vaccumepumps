package com.flowserve.vaccumepump.webservice.model;

public class ListValueTable {

	private String curve_id;//A:machineId
	
	private int comp_pump;//B:Betriebsart ;Operating mode
	private String material;//C:WKST
	private String nl;//D:speed
	private int point;// E:point
	public String getCurve_id() {
		return curve_id;
	}
	public void setCurve_id(String curve_id) {
		this.curve_id = curve_id;
	}
	public int getComp_pump() {
		return comp_pump;
	}
	public void setComp_pump(int comp_pump) {
		this.comp_pump = comp_pump;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
