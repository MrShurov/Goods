$(document).ready(function () {
    $('#createUser').click(function () {
        createUser();
    });
    $('#addInformation').click(function () {
        addInformation();
    });
});
$(document).ready(function () {
    var user = {
        username: null,
        password: null,
        companyName: null,
        postCode: null,
        paymentAccount: null,
        bankRequisites: null,
        unp: null
    };
    $.ajax({
        data: user,
        dataType: "json",
        type: 'post',
        url: "/user/getUser"
    }).done(function (data) {
        newUser = checkUserForNull(data);
        $("tbody").append($("<tr><td>Имя пользователя</td>" + "<td>" + newUser.username + "</td></tr>"))
            .append($("<tr><td>Названия компании</td>" + "<td>" + newUser.companyName + "</td></tr>"))
            .append($("<tr><td>Почтовый индекс</td>" + "<td>" + newUser.postCode + "</td></tr>"))
            .append($("<tr><td>Расчетный счет</td>" + "<td>" + newUser.paymentAccount + "</td></tr>"))
            .append($("<tr><td>Реквизиты банка</td>" + "<td>" + newUser.bankRequisites + "</td></tr>"))
            .append($("<tr><td>УНП</td>" + "<td>" + newUser.unp + "</td></tr>"))
            .append($("<tr><td>Номер телефона</td>" + "<td>" + newUser.tel + "</td></tr>"))
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
            window.location.replace("/createUser")
        }).fail(function (data) {
            alert("fail")
        })
    }
}

function addInformation() {
    var companyName = $("#companyName").val();
    var postCode = $("#postCode").val();
    var paymentAccount = $("#paymentAccount").val();
    var bankRequisites = $("#bankRequisites").val();
    var unp = $("#unp").val();
    var tel = $("#tel").val();
    if (companyName && postCode && paymentAccount && bankRequisites && unp && tel) {
        var user = {
            companyName: companyName,
            postCode: postCode,
            paymentAccount: paymentAccount,
            bankRequisites: bankRequisites,
            unp: unp,
            tel: tel
        };
        $.ajax({
            data: user,
            dataType: "json",
            type: 'put',
            url: "/user/addInformation"
        }).always()(function (data) {
            window.location.replace("/information")
        })
    }
}

function checkUserForNull(User) {
    var field;
    for (var key in User) {
        if (User[key] === null) {
            User[key] = "Не заполнено"
        }
    }
    return User;
}
