'use strict';

$(function() {
	$("input[type='password'][data-eye]").each(function(i) {
		var $this = $(this),
			id = 'eye-password-' + i,
			el = $('#' + id);

		$this.wrap($("<div/>", {
			style: 'position:relative',
			id: id
		}));

		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-'+i,
		}).css({
				position: 'absolute',
				right: 10,
				top: ($this.outerHeight() / 2) - 12,
				padding: '2px 7px',
				fontSize: 12,
				cursor: 'pointer',
		}));

		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));

		var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

		if(invalid_feedback.length) {
			$this.after(invalid_feedback.clone());
		}

		$this.on("keyup paste", function() {
			$("#passeye-"+i).val($(this).val());
		});
		$("#passeye-toggle-"+i).on("click", function() {
			if($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			}else{
				$this.attr('type', 'text');
				$this.val($("#passeye-"+i).val());				
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});

	$(".my-login-validation").submit(function() {
		var form = $(this);
        if (form[0].checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.addClass('was-validated');
	});


	document.getElementById("loginForm").addEventListener("submit", function(event) {
		event.preventDefault(); // 阻止表单默认提交行为
		if(document.getElementById("email").value ===""){
			document.getElementsByClassName("invalid-feedback")[0].textContent="请输入用户名"
			return
		}else if(document.getElementById("password").value===""){
			document.getElementsByClassName("invalid-feedback")[0].textContent="请输入密码"
			return;
		}
		fetch("/user/login", {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify({
				username: document.getElementById("email").value, // 确保提供了 'name' 参数
				password: document.getElementById("password").value
			})
		})
			.then(response => {
				if (!response.ok) {
					document.getElementById("email").value =""
					document.getElementById("password").value =""
					document.getElementsByClassName("invalid-feedback")[0].textContent="用户名密码错误"
					throw new Error("Network response was not ok.");
				}else{
					window.location.href = "/index"
				}
				return response;
			})
			.catch(error => {
				// 处理错误
				console.error("There was a problem with the fetch operation:", error);
			});
	});
});
