// 获取日期
var today = new Date();
// 获取当前年月日
var year = today.getFullYear();
var month = today.getMonth();
var data = today.getDate();


function doChange() {
    // 把$('date')中的option长度变为0
    $('dates').options.length = 0;
    var length = 31;
    // 获取月份
    var mon = $('months').value;
    // 如果是2月
    if (mon == 2) {
        // 平年就是28
        length = 28;
        // 获取年份
        var num = $('years').value;
        // 判断是不是闰年 闰年就是29
        if ((num % 4 == 0 && num % 100 != 0) || num % 400 == 0) {
            length++;
        }
    }
    // 定义正则判断月份 4 6 9 11 月
    var reg = / [469]|^11$/;
    // 符合条件就是30天
    if (reg.test(mon)) {
        length = 30;
    }
    // 然后循环 把值塞进去
    var tmp = new Option("日", "")
    $('dates').add(tmp);

    for (var k = 1; k <= length; k++) {
        var option = new Option(k, k);
        $('dates').add(option);
    }
}

// 封装获取id的简化函数
function $(id) {
    return document.getElementById(id);
}

window.onload = function() {
    var lastbut = document.getElementsByClassName("baritem")[0];
    var buts = document.getElementsByClassName("baritem");
    for (i = 0; i < buts.length; i++) {
        buts.item(i).onclick = function() {
            console.log(this);
            position = String(this.offsetLeft - 30) + "px " + String(this.offsetTop - 150) + "px";
            document.getElementsByClassName("leftbar")[0].style.backgroundPosition = position;
            console.log(this.getElementsByTagName("img"))
            lastbut.getElementsByTagName("img")[0].style.filter = "invert(50%)";
            lastbut.getElementsByTagName("button")[0].style.color = "#666666";
            this.getElementsByTagName("button")[0].style.color = "#ffffff";
            this.getElementsByTagName("img")[0].style.filter = "invert(0%)";
            lastbut = this;
        }
    }

    var lastline = document.getElementsByClassName("headitem2")[3].getElementsByTagName("button")[0]
    lastline.getElementsByTagName("div")[0].style.borderBottom = "2px solid #208bfe"
    lastline.style.color = "#6daefa"

    var lines = document.getElementsByClassName("headitem2")
    for (i = 0; i < lines.length; i++) {
        lines.item(i).getElementsByTagName("button")[0].onclick = function() {
            lastline.style.color = "#333333"
            lastline.getElementsByTagName("div")[0].style.borderBottom = "2px solid #f4f4f4"

            this.getElementsByTagName("div")[0].style.borderBottom = "2px solid #208bfe"
            this.style.color = "#6daefa"
            console.log(this)
            lastline = this
        }
    }
    // console.log(lastline);


    for (var i = year; i >= year - 40; i--) {
        var option = new Option(i, i);
        $('years').add(option);
        console.log($('years').value)
    }
    // 循环月份
    for (var j = 1; j <= 12; j++) {
        var option = new Option(j, j);
        $('months').add(option);
    }
    // 页面加载调用doChange事件
    doChange();
}