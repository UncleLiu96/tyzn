var ws = null;
if ('WebSocket' in window) {
    // alert("你的浏览器支持 WebSocket");
    ws = new WebSocket("ws://192.168.1.77:80/ws");
} else {
    alert('你的浏览器不支持webSocket');
}
//建立成功建立的回调方法
ws.onopen = function (event) {
    appendMessage(event.data);
}
//接收到消息的回调方法
ws.onmessage = function (event) {
    appendMessage(event.data);
}
//连接关闭的回调方法
ws.onclose = function () {
    //获取所有状态
    var networkState =$("[name='networkState']");
    //标记离线
    $.each(networkState,function(i,val){
        $(this).text("离线");
        $(this).attr("style", "color:#FD482C");
    });
}
//连接发送错误的回调方法
ws.onerror = function () {
}

//监听窗口关闭事件，当窗口关闭时，主动关闭webSocket连接
//防止连接还没断开就关闭窗口，server端会抛异常
ws.onbeforeunload = function () {
    ws.onclose();
}

//将消息显示在网页上
function appendMessage(message) {
    localStorage.msg = message;//存储本地，用于刷新赋值
    if (message.indexOf("[") != -1) {//判断是否存在编号
        var strings = message.replace("[", "").replace("]", "").split(",");
        for (var i = 0; i < strings.length; i++) {
            var s = strings[i].trim();
            var id = "#" + s;
            $(id).text("在线");
            $(id).attr("style", "color:#00FF00");
        }
    }


}

//关闭连接
function closeWebSocket() {
    ws.close();
}

//发送消息
function sendMessage() {
    var message = $("#message").val();
    ws.send(message);
}
//刷新
window.onbeforeunload = function confirmExit() { // 此地可以写你的业务代码
    closeWebSocket();//关闭websocket
}
