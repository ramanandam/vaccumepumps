package com.flowserve.vaccumepump.webservice.model;

public class MachineTable {
	
	private String curve_id;//machineId;
	private String material;//WKST;
	private int machineType;//Maschinenart column= D 
	private int nn;//NN column= G
	
	public String getCurve_id() {
		return curve_id;
	}
	public void setCurve_id(String curve_id) {
		this.curve_id = curve_id;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getMachineType() {
		return machineType;
	}
	public void setMachineType(int machineType) {
		this.machineType = machineType;
	}
	public int getNn() {
		return nn;
	}
	public void setNn(int nn) {
		this.nn = nn;
	}
	

}
