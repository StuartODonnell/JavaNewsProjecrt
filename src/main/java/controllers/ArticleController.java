package controllers;

import db.DBHelper;
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

public class ArticleController {

    private void setupEndpoints() {

            get("/articles/:id/edit", (req, res) -> {
                String stringId = req.params(":id");
                Integer intId = Integer.parseInt(stringId);
                Article article = DBHelper.find(integerId, Article.class);
                List<Journalist> departments = DBHelper.getAll(Journalist.class);

                Map<String, Object> model = new HashMap<>();
//                String loggedInUser = LoginController.getLoggedInUserName(req, res);
//                model.put("user", loggedInUser);
                model.put("template", "templates/articles/edit.vtl");
                model.put("article", article);

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            get("/articles", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
//                String loggedInUser = LoginController.getLoggedInUserName(req, res);
//                model.put("user", loggedInUser);
                List<Article> articles = DBHelper.getAll(Article.class);
                model.put("template", "templates/articles/index.vtl");
                model.put("articles", articles);
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            get ("/articles/new", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
//                String loggedInUser = LoginController.getLoggedInUserName(req, res);
//                model.put("user", loggedInUser);
                List<Journalist> journalists = DBHelper.getAll(Journalist.class);
                model.put("journalists", journalists);
                model.put("template", "templates/articles/create.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());


            get("/articles/:id", (req, res) -> {
                String stringId = req.params(":id");
                Integer integerId = Integer.parseInt(stringId);
                Article article = DBHelper.find(integerId, Article.class);
                List<Article> articles = DBHelper.findArticlesForJournalist(article.getJournalist());

                Map<String, Object> model = new HashMap<>();
//                String loggedInUser = LoginController.getLoggedInUserName(req, res);
//                model.put("user", loggedInUser);
                model.put("article", article);
                model.put("template", "templates/articles/show.vtl");

                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

            post ("/articles", (req, res) -> {
                int journalistId = Integer.parseInt(req.queryParams("journalist"));
                Journalist journalist = DBHelper.find(journalistId, Journalist.class);
                String userName = req.queryParams("userName");
                Article article = new Article(heading, subHeading, bodyArticle, date, categorisation, approval);
                DBHelper.save(article);
                res.redirect("/articles");
                return null;
            }, new VelocityTemplateEngine());

            post ("/articles/:id/delete", (req, res) -> {
                int id = Integer.parseInt(req.params(":id"));
                Article articleToDelete = DBHelper.find(id, Article.class);
                DBHelper.delete(articleToDelete);
                res.redirect("/articles");
                return null;
            }, new VelocityTemplateEngine());

            post ("/articles/:id", (req, res) -> {
                String stringId = req.params(":id");
                Integer integerId = Integer.parseInt(stringId);
                Article article = DBHelper.find(integerId, Article.class);
                int journalistId = Integer.parseInt(req.queryParams("journalist"));
                Journalist journalist = DBHelper.find(journalistId, Journalist.class);
                String userName = req.queryParams("userName");

                journalist.setUsername(userName);
                DBHelper.save(userName);
                res.redirect("/articles");
                return null;

            }, new VelocityTemplateEngine());
        }

}
