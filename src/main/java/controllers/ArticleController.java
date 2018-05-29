package controllers;

import db.DBHelper;
import db.DBJournalist;
import models.Approval;
import models.Article;
import models.Categorisation;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class ArticleController {

    private Journalist journalist1 = new Journalist("name1", "username1");
    private Journalist journalist2 = new Journalist("name2", "username2");
    private Journalist journalist3 = new Journalist("name3", "username3");
    GregorianCalendar gregorianCalendar = new GregorianCalendar();

    public ArticleController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {



//            get("/articles/:categorisation/:id/edit", (req, res) -> {
//                String stringId = req.params(":categorisation");
//                Integer integerId = Integer.parseInt(stringId);
//                Article article = DBHelper.find(Article.class, integerId);
//                List<Journalist> journalists = DBHelper.getAll(Journalist.class);
//
//                Map<String, Object> model = new HashMap<>();
////                String loggedInUser = LoginController.getLoggedInUserName(req, res);
////                model.put("user", loggedInUser);
//                model.put("template", "templates/articles/edit.vtl");
//                model.put("article", article);
//
//                return new ModelAndView(model, "templates/layout.vtl");
//            }, new VelocityTemplateEngine());

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
//                List<Journalist> journalists = DBJournalist.returnListOfActiveJournalists();
//                TODO list of journalists
                List<Journalist> journalists = new ArrayList<>();
                journalists.add(journalist1);
                journalists.add(journalist2);
                journalists.add(journalist3);
                List<Categorisation> categories = new ArrayList<>( Arrays.asList(Categorisation.values()));
                model.put("journalists", journalists);
                model.put("categories", categories);
                model.put("template", "templates/articles/create.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());
//
//
//            get("/articles/:id", (req, res) -> {
//                String stringId = req.params(":id");
//                Integer integerId = Integer.parseInt(stringId);
//                Article article = DBHelper.find(Article.class, integerId);
//                List<Journalist> journalists = DBHelper.findJournalistsByArticle(article);
//
//                Map<String, Object> model = new HashMap<>();
////                String loggedInUser = LoginController.getLoggedInUserName(req, res);
////                model.put("user", loggedInUser);
//                model.put("article", article);
//                model.put("template", "templates/articles/show.vtl");


//            get ("/articles/new", (req, res) -> {
//                Map<String, Object> model = new HashMap<>();
////                String loggedInUser = LoginController.getLoggedInUserName(req, res);
////                model.put("user", loggedInUser);
//                List<Journalist> journalists = DBHelper.getAll(Journalist.class);
//                model.put("journalists", journalists);
//                model.put("template", "templates/articles/create.vtl");
//                return new ModelAndView(model, "templates/layout.vtl");
//            }, new VelocityTemplateEngine());
//
//
//            get("/articles/:id", (req, res) -> {
//                String stringId = req.params(":id");
//                Integer integerId = Integer.parseInt(stringId);
//                Article article = DBHelper.find(Article.class, integerId);
//                List<Journalist> journalists = DBHelper.findJournalistsByArticle(article);
//
//                Map<String, Object> model = new HashMap<>();
////                String loggedInUser = LoginController.getLoggedInUserName(req, res);
////                model.put("user", loggedInUser);
//                model.put("article", article);
//                model.put("template", "templates/articles/show.vtl");
//
//                return new ModelAndView(model, "templates/layout.vtl");
//            }, new VelocityTemplateEngine());
//
            post ("/articles", (req, res) -> {
//                int journalistId = Integer.parseInt(req.queryParams("journalist"));
//                Journalist journalist = DBHelper.find(Journalist.class,journalistId);
                String heading = req.queryParams("heading");
                String subheading = req.queryParams("subheader");
                String article_body = req.queryParams("article_body");
//                String date = req.queryParams("date");
//                String pattern = "dd-MM-yyyy";
                String category = req.queryParams("categorisation");
                Categorisation cat = Categorisation.valueOf(category);
                String journalist = req.queryParams("journalist");
                Journalist foundJournalist = DBJournalist.findJournalistByName(journalist);
                Article article = new Article(heading, subheading, article_body, new GregorianCalendar(), cat, foundJournalist);
                DBHelper.save(article);
                res.redirect("/articles");
                return null;
            }, new VelocityTemplateEngine());
//
//            post ("/articles/:id/delete", (req, res) -> {
//                int id = Integer.parseInt(req.params(":id"));
//                Article articleToDelete = DBHelper.find(Article.class, id);
//                DBHelper.delete(articleToDelete);
//                res.redirect("/articles");
//                return null;
//            }, new VelocityTemplateEngine());
//
//            post ("/articles/:id", (req, res) -> {
//                String stringId = req.params(":id");
//                Integer integerId = Integer.parseInt(stringId);
//                Article article = DBHelper.find(Article.class, integerId);
//                int journalistId = Integer.parseInt(req.queryParams("journalist"));
//                Journalist journalist = DBHelper.find(Journalist.class, journalistId);
//                String userName = req.queryParams("userName");
//
//                journalist.setUsername(userName);
//                DBHelper.save(userName);
//                res.redirect("/articles");
//                return null;
//
//            }, new VelocityTemplateEngine());
        }

}


