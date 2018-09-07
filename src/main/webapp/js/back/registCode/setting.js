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
        	return settings.URL.basePath() + "backstage/registCode/ajaxLoadRegistCode/" + pageNo
        }
    },
    
    ajaxLoad : function(pageNo){
    	if (pageNo === '' || pageNo === undefined || pageNo === null || pageNo === 0) {
    		pageNo = 1;
    	}
    	var index = layer.load(2);
		var data = {};
		$.getMyJSON(settings.URL.ajaxLoad(pageNo), data, function(data){
			layer.close(index);
			var productInfo = $.templates('#registCodeInfo');
			console.info(data.data[0].list)
			var product = productInfo.render(data.data[0].list);
			currentPage = data.data[0].currentPage;
			$("#registCodeFill").html(product);
			$("#ajaxPage").html(data.data[1]);
			//$("#ajaxUrl").val(settings.URL.laboratorySetList);
		});
    },
    
    ajaxSearch : function() {
    	settings.ajaxLoad(1);
    }

}