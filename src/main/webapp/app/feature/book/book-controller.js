"use strict";

(function() {

    var BookController =  function(bookService, $log, $scope) {

    	var vm = this;

      vm.isHidden = false;

    vm.hideTable = function()
    {
      vm.isHidden = !vm.isHidden
    };

        vm.delete = function(bookToDelete) {
            bookService.deleteBook(bookToDelete);
            bookService.getBooks().then(function (results) {
            vm.books = results;});
        };

        vm.add = function(){
          var result = {"bookTitle":vm.formData.bookTitle,
                         "genre":vm.formData.genre,
                         "publishYear":vm.formData.year  };
             bookService.saveBook(result);
             bookService.getBooks().then(function (results) {
             vm.books = results;});

        }

        function init() {
        	bookService.getBooks().then(function (results) {
           	vm.books = results;
           	$log.log("In the book controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.books));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }

       init();

    };

    angular.module('bookApp').controller('bookController', ['bookService','$log', BookController]);
}());
