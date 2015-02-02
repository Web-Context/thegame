package com.webcontext.apps.webmongo;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.webcontext.apps.webmongo.model.Game;
import com.webcontext.apps.webmongo.transformers.JsonTransformer;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		staticFileLocation("/dist/");
		get("/hello/:name",
				(request, response) -> {
					Map<String, Object> attributes = new HashMap<>();
					attributes.put("message", 
							String.format("Hello %s!", request.params("name")));
					return new ModelAndView(attributes, "hello.html");
				}, new FreeMarkerEngine());
		get("/rest/games", (req, res) -> {
			Gson gson = new GsonBuilder().setDateFormat("YYYY-mm-dd hh:MM:SS")
					.create();
			List<Game> list = null;
			BufferedReader br = new BufferedReader(new FileReader(App.class
					.getResource("/").getPath() + "dataset/games.json"));

			Type listType = new TypeToken<ArrayList<Game>>() {
			}.getType();
			list = gson.fromJson(br, listType);
			//res.header("Content-type", "application/json; charset=utf-8");
			return list;
		}, new JsonTransformer());
	}
}
