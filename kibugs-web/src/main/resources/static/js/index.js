Index = {

    /**
     * 加载更多
     * @param current
     */
    loadMore: function (current, type) {
        $("#loadMoreId").addClass("loader")
        $("#loadMoreId").text("加载中...");
        $("#loadMoreId").attr("disabled",true);
        $.get("/loadMore", {'current': current + 1, 'type': type}, function (res) {
            $("#data-content").append(res.data);
            $("#loadMoreId").removeClass("loader")
            $("#loadMoreId").attr("disabled",false);
            $("#loadMoreId").text("加载更多");
        })

    }


}