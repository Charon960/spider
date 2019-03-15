package com.charon.controller;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.charon.wrapper.ItemEntity;
import com.charon.wrapper.QueryEntity;
import com.charon.wrapper.ResultEntity;
import com.charon.wrapper.ScoreEntity;
import com.charon.wrapper.TotalResultEntity;

@Controller
public class IndexController {
	
	@Value("#{replace[query]}")
	private String queryStr;
	
	@Value("#{replace[replace]}")
	private String replaceStr;
	
	private QueryEntity r_query;
	private TotalResultEntity r_result;
	
	@ModelAttribute
	public void repalce () {
		if (r_query == null)
			r_query = JSON.parseObject(queryStr, QueryEntity.class);
		if (r_result == null)
			r_result = JSON.parseObject(replaceStr, TotalResultEntity.class);
	}

	@RequestMapping("/index.htm")
	public String index(QueryEntity query, ModelMap model) throws IOException{
		Map<String, String> map;
		
		
		if ((map = query.wrap()) != null) {
			TotalResultEntity totalResultEntity;
			if (query.equals(r_query)) {
				totalResultEntity = r_result;
			} else {
				Document doc = Jsoup.connect("http://www.jjdzc.com/peidui.php").data(map).userAgent("Mozilla").cookie("auth", "token").post();
				Elements person_info = doc.select("p.person_info");
				Elements info_table = doc.select("div.info_table");
				Elements hehun_result_dl = doc.select("dl.hehun_result_dl");
				
				// 男方解析
				Elements man_info = person_info.get(0).select("strong");
				Elements man_tableA = info_table.get(0). select("table.tableA");
				Elements man_tableB = info_table.get(0). select("table.tableB");
				ResultEntity man_resultEntity = new ResultEntity(
						man_info.get(0).html(),
						man_info.get(1).html(),
						man_info.get(2).html(),
						man_info.get(3).html(),
						man_info.get(4).html(),
						man_tableB.get(0).select("tfoot td").html(),
						new ItemEntity[]{
							new ItemEntity(man_tableA.get(0).select("tr:eq(0) td:eq(1)").html(),
										new String[]{man_tableA.get(0).select("tr:eq(0) td:eq(2)").html(),
															man_tableA.get(0).select("tr:eq(0) td:eq(3)").html(),
															man_tableA.get(0).select("tr:eq(0) td:eq(4)").html(),
															man_tableA.get(0).select("tr:eq(0) td:eq(5)").html()}),
							new ItemEntity(man_tableA.get(0).select("tr:eq(1) td:eq(0)").html(),
										new String[]{man_tableA.get(0).select("tr:eq(1) td:eq(1)").html(),
															man_tableA.get(0).select("tr:eq(1) td:eq(2)").html(),
															man_tableA.get(0).select("tr:eq(1) td:eq(3)").html(),
															man_tableA.get(0).select("tr:eq(1) td:eq(4)").html()}), 
							new ItemEntity(man_tableA.get(0).select("tr:eq(2) td:eq(0)").html(),
										new String[]{man_tableA.get(0).select("tr:eq(2) td:eq(1)").html(),
															man_tableA.get(0).select("tr:eq(2) td:eq(2)").html(),
															man_tableA.get(0).select("tr:eq(2) td:eq(3)").html(),
															man_tableA.get(0).select("tr:eq(2) td:eq(4)").html()}
											)},
						new ItemEntity(man_tableB.get(0).select("td:eq(0)").html(), 
								new String[]{
								man_tableB.get(0).select("td:eq(1)").html(),
								man_tableB.get(0).select("td:eq(2)").html(),
								man_tableB.get(0).select("td:eq(3)").html(),
								man_tableB.get(0).select("td:eq(4)").html(),
								man_tableB.get(0).select("td:eq(5)").html(),
								man_tableB.get(0).select("td:eq(6)").html(),
								man_tableB.get(0).select("td:eq(7)").html(),
								man_tableB.get(0).select("td:eq(8)").html()
							})
						);
				
				// 女方解析
				Elements woman_info = person_info.get(1).select("strong");
				Elements woman_tableA = info_table.get(1). select("table.tableA");
				Elements woman_tableB = info_table.get(1). select("table.tableB");
				ResultEntity women_resultEntity = new ResultEntity(
						woman_info.get(0).html(),
						woman_info.get(1).html(),
						woman_info.get(2).html(),
						woman_info.get(3).html(),
						woman_info.get(4).html(),
						woman_tableB.get(0).select("tfoot td").html(),
						new ItemEntity[]{
							new ItemEntity(woman_tableA.get(0).select("tr:eq(0) td:eq(1)").html(),
										new String[]{woman_tableA.get(0).select("tr:eq(0) td:eq(2)").html(),
															woman_tableA.get(0).select("tr:eq(0) td:eq(3)").html(),
															woman_tableA.get(0).select("tr:eq(0) td:eq(4)").html(),
															woman_tableA.get(0).select("tr:eq(0) td:eq(5)").html()}),
							new ItemEntity(woman_tableA.get(0).select("tr:eq(1) td:eq(0)").html(),
										new String[]{woman_tableA.get(0).select("tr:eq(1) td:eq(1)").html(),
															woman_tableA.get(0).select("tr:eq(1) td:eq(2)").html(),
															woman_tableA.get(0).select("tr:eq(1) td:eq(3)").html(),
															woman_tableA.get(0).select("tr:eq(1) td:eq(4)").html()}), 
							new ItemEntity(woman_tableA.get(0).select("tr:eq(2) td:eq(0)").html(),
										new String[]{woman_tableA.get(0).select("tr:eq(2) td:eq(1)").html(),
															woman_tableA.get(0).select("tr:eq(2) td:eq(2)").html(),
															woman_tableA.get(0).select("tr:eq(2) td:eq(3)").html(),
															woman_tableA.get(0).select("tr:eq(2) td:eq(4)").html()}
											)},
						new ItemEntity(woman_tableB.get(0).select("td:eq(0)").html(), 
								new String[]{
								woman_tableB.get(0).select("td:eq(1)").html(),
								woman_tableB.get(0).select("td:eq(2)").html(),
								woman_tableB.get(0).select("td:eq(3)").html(),
								woman_tableB.get(0).select("td:eq(4)").html(),
								woman_tableB.get(0).select("td:eq(5)").html(),
								woman_tableB.get(0).select("td:eq(6)").html(),
								woman_tableB.get(0).select("td:eq(7)").html(),
								woman_tableB.get(0).select("td:eq(8)").html()
							})
						);
				
				// 评分
				totalResultEntity = new TotalResultEntity(man_resultEntity, women_resultEntity, new ScoreEntity[]{
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(0)").html(),
								hehun_result_dl.get(0).select("dd p:eq(1)").html()),
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(2)").html(),
								hehun_result_dl.get(0).select("dd p:eq(3)").html()),
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(4)").html(),
								hehun_result_dl.get(0).select("dd p:eq(5)").html()),
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(6)").html(),
								hehun_result_dl.get(0).select("dd p:eq(7)").html()),
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(8)").html(),
								hehun_result_dl.get(0).select("dd p:eq(9)").html()),
						new ScoreEntity(hehun_result_dl.get(0).select("dd h5:eq(10)").html(),
								hehun_result_dl.get(0).select("dd p:eq(11)").html())
				}, hehun_result_dl.get(0).select("strong.cRed").html());
			}
			model.addAttribute("totalResultEntity", totalResultEntity);
			model.addAllAttributes(map);
		}
		return "index";
	}
}

