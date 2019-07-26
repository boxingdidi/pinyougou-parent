 //控制层 
app.controller('itemCatController' ,function($scope,$controller  ,typeTemplateService ,itemCatService){
	
	$controller('baseController',{$scope:$scope});//继承


    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				response.text=response.typeId+"";
				response.typeId = {"text":response.text};
				$scope.entity= response;
			}
		);				
	}

	//保存 
	$scope.save=function(){
		$scope.selectTypeIdList();
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			//{"id":1211,"name":"enen","parentId":1210,"typeId":{"text":"37"},"text":"37"}
			delete $scope.entity.text;
			$scope.entity.typeId=$scope.entity.typeId.text;
			serviceObject=itemCatService.update( $scope.entity ); //修改  
		}else{

			$scope.entity.parentId=$scope.parentId;//赋予上级ID
			$scope.entity.typeId=$scope.entity.typeId.text;
			serviceObject=itemCatService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
					$scope.findByParentId($scope.parentId);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		itemCatService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){

					$scope.findByParentId($scope.parentId);//重新加载
					$scope.selectIds=[];
				}else{
					$scope.selectIds=[];
					alert(response.msg);

				}
			}		
		);				
	}


	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		itemCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}


	$scope.parentId=0;//上级ID
	//根据上层id查询下级列表
	$scope.findByParentId = function (parentId) {
		//记住上级ID
		$scope.parentId=parentId;

		itemCatService.findByParentId(parentId).success(
			function (response) {
				$scope.list = response;
		});
	}


	//定义当前级别
	$scope.grade=1;
	$scope.changeGrade=function (value) {
		$scope.grade = value;
	}

	//判断面包屑在第几层，并加载数据
	$scope.selectList=function (p_entity) {

		//第一层 显示当前所以分类
		if ($scope.grade == 1){
			$scope.entity_1 = null;
			$scope.entity_2 = null;
		}
		//第二层 显示当前节点的上层树
		if ($scope.grade == 2){
			$scope.entity_1 = p_entity;
			$scope.entity_2 = null;
		}

		//第三层 显示第三层节点的上层树
		if ($scope.grade == 3){
			$scope.entity_2 = p_entity;
		}

		$scope.findByParentId(p_entity.id);
	}



	$scope.typeIdList={data:[]};//商品模版类型集合
	$scope.selectTypeIdList=function () {

		typeTemplateService.selectTypeIdList().success(
			function (response) {
				for (var i=0;i<response.length; i++ ){
					response[i].text = response[i].text+"";
				}
				$scope.typeIdList={data:response};
		});
	}


});
