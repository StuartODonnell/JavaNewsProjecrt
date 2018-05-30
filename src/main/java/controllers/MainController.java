package controllers;

import db.DBArticle;
import db.DBHelper;
import db.Seeds;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();

        //TODO CREATE STATIC FILE LOCATION
        staticFileLocation("/public");

        JournalistController journalistController = new JournalistController();
        ArticleController articleController = new ArticleController();
        NewsController newsController = new NewsController();

        //TODO MAIN METHOD FOR GET - USERNAME AND PASSWORD

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

//            String loggedInUser = LoginController.getLoggedInUsername(req, res);
//            model.put("user", loggedInUser);

            model.put("template","templates/main.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/search", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            List<Article> results = DBArticle.searchArticlesByHeading("search");
            model.put("results", results);
            model.put("templates", "templates/news/search.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/search", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            String search = req.queryParams("search");
            List<Article> foundArticles = DBArticle.searchArticlesByHeading(search);
            model.put("foundArticles", foundArticles);
            model.put("template", "templates/news/search.vtl" );
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }


}
