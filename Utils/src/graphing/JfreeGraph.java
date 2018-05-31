package graphing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JfreeGraph extends ApplicationFrame {

	/**
	 * A demonstration application showing an XY series containing a null value.
	 *
	 * @param title
	 *            the frame title.
	 * @throws IOException 
	 */
	XYSeries series = null;
	XYSeriesCollection seriesData = null;
	
	public JfreeGraph(final String title, int[] data) throws IOException {
		super(title);
		final XYSeries series = new XYSeries("Random Data");
		for(int i = 0; i < data.length; i++) {
			series.add(i,data[i]);
		}
		this.series = series;
		seriesData = new XYSeriesCollection(series);
		
	}
	
	public JfreeGraph(final String title, double[] data) throws IOException {
		super(title);
		final XYSeries series = new XYSeries("Random Data");
		for(int i = 0; i < data.length; i++) {
			series.add(i,data[i]);
		}
		this.series = series;
		seriesData = new XYSeriesCollection(series);
		
	}
	
	public JfreeGraph(final String title, double[] x, double[] y) throws IOException {
		super(title);
		final XYSeries series = new XYSeries("Random Data");
		for(int i = 0; i < x.length; i++) {
			series.add(x[i],y[i]);
		}
		
		this.series = series;
		seriesData = new XYSeriesCollection(series);
	}
	
	public void saveGraph(String filePath) throws IOException {
		JFreeChart chart = ChartFactory.createXYLineChart(this.getTitle(), "TimeStep", "Y", seriesData,
				PlotOrientation.VERTICAL, true, true, false);
		
		
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
		setContentPane(chartPanel);
		
		ChartUtilities.saveChartAsPNG(new File(filePath), chart, 400, 400);
	}
	
	public void saveGraphLog(String filePath) throws IOException {
		
		
		LogAxis xAxis = new LogAxis("X");
		xAxis.setBase(10);
		xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		xAxis.setRange(0, 10000);
		
		NumberAxis yAxis = new NumberAxis("Y");
	    yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	   
	    
	    XYPlot plot = new XYPlot(new XYSeriesCollection(series),
	        xAxis, yAxis, new XYLineAndShapeRenderer(true, false));
		
	    JFreeChart chart = new JFreeChart(
	            "Chart", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
		setContentPane(chartPanel);
		
		ChartUtilities.saveChartAsPNG(new File(filePath), chart, 400, 400);
	}
	
	
	

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is available *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *            ignored.
	 */

}