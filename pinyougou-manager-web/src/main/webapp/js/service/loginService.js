app.service('loginService',function ($http) {

    this.getLoginName = function () {
        return $http.post('../login/getLoginUserName.do')
    }

})