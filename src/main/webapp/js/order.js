var setting = {
		selector: 0,
		orderInfo:{},
		init : function(){
			this.ajaxLoadData();
			//var totalCount = 0;
			$(document).on("click", ".fa.fa-plus-circle", function(){
				var totalCount = 0;
				$(".pop.mov").each(function(){
					totalCount += Number($(this).find("e").html());
				});
				++totalCount;
	            //this.goods[index1].items[index2].num++;
				
				$(this).prev().addClass("mov");
				var count = $(this).prev().find("e").html();
				$(this).prev().find("e").html(Number(count) + 1);
				setting.addCart($(this).attr("data"), Number(count) + 1)
				
				$(".total").html(totalCount);
				
				setting.calculate();

	            // 小球动画 
	            var top = event.clientY, // 小球降落起点
	                left = event.clientX,
	                endTop = window.innerHeight - 30,  // 小球降落终点
	                endLeft = 20; 

	            // // 小球到达起点
	            var outer = $('#points .pointPre').first().removeClass("pointPre").css({
	                left: left + 'px',
	                top: top + 'px'
	            });
	            var inner = outer.find(".point-inner"); 
	 
	            setTimeout(function() { 
	                // 将jquery对象转换为DOM对象
	                outer[0].style.webkitTransform = 'translate3d(0,' + (endTop - top) + 'px,0)';
	                inner[0].style.webkitTransform = 'translate3d(' + (endLeft - left) + 'px,0,0)';
	                
	                // 小球运动完毕恢复到原点
	                setTimeout(function() {
	                    outer.removeAttr("style").addClass("pointPre");
	                    inner.removeAttr("style");
	                }, 1000);  //这里的延迟值和小球的运动时间相关
	            }, 1);
			}).on("click", ".fa.fa-minus-circle", function(){
				var totalCount = 0;
				$(".pop.mov").each(function(){
					totalCount += Number($(this).find("e").html());
				});
				--totalCount;
	            var count = $(this).next().html();
	            $(this).next().html(--count);
	            setting.addCart($(this).attr("data"), count)
	            if(count <= 0){
	            	$(this).parent().removeClass("mov");
	            }
	            $(".total").html(totalCount);
	            setting.calculate();
			}).on("click", ".right-click li", function(){
				var index = $(this).attr("index")
				this.selector = index;
				window.location.hash = $(this).html();
				$(this).addClass("click").siblings().removeClass("click");
				$(this).parents(".left").scrollTop = (index > 7 ? index-7 : 0)*54;
			}).on("click", ".pay", function(){
				var totalCount = 0;
				$(".pop.mov").each(function(){
					totalCount += Number($(this).find("e").html());
				});
				setting.addNewOrder(totalCount);
			});
		},
		calculate : function(){
			var totalCount = 0;
			$(".pop.mov").each(function(){
				totalCount += Number($(this).find("e").html());
			});
			if(totalCount > 0){
				$(".pay").removeClass("notPay");
			}else{
				$(".pay").addClass("notPay");
			}
		},
		URL : {
	        basePath : function() {
	            return "/";
	        },
	        ajaxLoad : function(){
	        	return setting.URL.basePath() + "order/ajaxLoadData";
	        },
	        addNewOrder : function(){
	        	return setting.URL.basePath() + "order/addNewOrder";
	        },
	        addCart : function(){
	        	return setting.URL.basePath() + "order/addCart";
	        }
	    },
		ajaxLoadData : function(){
			$.getMyJSON(setting.URL.ajaxLoad(), {}, function(data){
				console.info(data)
				var categories = $("#categories").render(data.data[1]);
				$("#order-category").append(categories);
				
				var products = $("#products").render(data.data[0]);
				$("#order-product").append(products);
				
				var carts = data.data[2];
				var count = 0;
				for (var i = 0; i < carts.length; i++) {
					$("#order-product li[data-index="+carts[i].pid+"] .pop").addClass("mov");
					$("#order-product li[data-index="+carts[i].pid+"] e").html(carts[i].quantity);
					count += carts[i].quantity;
				}
				$(".total").html(count);
				setting.calculate();
			});
		},
		addNewOrder : function(count){
			if(count == undefined || count <= 0){
				layer.alert("购物车是空的哦", {icon:"2"});
				return;
			}
			window.location.href='/order/toCart'
		},
		addCart : function(pid, count){
			$.getMyContentJSON(setting.URL.addCart(), JSON.stringify({"pid":pid,"count":count}), function(data){
				if(data.returncode == 0){
					//layer.msg("已加入购物车");
				}else{
					layer.alert("系统错误", {icon:"2"});
				}
			});
		}
}