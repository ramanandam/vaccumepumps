 package com.flowserve.vaccumepump.webservice.dto;

import java.io.Serializable;

public class IVacuumSelectionInputs implements Serializable{

	
	private String machineID;
	private String materialID;//Werkstoff_ID
	private String vacuumOperation;
	private String compressorOperation;
	private String permissionGroup;//Berechtigungsgruppe;
	private double bf;//Betriebsflüssigkeit (Stoff_ID)
	private double p_1;
	private double p_2;
	private double T_1;
	private double T_BF;
	
	private boolean checkBox_saturate;//checkBox_saturate;//checkBox_saettigen;
	private  double V_1_Gas_total_norm;//V_1_Gas_gesamt_norm
	private int stc_result;//stc_Ergebnis;
	private int stcCalculationType;//stcBerechnungsart
	private boolean  stc_Macro_Calculation
;//stc_Makro_Berechnung;
	
	
	private double rehzahl;
	
	
	private double drehzahl;
	
	private double V_1_F;
	
	private double T_FF;
	private int authorizationGroup;//Berechtigungsgruppe
	private double V_BF_manuell;
	private double delta_p_Waermetauscher;
	//Delta_p_Waermetauscher [mbar]
	private double gas;//Gas (Stoff_ID)
	private double 	V_1_Gas_rel;//Formular_V_1_Gas_rel_1....
	private double V_1_Gas;//Formular_V_1_Gas_1;
	private double m_1_Gas_rel;//Formular_m_1_Gas_rel_2
	private double m_1_Gas;//Formular_m_1_Gas_1;
	private double Ist_Dampf;//Formular_Ist_Dampf_1;
	private double p_SD_Gas_T_1;//Formular_p_SD_Gas_T_1_1;
	private double p_SD_Gas_T_BF_1;//Formular_p_SD_Gas_T_BF_1;
	private double V_1_Gas_Total_Volume ;//V_1_Gas_gesamt
	
	
	
	private String lambda_1;
	private String lambda_2;
	private String lambda_3;
	private String lambda_4;
	private String lambda_5;
	private String lambda_6;
	private String lambda_7;
	private String lambda_8;
	private String lambda_9;
	 
	private String phi_6;
	private String phi_7;
	private String phi_8;
	private String phi_9;
	 
	private String n_ref;// [U/min]
	
	 
	private String p_2_ref;// [mbar]
	private String V_1_ref;// [m³/h]
	private String P_ref;// [kW]

	
	
	private String P;// [kW]
	private String V_BF;// [m³/h]
	private String Q_WT;// [kW]
	private String T_2;// [°C]
	
	
	
	
	/*
	 * GLOBAL VARIABLES STRAT
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	//Dim stc_Ergebnis As Integer                 ' 0: kein Ergebnis, Eingabemodus, 1: Ergebnis dargestellt, Berechnung erfolgreich,
    //' -1: Ergebnis dargestellt, Fehler / Warnungen
	// Variable declaration
	// 0: no result, input mode
	// 1: result displayed, calculation successful
	// -1: result displayed, errors/warnings
	//int stc_Ergebnis;
	int stc_Result;

	
	 
	/*
	 * Dim stc_Berechnungsart As Integer ' 0: undefiniert, 1: Gasströme umrechnen,
	 * 2: Betriebspunkt, ' 3: Maschinenauswahl für Betriebspunkt, 4:
	 * Evakuierungszeit, ' 5: Maschinenauswahl für Evakuierungszeit, ' 7:
	 * Gasstrahler-Betriebspunkt, 8: Gasstrahlerauswahl
	 */	
	
	// Variable declaration
	// 0: undefined
	// 1: convert gas flows
	// 2: operating point
	// 3: machine selection for operating point
	// 4: evacuation time
	// 5: machine selection for evacuation time
	// 7: gas emitter operating point
	// 8: gas emitter selection
	int calculationType;

	//Dim stc_V_1_Gas_gesamt_gegeben As Boolean
private boolean stc_V_1_Gas_Total_Provided;
//Dim stc_m_1_Gas_gesamt_gegeben As Boolean
//Declaration of the variable
//Represents the total mass of gas given
 
//Dim stc_m_1_Gas_gesamt_gegeben As Boolean

private boolean stc_m_1_Gas_Total_Given;
	/*
	 * GLOBAL VARIABLES END
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	private double phi;
	
	private double lambda;
	
	private double V_FF;
	
	private double p_2_max;
	
	public boolean freieDrehzahl;
	 private boolean freieDrehzahl60Hz;// --> 1,2*NN
	private boolean freieDrehzahl50Hz;// --> NN
	private boolean isFreieDrehzahl;
	
	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}
	/*
	 * ; private String betriebsflüssigkeitStoffID; private
	 * String operating_type;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // ChecBox private boolean alsoShowMachinesWithWarnings;
	 * 
	 * private String operatingFluidMaterialDataManuallyImportData;
	 * 
	 * private String gasesSubstanceDataManuallyImportData; // check Box private
	 * boolean saturateTheMixture;
	 * 
	 * private String gasRadiatorOperatingPointInput;
	 * 
	 * public String getMachineID() { return machineID; }
	 * 
	 * public void setMachineID(String machineID) { this.machineID = machineID; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public String getBetriebsflüssigkeitStoffID() { return
	 * betriebsflüssigkeitStoffID; }
	 * 
	 * public void setBetriebsflüssigkeitStoffID(String betriebsflüssigkeitStoffID)
	 * { this.betriebsflüssigkeitStoffID = betriebsflüssigkeitStoffID; }
	 * 
	 * public String getAuthorizationGroup() { return authorizationGroup; }
	 * 
	 * public void setAuthorizationGroup(String authorizationGroup) {
	 * this.authorizationGroup = authorizationGroup; }
	 * 
	 * public boolean isFreieDrehzahl() { return freieDrehzahl; }
	 * 
	 * public void setFreieDrehzahl(boolean freieDrehzahl) { this.freieDrehzahl =
	 * freieDrehzahl; }
	 * 
	 * public boolean isFreieDrehzahl50Hz() { return freieDrehzahl50Hz; }
	 * 
	 * public void setFreieDrehzahl50Hz(boolean freieDrehzahl50Hz) {
	 * this.freieDrehzahl50Hz = freieDrehzahl50Hz; }
	 * 
	 * public boolean isFreieDrehzahl60Hz() { return freieDrehzahl60Hz; }
	 * 
	 * public void setFreieDrehzahl60Hz(boolean freieDrehzahl60Hz) {
	 * this.freieDrehzahl60Hz = freieDrehzahl60Hz; }
	 * 
	 * public boolean isAlsoShowMachinesWithWarnings() { return
	 * alsoShowMachinesWithWarnings; }
	 * 
	 * public void setAlsoShowMachinesWithWarnings(boolean
	 * alsoShowMachinesWithWarnings) { this.alsoShowMachinesWithWarnings =
	 * alsoShowMachinesWithWarnings; }
	 * 
	 * public String getOperatingFluidMaterialDataManuallyImportData() { return
	 * operatingFluidMaterialDataManuallyImportData; }
	 * 
	 * public void setOperatingFluidMaterialDataManuallyImportData(String
	 * operatingFluidMaterialDataManuallyImportData) {
	 * this.operatingFluidMaterialDataManuallyImportData =
	 * operatingFluidMaterialDataManuallyImportData; }
	 * 
	 * public String getGasesSubstanceDataManuallyImportData() { return
	 * gasesSubstanceDataManuallyImportData; }
	 * 
	 * public void setGasesSubstanceDataManuallyImportData(String
	 * gasesSubstanceDataManuallyImportData) {
	 * this.gasesSubstanceDataManuallyImportData =
	 * gasesSubstanceDataManuallyImportData; }
	 * 
	 * public boolean isSaturateTheMixture() { return saturateTheMixture; }
	 * 
	 * public void setSaturateTheMixture(boolean saturateTheMixture) {
	 * this.saturateTheMixture = saturateTheMixture; }
	 * 
	 * public String getGasRadiatorOperatingPointInput() { return
	 * gasRadiatorOperatingPointInput; }
	 * 
	 * public void setGasRadiatorOperatingPointInput(String
	 * gasRadiatorOperatingPointInput) { this.gasRadiatorOperatingPointInput =
	 * gasRadiatorOperatingPointInput; }
	 * 
	 * public String getOperating_type() { return operating_type; }
	 * 
	 * public void setOperating_type(String operating_type) { this.operating_type =
	 * operating_type; }
	 */

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public String getVacuumOperation() {
		return vacuumOperation;
	}

	public void setVacuumOperation(String vacuumOperation) {
		this.vacuumOperation = vacuumOperation;
	}

	public String getCompressorOperation() {
		return compressorOperation;
	}

	public void setCompressorOperation(String compressorOperation) {
		this.compressorOperation = compressorOperation;
	}

	public String getPermissionGroup() {
		return permissionGroup;
	}

	public void setPermissionGroup(String permissionGroup) {
		this.permissionGroup = permissionGroup;
	}

	public double getBf() {
		return bf;
	}

	public void setBf(double bf) {
		this.bf = bf;
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

	public boolean isCheckBox_saturate() {
		return checkBox_saturate;
	}

	public void setCheckBox_saturate(boolean checkBox_saturate) {
		this.checkBox_saturate = checkBox_saturate;
	}

	public double getV_1_Gas_total_norm() {
		return V_1_Gas_total_norm;
	}

	public void setV_1_Gas_total_norm(double v_1_Gas_total_norm) {
		V_1_Gas_total_norm = v_1_Gas_total_norm;
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

	public int getStcCalculationType() {
		return stcCalculationType;
	}

	public void setStcCalculationType(int stcCalculationType) {
		this.stcCalculationType = stcCalculationType;
	}

	public boolean isFreieDrehzahl() {
		return isFreieDrehzahl;
	}

	public void setFreieDrehzahl(boolean isFreieDrehzahl) {
		this.isFreieDrehzahl = isFreieDrehzahl;
	}

	public boolean isFreieDrehzahl60Hz() {
		return freieDrehzahl60Hz;
	}

	public void setFreieDrehzahl60Hz(boolean freieDrehzahl60Hz) {
		this.freieDrehzahl60Hz = freieDrehzahl60Hz;
	}

	public boolean isFreieDrehzahl50Hz() {
		return freieDrehzahl50Hz;
	}

	public void setFreieDrehzahl50Hz(boolean freieDrehzahl50Hz) {
		this.freieDrehzahl50Hz = freieDrehzahl50Hz;
	}

	public double getRehzahl() {
		return rehzahl;
	}

	public void setRehzahl(double rehzahl) {
		this.rehzahl = rehzahl;
	}

	public double getDrehzahl() {
		return drehzahl;
	}

	public void setDrehzahl(double drehzahl) {
		this.drehzahl = drehzahl;
	}

	public double getV_1_F() {
		return V_1_F;
	}

	public void setV_1_F(double v_1_F) {
		V_1_F = v_1_F;
	}

	public double getT_FF() {
		return T_FF;
	}

	public void setT_FF(double t_FF) {
		T_FF = t_FF;
	}

	public int getAuthorizationGroup() {
		return authorizationGroup;
	}

	public void setAuthorizationGroup(int authorizationGroup) {
		this.authorizationGroup = authorizationGroup;
	}

	public double getV_BF_manuell() {
		return V_BF_manuell;
	}

	public void setV_BF_manuell(double v_BF_manuell) {
		V_BF_manuell = v_BF_manuell;
	}

	public double getDelta_p_Waermetauscher() {
		return delta_p_Waermetauscher;
	}

	public void setDelta_p_Waermetauscher(double delta_p_Waermetauscher) {
		this.delta_p_Waermetauscher = delta_p_Waermetauscher;
	}

	 
	public int getStc_Result() {
		return stc_Result;
	}

	public void setStc_Result(int stc_Result) {
		this.stc_Result = stc_Result;
	}

	public int getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(int calculationType) {
		this.calculationType = calculationType;
	}

	public boolean isStc_V_1_Gas_Total_Provided() {
		return stc_V_1_Gas_Total_Provided;
	}

	public void setStc_V_1_Gas_Total_Provided(boolean stc_V_1_Gas_Total_Provided) {
		this.stc_V_1_Gas_Total_Provided = stc_V_1_Gas_Total_Provided;
	}

	public boolean isStc_m_1_Gas_Total_Given() {
		return stc_m_1_Gas_Total_Given;
	}

	public void setStc_m_1_Gas_Total_Given(boolean stc_m_1_Gas_Total_Given) {
		this.stc_m_1_Gas_Total_Given = stc_m_1_Gas_Total_Given;
	}

	public double getGas() {
		return gas;
	}

	public void setGas(double gas) {
		this.gas = gas;
	}

	public double getV_1_Gas_rel() {
		return V_1_Gas_rel;
	}

	public void setV_1_Gas_rel(double v_1_Gas_rel) {
		V_1_Gas_rel = v_1_Gas_rel;
	}

	 

	public double getM_1_Gas_rel() {
		return m_1_Gas_rel;
	}

	public void setM_1_Gas_rel(double m_1_Gas_rel) {
		this.m_1_Gas_rel = m_1_Gas_rel;
	}

	public double getM_1_Gas() {
		return m_1_Gas;
	}

	public void setM_1_Gas(double m_1_Gas) {
		this.m_1_Gas = m_1_Gas;
	}

	public double getIst_Dampf() {
		return Ist_Dampf;
	}

	public void setIst_Dampf(double ist_Dampf) {
		Ist_Dampf = ist_Dampf;
	}

	public double getP_SD_Gas_T_1() {
		return p_SD_Gas_T_1;
	}

	public void setP_SD_Gas_T_1(double p_SD_Gas_T_1) {
		this.p_SD_Gas_T_1 = p_SD_Gas_T_1;
	}

	public double getP_SD_Gas_T_BF_1() {
		return p_SD_Gas_T_BF_1;
	}

	public void setP_SD_Gas_T_BF_1(double p_SD_Gas_T_BF_1) {
		this.p_SD_Gas_T_BF_1 = p_SD_Gas_T_BF_1;
	}

	public double getV_1_Gas() {
		return V_1_Gas;
	}

	public void setV_1_Gas(double v_1_Gas) {
		V_1_Gas = v_1_Gas;
	}

	public double getV_1_Gas_Total_Volume() {
		return V_1_Gas_Total_Volume;
	}

	public void setV_1_Gas_Total_Volume(double v_1_Gas_Total_Volume) {
		V_1_Gas_Total_Volume = v_1_Gas_Total_Volume;
	}

	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getLambda() {
		return lambda;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}

	public double getV_FF() {
		return V_FF;
	}

	public void setV_FF(double v_FF) {
		V_FF = v_FF;
	}

	public double getP_2_max() {
		return p_2_max;
	}

	public void setP_2_max(double p_2_max) {
		this.p_2_max = p_2_max;
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
}
