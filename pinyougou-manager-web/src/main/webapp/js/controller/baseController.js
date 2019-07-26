app.controller('baseController',function($scope){

    //分页控件配置加载
    // currentPage ：当前页码  totalItems：总记录数
    // itemsPerPage： 每页显示条数 perPageOptions：选择每页显示条数
    // onChange ：当选择每页显示条数改变是，需要做的工作
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();
        }
    };

    //刷新列表的方法
    $scope.reloadList = function(){
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage)
    };

    //复选框被勾选的集合
    $scope.selectIds = [];
    //判断当前是否勾选，添加或移出勾选框的操作
    $scope.updateSelection = function ($event,id) {
        //判断当前标签是否被选中，如果被选中，将当前标签的id push进selectIds 集合中
        // $event.target  当前标签的指向
        if ($event.target.checked){
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    }

    $scope.jsonParseToString = function (jsonString,key) {
        var jsonParseString = JSON.parse(jsonString);
        var str = "";
        for (i =0; i<jsonParseString.length;i++){
            str += jsonParseString[i][key]+", "
        }
        str =str.substring(0,str.length-2)


        return str;
    }

});