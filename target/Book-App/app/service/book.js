"use strict";

(function () {

    
    function BookService (bookDal) {

        this.getBooks = function()
        {
        	return bookDal.getBooks();
        };
        
        this.deleteBook = function(bookToDelete)
        {
        	return bookDal.deleteBook(bookToDelete);
        };

    }
    
    angular.module("bookApp").service("bookService", ['bookDal', BookService]);

}());