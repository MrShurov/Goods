$(document).ready(function () {
    $('#createUser').click(function () {
        createUser();
    });
});

function createUser() {
    var username = $("#username").val();
    var password = $("#password").val();
    if (username && password) {
        var user = {
            username: username,
            password: password
        };
        $.ajax({
            data: user,
            dataType: "json",
            type: 'post',
            url: "/user/createUser"
        }).done(function (data) {
            alert("succses");
        }).fail(function (data) {
            alert("fail")
        })
    }
}