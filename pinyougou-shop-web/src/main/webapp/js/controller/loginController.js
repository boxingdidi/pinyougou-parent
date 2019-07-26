
    $scope.getShopLoginName = function () {
        loginService.getShopLoginName().success(
            function (response) {
                $scope.loginName=response.shopLoginName;
        });
    }

});