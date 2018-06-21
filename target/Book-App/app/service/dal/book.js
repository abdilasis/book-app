"use strict";

(function () {

    function BookDal (dal) {

        this.getBooks = function () {
            return dal.http.GET("rest/book/json");
        };

        this.saveBook = function (bookToSave) {
            return dal.http.POST("rest/book/json", bookToSave);
        };

        this.updateBook = function (bookToUpdate) {
            return dal.http.PUT("rest/book/json/", bookToUpdate);
        };

        this.deleteBook = function (bookToDelete) {
            return dal.http.DELETE("rest/book/json/", bookToDelete);
        };
    }
    
    angular.module("bookApp").service("bookDal", ["dal", BookDal]);
}());