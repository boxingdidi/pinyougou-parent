app.controller('brandController',function($scope,$controller,brandService){


    //继承 baseController
    $controller('baseController',{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            });
    }

    // 品牌列表分页的方法
    // 由于search方法 废弃
    $scope.findPage = function (page,size) {
        brandService.findPage(page,size).success(
            function(response){
                $scope.list = response.rows; //获得列表数据
                $scope.paginationConf.totalItems = response.total; //获得当前列表总记录数
            });
    }

    //品牌新增 或品牌删除
    $scope.save = function(){

        var serviceObject = null;
        if ($scope.tbbrand.id != null){
            serviceObject = brandService.update($scope.tbbrand);
        }else {
            serviceObject = brandService.add($scope.tbbrand);
        }

        serviceObject.success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                }else {
                    alert(response.msg);
                }
            });
    }

    //根据brand的id查询品牌数据，进行前台回显
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.tbbrand = response;
            });
    }

    //删除商品的方法
    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                }else {
                    alert(response.msg);
                }
            });
    }

    //进行条件查询的方法
    // 在分页查询的需求上进行改动
    $scope.searchEntity={};

    $scope.search = function (page,rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list = response.rows; //获得列表数据
                $scope.paginationConf.totalItems = response.total; //获得当前列表总记录数
            });
    }

});