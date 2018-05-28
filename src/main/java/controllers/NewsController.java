package controllers;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;


import models.Approval;
import models.Article;
import models.Categorisation;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class NewsController {

    public NewsController() {
        this.setupEndpoints();
    }

        private void setupEndpoints() {

            get("/news", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                List<Article> articles = DBArticle.returnArticlesinDescOrder();
                model.put("template", "templates/news/index.vtl");
                model.put("articles", articles);
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            get("/news/:id", (req, res) -> {
                Integer integerId = Integer.parseInt(req.params("id"));
                Article article = DBHelper.find(Article.class, integerId);
                Map<String, Object> model = new HashMap<>();
                model.put("article", article);
                model.put("template", "templates/news/show.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
                }, new VelocityTemplateEngine());
            }
}

