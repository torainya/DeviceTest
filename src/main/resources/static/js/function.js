function drag(obj) {
    var move = false;
    var obj = obj;
    obj.onmousedown = function (event) {

        if (obj.setCapture) {
            obj.setCapture();
        }
        event = event || window.event
        var ol = event.clientX - obj.offsetLeft;
        var ot = event.clientY - obj.offsetTop;
        document.onmousemove = function (event) {
            move = true;
            event = event || window.event
            var x = event.clientX - ol;
            var y = event.clientY - ot;
            obj.style.left = x + "px";
            obj.style.top = y + "px";
        }
        document.onmouseup = function () {
            if (move == false)
                if (obj.style.backgroundColor == "lime") {

                    $.ajax({
                        url: "switch",
                        type: "post",
                        data: {state: 0},
                        // data: JSON.stringify(data),
                        // contentType:"application/json",
                        success: function (data) {
                            obj.style.backgroundColor = "red";
                            $(obj).children(".value").hide();
                        },
                        error: function (e) {
                            alert("操作失败");
                        }
                    })
                } else {
                    $.ajax({
                        url: "switch",
                        type: "post",
                        data: {state: 1},
                        // data: JSON.stringify(data),
                        // contentType:"application/json",
                        success: function (data) {
                            obj.style.backgroundColor = "lime";
                            $(obj).children(".value").show();
                        },
                        error: function (e) {
                            alert("操作失败");
                        }
                    })


                }
            // 鼠标移除和释放按下操作时,取消以下事件
            document.onmousemove = null;
            document.onmouseup = null;
            move = false;
        }

        return false;
    }

}


function createRouter() {  // 添加新传感器 按钮的触发事件
    const id = $("#router_id").val();
    const name = $("#router_name").val();
    const network = $("#router_network").val();
    const data = {
        "id": id,
        "name": name,
        "network": network
    };
    $.ajax({
        url: "newRouter",
        type: "POST",
        data: data,
        //data: JSON.parse(data),
        //contentType:"application/json",
        success: function (data) {
            createDevice(name);
        },
        error: function (e) {
            alert("操作失败");
        }
    })
}


function createDevice(deviceName) {
    var obj = document.createElement("div");//创建一个标签
    obj.className = "box";
    var p = document.createElement("p");
    p.innerText = deviceName;
    obj.appendChild(p);
    var p = document.createElement("p");
    p.className = "value";
    obj.appendChild(p);

    setInterval(function () {
            $.ajax({
                url: "getValue",
                type: "post",
                data: {deviceName: deviceName},
                success: function (data) {
                    p.innerText = data;
                },
                error: function (e) {
                    p.innerText = "获取信息失败";
                }
            })
        }
        , 2000);

    setInterval(function () {
            $.ajax({
                url: "getState",
                type: "post",
                data: {deviceName: deviceName},
                success: function (state) {
                    if(state = -1){

                    }

                },
                error: function (e) {
                    p.innerText = "获取信息失败";
                }
            })
        }
        , 2000);

    var body = document.getElementById("body");
    body.appendChild(obj);
    drag(obj);
    return p;
}

$(document).ready(function () {
    $(".box").click(function () {
        $("p").hide();
    })
})


