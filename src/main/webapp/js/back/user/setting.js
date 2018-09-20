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
        	return settings.URL.basePath() + "backstage/user/ajaxLoadUser/" + pageNo
        }
    },
    
    ajaxLoad : function(pageNo){
    	if (pageNo === '' || pageNo === undefined || pageNo === null || pageNo === 0) {
    		pageNo = 1;
    	}
    	var index = layer.load(2);
		var data = {};
		var data = JSON.stringify({
				"phone": $('#phone').val(),
				"registTime": $('#registTime').val()
		});
		
		$.ajax({
	        type : "POST",
	        url : settings.URL.ajaxLoad(pageNo),
	        data : data,
	        dataType : "json",
	        contentType : "application/json; charset=utf-8",
	        success:function (data) {
	        	layer.close(index);
				var productInfo = $.templates('#orderInfo');
				console.info(data.data[0].list)
				var product = productInfo.render(data.data[0].list);
				currentPage = data.data[0].currentPage;
				$("#orderFill").html(product);
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