"use strict";

(function () {

    angular.module('bookApp').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("book", {
                url: "/book",
                templateUrl: "app/feature/book/book.html"
        })
    });
}());