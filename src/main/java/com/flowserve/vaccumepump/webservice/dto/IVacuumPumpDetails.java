package com.flowserve.vaccumepump.webservice.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.flowserve.vaccumepump.webservice.model.SubstanceNameTable;

public class IVacuumPumpDetails implements Serializable {

	
	
	private List<String> machineIdList;
	private String machineType;
	private int ratedSpeedRpm;
	private List<String> materialIdList;
	private List<String> vacuumoperationList;
	private List<String> compressorOperationList;
	private double speedRpm;
	
	private boolean stc_Makro_Berechnung;// Need to find out which varibale in the form ? 
	
	private  double V_1_Gas_total_norm;//V_1_Gas_gesamt_norm
	
	private double p_1;
	private double p_2;
	private double T_1;
	private double T_BF;
	
	private double p_SD_Dampf;
	private String feuchte;
	private double psi;
	
	private double M_mol_mittel;
	private int stc_result;//stc_Ergebnis; 
	private boolean  stc_Macro_Calculation
	;//stc_Makro_Berechnung;
	 
	

	private String gasSubstanceID;
	private String relativeVolumeFlow;
	private String absoluteVolumeFlow;
	private String relativeMassFlow;
	private String absoluteMassFlow;
	private boolean steam;
	private String vaporPressureAtT_1;
	private String vaporPressureAtT_BF;
	private String standardVolumeFlow;

	private String totalVolumeCurrent;// [m³/h]:

	private String totalMassCurrent;// [kg/h]:

	private String standardizedTotalVolumeFlow;// [Nm³/h]:

	private String averageMolecularWeight;// [g/mol]:

	private String mixtureSaturationVaporPressure;// [mbar]:
	private String relativeHumidity;// [%]

	private String degreeOfSaturationOfTheInertGas;// [-]:

	private String mistake;

	private String P;// [kW]
	private String V_BF;// [m³/h]
	private String Q_WT;// [kW]
	private String T_2;// [°C]
	private String V_FF;// [m³/h]
	private String P_max;// [kW]
	private String p_2_max_mbarInCompressorOperation;

	private String lambda_1;
	private String lambda_2;
	private String lambda_3;
	private String lambda_4;
	private String lambda_5;
	private String lambda_6;
	private String lambda_7;
	private String lambda_8;
	private String lambda_9;
	private String lambda;

	private String phi_6;
	private String phi_7;
	private String phi_8;
	private String phi_9;
	private String phi;

	private String n_ref;// [U/min]
	private String p_2_ref;// [mbar]
	private String V_1_ref;// [m³/h]
	private String P_ref;// [kW]

	private String optimizedBFtemperature;// [°C]

	private String v_1_Gas_gesShould;// [m³/h]

	private String ToleranceRange;// + [%]:

	private String toleranceRange;// [%]:

	private String containerSize;// [m³]

	private String p_1_beginning;// [mbar]

	private String p_1_Ende;// [mbar]
	private String standardizedLeakageAirVolumeFlow;// [Nm³/h]

	private String evacuationTimeS;// [s]

	private String evacuationTimeM;// [min]

	private String targetEvacuationTime;// [s]

	private String ToleranceRangePlus;// [%]:
	private String ToleranceRangeMinus;// [%]:

	//private String p_1;// [mbar]
	private String V_1;// [m³/h]

	private String propellantGasVolumeFlow;// [Nm³/h]

	private String V_1Should;// [m³/h]


	
	//Below onwards fileds for Promoted Gases form 
	//There are 6 lists on the Form Geförderte Gase - Promoted gases
	List<String> comboBox_Gas_List;
	Map<String,SubstanceNameTable> substanceNameTableMap;
	
	
	private double P_2_max;
	
	
private boolean stc_V_1_Gas_gegeben;
	
	private boolean stc_V_1_Gas_gesamt_gegeben;
	private boolean stc_m_1_Gas_gegeben;
	private boolean stc_m_1_Gas_gesamt_gegeben;
	private boolean stc_m_1_Gas_rel_gegeben;
	
	private boolean fields_filled;
	 

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	 

	public double getSpeedRpm() {
		return speedRpm;
	}

	public void setSpeedRpm(double speedRpm) {
		this.speedRpm = speedRpm;
	}

	public String getGasSubstanceID() {
		return gasSubstanceID;
	}

	public void setGasSubstanceID(String gasSubstanceID) {
		this.gasSubstanceID = gasSubstanceID;
	}

	public String getRelativeVolumeFlow() {
		return relativeVolumeFlow;
	}

	public void setRelativeVolumeFlow(String relativeVolumeFlow) {
		this.relativeVolumeFlow = relativeVolumeFlow;
	}

	public String getAbsoluteVolumeFlow() {
		return absoluteVolumeFlow;
	}

	public void setAbsoluteVolumeFlow(String absoluteVolumeFlow) {
		this.absoluteVolumeFlow = absoluteVolumeFlow;
	}

	public String getRelativeMassFlow() {
		return relativeMassFlow;
	}

	public void setRelativeMassFlow(String relativeMassFlow) {
		this.relativeMassFlow = relativeMassFlow;
	}

	public String getAbsoluteMassFlow() {
		return absoluteMassFlow;
	}

	public void setAbsoluteMassFlow(String absoluteMassFlow) {
		this.absoluteMassFlow = absoluteMassFlow;
	}

	public boolean isSteam() {
		return steam;
	}

	public void setSteam(boolean steam) {
		this.steam = steam;
	}

	public String getVaporPressureAtT_1() {
		return vaporPressureAtT_1;
	}

	public void setVaporPressureAtT_1(String vaporPressureAtT_1) {
		this.vaporPressureAtT_1 = vaporPressureAtT_1;
	}

	public String getVaporPressureAtT_BF() {
		return vaporPressureAtT_BF;
	}

	public void setVaporPressureAtT_BF(String vaporPressureAtT_BF) {
		this.vaporPressureAtT_BF = vaporPressureAtT_BF;
	}

	public String getStandardVolumeFlow() {
		return standardVolumeFlow;
	}

	public void setStandardVolumeFlow(String standardVolumeFlow) {
		this.standardVolumeFlow = standardVolumeFlow;
	}

	public String getTotalVolumeCurrent() {
		return totalVolumeCurrent;
	}

	public void setTotalVolumeCurrent(String totalVolumeCurrent) {
		this.totalVolumeCurrent = totalVolumeCurrent;
	}

	public String getTotalMassCurrent() {
		return totalMassCurrent;
	}

	public void setTotalMassCurrent(String totalMassCurrent) {
		this.totalMassCurrent = totalMassCurrent;
	}

	public String getStandardizedTotalVolumeFlow() {
		return standardizedTotalVolumeFlow;
	}

	public void setStandardizedTotalVolumeFlow(String standardizedTotalVolumeFlow) {
		this.standardizedTotalVolumeFlow = standardizedTotalVolumeFlow;
	}

	public String getAverageMolecularWeight() {
		return averageMolecularWeight;
	}

	public void setAverageMolecularWeight(String averageMolecularWeight) {
		this.averageMolecularWeight = averageMolecularWeight;
	}

	public String getMixtureSaturationVaporPressure() {
		return mixtureSaturationVaporPressure;
	}

	public void setMixtureSaturationVaporPressure(String mixtureSaturationVaporPressure) {
		this.mixtureSaturationVaporPressure = mixtureSaturationVaporPressure;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getDegreeOfSaturationOfTheInertGas() {
		return degreeOfSaturationOfTheInertGas;
	}

	public void setDegreeOfSaturationOfTheInertGas(String degreeOfSaturationOfTheInertGas) {
		this.degreeOfSaturationOfTheInertGas = degreeOfSaturationOfTheInertGas;
	}

	public String getMistake() {
		return mistake;
	}

	public void setMistake(String mistake) {
		this.mistake = mistake;
	}

	public String getP() {
		return P;
	}

	public void setP(String p) {
		P = p;
	}

	public String getV_BF() {
		return V_BF;
	}

	public void setV_BF(String v_BF) {
		V_BF = v_BF;
	}

	public String getQ_WT() {
		return Q_WT;
	}

	public void setQ_WT(String q_WT) {
		Q_WT = q_WT;
	}

	public String getT_2() {
		return T_2;
	}

	public void setT_2(String t_2) {
		T_2 = t_2;
	}

	public String getV_FF() {
		return V_FF;
	}

	public void setV_FF(String v_FF) {
		V_FF = v_FF;
	}

	public String getP_max() {
		return P_max;
	}

	public void setP_max(String p_max) {
		P_max = p_max;
	}

	public String getP_2_max_mbarInCompressorOperation() {
		return p_2_max_mbarInCompressorOperation;
	}

	public void setP_2_max_mbarInCompressorOperation(String p_2_max_mbarInCompressorOperation) {
		this.p_2_max_mbarInCompressorOperation = p_2_max_mbarInCompressorOperation;
	}

	public String getLambda_1() {
		return lambda_1;
	}

	public void setLambda_1(String lambda_1) {
		this.lambda_1 = lambda_1;
	}

	public String getLambda_2() {
		return lambda_2;
	}

	public void setLambda_2(String lambda_2) {
		this.lambda_2 = lambda_2;
	}

	public String getLambda_3() {
		return lambda_3;
	}

	public void setLambda_3(String lambda_3) {
		this.lambda_3 = lambda_3;
	}

	public String getLambda_4() {
		return lambda_4;
	}

	public void setLambda_4(String lambda_4) {
		this.lambda_4 = lambda_4;
	}

	public String getLambda_5() {
		return lambda_5;
	}

	public void setLambda_5(String lambda_5) {
		this.lambda_5 = lambda_5;
	}

	public String getLambda_6() {
		return lambda_6;
	}

	public void setLambda_6(String lambda_6) {
		this.lambda_6 = lambda_6;
	}

	public String getLambda_7() {
		return lambda_7;
	}

	public void setLambda_7(String lambda_7) {
		this.lambda_7 = lambda_7;
	}

	public String getLambda_8() {
		return lambda_8;
	}

	public void setLambda_8(String lambda_8) {
		this.lambda_8 = lambda_8;
	}

	public String getLambda_9() {
		return lambda_9;
	}

	public void setLambda_9(String lambda_9) {
		this.lambda_9 = lambda_9;
	}

	public String getLambda() {
		return lambda;
	}

	public void setLambda(String lambda) {
		this.lambda = lambda;
	}

	public String getPhi_6() {
		return phi_6;
	}

	public void setPhi_6(String phi_6) {
		this.phi_6 = phi_6;
	}

	public String getPhi_7() {
		return phi_7;
	}

	public void setPhi_7(String phi_7) {
		this.phi_7 = phi_7;
	}

	public String getPhi_8() {
		return phi_8;
	}

	public void setPhi_8(String phi_8) {
		this.phi_8 = phi_8;
	}

	public String getPhi_9() {
		return phi_9;
	}

	public void setPhi_9(String phi_9) {
		this.phi_9 = phi_9;
	}

	public String getPhi() {
		return phi;
	}

	public void setPhi(String phi) {
		this.phi = phi;
	}

	public String getN_ref() {
		return n_ref;
	}

	public void setN_ref(String n_ref) {
		this.n_ref = n_ref;
	}

	public String getP_2_ref() {
		return p_2_ref;
	}

	public void setP_2_ref(String p_2_ref) {
		this.p_2_ref = p_2_ref;
	}

	public String getV_1_ref() {
		return V_1_ref;
	}

	public void setV_1_ref(String v_1_ref) {
		V_1_ref = v_1_ref;
	}

	public String getP_ref() {
		return P_ref;
	}

	public void setP_ref(String p_ref) {
		P_ref = p_ref;
	}

	public String getOptimizedBFtemperature() {
		return optimizedBFtemperature;
	}

	public void setOptimizedBFtemperature(String optimizedBFtemperature) {
		this.optimizedBFtemperature = optimizedBFtemperature;
	}

	public String getV_1_Gas_gesShould() {
		return v_1_Gas_gesShould;
	}

	public void setV_1_Gas_gesShould(String v_1_Gas_gesShould) {
		this.v_1_Gas_gesShould = v_1_Gas_gesShould;
	}

	public String getToleranceRange() {
		return toleranceRange;
	}

	public void setToleranceRange(String toleranceRange) {
		this.toleranceRange = toleranceRange;
	}

	public String getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}

	public String getP_1_beginning() {
		return p_1_beginning;
	}

	public void setP_1_beginning(String p_1_beginning) {
		this.p_1_beginning = p_1_beginning;
	}

	public String getP_1_Ende() {
		return p_1_Ende;
	}

	public void setP_1_Ende(String p_1_Ende) {
		this.p_1_Ende = p_1_Ende;
	}

	public String getStandardizedLeakageAirVolumeFlow() {
		return standardizedLeakageAirVolumeFlow;
	}

	public void setStandardizedLeakageAirVolumeFlow(String standardizedLeakageAirVolumeFlow) {
		this.standardizedLeakageAirVolumeFlow = standardizedLeakageAirVolumeFlow;
	}

	public String getEvacuationTimeS() {
		return evacuationTimeS;
	}

	public void setEvacuationTimeS(String evacuationTimeS) {
		this.evacuationTimeS = evacuationTimeS;
	}

	public String getEvacuationTimeM() {
		return evacuationTimeM;
	}

	public void setEvacuationTimeM(String evacuationTimeM) {
		this.evacuationTimeM = evacuationTimeM;
	}

	public String getTargetEvacuationTime() {
		return targetEvacuationTime;
	}

	public void setTargetEvacuationTime(String targetEvacuationTime) {
		this.targetEvacuationTime = targetEvacuationTime;
	}

	public String getToleranceRangePlus() {
		return ToleranceRangePlus;
	}

	public void setToleranceRangePlus(String toleranceRangePlus) {
		ToleranceRangePlus = toleranceRangePlus;
	}

	public String getToleranceRangeMinus() {
		return ToleranceRangeMinus;
	}

	public void setToleranceRangeMinus(String toleranceRangeMinus) {
		ToleranceRangeMinus = toleranceRangeMinus;
	}

	 

	public String getV_1() {
		return V_1;
	}

	public void setV_1(String v_1) {
		V_1 = v_1;
	}

	public String getPropellantGasVolumeFlow() {
		return propellantGasVolumeFlow;
	}

	public void setPropellantGasVolumeFlow(String propellantGasVolumeFlow) {
		this.propellantGasVolumeFlow = propellantGasVolumeFlow;
	}

	public String getV_1Should() {
		return V_1Should;
	}

	public void setV_1Should(String v_1Should) {
		V_1Should = v_1Should;
	}

	public List<String> getMachineIdList() {
		return machineIdList;
	}

	public void setMachineIdList(List<String> machineIdList) {
		this.machineIdList = machineIdList;
	}

	public void setRatedSpeedRpm(int ratedSpeedRpm) {
		this.ratedSpeedRpm = ratedSpeedRpm;
	}

	public int getRatedSpeedRpm() {
		return ratedSpeedRpm;
	}

	public List<String> getMaterialIdList() {
		return materialIdList;
	}

	public void setMaterialIdList(List<String> materialIdList) {
		this.materialIdList = materialIdList;
	}

	public List<String> getCompressorOperationList() {
		return compressorOperationList;
	}

	public void setCompressorOperationList(List<String> compressorOperationList) {
		this.compressorOperationList = compressorOperationList;
	}

	public List<String> getVacuumoperationList() {
		return vacuumoperationList;
	}

	public void setVacuumoperationList(List<String> vacuumoperationList) {
		vacuumoperationList = vacuumoperationList;
	}

	public boolean isStc_Makro_Berechnung() {
		return stc_Makro_Berechnung;
	}

	public void setStc_Makro_Berechnung(boolean stc_Makro_Berechnung) {
		this.stc_Makro_Berechnung = stc_Makro_Berechnung;
	}

	public double getV_1_Gas_total_norm() {
		return V_1_Gas_total_norm;
	}

	public void setV_1_Gas_total_norm(double v_1_Gas_total_norm) {
		V_1_Gas_total_norm = v_1_Gas_total_norm;
	}

	public double getP_1() {
		return p_1;
	}

	public void setP_1(double p_1) {
		this.p_1 = p_1;
	}

	public double getP_2() {
		return p_2;
	}

	public void setP_2(double p_2) {
		this.p_2 = p_2;
	}

	public double getT_1() {
		return T_1;
	}

	public void setT_1(double t_1) {
		T_1 = t_1;
	}

	public double getT_BF() {
		return T_BF;
	}

	public void setT_BF(double t_BF) {
		T_BF = t_BF;
	}

	public double getP_SD_Dampf() {
		return p_SD_Dampf;
	}

	public void setP_SD_Dampf(double p_SD_Dampf) {
		this.p_SD_Dampf = p_SD_Dampf;
	}

	public String getFeuchte() {
		return feuchte;
	}

	public void setFeuchte(String feuchte) {
		this.feuchte = feuchte;
	}

	public double getPsi() {
		return psi;
	}

	public void setPsi(double psi) {
		this.psi = psi;
	}

	public double getM_mol_mittel() {
		return M_mol_mittel;
	}

	public void setM_mol_mittel(double m_mol_mittel) {
		M_mol_mittel = m_mol_mittel;
	}

	public int getStc_result() {
		return stc_result;
	}

	public void setStc_result(int stc_result) {
		this.stc_result = stc_result;
	}

	public boolean isStc_Macro_Calculation() {
		return stc_Macro_Calculation;
	}

	public void setStc_Macro_Calculation(boolean stc_Macro_Calculation) {
		this.stc_Macro_Calculation = stc_Macro_Calculation;
	}

	public List<String> getComboBox_Gas_List() {
		return comboBox_Gas_List;
	}

	public void setComboBox_Gas_List(List<String> comboBox_Gas_List) {
		this.comboBox_Gas_List = comboBox_Gas_List;
	}

	public Map<String, SubstanceNameTable> getSubstanceNameTableMap() {
		return substanceNameTableMap;
	}

	public void setSubstanceNameTableMap(Map<String, SubstanceNameTable> substanceNameTableMap) {
		this.substanceNameTableMap = substanceNameTableMap;
	}

	public double getP_2_max() {
		return P_2_max;
	}

	public void setP_2_max(double p_2_max) {
		P_2_max = p_2_max;
	}

	public boolean isStc_V_1_Gas_gegeben() {
		return stc_V_1_Gas_gegeben;
	}

	public void setStc_V_1_Gas_gegeben(boolean stc_V_1_Gas_gegeben) {
		this.stc_V_1_Gas_gegeben = stc_V_1_Gas_gegeben;
	}

	public boolean isStc_V_1_Gas_gesamt_gegeben() {
		return stc_V_1_Gas_gesamt_gegeben;
	}

	public void setStc_V_1_Gas_gesamt_gegeben(boolean stc_V_1_Gas_gesamt_gegeben) {
		this.stc_V_1_Gas_gesamt_gegeben = stc_V_1_Gas_gesamt_gegeben;
	}

	public boolean isStc_m_1_Gas_gegeben() {
		return stc_m_1_Gas_gegeben;
	}

	public void setStc_m_1_Gas_gegeben(boolean stc_m_1_Gas_gegeben) {
		this.stc_m_1_Gas_gegeben = stc_m_1_Gas_gegeben;
	}

	public boolean isStc_m_1_Gas_gesamt_gegeben() {
		return stc_m_1_Gas_gesamt_gegeben;
	}

	public void setStc_m_1_Gas_gesamt_gegeben(boolean stc_m_1_Gas_gesamt_gegeben) {
		this.stc_m_1_Gas_gesamt_gegeben = stc_m_1_Gas_gesamt_gegeben;
	}

	public boolean isStc_m_1_Gas_rel_gegeben() {
		return stc_m_1_Gas_rel_gegeben;
	}

	public void setStc_m_1_Gas_rel_gegeben(boolean stc_m_1_Gas_rel_gegeben) {
		this.stc_m_1_Gas_rel_gegeben = stc_m_1_Gas_rel_gegeben;
	}

	public boolean isFields_filled() {
		return fields_filled;
	}

	public void setFields_filled(boolean fields_filled) {
		this.fields_filled = fields_filled;
	}

}
