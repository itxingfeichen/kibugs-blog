Index = {

    /**
     * 加载更多
     * @param current
     */
    loadMore: function (type) {
        $("#loadMoreId").addClass("loader")
        $("#loadMoreId").text("加载中...");
        $("#loadMoreId").attr("disabled", true);
        var current = $("#current").val();
        var objectId = $("#objectId").val();
        $.get("/loadMore", {'current': current, 'type': type, 'objectId': objectId}, function (res) {
            $("#loadMoreId").removeClass("loader");
            if(!res.data){
                $("#loadMoreId").text("没有啦，要不您去写点儿吧...");
            }else{
                $("#data-content").append(res.data);
                $("#loadMoreId").attr("disabled", false);
                $("#current").val(Number(current)+1)
                $("#loadMoreId").text("加载更多");
            }

        })


    }


}