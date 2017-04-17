/**
 * Created by xirui on 2017/4/12.
 */

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http){

    $scope.tableState = true;
    $scope.tipState = true;
    $scope.pagingState = true;

    $scope.sport = function () {
        $http({method:"GET", url:"http://q95265.xicp.net/qpp/result/sport"}).
        then(function (response) {
            $scope.tableState = false;
            $scope.tipState = false;
            $scope.results = response.data.data;
        }, function (response) {
            $scope.tableState = true;
            $scope.tipState = true;
            $scope.pagingState = true;
            alert("定时任务执行中!,请稍后重试");
        });
        $scope.results.$destroy();
    }

    $scope.money = function () {
        $http({method:"GET", url:"http://q95265.xicp.net/qpp/result/money"}).
        then(function (response) {
            $scope.tableState = false;
            $scope.tipState = false;
            $scope.results = response.data.data;
        }, function (response) {
            $scope.tableState = true;
            $scope.tipState = true;
            $scope.pagingState = true;
            alert("定时任务执行中!,请稍后重试");
        });
        $scope.results.$destroy();
    }

    $scope.domestic = function () {
        $http({method:"GET", url:"http://q95265.xicp.net/qpp/result/domestic"}).
        then(function (response) {
            $scope.tableState = false;
            $scope.tipState = false;
            $scope.results = response.data.data;
        }, function (response) {
            $scope.tableState = true;
            $scope.tipState = true;
            $scope.pagingState = true;
            alert("定时任务执行中!,请稍后重试");
        });
        $scope.results.$destroy();
    }

    $scope.ent = function () {
        $http({method:"GET", url:"http://q95265.xicp.net/qpp/result/ent"}).
        then(function (response) {
            $scope.tableState = false;
            $scope.tipState = false;
            $scope.results = response.data.data;
        }, function (response) {
            $scope.tableState = true;
            $scope.tipState = true;
            $scope.pagingState = true;
            alert("定时任务执行中!,请稍后重试");
        });
        $scope.results.$destroy();
    }


});


//轮播控制
$(document).ready(function(){
    $('#carousel-528374').carousel({interval:2000});//每隔2秒自动轮播
});
