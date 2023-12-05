// 获取日期
var today = new Date();
// 获取当前年月日
var year = today.getFullYear();
var month = today.getMonth();
var data = today.getDate();

function exit(){
    window.location.href = "exit"
}

function changeframe(){
    // 使用 querySelectorAll 选择所有类名为 "highlight" 的元素
    var elements = document.querySelectorAll('.main_left');
    var frame = document.getElementById("mainframe")
    console.log(frame)
    // 遍历元素列表并对每个元素进行操作
    elements.forEach(function(element) {
        element.addEventListener('click', function() {
            frame.setAttribute("src",this.getAttribute("data-src"))
            // console.log(frame)
            })
    })
    var content = document.getElementById("content")
    frame.style.height = (content.clientHeight-80)+"px";
}
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

    changeframe();
}