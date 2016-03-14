package com.ny.result;

import java.util.List;

public class ChartsDataSourceResult {
	private Chart chart;
	private List<CharData> data;
	
	public List<CharData> getData() {
		return data;
	}
	public void setData(List<CharData> data) {
		this.data = data;
	}
	public Chart getChart() {
		return chart;
	}
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	
	
	
}
