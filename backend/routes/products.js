var express = require('express');
var router = express.Router();
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;

var Product = require('../models/product');
var Categoria = require('../models/categorias');

//CRUD
router.get("/new", function (req, res) {
	Categoria.find({}, function (err, categorias) {
		if (err) { res.redirect("/"); return; }
		res.send(categorias)
	});
});

//enable cors
router.use(function (req, res, next) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	next();
});

// 
router.route("/")
	//Show register
	.get(function (req, res) {
		Product.find({}, function (err, products) {
			if (err) { res.redirect("/"); return; }
			res.send(products)
		});
	})
	//Create register
	.post(function (req, res) {
		var newProduct = new Product({
			title: req.body.title,
			category_id: req.body.category_id
		});
		Product.createProduct(newProduct, function (err, product) {
			if (err) throw err;
			console.log(product);
			console.log("Guardamos el producto exitosamente")
			res.json({ message: 'Product save' });
		});
	})

router.route("/:id")
	.put(function (req, res) {
		Product.findById(req.params.id, function (err, product) {
			if (err) res.send(err);
			if (req.body.title) product.title = req.body.title;
			if (req.body.category_id) product.category_id = req.body.category_id;
			product.save(function (err) {
				if (err) send(err);
				res.json({ message: 'Product updated' });
			});
		});
	})
	//Delete register
	.delete(function (req, res) {
		Product.findOneAndRemove({ _id: req.params.id }, function (err) {
			if (!err) {
				console.log("Producto eliminado");
				res.redirect("/");
			}
			else {
				console.log(err);
				res.redirect("/" + req.params.id);
			}
		});
	});

module.exports = router;