app.service('loginService',function ($http) {

    //获取登陆当前登陆人
    this.getShopLoginName = function () {
        return $http.post('../shopLogin/getShopLoginName.do')
    }
});