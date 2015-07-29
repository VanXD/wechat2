 function sendJsonData(url, data, callback) {
     $.ajax({
         type: 'post',
         url: url,
         //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
         contentType: 'application/json;charset=utf-8',
         //数据格式是json串
         data: JSON.stringify(data),
         success: callback
     });
 }

 function getAccessToken() {
     $.ajax({
         type: "GET",
         url: "http://localhost:8080/wechat2/accesstoken",
         success: function (data) {

         }
     });
 }

 function getMaterialCount() {
     $.ajax({
         type: "GET",
         url: "getMaterialCount",
         success: function (materialCount) {
             $("#voice_count").html(materialCount.voice_count);
             $("#video_count").html(materialCount.video_count);
             $("#image_count").html(materialCount.image_count);
             $("#news_count").html(materialCount.news_count);
         }
     });
 }

 function batchGetMaterial() {
     var batchRequire = new Object();
     batchRequire.type = $("#type").val();
     batchRequire.offset = $("#offset").val();
     batchRequire.count = $("#count").val();
     sendJsonData("http://localhost:8080/wechat2/material/batchGetMaterial", batchRequire, function (data) {
         alert(data);
     })
 }