
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.StringUtil;
*/
public class ConvertedLogic {

	public static void main(String[] args) throws SQLException {
		/*
		 * String filePath = "path/to/your/excel/file.xlsx"; try (FileInputStream fis =
		 * new FileInputStream(filePath); Workbook workbook =
		 * WorkbookFactory.create(fis)) {
		 * 
		 * // Declare a Sheet object (equivalent to Dim Form As Worksheet in VBScript)
		 * Sheet formSheet = workbook.getSheet("Form"); //Dim Form As Worksheet, Machine
		 * Table As Worksheet, Substance Name Table As Worksheet //Sheet machineTable =
		 * workbook.getSheet("Machine Table"); ResultSet machineTable = null; // Sheet
		 * substanceNameTable = workbook.getSheet("Substance Name Table"); ResultSet
		 * substanceNameTable = null; //Sheet gasRadiatorTable =
		 * workbook.getSheet("Gas Radiator Table"); ResultSet gasRadiatorTable = null;//
		 * = workbook.getSheet("Gas Radiator Table"); // Thease all the sheets becomes
		 * ResultSet from DB in future
		 * 
		 * // Dim ComboBox_Machine_ID As ComboBox List<String> ComboBox_Machine_ID=new
		 * ArrayList<>();
		 * 
		 * 
		 * //Dim ComboBox_Gas radiator As ComboBox String ComboBox_Gas; //Dim a As Range
		 * String Range; //Dim i As Integer, j As Integer int i,j; //Dim M_ID, M_ID_old,
		 * G_ID, n
		 * 
		 * String M_ID, M_ID_old, G_ID,n; //Dim ComboBox_array, combobox_array2 String[]
		 * ComboBox_array; String[] combobox_array2;
		 * 
		 * //Dim entry String entry;
		 * 
		 * 
		 * //Dim col_G_ID, col_M_ID, col_n
		 * 
		 * String col_G_ID=null, col_M_ID=null, col_n=null;
		 * 
		 * 
		 * 
		 * 
		 * //Dim col_material_name, col_material_ID, col_language_code String
		 * col_material_name, col_material_ID, col_language_code;
		 * 
		 * //Dim dataset_row // String[] datasetRow = {"value1", "value2", "value3"};
		 * 
		 * List<String> datasetRow=new ArrayList<String>();
		 * 
		 * //Dim fabric name, fabric ID, language code String fabricname, fabricID,
		 * languagecode;
		 * 
		 * 
		 * Set Form = Worksheets("Form") Set ComboBox_Machine_ID =
		 * Form.OLEObjects("ComboBox_Machine_ID").Object Set ComboBox_Gasstrahler =
		 * Form.OLEObjects("ComboBox_Gasstrahler").Object
		 * 
		 * Set MachineTable = Worksheets("MachineTable") Set Substance Name Table =
		 * Worksheets("Substance Name Table") Set gas lamp table =
		 * Worksheets("Gas lamp table")
		 * 
		 * List<String> ComboBox_Gasstrahler=new ArrayList<>();
		 * 
		 * //ComboBox_Machine_ID.Clear
		 * 
		 * ComboBox_Machine_ID.clear();
		 * 
		 * 
		 * 
		 * do M_ID = Machine Table.Cells(dataset_row, 1) If (Not IsEmpty(M_ID)) And
		 * (M_ID <> M_ID_alt) Then ComboBox_Machine_ID.AddItem M_ID M_ID_old = M_ID
		 * EndIf dataset_row = dataset_row + 1 Loop Until IsEmpty(M_ID)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * for (String value : datasetRow) { // M_ID = Machine Table.Cells(dataset_row,
		 * 1) //M_ID = machineTable.getRow(1); M_ID = machineTable.getString(1);
		 * 
		 * 
		 * If (Not IsEmpty(M_ID)) And (M_ID <> M_ID_alt) Then
		 * ComboBox_Machine_ID.AddItem M_ID M_ID_old = M_ID EndIf
		 * 
		 * 
		 * if (M_ID != null) {
		 * 
		 * //ComboBox_Machine_ID.add(M_ID.getCell(1).getStringCellValue());
		 * ComboBox_Machine_ID.add(M_ID); M_ID_old = M_ID; }
		 * 
		 * // dataset_row = dataset_row + 1
		 * 
		 * }
		 * 
		 * //ReDim ComboBox_array(800, 4) String[][] comboBoxArray = new String[801][5];
		 * //i = 0 i = 0;
		 * 
		 * // ComboBox_Gasstrahler.Clear ComboBox_Gasstrahler.clear();
		 * 
		 * //col_G_ID = Gas radiator table.Rows(1).Find("TYPE", , , xlWhole).Column
		 * col_G_ID=gasRadiatorTable.getString("TYPE");
		 * 
		 * 
		 * 
		 * col_M_ID = Gas radiator table.Rows(1).Find("PUMP", , , xlWhole).Column col_n
		 * = Gas radiator table.Rows(1).Find("RPM", , , xlWhole).Column
		 * 
		 * 
		 * // col_M_ID = Gas radiator table.Rows(1).Find("PUMP", , , xlWhole).Column
		 * col_M_ID=gasRadiatorTable.getString("PUMP"); // col_n = Gas radiator
		 * table.Rows(1).Find("RPM", , , xlWhole).Column
		 * 
		 * col_n=gasRadiatorTable.getString("RPM");
		 * 
		 * //dataset_row = CONST_dataset_row_start //Iterate through data set rows
		 * 
		 * 
		 * do G_ID = gas lamp table.Cells(dataset_row, col_G_ID) If Not IsEmpty(G_ID)
		 * Then M_ID = gas lamp table.Cells(dataset_row, col_M_ID) n = gas lamp
		 * table.Cells(dataset_row, col_n) ComboBox_array(i, 0) = G_ID
		 * ComboBox_array(i,1) = M_ID ComboBox_array(i, 2) = n ComboBox_array(i, 3) =
		 * G_ID & " - " & M_ID & " - " & Str(n) & " RPM" i = i + 1 EndIf dataset_row =
		 * dataset_row + 1 Loop Until IsEmpty(G_ID)
		 * 
		 * 
		 * for(String value:datasetRow)// Loop Until IsEmpty(G_ID) { G_ID
		 * =gasRadiatorTable.getString(col_G_ID); if(G_ID!=null) {
		 * 
		 * M_ID = gasRadiatorTable.getString(col_M_ID); //n = gas lamp
		 * table.Cells(dataset_row, col_n) n=gasRadiatorTable.getString(col_n);
		 * 
		 * //ComboBox_array(i, 0) = G_ID comboBoxArray[i][0]=G_ID; //ComboBox_array(i,
		 * 1) = M_ID comboBoxArray[i][1]=M_ID; //ComboBox_array(i, 2) = n
		 * comboBoxArray[i][2]=n; // ComboBox_array(i, 3) = G_ID & " - " & M_ID & " - "
		 * & Str(n) & " RPM"
		 * comboBoxArray[i][3]="G_ID & \" - \" & M_ID & \" - \" & Str(n) & \" RPM\"";
		 * i++; } //go to next row }
		 * 
		 * 
		 * 
		 * 
		 * If i > 0 Then ReDim combobox_array2(i - 1, 4) For j = 0 To i - 1
		 * combobox_array2(j, 0) = ComboBox_array(j, 0) combobox_array2(j, 1) =
		 * ComboBox_array(j, 1) combobox_array2(j, 2) = ComboBox_array(j, 2)
		 * combobox_array2(j, 3) = ComboBox_array(j, 3) Next j
		 * Form.OLEObjects("ComboBox_Gasstrahler").Object.List() = combobox_array2 EndIf
		 * 
		 * String[][] comboBoxArray2 = new String[i-1][4]; if( i > 0){ //For j = 0 To i
		 * - 1 for( j=0;j<=i-1;j++) {
		 * 
		 * //combobox_array2(j, 0) = ComboBox_array(j, 0)
		 * comboBoxArray2[j][0]=comboBoxArray[j][0]; //combobox_array2(j, 1) =
		 * ComboBox_array(j, 1)
		 * 
		 * comboBoxArray2[j][1]=comboBoxArray[j][1]; //combobox_array2(j, 2) =
		 * ComboBox_array(j, 2) comboBoxArray2[j][2]=comboBoxArray[j][2];
		 * 
		 * //combobox_array2(j, 3) = ComboBox_array(j, 3)
		 * 
		 * comboBoxArray2[j][3]=comboBoxArray[j][3];
		 * //Form.OLEObjects("ComboBox_Gasstrahler").Object.List() = combobox_array2
		 * 
		 * ComboBox_Gasstrahler.add(comboBoxArray2[j][1]);
		 * ComboBox_Gasstrahler.add(comboBoxArray2[j][2]);
		 * ComboBox_Gasstrahler.add(comboBoxArray2[j][3]);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * col_stoffname = substance name table.Rows(1).Find("NAME", , , xlWhole).Column
		 * col_language_code = fabric_name_table.Rows(1).Find("language_code", , ,
		 * xlWhole).Column col_Stoff_ID = Stoffnamentabelle.Rows(1).Find("Stoff_ID", , ,
		 * xlWhole).Column
		 * 
		 * //col_stoffname = substance name table.Rows(1).Find("NAME", , ,
		 * xlWhole).Column String col_stoffname= substanceNameTable.getString("NAME");
		 * //col_language_code = fabric_name_table.Rows(1).Find("language_code", , ,
		 * xlWhole).Column col_language_code=
		 * substanceNameTable.getString("language_code");
		 * 
		 * //col_Stoff_ID = Stoffnamentabelle.Rows(1).Find("Stoff_ID", , ,
		 * xlWhole).Column String col_Stoff_ID=
		 * substanceNameTable.getString("Stoff_ID"); //ReDim combobox_array2(800, 1)
		 * String[][] comboboxArray2 = new String[801][2]; //dataset_row =
		 * CONST_dataset_row_start
		 * 
		 * i=0; for(String value:datasetRow)//Loop Until IsEmpty(Material Name) { //
		 * Substance name = Substance name table.Cells(dataset_row, col_substance name)
		 * 
		 * String Substancename=substanceNameTable.getString("col_substance");
		 * //Stoff_ID = substance name table.Cells(dataset_row, col_Stoff_ID) String
		 * Stoff_ID = substanceNameTable.getString("col_Stoff_ID"); //Language code =
		 * substance name table.Cells(dataset_row, col_language_code) String
		 * Languagecode=substanceNameTable.getString("col_language_code"); String
		 * MaterialName=null;// if(MaterialName!=null && Languagecode.equalsIgnoreCase(
		 * "de") ) {
		 * 
		 * combobox_array2(i, 0) = substance name combobox_array2(i, 1) = substance_ID
		 * 
		 * comboBoxArray2[i][0]=Substancename; comboBoxArray2[1][1]=Substancename; i++;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * if(i>0) {
		 * 
		 * comboBoxArray = new String[i][3]; //For j = 0 To i - 1 for(j=0;j<=i-1;j++) {
		 * //ComboBox_array(j, 0) = combobox_array2(j, 0)
		 * comboBoxArray[j][0]=comboBoxArray2[j][0];
		 * 
		 * //ComboBox_array(j, 1) = combobox_array2(j, 1)
		 * comboBoxArray[j][1]=comboBoxArray2[j][1];
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * //Form.OLEObjects("ComboBox_Gas_1").Object.List() = ComboBox_array
		 * 
		 * String ComboBox_Gas_1=comboBoxArray[0][0];//but actally need to assign
		 * complete list
		 * 
		 * // Form.OLEObjects("ComboBox_Gas_2").Object.List() = ComboBox_array String
		 * ComboBox_Gas_2=comboBoxArray[0][0];//but actally need to assign complete list
		 * //Form.OLEObjects("ComboBox_Gas_3").Object.List() = ComboBox_array String
		 * ComboBox_Gas_3=comboBoxArray[0][0];//but actally need to assign complete list
		 * //Form.OLEObjects("ComboBox_Gas_4").Object.List() = ComboBox_array String
		 * ComboBox_Gas_4=comboBoxArray[0][0];//but actally need to assign complete list
		 * //Form.OLEObjects("ComboBox_Gas_5").Object.List() = ComboBox_array String
		 * ComboBox_Gas_5=comboBoxArray[0][0];//but actally need to assign complete list
		 * //Form.OLEObjects("ComboBox_Gas_6").Object.List() = ComboBox_array String
		 * ComboBox_Gas_6=comboBoxArray[0][0];//but actally need to assign complete list
		 * //Form.OLEObjects("ComboBox_BF").Object.List() = ComboBox_array String
		 * ComboBox_Gas_BF=comboBoxArray[0][0];//but actally need to assign complete
		 * list //Form.OLEObjects("ComboBox_Manual_Gas_1").Object.List() =
		 * ComboBox_array String ComboBox_Manual_Gas_1=comboBoxArray[0][0];//but actally
		 * need to assign complete list //
		 * Form.OLEObjects("ComboBox_Manual_Gas_2").Object.List() = ComboBox_array
		 * String ComboBox_Manual_Gas_2=comboBoxArray[0][0];//but actally need to assign
		 * complete list //Form.OLEObjects("ComboBox_Manual_BF").Object.List() =
		 * ComboBox_array String ComboBox_Manual_BF=comboBoxArray[0][0];//but actally
		 * need to assign complete list
		 * 
		 * // There is no item is slected
		 * 
		 * //Form.OLEObjects("ComboBox_Gas_1").Object.ListIndex = -1
		 * ComboBox_Gas_1=null; // Form.OLEObjects("ComboBox_Gas_2").Object.ListIndex =
		 * -1 ComboBox_Gas_2=null; // Form.OLEObjects("ComboBox_Gas_3").Object.ListIndex
		 * = -1 ComboBox_Gas_3=null; //
		 * Form.OLEObjects("ComboBox_Gas_4").Object.ListIndex = -1 ComboBox_Gas_4=null;
		 * // Form.OLEObjects("ComboBox_Gas_5").Object.ListIndex = -1
		 * ComboBox_Gas_5=null; // Form.OLEObjects("ComboBox_Gas_6").Object.ListIndex =
		 * -1 ComboBox_Gas_6=null; //
		 * Form.OLEObjects("ComboBox_Manual_Gas_1").Object.ListIndex = -1
		 * ComboBox_Manual_Gas_1=null; //
		 * Form.OLEObjects("ComboBox_Manual_Gas_2").Object.ListIndex = -1
		 * ComboBox_Manual_Gas_2=null; //
		 * Form.OLEObjects("ComboBox_Manual_BF").Object.ListIndex = -1
		 * ComboBox_Manual_BF=null;
		 * 
		 * //End Sub //Close work book
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // Example usage if (formSheet != null) { System.out.println("Sheet name: " +
		 * formSheet.getSheetName()); } else {
		 * System.out.println("Sheet 'Form' does not exist."); }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */}

	/*
	 * ' -------------------------------------------------
	 * -------------------------------------------------- --- ' IQ_VAC - Form ' '
	 * Helper functions for the form for testing IQ-VAC in Excel ' '
	 * -----------------------------------------------------------------------------
	 * ---------------------------
	 * 
	 * Option Explicit
	 * 
	 * ' The following variables are used to determine which quantities are used for
	 * the gas flow conversion or operating point ' and machine selection are to be
	 * regarded as predetermined sizes
	 */

	/*
	 * Dim stc_Berechnungsart As Integer ' 0: undefined, 1: convert gas flows, 2:
	 * operating point, ' 3: Machine selection for operating point, 4: Evacuation
	 * time, ' 5: Machine selection for evacuation time, ' 7: Gas jet operating
	 * point, 8: Gas jet selection
	 */

	// enum Berechnungsart; Create Enum
	;;;;;;;
	/*
	 * Dim stc_Result As Integer ' 0: no result, input mode, 1: result displayed,
	 * calculation successful, ' -1: Result displayed, errors / warnings
	 */

	// enum ResultStatus
	;;;

	// Dim stc_Macro_Calculation As Boolean ' Indicates that cells are changed by
	// macro (and not by user input)
	boolean stc_Macro_Calculation;

	// Dim stc_number_gases As Integer
	int stc_number_gases;
	// Dim stc_V_1_Gas_rel_given As Boolean
	boolean stc_V_1_Gas_rel_given;
	// Dim stc_V_1_Gas_given As Boolean
	boolean stc_V_1_Gas_given;
	// Dim stc_V_1_Gas_total_given As Boolean
	boolean stc_V_1_Gas_total_given;
	// Dim stc_m_1_Gas_rel_given As Boolean
	boolean stc_m_1_Gas_rel_given;
	// Dim stc_m_1_Gas_gegeben As Boolean
	boolean stc_m_1_Gas_gegeben;
	// Dim stc_m_1_gas_total_given As Boolean
	boolean stc_m_1_gas_total_given;

	/*
	 * Private Sub Characteristic_curve_represent(Machine_ID, Material_ID As
	 * Integer, Betr_type, n As Double)
	 */

	private void characteristicCurveRepresent(int machineID, int materialID, String betrType, double n) {
		// Method implementation here
		// For example:
		System.out.println("Machine ID: " + machineID);
		System.out.println("Material ID: " + materialID);
		System.out.println("Betr Type: " + betrType);
		System.out.println("Value of n: " + n);

		// Const test_number_positions = 30
		int TEST_NUMBER_POSITIONS = 30;

		// Dim Form As Worksheet
		ResultSet Form = null;

		// Dim Error As Error Code Type
		String ErrorCodeType = null;
		// Dim Chart_Saugvermoegen As Chart
		String Chart_Saugvermoegen;

		// Dim Series_Suction Capacity As Series
		String Series_SuctionCapacity;
		// Dim Chart_Power Consumption As Chart
		String Chart_PowerConsumption;
		// Dim Series_Power Consumption As Series
		String Series_PowerConsumption;

		/* Dim i As Integer, j As Integer */
		Integer i, j;
		// Dim n_List_i, p_x_j, V_1_List_ij, P_List_ij
		List<String> n_List_i = null;
		int p_x_j = 0;
		List<String> P_List_ij = null;
		// Dim values_p, values_sl, values_pl
		int[] values_p = null, values_sl = null, values_pl = null;
		// Dim_min
		int Dim_min = 0;
		// Dim Axis_p_sl As Axis, axis_p_pl As Axis

		// Set Form = Worksheets("Form");

		ResultSet form = null;
		// Set Chart_Suction_Capacity = Form.ChartObjects.Item(1).Chart
		String Chart_Suction_Capacity = null;

		// Set Series_SuctionCapacity =
		// Chart_SuctionCapacity.SeriesCollection("SuctionCapacity")
		String[] Series_SuctionCapacity1 = null;

		// Set Chart_Leistungsaufnahme = Form.ChartObjects.Item(2).Chart
		String Chart_Leistungsaufnahme = null;
		// Set Series_PowerConsumption =
		// Chart_PowerConsumption.SeriesCollection("PowerConsumption")
		String Series_PowerConsumption1 = null;
		// Set Axis_p_sl = Chart_Saugvermoegen.Axes(xlCategory)
		String Axis_p_sl = null;
		// Set axis_p_pl = Chart_Power_Consumption.Axes(xlCategory)
		String axis_p_pl = null;

		// Dim Series_test As Series
		String Series_test = null;

		// Dim p_test(1 To test_anz_stellen) As Double
		// Double p_test;
		int test_anz_stellen = 100;// Constant not in code ...
		double[] p_test = new double[test_anz_stellen];
		// Dim V_test(1 To test_anz_stellen) As Double
		//
		double[] V_test = new double[test_anz_stellen];

		// Dim alpha_sl, alpha_pl
		String alpha_sl = null;
		String alpha_pl = null;

		// Set Serie_test = Chart_Saugvermoegen.SeriesCollection("Test")
		String Serie_test = null;

		/*
		 * For i = 1 To test_number_of_places p_test(i) = Round(10 ^ (i /
		 * (test_anz_stellen / 2) + 1.2), 1) Next i
		 */ int test_number_of_places = 100;/// som econstant not there in code

		for (i = 1; i <= test_number_of_places; i++) {
			double exponent = (double) i / (test_anz_stellen / 2) + 1.2;
			double value = Math.pow(10, exponent);

			// Round to 1 decimal place
			p_test[i - 1] = Math.round(value * 10) / 10.0;
		}

		// If IsEmpty(Machine_ID) Then
		String Machine_ID = null;
		if (Machine_ID == null) {

		}
		// Series_Suction_Capacity.XValues = Array(1, 1)
		// Series_SuctionCapacity[0][0]; --Not able undersatnd
		// Series_Suction_Capacity.Values = Array(1, 1)
		// Series_Suction_Capacity[][]//--Not able undersatnd
		// Chart_Saugvermoegen.ChartTitle.Text = "Suction capacity"
		Chart_Saugvermoegen = "Suction capacity";
		// Series_Power_Consumption.XValues = Array(1, 1)
		// Series_Power_Consumption[][];--Not able undersatnd
		// Series_PowerConsumption.Values = Array(1, 1)
		// Series_PowerConsumption
		// Chart_PowerConsumption.ChartTitle.Text = "Power Consumption"
		Chart_PowerConsumption = "Power Consumption";
		// Exit Sub
		// EndIf
//Call map matrix (error, machine_ID, material_ID, CInt(operating_type), n_list_i, p_x_j, V_1_list_ij, P_list_ij, Empty)
		mapMatrix(ErrorCodeType, Machine_ID, Machine_ID, Dim_min, test_anz_stellen, test_number_of_places, null, null,
				Series_PowerConsumption1);

		// Call bicubic_spline_coeff(n_Liste_i, p_x_j, V_1_Liste_ij, alpha_sl)
		bicubicSplineCoeff(Dim_min, test_anz_stellen, null, test_number_of_places);

		// Call bicubic_spline_coeff(n_Liste_i, p_x_j, P_Liste_ij, alpha_pl)
		bicubicSplineCoeff(Dim_min, test_anz_stellen, null, test_number_of_places);

		// ReDim V_1_Liste_j(LBound(p_x_j) To UBound(p_x_j)) As Double
		double[] V_1_Liste_j = new double[p_x_j - p_x_j + 1];

		// ReDim P_Liste_j(LBound(p_x_j) To UBound(p_x_j)) As Double
		double[] P_Liste_j = new double[p_x_j - p_x_j + 1];

		/*
		 * For j = LBound(p_x_j) To UBound(p_x_j) V_1_Liste_j(j) =
		 * Round(bicubic_spline_interpolation(n_Liste_i, p_x_j, alpha_sl, n,
		 * CDbl(p_x_j(j)))) P_Liste_j(j) = Round(bicubic_spline_interpolation(n_Liste_i,
		 * p_x_j, alpha_pl, n, CDbl(p_x_j(j))), 2) Next j
		 */
		double[] pXJ = { 1.0, 2.0, 3.0, 4.0 }; // Example data
		double[] v1ListeJ = new double[pXJ.length];
		double[] pListeJ = new double[pXJ.length];
		int nListeI = 5; // Example value
		double alphaSl = 1.5; // Example value
		double alphaPl = 2.5; // Example value
		n = 10; // Example value

		// Iterate over the array
		for (j = 0; j < pXJ.length; j++) {
			// Perform bicubic spline interpolation and round results
			double interpolationSl = bicubicSplineInterpolation(nListeI, pXJ, alphaSl, n, pXJ[j]);
			double interpolationPl = bicubicSplineInterpolation(nListeI, pXJ, alphaPl, n, pXJ[j]);

			v1ListeJ[j] = Math.round(interpolationSl);
			pListeJ[j] = Math.round(interpolationPl * 100.0) / 100.0; // Round to 2 decimal places
		}

		/*
		 * For j = 1 To test_number_of_places V_test(j) =
		 * Round(bicubic_spline_interpolation(n_List_i, p_x_j, alpha_sl, n, p_test(j)))
		 * Next j
		 */

		int testNumberOfPlaces = 5; // Example value
		double[] pTest = { 1.0, 2.0, 3.0, 4.0, 5.0 }; // Example data
		double[] vTest = new double[testNumberOfPlaces];
		int nListI = 5; // Example value
		alphaSl = 1.5; // Example value
		n = 10; // Example value

		// Iterate over the array
		for (j = 0; j < testNumberOfPlaces; j++) {
			vTest[j] = Math.round(bicubicSplineInterpolation(nListI, pTest, alphaSl, n, pTest[j]));
		}

		/*
		 * values_p = p_x_j values_sl = V_1_List_j values_pl = P_List_j
		 */

		/*
		 * values_p[0] = p_x_j; values_sl[0] =(int) 1.0; values_pl[0] = (int) 1.0;
		 */

		/*
		 * If Not IsEmpty(values_p) Then Chart_Suction_Capacity.ChartTitle.Text =
		 * "Catalog suction capacity for " & Machine_ID & " (" & Material_ID & ") and "
		 * & n & " rpm" Chart_Power_Consumption.ChartTitle.Text =
		 * "Catalog power consumption for " & Machine_ID & " (" & Material_ID & ") and "
		 * & n & " rpm"
		 */

		// If Not IsEmpty(values_p) Then
		if (values_p == null) {

			// Chart_Suction_Capacity.ChartTitle.Text = "Catalog suction capacity for " &
			// Machine_ID & " (" & Material_ID & ") and " & n & " rpm"

			Chart_Suction_Capacity = "Catalog suction capacity for " + "& Machine_ID &" + "(" + "& Material_ID & "
					+ ") and " + "& n & " + "rpm";

			// Chart_Power_Consumption.ChartTitle.Text = "Catalog power consumption for " &
			// Machine_ID & " (" & Material_ID & ") and " & n & " rpm"
			String Chart_Power_Consumption = "Catalog power consumption for & Machine_ID & (& Material_ID & ) and  & n &  rpm";
		}

		// If type = 1 Then

		int type = 0;
		int subject_type = 0;
		if (type == 1) {
			// Chart_Saugvermoegen.ChartTitle.Text = Chart_Saugvermoegen.ChartTitle.Text &
			// vbLf & "Vacuum operation"
			Chart_Saugvermoegen = "Vacuum operation";
			// Chart_Leistungsaufnahme.ChartTitle.Text =
			// Chart_Leistungsaufnahme.ChartTitle.Text & vbLf & "Vacuum operation"
			Chart_Leistungsaufnahme = "Vacuum operation";
			// Axis_p_sl.AxisTitle.Text = "p_1 [mbar]"
			Axis_p_sl = null;
			// String Axis_p_sl.MinimumScale = 10 ^ Int(Log(values_p(1)) / Log(10));
			// Axis_p_sl.ScaleType = xlScaleLogarithmic
			// Axis_p_sl.HasMinorGridlines = True
			boolean HasMinorGridlines = true;
			// Axis_p_sl.MinorGridlines.border.ColorIndex = 15
			int Axis_p_sl_MinorGridlines_border_ColorIndex = 15;

			// axis_p_pl.AxisTitle.Text = "p_1 [mbar]"
			String axis_p_pl_AxisTitle_Text = "p_1 [mbar]";
			// axis_p_pl.MinimumScale = 10 ^ Int(Log(values_p(1)) / Log(10))

			double axis_p_pl_MinimumScale = Math.pow(10, Math.floor(Math.log(values_p[1]) / Math.log(10)));
			// axis_p_pl.ScaleType = xlScaleLogarithmic
			// axis_p_pl.HasMinorGridlines = True
			boolean axis_p_pl_HasMinorGridlines = true;
			// axis_p_pl.MinorGridlines.border.ColorIndex = 15
			int axis_p_pl_MinorGridlines_border_ColorIndex = 15;
		}
		// ElseIf subject_type = 2 Then

		else if (subject_type == 2) {
			// Chart_SuctionCapacity.ChartTitle.Text = Chart_SuctionCapacity.ChartTitle.Text
			// & vbLf & "Compressor operation"
			String Chart_SuctionCapacity_ChartTitle_Text = "Compressor operation";
			// Chart_Leistungsaufnahme.ChartTitle.Text =
			// Chart_Leistungsaufnahme.ChartTitle.Text & vbLf & "Compressor operation"
			String Chart_Leistungsaufnahme_ChartTitle_Text = "Compressor operation";
			// Axis_p_sl.AxisTitle.Text = "p_2 [mbar]"
			String Axis_p_sl_AxisTitle_Text = "p_2 [mbar]";
			// Axis_p_sl.ScaleType = xlScaleLinear
			String Axis_p_sl_ScaleType = "xlScaleLinear";
			int Axis_p_sl_MinimumScale = 0;
			// Axis_p_sl.HasMinorGridlines = False
			boolean Axis_p_sl_HasMinorGridlines = false;

			// axis_p_pl.AxisTitle.Text = "p_2 [mbar]"
			String axis_p_pl_AxisTitle_Text = "p_2 [mbar]";

			// axis_p_pl.ScaleType = xlScaleLinear
			String axis_p_pl_ScaleType = " xlScaleLinear";
			int axis_p_pl_MinimumScale = 0;
			// axis_p_pl.HasMinorGridlines = False
			boolean axis_p_pl_HasMinorGridlines = false;

			// EndIf
		}

		else {

			// Serie_Saugvermoegen.XValues = values_p

			int Serie_Saugvermoegen_XValues = values_p[0];

			// Serie_Saugvermoegen.Values = values_sl
			int Serie_Saugvermoegen_Values = values_sl[0];
			// Series_Power_Consumption.XValues = values_p
			int Series_Power_Consumption_XValues = values_p[0];
			// Series_Power_Consumption.Values = values_pl
			int Series_Power_Consumption_Values = values_pl[0];
			// EndIf
		}

		// End Sub

	}

	// Private Sub gasjet_characteristic_curve_display(Gasjet_ID, Machine_ID, n)

	private void gasjet_characteristic_curve_display(int gasjetID, int machineID, int n) throws SQLException {

		// Dim Chart_Saugvermoegen As Chart
		String Chart_Saugvermoegen = null;
		// Dim Serie_Saugvermoegen As Series
		String Serie_Saugvermoegen = null;
		// Dim Gas Radiator Table As Worksheet
		ResultSet GasRadiatorTable = null;

		// Dim G_ID, M_ID
		String G_ID, M_ID;
		// Dim col_G_ID, col_M_ID, col_n, col_px1, col_vol11
		int col_G_ID, col_M_ID, col_n, col_px1, col_vol11;

		// Dim search_range As Range, found_range As Range
		// xls has records starting row to end row ...iteration purpose we can use this
		// ..

		int search_range = 0, found_range = 100;// appraximate values given ..indicates first and last row in a sheet
		// Dim first_row, found_row, dataset_row

		int first_row, found_row, dataset_row;

		// Dim found_once As Boolean

		boolean found_once;

		// Dim p_i(1 To 6), V_1_i(1 To 6)
		int[] pI = new int[6];
		double[] v1I = new double[6];

		// Dim i As Integer
		int i = 0;

		// Set gas lamp table = Worksheets("Gas lamp table")
		ResultSet gaslamptable = null;
		// Set Chart_Suction_Capacity = Form.ChartObjects.Item(3).Chart
		int[] Chart_Suction_Capacity = null;
		// Set Series_SuctionCapacity =
		// Chart_SuctionCapacity.SeriesCollection("SuctionCapacity")
		int[] Series_SuctionCapacity = null;

		/*
		 * If IsEmpty(Gasstrahler_ID) Then Chart_Suction_Capacity.ChartTitle.Text =
		 * "Catalog suction capacity" Series_Suction_Capacity.XValues = Array(1, 1)
		 * Series_Suction_Capacity.Values = Array(1, 1)
		 */
		String Gasstrahler_ID = null;
		if (Gasstrahler_ID == null) {
			String Chart_Suction_Capacity_ChartTitle_Text = "Catalog suction capacity";
			int[] Series_Suction_Capacity_XValues = { 1 };
			int[] Series_Suction_Capacity_Values = { 1 };

		}

		// Exit Sub
		// exit function

		// EndIf exit if condition

		// col_G_ID = Gas radiator table.Rows(1).Find("TYPE", , , xlWhole).Column
		col_G_ID = gaslamptable.getInt("TYPE");
		// col_M_ID = Gas radiator table.Rows(1).Find("PUMP", , , xlWhole).Column
		col_M_ID = gaslamptable.getInt("PUMP");
		// col_px1 = Gas radiator table.Rows(1).Find("PX1", , , xlWhole).Column

		col_px1 = gaslamptable.getInt("PX1");

		// col_vol11 = Gas radiator table.Rows(1).Find("VOL11", , , xlWhole).Column
		col_vol11 = gaslamptable.getInt("VOL11");
		;
		// col_n = Gas radiator table.Rows(1).Find("RPM", , , xlWhole).Column
		col_n = gaslamptable.getInt("RPM");

		// Set search_range = gas lamp table.Columns(col_G_ID)
		search_range = gaslamptable.getInt(col_G_ID);

		// first_row = 0
		first_row = 0;
		// found_row = 0
		found_row = 0;
		// found_once = False
		found_once = false;
		// dataset_row = 0
		dataset_row = 0;

		/*
		 * do If Not found_once Then Set found_range = search_range.Find(Gasstrahler_ID,
		 * , , xlWhole) If Not found_range Is Nothing Then found_once = True found_row =
		 * found_range.Row EndIf Else If first_row = 0 Then first_row = found_range.Row
		 * Set found_range = search_range.FindNext(found_range) found_row =
		 * found_range.Row EndIf If (Not found_range Is Nothing) And (found_row <>
		 * first_row) Then M_ID = gas lamp table.Cells(found_row, col_M_ID) If M_ID =
		 * Machine_ID And n = Gas radiator table.Cells(found_row, col_n) Then
		 * dataset_row = found_row Exit Do EndIf EndIf Loop Until found_range Is Nothing
		 * Or found_row = first_row
		 */

		int index = 0;
		List<ArrayList<String>> arrayGaslamptable = null;// gaslamptable.getArray(0);
		for (ArrayList<String> row : arrayGaslamptable) {
			// Cell cell = row.getCell(0); // Assuming the search is in the first column
			// (adjust as needed)
			String cell = row.get(index);
			if (cell != null && cell.equals(Gasstrahler_ID)) {
				found_once = true;
				first_row = new Integer(row.get(index));
				break;
			}
		}

		if (found_once) {
			int foundRow = first_row;

			while (foundRow != -1) {
				ArrayList<String> currentRow = arrayGaslamptable.get(foundRow);
				if (currentRow != null) {
					String mID = currentRow.get(col_M_ID);
					// String n = GasRadiatorTable.get(foundRow).getCell(colN).getStringCellValue();
					n = GasRadiatorTable.getInt(foundRow);

					if (mID.equals(machineID) && String.valueOf(n).equals("desiredValue")) { // Replace "desiredValue"
																								// with the actual value
																								// to compare
						dataset_row = foundRow;
						break;
					}

					// foundRow = findNextRow(gasLampSheet, foundRow, gasstrahlerID);
					foundRow = index++; // get next Record //findNextRow(gasLampSheet, foundRow, gasstrahlerID);

				}
			}
		}

		/*
		 * If dataset_row > 0 Then
		 * 
		 * Chart_Suction_Capacity.ChartTitle.Text = "Catalog suction capacity for " &
		 * Gas_jet_ID & " - " & Machine_ID & " - " & n & " rpm"
		 * 
		 * For i = 1 To 6 p_i(i) = gas radiator table.Cells(dataset_row, col_px1 + (i -
		 * 1)) V_1_i(i) = gas lamp table.Cells(dataset_row, col_vol11 + (i - 1)) Next i
		 * 
		 * Series_Suction_Capacity.XValues = p_i Series_Suction_Capacity.Values = V_1_i
		 * EndIf End Sub
		 */

		if (dataset_row > 0) {

			String Chart_Suction_Capacity_ChartTitle_Text = "Catalog suction capacity for &" + gasjetID + "&  -  &"
					+ machineID + "&  -  &" + n + "&  rpm";
			for (int i1 = 1; i1 <= 6; i1++) {

				pI[i1] = GasRadiatorTable.getInt(col_px1 + (i1 - 1));
				v1I[i1] = gaslamptable.getInt(col_vol11 + (i1 - 1));
				/*
				 * Series_Suction_Capacity[i1] = pI; Series_Suction_Capacity[i1] = v1I;
				 */

			}

		}

	}

	public static double bicubicSplineInterpolation(int nListeI, double[] pXJ, double alpha, int n, double x) {
		// Implement the interpolation logic
		// Placeholder implementation
		return x * alpha; // Example calculation
	}

	// Method for bicubic spline interpolation
	public static double bicubicSplineInterpolation(int nListeI, double[] pXJ, double alpha, double n, double x) {
		// Implement the interpolation logic
		// Placeholder implementation
		return x * alpha; // Example calculation
	}

	public void mapMatrix(String error, String machineId, String materialId, int operatingType, int nListI, double pXJ,
			double[][] v1ListIj, double[][] pListIj, Object o) // Use Object to represent null or any type for the
																// "Empty" parameter)

	{

	}

	public void bicubicSplineCoeff(int nListeI, double pXJ, double[][] v1ListeIj, double alphaSl) {
		// Method implementation
		System.out.println("n_Liste_i: " + nListeI);
		System.out.println("p_x_j: " + pXJ);
		System.out.println("alpha_sl: " + alphaSl);

		System.out.println("V_1_Liste_ij:");
		for (double[] row : v1ListeIj) {
			for (double value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}

		// Implement the actual bicubic spline coefficient calculation logic here

	}

}
