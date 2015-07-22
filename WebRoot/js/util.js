 function sendJsonData(url, data) {
     $.ajax({
         type: 'post',
         url: url,
         //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
         contentType: 'application/json;charset=utf-8',
         //数据格式是json串
         data: JSON.stringify(data),
         success: function (data) { //返回json结果
             
         }
     });
 }

function getAccessToken(){
    $.ajax({
        type    : "GET",
        url     : "http://localhost:8080/wechat2/accesstoken",
        success : function(data){
            
        }
    });
}

function getMaterialCount(){
    $.ajax({
        type    : "GET",
        url     : "getMaterialCount",
        success : function(materialCount){
            $("#news_count").val(materialCount.news_count);
        }
    });
}