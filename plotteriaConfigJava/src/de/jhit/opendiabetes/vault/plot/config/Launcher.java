package de.jhit.opendiabetes.vault.plot.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ini4j.ConfigParser;
import org.ini4j.ConfigParser.DuplicateSectionException;
import org.ini4j.ConfigParser.InterpolationException;
import org.ini4j.ConfigParser.NoOptionException;
import org.ini4j.ConfigParser.NoSectionException;

import com.google.gson.Gson;

import de.jhit.opendiabetes.vault.plot.config.Generic.GenericType;

public class Launcher {

	public static void createIni(PlotteriaConfig cfg, String fileName) {
		ConfigParser config = new ConfigParser();

		try {
			config.addSection("limits");
			config.set("limits", "limitsManual", cfg.isLimitsManual());
			config.set("limits", "hmin", cfg.getHmin());
			config.set("limits", "hmax", cfg.getHmax());
			config.set("limits", "barWidth", cfg.getBarWidth());
			config.set("limits", "bgCgmMaxValue", cfg.getBgCgmMaxValue());
			config.set("limits", "maxBasalValue", cfg.getMaxBasalValue());
			config.set("limits", "maxBasalBelowLegendValue", cfg.getMaxBasalBelowLegendValue());
			config.set("limits", "cgmBgHighLimit", cfg.getCgmBgHighLimit());
			config.set("limits", "cgmBgLimitMarkerLow", cfg.getCgmBgLimitMarkerLow());
			config.set("limits", "cgmBgLimitMarkerHigh", cfg.getCgmBgLimitMarkerHigh());
			config.set("limits", "minHrValue", cfg.getMinHrValue());
			config.set("limits", "maxHrValue", cfg.getMaxHrValue());
			config.set("limits", "minCgmBgValue", cfg.getMinCgmBgValue());
			config.set("limits", "maxBarValue", cfg.getMaxBarValue());
			config.set("limits", "interruptLinePlotMinutes", cfg.getInterruptLinePlotMinutes());
			config.set("limits", "glucoseElevationN1", cfg.getGlucoseElevationN1());
			config.set("limits", "glucoseElevationN2", cfg.getGlucoseElevationN2());
			config.set("limits", "glucoseElevationN3", cfg.getGlucoseElevationN3());
			config.set("limits", "legendXOffset", cfg.getLegendXOffset());
			config.set("limits", "legendYOffset", cfg.getLegendYOffset());
			config.set("limits", "mlCgmArrayIndex", cfg.getMlCgmArrayIndex());
			config.set("limits", "bolusClassificationMinutes", cfg.getBolusClassificationMinutes());
			
			config.addSection("plotBooleans");
			config.set("plotBooleans", "filterBgManual", cfg.isFilterBgManual());
			config.set("plotBooleans", "plotCarb", cfg.isPlotCarb());
			config.set("plotBooleans", "plotBolus", cfg.isPlotBolus());
			config.set("plotBooleans", "plotBolusCalculation", cfg.isPlotBolusCalculation());
			config.set("plotBooleans", "plotBasal", cfg.isPlotBasal());
			config.set("plotBooleans", "plotBg", cfg.isPlotBg());
			config.set("plotBooleans", "plotCgm", cfg.isPlotCgm());
			config.set("plotBooleans", "plotCgmRaw", cfg.isPlotCgmRaw());
			config.set("plotBooleans", "plotHeartRate", cfg.isPlotHeartRate());
			config.set("plotBooleans", "plotSleep", cfg.isPlotSleep());
			config.set("plotBooleans", "plotSymbols", cfg.isPlotSymbols());
			config.set("plotBooleans", "plotLocation", cfg.isPlotLocation());
			config.set("plotBooleans", "plotExercise", cfg.isPlotExercise());
			config.set("plotBooleans", "plotStress", cfg.isPlotStress());
			config.set("plotBooleans", "plotAutonomousSuspend", cfg.isPlotAutonomousSuspend());
			config.set("plotBooleans", "plotElevation", cfg.isPlotElevation());
			config.set("plotBooleans", "plotBolusClassification", cfg.isPlotBolusClassification());
			
			config.addSection("colors");
			config.set("colors", "hbgColor", cfg.getHbgColor());
			config.set("colors", "gridColor", cfg.getGridColor());
			config.set("colors", "carbBarColor", cfg.getCarbBarColor());
			config.set("colors", "bolusBarColor", cfg.getBolusBarColor());
			config.set("colors", "bolusCalculationColor", cfg.getBolusCalculationColor());
			config.set("colors", "bgPlotColor", cfg.getBgPlotColor());
			config.set("colors", "cgmPlotColor", cfg.getCgmPlotColor());
			config.set("colors", "cgmRawPlotColor", cfg.getCgmRawPlotColor());
			config.set("colors", "cgmCalibrationPlotColor", cfg.getCgmCalibrationPlotColor());
			config.set("colors", "mlCgmPlotColor", cfg.getMlCgmPlotColor());
			config.set("colors", "pumpCgmPredictionPlotColor", cfg.getPumpCgmPredictionPlotColor());
			config.set("colors", "basalPlotColor", cfg.getBasalPlotColor());
			config.set("colors", "heartRatePlotColor", cfg.getHeartRatePlotColor());
			config.set("colors", "overMaxColor", cfg.getOverMaxColor());
			config.set("colors", "symbolsColor", cfg.getSymbolsColor());
			config.set("colors", "pumpColor", cfg.getPumpColor());
			config.set("colors", "symbolsBackgroundColor", cfg.getSymbolsBackgroundColor());
			config.set("colors", "cgmBgLimitMarkerColor", cfg.getCgmBgLimitMarkerColor());
			config.set("colors", "stress0Color", cfg.getStress0Color());
			config.set("colors", "stress1Color", cfg.getStress1Color());
			config.set("colors", "stress2Color", cfg.getStress2Color());
			config.set("colors", "stress3Color", cfg.getStress3Color());
			config.set("colors", "stress4Color", cfg.getStress4Color());
			config.set("colors", "exerciseLowColor", cfg.getExerciseLowColor());
			config.set("colors", "exerciseMidColor", cfg.getExerciseMidColor());
			config.set("colors", "exerciseHighColor", cfg.getExerciseHighColor());
			config.set("colors", "lightSleepColor", cfg.getLightSleepColor());
			config.set("colors", "deepSleepColor", cfg.getDeepSleepColor());
			config.set("colors", "autonomousSuspendColor", cfg.getAutonomousSuspendColor());
			config.set("colors", "glucoseElevationColor", cfg.getGlucoseElevationColor());
			config.set("colors", "bolusClassificiationColorClass1", cfg.getBolusClassificiationColorClass1());
			config.set("colors", "bolusClassificiationColorClass2", cfg.getBolusClassificiationColorClass2());
			config.set("colors", "bolusClassificiationColorClass3", cfg.getBolusClassificiationColorClass3());
			config.set("colors", "bolusClassificiationColorClass4", cfg.getBolusClassificiationColorClass4());
			config.set("colors", "bolusClassificiationColorClass5", cfg.getBolusClassificiationColorClass5());
			config.set("colors", "bolusClassificiationColorClass6", cfg.getBolusClassificiationColorClass6());
			
			config.addSection("axisLabels");
			config.set("axisLabels", "showXaxisLabel", cfg.isShowXaxisLabel());
			config.set("axisLabels", "xaxisLabel", cfg.getXaxisLabel());
			config.set("axisLabels", "bolusLabel", cfg.getBolusLabel());
			config.set("axisLabels", "basalLabel", cfg.getBasalLabel());
			config.set("axisLabels", "bgLabel", cfg.getBgLabel());
			config.set("axisLabels", "hrLabel", cfg.getHrLabel());
			config.set("axisLabels", "cgmRawLabel", cfg.getCgmRawLabel());
			
			config.addSection("legendLabels");
			config.set("legendLabels", "bgLegend", cfg.getBgLegend());
			config.set("legendLabels", "cgmLegend", cfg.getCgmLegend());
			config.set("legendLabels", "cgmAlertLegend", cfg.getCgmAlertLegend());
			config.set("legendLabels", "cgmCalibrationLegend", cfg.getCgmCalibrationLegend());
			config.set("legendLabels", "mlCgmLegend", cfg.getMlCgmLegend());
			config.set("legendLabels", "pumpCgmPredictionLegend", cfg.getPumpCgmPredictionLegend());
			config.set("legendLabels", "basalLegend", cfg.getBasalLegend());
			config.set("legendLabels", "heartRateLegend", cfg.getHeartRateLegend());
			config.set("legendLabels", "carbLegend", cfg.getCarbLegend());
			config.set("legendLabels", "bolusLegend", cfg.getBolusLegend());
			config.set("legendLabels", "bolusCalculationLegend", cfg.getBolusCalculationLegend());
			config.set("legendLabels", "autonomousSuspendLegend", cfg.getAutonomousSuspendLegend());
			config.set("legendLabels", "lowElevationUpLegend", cfg.getLowElevationUpLegend());
			config.set("legendLabels", "midElevationUpLegend", cfg.getMidElevationUpLegend());
			config.set("legendLabels", "highElevationUpLegend", cfg.getHighElevationUpLegend());
			config.set("legendLabels", "lowElevationDownLegend", cfg.getLowElevationDownLegend());
			config.set("legendLabels", "midElevationDownLegend", cfg.getMidElevationDownLegend());
			config.set("legendLabels", "highElevationDownLegend", cfg.getHighElevationDownLegend());
			
			config.addSection("symbolLabels");
			config.set("symbolLabels", "exerciseLegend", cfg.getExerciseLegend());
			config.set("symbolLabels", "pumpRewindLegend", cfg.getPumpRewindLegend());
			config.set("symbolLabels", "pumpKatErrLegend", cfg.getPumpKatErrLegend());
			config.set("symbolLabels", "cgmCalibrationErrorLegend", cfg.getCgmCalibrationErrorLegend());
			config.set("symbolLabels", "cgmConnectionErrorLegend", cfg.getCgmConnectionErrorLegend());
			config.set("symbolLabels", "cgmSensorFinishedLegend", cfg.getCgmSensorFinishedLegend());
			config.set("symbolLabels", "cgmSensorStartLegend", cfg.getCgmSensorStartLegend());
			config.set("symbolLabels", "cgmTimeSyncLegend", cfg.getCgmTimeSyncLegend());
			config.set("symbolLabels", "pumpReservoirEmptyLegend", cfg.getPumpReservoirEmptyLegend());
			
			config.addSection("stressLabels");
			config.set("stressLabels", "stress0Label", cfg.getStress0Label());
			config.set("stressLabels", "stress1Label", cfg.getStress1Label());
			config.set("stressLabels", "stress2Label", cfg.getStress2Label());
			config.set("stressLabels", "stress3Label", cfg.getStress3Label());
			config.set("stressLabels", "stress4Label", cfg.getStress4Label());
			
			config.addSection("symbolMarkers");
			config.set("symbolMarkers", "rewindMarker", cfg.getRewindMarker());
			config.set("symbolMarkers", "katErrMarker", cfg.getKatErrMarker());
			config.set("symbolMarkers", "exerciseMarker", cfg.getExerciseMarker());
			config.set("symbolMarkers", "cgmCalibrationErrorMarker", cfg.getCgmCalibrationErrorMarker());
			config.set("symbolMarkers", "cgmConnectionErrorMarker", cfg.getCgmConnectionErrorMarker());
			config.set("symbolMarkers", "cgmSensorFinishedMarker", cfg.getCgmSensorFinishedMarker());
			config.set("symbolMarkers", "cgmSensorStartMarker", cfg.getCgmSensorStartMarker());
			config.set("symbolMarkers", "cgmTimeSyncMarker", cfg.getCgmTimeSyncMarker());
			config.set("symbolMarkers", "pumpReservoirEmptyMarker", cfg.getPumpReservoirEmptyMarker());
			
			config.addSection("plotMarkers");
			config.set("plotMarkers", "cgmMarker", cfg.getCgmMarker());
			config.set("plotMarkers", "bolusCalculationMarker", cfg.getBolusCalculationMarker());
			config.set("plotMarkers", "heartRateMarker", cfg.getHeartRateMarker());
			config.set("plotMarkers", "cgmCalibrationMarker", cfg.getCgmCalibrationMarker());
			config.set("plotMarkers", "cgmAdditionalMarkerSize", cfg.getCgmAdditionalMarkerSize());
			config.set("plotMarkers", "cgmMainMarkerSize", cfg.getCgmMainMarkerSize());
			config.set("plotMarkers", "bolusCalculationMarkerSize", cfg.getBolusCalculationMarkerSize());
			config.set("plotMarkers", "heartRateMarkerSize", cfg.getHeartRateMarkerSize());
			
			config.addSection("locations");
			config.set("locations", "locNoDataLabel", cfg.getLocNoDataLabel());
			config.set("locations", "locTransitionLabel", cfg.getLocTransitionLabel());
			config.set("locations", "locHomeLabel", cfg.getLocHomeLabel());
			config.set("locations", "locWorkLabel", cfg.getLocWorkLabel());
			config.set("locations", "locFoodLabel", cfg.getLocFoodLabel());
			config.set("locations", "locSportsLabel", cfg.getLocSportsLabel());
			config.set("locations", "locOtherLabel", cfg.getLocOtherLabel());
			
			config.set("locations", "locNoDataColor", cfg.getLocNoDataColor());
			config.set("locations", "locTransitionColor", cfg.getLocTransitionColor());
			config.set("locations", "locHomeColor", cfg.getLocHomeColor());
			config.set("locations", "locWorkColor", cfg.getLocWorkColor());
			config.set("locations", "locFoodColor", cfg.getLocFoodColor());
			config.set("locations", "locSportsColor", cfg.getLocSportsColor());
			config.set("locations", "locOtherColor", cfg.getLocOtherColor());
			
			config.addSection("exerciseLabel");
			config.set("exerciseLabel", "exerciseLowLabel", cfg.getExerciseLowLabel());
			config.set("exerciseLabel", "exerciseMidLabel", cfg.getExerciseMidLabel());
			config.set("exerciseLabel", "exerciseHighLabel", cfg.getExerciseHighLabel());
			
			config.addSection("sleepLabel");
			config.set("sleepLabel", "lightSleepLabel", cfg.getLightSleepLabel());
			config.set("sleepLabel", "deepSleepLabel", cfg.getDeepSleepLabel());
			
			config.addSection("linewidths");
			config.set("linewidths", "heartRateLineWidth", cfg.getHeartRateLineWidth());
			config.set("linewidths", "basalLineWidth", cfg.getBasalLineWidth());
			config.set("linewidths", "cgmLineWidth", cfg.getCgmLineWidth());
			config.set("linewidths", "cgmRawLineWidth", cfg.getCgmRawLineWidth());
			config.set("linewidths", "mlCgmLineWidth", cfg.getMlCgmLineWidth());
			config.set("linewidths", "pumpCgmPredictionLineWidth", cfg.getPumpCgmPredictionLineWidth());
			config.set("linewidths", "bgLineWidth", cfg.getBgLineWidth());
			config.set("linewidths", "bolusCalculationLineWidth", cfg.getBolusCalculationLineWidth());
			
			config.addSection("fileSettings");
			config.set("fileSettings", "fileExtension", cfg.getFileExtension());
			config.set("fileSettings", "filenamePrefix", cfg.getFilenamePrefix());
			config.set("fileSettings", "filenameDateFormatString", cfg.getFilenameDateFormatString());
			config.set("fileSettings", "plotListFileDailyStatistics", cfg.getPlotListFileDailyStatistics());
			config.set("fileSettings", "plotListFileDaily", cfg.getPlotListFileDaily());
			config.set("fileSettings", "plotListFileTinySlices", cfg.getPlotListFileTinySlices());
			config.set("fileSettings", "plotListFileNormalSlices", cfg.getPlotListFileNormalSlices());
			config.set("fileSettings", "plotListFileBigSlices", cfg.getPlotListFileBigSlices());
			config.set("fileSettings", "headerFileDailyStatistics", cfg.getHeaderFileDailyStatistics());
			config.set("fileSettings", "headerFileDaily", cfg.getHeaderFileDaily());
			config.set("fileSettings", "headerFileTinySlices", cfg.getHeaderFileTinySlices());
			config.set("fileSettings", "headerFileNormalSlices", cfg.getHeaderFileNormalSlices());
			config.set("fileSettings", "headerFileBigSlices", cfg.getHeaderFileBigSlices());
			config.set("fileSettings", "legendFileSymbols", cfg.getLegendFileSymbols());
			config.set("fileSettings", "legendFileDetailed", cfg.getLegendFileDetailed());
			
			config.addSection("dailyStatistics");
			config.set("dailyStatistics", "maxLengthNotes", cfg.getMaxLengthNotes());
			config.set("dailyStatistics", "labelTimeInRange", cfg.getLabelTimeInRange());
			config.set("dailyStatistics", "labelHypo", cfg.getLabelHypo());
			config.set("dailyStatistics", "labelHyper", cfg.getLabelHyper());
			config.set("dailyStatistics", "labelBasalTotal", cfg.getLabelBasalTotal());
			config.set("dailyStatistics", "labelBolusTotal", cfg.getLabelBolusTotal());
			config.set("dailyStatistics", "labelCarbTotal", cfg.getLabelCarbTotal());
			config.set("dailyStatistics", "labelAutonomousSuspentionTime", cfg.getLabelAutonomousSuspentionTime());
			config.set("dailyStatistics", "labelNote", cfg.getLabelNote());
			config.set("dailyStatistics", "colorTimeInRange", cfg.getColorTimeInRange());
			config.set("dailyStatistics", "colorHyper", cfg.getColorHyper());
			config.set("dailyStatistics", "colorHypo", cfg.getColorHypo());
			config.set("dailyStatistics", "colorNone", cfg.getColorNone());
			
			config.set("axisLabels", "titelDateFormat", cfg.getTitelDateFormat());
			config.set("axisLabels", "delimiter", cfg.getDelimiter());

			config.addSection("generics");
			config.set("generics", "cgm", cfg.getCgmGenerics());
			config.set("generics", "bolusCalculation", cfg.getBolusCalculationGenerics());
			config.set("generics", "bolus", cfg.getBolusGenerics());
			config.set("generics", "basal", cfg.getBasalGenerics());
			
			config.write(new File(fileName));
			
		} catch (DuplicateSectionException e) {
			Logger.getGlobal().log(Level.WARNING, "[DuplicateSectionException] \'" + e.getMessage() + "\'");
			System.exit(0);
			e.printStackTrace();
		} catch (NoSectionException e) {
			Logger.getGlobal().log(Level.WARNING, "[NoSectionException] \'" + e.getMessage() + "\'");
			System.exit(0);
			e.printStackTrace();
		} catch (IOException e) {
			Logger.getGlobal().log(Level.WARNING, "[IOException] \'" + e.getMessage() + "\'");
			System.exit(0);
			e.printStackTrace();
		}


	}
	
	public static PlotteriaConfig parseIni(String filename) {
		ConfigParser config = new ConfigParser();
		PlotteriaConfig res = new PlotteriaConfig();
		try {
			config.read(filename);			
			try {
				res.setLimitsManual(config.getBoolean("limits", "limitsmanual"));
				res.setHmin(config.getInt("limits", "hmin"));
				res.setHmax(config.getInt("limits", "hmax"));
				res.setBarWidth(config.getDouble("limits", "barwidth"));
				res.setBgCgmMaxValue(config.getInt("limits", "bgcgmmaxvalue"));
				res.setMaxBasalValue(config.getDouble("limits", "maxbasalvalue"));
				res.setMaxBasalBelowLegendValue(config.getDouble("limits", "maxbasalbelowlegendvalue"));
				res.setCgmBgHighLimit(config.getInt("limits", "cgmbghighlimit"));
				res.setCgmBgLimitMarkerLow(config.getInt("limits", "cgmbglimitmarkerlow"));
				res.setCgmBgLimitMarkerHigh(config.getInt("limits", "cgmbglimitmarkerhigh"));
				res.setMinHrValue(config.getDouble("limits", "minhrvalue"));
				res.setMaxHrValue(config.getDouble("limits", "maxhrvalue"));
				res.setMinCgmBgValue(config.getInt("limits", "mincgmbgvalue"));
				res.setMaxBarValue(config.getDouble("limits", "maxbarvalue"));
				res.setInterruptLinePlotMinutes(config.getDouble("limits", "interruptlineplotminutes"));
				res.setGlucoseElevationN1(config.getDouble("limits", "glucoseelevationn1"));
				res.setGlucoseElevationN2(config.getDouble("limits", "glucoseelevationn2"));
				res.setGlucoseElevationN3(config.getDouble("limits", "glucoseelevationn3"));
				
				res.setLegendXOffset(config.getDouble("limits", "legendxoffset"));
				res.setLegendYOffset(config.getDouble("limits", "legendyoffset"));
				
				res.setMlCgmArrayIndex(config.getInt("limits", "mlcgmarrayindex"));
				
				res.setBolusClassificationMinutes(config.getDouble("limits", "bolusclassificationminutes"));
				
				res.setFilterBgManual(config.getBoolean("plotbooleans", "filterbgmanual"));
				res.setPlotCarb(config.getBoolean("plotbooleans", "plotcarb"));
				res.setPlotBolus(config.getBoolean("plotbooleans", "plotbolus"));
				res.setPlotBolusCalculation(config.getBoolean("plotbooleans", "plotboluscalculation"));
				res.setPlotBasal(config.getBoolean("plotbooleans", "plotbasal"));
				res.setPlotBg(config.getBoolean("plotbooleans", "plotbg"));
				res.setPlotCgm(config.getBoolean("plotbooleans", "plotcgm"));
				res.setPlotCgmRaw(config.getBoolean("plotbooleans", "plotcgmraw"));
				res.setPlotHeartRate(config.getBoolean("plotbooleans", "plotheartrate"));
				res.setPlotSleep(config.getBoolean("plotbooleans", "plotsleep"));
				res.setPlotSymbols(config.getBoolean("plotbooleans", "plotsymbols"));
				res.setPlotLocation(config.getBoolean("plotbooleans", "plotlocation"));
				res.setPlotExercise(config.getBoolean("plotbooleans", "plotexercise"));
				res.setPlotStress(config.getBoolean("plotbooleans", "plotstress"));
				res.setPlotAutonomousSuspend(config.getBoolean("plotbooleans", "plotautonomoussuspend"));
				res.setPlotElevation(config.getBoolean("plotbooleans", "plotelevation"));
				res.setPlotBolusClassification(config.getBoolean("plotbooleans", "plotbolusclassification"));
				
				res.setHbgColor(config.get("colors", "hbgcolor"));
				res.setGridColor(config.get("colors", "gridcolor"));
				res.setCarbBarColor(config.get("colors", "carbbarcolor"));
				res.setBolusBarColor(config.get("colors", "bolusbarcolor"));
				res.setBolusCalculationColor(config.get("colors", "boluscalculationcolor"));
				res.setBgPlotColor(config.get("colors", "bgplotcolor"));
				res.setCgmPlotColor(config.get("colors", "cgmplotcolor"));
				res.setCgmRawPlotColor(config.get("colors", "cgmrawplotcolor"));
				res.setCgmCalibrationPlotColor(config.get("colors", "cgmcalibrationplotcolor"));
				res.setMlCgmPlotColor(config.get("colors", "mlcgmplotcolor"));
				res.setPumpCgmPredictionPlotColor(config.get("colors", "pumpcgmpredictionplotcolor"));
				res.setBasalPlotColor(config.get("colors", "basalplotcolor"));
				res.setHeartRatePlotColor(config.get("colors", "heartrateplotcolor"));
				res.setOverMaxColor(config.get("colors", "overmaxcolor"));
				res.setSymbolsColor(config.get("colors", "symbolscolor"));
				res.setPumpColor(config.get("colors", "pumpcolor"));
				res.setSymbolsBackgroundColor(config.get("colors", "symbolsbackgroundcolor"));
				res.setCgmBgLimitMarkerColor(config.get("colors", "cgmbglimitmarkercolor"));
				res.setStress0Color(config.get("colors", "stress0color"));
				res.setStress1Color(config.get("colors", "stress1color"));
				res.setStress2Color(config.get("colors", "stress2color"));
				res.setStress3Color(config.get("colors", "stress3color"));
				res.setStress4Color(config.get("colors", "stress4color"));
				res.setExerciseLowColor(config.get("colors", "exerciselowcolor"));
				res.setExerciseMidColor(config.get("colors", "exercisemidcolor"));
				res.setExerciseHighColor(config.get("colors", "exercisehighcolor"));
				res.setLightSleepColor(config.get("colors", "lightsleepcolor"));
				res.setDeepSleepColor(config.get("colors", "deepsleepcolor"));
				res.setAutonomousSuspendColor(config.get("colors", "autonomoussuspendcolor"));
				res.setGlucoseElevationColor(config.get("colors", "glucoseelevationcolor"));
				res.setBolusClassificiationColorClass1(config.get("colors", "bolusclassificiationcolorclass1"));
				res.setBolusClassificiationColorClass2(config.get("colors", "bolusclassificiationcolorclass2"));
				res.setBolusClassificiationColorClass3(config.get("colors", "bolusclassificiationcolorclass3"));
				res.setBolusClassificiationColorClass4(config.get("colors", "bolusclassificiationcolorclass4"));
				res.setBolusClassificiationColorClass5(config.get("colors", "bolusclassificiationcolorclass5"));
				res.setBolusClassificiationColorClass6(config.get("colors", "bolusclassificiationcolorclass6"));				
				
				
				res.setShowXaxisLabel(config.getBoolean("axislabels", "showxaxislabel"));
				res.setXaxisLabel(config.get("axislabels","xaxislabel"));
				res.setBolusLabel(config.get("axislabels","boluslabel"));
				res.setBasalLabel(config.get("axislabels","basallabel"));
				res.setBgLabel(config.get("axislabels","bglabel"));
				res.setHrLabel(config.get("axislabels","hrlabel"));
				res.setCgmRawLabel(config.get("axislabels","cgmrawlabel"));
				res.setTitelDateFormat(config.get("axislabels","titeldateformat"));
				res.setDelimiter(config.get("axislabels","delimiter"));
				
				
				res.setBgLegend(config.get("legendlabels", "bglegend"));
				res.setCgmLegend(config.get("legendlabels", "cgmlegend"));
				res.setCgmAlertLegend(config.get("legendlabels", "cgmalertlegend"));
				res.setCgmCalibrationLegend(config.get("legendlabels", "cgmcalibrationlegend"));
				res.setMlCgmLegend(config.get("legendlabels", "mlcgmlegend"));
				res.setPumpCgmPredictionLegend(config.get("legendlabels", "pumpcgmpredictionlegend"));
				res.setBasalLegend(config.get("legendlabels", "basallegend"));
				res.setHeartRateLegend(config.get("legendlabels", "heartratelegend"));
				res.setCarbLegend(config.get("legendlabels", "carblegend"));
				res.setBolusLegend(config.get("legendlabels", "boluslegend"));
				res.setBolusCalculationLegend(config.get("legendlabels", "boluscalculationlegend"));
				res.setAutonomousSuspendLegend(config.get("legendlabels", "autonomoussuspendlegend"));
				res.setLowElevationUpLegend(config.get("legendlabels", "lowelevationuplegend"));
				res.setMidElevationUpLegend(config.get("legendlabels", "midelevationuplegend"));
				res.setHighElevationUpLegend(config.get("legendlabels", "highelevationuplegend"));
				res.setLowElevationDownLegend(config.get("legendlabels", "lowelevationdownlegend"));
				res.setMidElevationDownLegend(config.get("legendlabels", "midelevationdownlegend"));
				res.setHighElevationDownLegend(config.get("legendlabels", "highelevationdownlegend"));
				
				
				res.setExerciseLegend(config.get("symbollabels", "exerciselegend"));
				res.setPumpRewindLegend(config.get("symbollabels", "pumprewindlegend"));
				res.setPumpKatErrLegend(config.get("symbollabels", "pumpkaterrlegend"));
				res.setCgmCalibrationErrorLegend(config.get("symbollabels", "cgmcalibrationerrorlegend"));
				res.setCgmConnectionErrorLegend(config.get("symbollabels", "cgmconnectionerrorlegend"));
				res.setCgmSensorFinishedLegend(config.get("symbollabels", "cgmsensorfinishedlegend"));
				res.setCgmSensorStartLegend(config.get("symbollabels", "cgmsensorstartlegend"));
				res.setCgmTimeSyncLegend(config.get("symbollabels", "cgmtimesynclegend"));
				res.setPumpReservoirEmptyLegend(config.get("symbollabels", "pumpreservoiremptylegend"));
				
				res.setStress0Label(config.get("stresslabels", "stress0label"));
				res.setStress1Label(config.get("stresslabels", "stress1label"));
				res.setStress2Label(config.get("stresslabels", "stress2label"));
				res.setStress3Label(config.get("stresslabels", "stress3label"));
				res.setStress4Label(config.get("stresslabels", "stress4label"));
				
				res.setRewindMarker(config.get("symbolmarkers", "rewindmarker"));
				res.setKatErrMarker(config.get("symbolmarkers", "katerrmarker"));
				res.setExerciseMarker(config.get("symbolmarkers", "exercisemarker"));
				res.setCgmCalibrationErrorMarker(config.get("symbolmarkers", "cgmcalibrationerrormarker"));
				res.setCgmConnectionErrorMarker(config.get("symbolmarkers", "cgmconnectionerrormarker"));
				res.setCgmSensorFinishedMarker(config.get("symbolmarkers", "cgmsensorfinishedmarker"));
				res.setCgmSensorStartMarker(config.get("symbolmarkers", "cgmsensorstartmarker"));
				res.setCgmTimeSyncMarker(config.get("symbolmarkers", "cgmtimesyncmarker"));
				res.setPumpReservoirEmptyMarker(config.get("symbolmarkers", "pumpreservoiremptymarker"));
				
				res.setCgmMarker(config.get("plotmarkers", "cgmmarker"));
				res.setBolusCalculationMarker(config.get("plotmarkers", "boluscalculationmarker"));
				res.setHeartRateMarker(config.get("plotmarkers", "heartratemarker"));
				res.setCgmCalibrationMarker(config.get("plotmarkers", "cgmcalibrationmarker"));
				res.setCgmAdditionalMarkerSize(config.getInt("plotmarkers", "cgmadditionalmarkersize"));
				res.setCgmMainMarkerSize(config.getInt("plotmarkers", "cgmmainmarkersize"));
				res.setBolusCalculationMarkerSize(config.getInt("plotmarkers", "boluscalculationmarkersize"));
				res.setHeartRateMarkerSize(config.getInt("plotmarkers", "heartratemarkersize"));
				
				
				res.setLocNoDataLabel(config.get("locations", "locnodatalabel"));
				res.setLocTransitionLabel(config.get("locations", "loctransitionlabel"));
				res.setLocHomeLabel(config.get("locations", "lochomelabel"));
				res.setLocWorkLabel(config.get("locations", "locworklabel"));
				res.setLocFoodLabel(config.get("locations", "locfoodlabel"));
				res.setLocSportsLabel(config.get("locations", "locsportslabel"));
				res.setLocOtherLabel(config.get("locations", "locotherlabel"));
				
				res.setLocNoDataColor(config.get("locations", "locnodatacolor"));
				res.setLocTransitionColor(config.get("locations", "loctransitioncolor"));
				res.setLocHomeColor(config.get("locations", "lochomecolor"));
				res.setLocWorkColor(config.get("locations", "locworkcolor"));
				res.setLocFoodColor(config.get("locations", "locfoodcolor"));
				res.setLocSportsColor(config.get("locations", "locsportscolor"));
				res.setLocOtherColor(config.get("locations", "locothercolor"));
				
				
				res.setExerciseLowLabel(config.get("exerciselabel", "exerciselowlabel"));
				res.setExerciseMidLabel(config.get("exerciselabel", "exercisemidlabel"));
				res.setExerciseHighLabel(config.get("exerciselabel", "exercisehighlabel"));
				
				
				res.setLightSleepLabel(config.get("sleeplabel", "lightsleeplabel"));
				res.setDeepSleepLabel(config.get("sleeplabel", "deepsleeplabel"));
				
				
				res.setHeartRateLineWidth(config.getDouble("linewidths", "heartratelinewidth"));
				res.setBasalLineWidth(config.getDouble("linewidths", "basallinewidth"));
				res.setCgmLineWidth(config.getDouble("linewidths", "cgmlinewidth"));
				res.setCgmRawLineWidth(config.getDouble("linewidths", "cgmrawlinewidth"));
				res.setMlCgmLineWidth(config.getDouble("linewidths", "mlcgmlinewidth"));
				res.setPumpCgmPredictionLineWidth(config.getDouble("linewidths", "pumpcgmpredictionlinewidth"));
				res.setBgLineWidth(config.getDouble("linewidths", "bglinewidth"));
				res.setBolusCalculationLineWidth(config.getDouble("linewidths", "boluscalculationlinewidth"));
				
				
				res.setFileExtension(config.get("filesettings", "fileextension"));
				res.setFilenamePrefix(config.get("filesettings", "filenameprefix"));
				res.setFilenameDateFormatString(config.get("filesettings", "filenamedateformatstring"));
				res.setPlotListFileDailyStatistics(config.get("filesettings", "plotlistfiledailystatistics"));
				res.setPlotListFileDaily(config.get("filesettings", "plotlistfiledaily"));
				res.setPlotListFileTinySlices(config.get("filesettings", "plotlistfiletinyslices"));
				res.setPlotListFileNormalSlices(config.get("filesettings", "plotlistfilenormalslices"));
				res.setPlotListFileBigSlices(config.get("filesettings", "plotlistfilebigslices"));
				res.setHeaderFileDailyStatistics(config.get("filesettings", "headerfiledailystatistics"));
				res.setHeaderFileDaily(config.get("filesettings", "headerfiledaily"));
				res.setHeaderFileTinySlices(config.get("filesettings", "headerfiletinyslices"));
				res.setHeaderFileNormalSlices(config.get("filesettings", "headerfilenormalslices"));
				res.setHeaderFileBigSlices(config.get("filesettings", "headerfilebigslices"));
				res.setLegendFileSymbols(config.get("filesettings", "legendfilesymbols"));
				res.setLegendFileDetailed(config.get("filesettings", "legendfiledetailed"));

				
				res.setMaxLengthNotes(config.getInt("dailystatistics", "maxlengthnotes"));
				res.setLabelTimeInRange(config.get("dailystatistics", "labeltimeinrange"));
				res.setLabelHypo(config.get("dailystatistics", "labelhypo"));
				res.setLabelBasalTotal(config.get("dailystatistics", "labelbasaltotal"));
				res.setLabelBolusTotal(config.get("dailystatistics", "labelbolustotal"));
				res.setLabelCarbTotal(config.get("dailystatistics", "labelcarbtotal"));
				res.setLabelAutonomousSuspentionTime(config.get("dailystatistics", "labelautonomoussuspentiontime"));
				res.setLabelNote(config.get("dailystatistics", "labelnote"));
				res.setColorTimeInRange(config.get("dailystatistics", "colortimeinrange"));
				res.setColorHyper(config.get("dailystatistics", "colorhyper"));
				res.setColorHypo(config.get("dailystatistics", "colorhypo"));
				res.setColorNone(config.get("dailystatistics", "colornone"));
				
				Gson gson = new Gson();
				for(String[] s: gson.fromJson(config.get("generics", "cgm"), String[][].class)) {
					res.getCgmGenerics().add(new Generic(GenericType.CGM, s[0], s[1], s[2], s[3]));
				}
				for(String[] s: gson.fromJson(config.get("generics", "boluscalculation"), String[][].class)) {
					res.getCgmGenerics().add(new Generic(GenericType.BOLUSCALCULATION, s[0], s[1], s[2], s[3]));
				}
				for(String[] s: gson.fromJson(config.get("generics", "bolus"), String[][].class)) {
					res.getCgmGenerics().add(new Generic(GenericType.BOLUS, s[0], s[1], s[2], s[3]));
				}
				for(String[] s: gson.fromJson(config.get("generics", "basal"), String[][].class)) {
					res.getCgmGenerics().add(new Generic(GenericType.BASAL, s[0], s[1], s[2], s[3]));
				}
				
				config.get("generics", "wichser");

			} catch (NoSectionException e) {
				Logger.getGlobal().log(Level.WARNING, "[NoSectionException] Section \'" + e.getMessage() + "\' does not exist.");
				System.exit(0);
				e.printStackTrace();
			} catch (NoOptionException e) {
				Logger.getGlobal().log(Level.WARNING, "[NoOptionException] Option \'" + e.getMessage() + "\' does not exist.");
				System.exit(0);
				e.printStackTrace();
			} catch (InterpolationException e) {
				Logger.getGlobal().log(Level.WARNING, "[InterpolationException] \'" + e.getMessage() + "\'");
				System.exit(0);
				e.printStackTrace();
			}
		} catch (IOException e) {
			Logger.getGlobal().log(Level.WARNING, "[IOException] \'" + e.getMessage() + "\'");
			System.exit(0);
			e.printStackTrace();
		}
		
		return res;
	}

	public static void main(String[] args) {
		PlotteriaConfig sampleConfig = new PlotteriaConfig();

		sampleConfig.getCgmGenerics().add(new Generic(Generic.GenericType.CGM, "CGM Spline", "splineCgm", "#FE9A2E", ""));
		sampleConfig.getCgmGenerics().add(new Generic(Generic.GenericType.CGM, "Just a Test", "justTest", "#AABBCC", ""));
		createIni(sampleConfig, "config.ini");
		
		PlotteriaConfig parsedConfig = parseIni("config.ini");

		createIni(parsedConfig, "config_copy.ini");
	}

}
