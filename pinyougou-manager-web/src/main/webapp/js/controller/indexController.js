app.controller("indexcontroller",function ($scope,loginService) {

    //获取当前登陆人的名称
    $scope.getLoginName=function () {
        loginService.getLoginName().success(
            function (response) {
                $scope.loginName=response.loginName;
        });
    }

});