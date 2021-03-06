var settings = {
	currentPage : 1,
	
	init : function(){
		$("#ajaxPage").empty();
		this.ajaxLoad(0);
	},

    URL : {
        basePath : function() {
            return "/";
        },
        ajaxLoad : function(pageNo){
        	return settings.URL.basePath() + "backstage/product/ajaxLoadProduct/" + pageNo
        }
    },
    
    ajaxLoad : function(pageNo){
    	if (pageNo === '' || pageNo === undefined || pageNo === null || pageNo === 0) {
    		pageNo = 1;
    	}
    	var index = layer.load(2);
		
		
		var data = JSON.stringify({
				"name": $('#name').val(),
				"category": $('#category').find("option:selected").attr("value")
		});
		
		$.ajax({
	        type : "POST",
	        url : settings.URL.ajaxLoad(pageNo),
	        data : data,
	        dataType : "json",
	        contentType : "application/json; charset=utf-8",
	        success:function (data) {
	        	layer.close(index);
				var productInfo = $.templates('#productInfo');
				console.info(data.data[0].list)
				var product = productInfo.render(data.data[0].list);
				currentPage = data.data[0].currentPage;
				$("#productFill").html(product);
				$("#ajaxPage").html(data.data[1]);
			},
	 	    error: function (error) { 
	 	    	alert('网络连接失败'); 
	 	    }
	    });
    },
    
    ajaxSearch : function() {
    	settings.ajaxLoad(1);
    }

}