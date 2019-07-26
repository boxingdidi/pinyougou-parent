app.service('uploadImageService',function($http){

    //上传文件
    this.uploadImageFile=function(){
        var formdata=new FormData();
        formdata.append('file',file.files[0]);//file 文件上传框的name

        return $http({
            url:'../uploadImageFastDFS.do',
            method:'post',
            data:formdata,
            headers:{ 'Content-Type':undefined },
            transformRequest: angular.identity
        });

    }


});