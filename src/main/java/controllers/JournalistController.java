package controllers;

import db.DBHelper;
import models.Article;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class JournalistController {

    public JournalistController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/journalists/:id/edit", (req, res) -> {
            String stringId = req.params(":id");
            Integer integerId = Integer.parseInt(stringId);
            Journalist journalist = DBHelper.find(integerId, Journalist.class);

            Map<String, Object> model = new HashMap<>();
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("journalist", journalist);
            model.put("template", "templates/journalists/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/journalists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("template", "templates/journalists/index.vtl");
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/journalists/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/journalists/:id", (req, res) -> {
            String stringId = req.params(":id");
            Integer integerId = Integer.parseInt(stringId);
            Journalist journalist = DBHelper.find(integerId, Journalist.class);
            List<Article> articles = DBHelper.findArticlesByJournalist(journalist);

            Map<String, Object> model = new HashMap<>();
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("journalist", journalist);
            model.put("articles", articles);
            model.put("template", "templates/journalists/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/journalists/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            String loggedInUser = LoginController.getLoggedInUserName(req, res);
//            model.put("user", loggedInUser);
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/djournalists", (req, res) -> {
            String title = req.queryParams("title");

            Journalist journalist = new Journalist(name);
            DBHelper.save(journalist);
            res.redirect("/departments");
            return null;
        }, new VelocityTemplateEngine());

        post ("/departments/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalistToDelete = DBHelper.find(id, Journalist.class);
            DBHelper.delete(journalistToDelete);
            res.redirect("/departments");
            return null;
        }, new VelocityTemplateEngine());

        post ("/journalists/:id", (req, res) -> {
            String stringId = req.params(":id");
            Integer integerId = Integer.parseInt(stringId);
            Journalist journalist = DBHelper.find(integerId, Journalist.class);
            String title = req.queryParams("username");
            journalist.setName(name);
            DBHelper.save(journalist);
            res.redirect("/journalists");
            return null;

        }, new VelocityTemplateEngine());

    }
}
