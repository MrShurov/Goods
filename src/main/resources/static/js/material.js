$(document).ready(function () {
    $('#Update').click(function () {
        updateMaterial();
    });
});
$(document).load(function () {
    let id = 0;
    $("tr").each(function () {
        $("tr").attr('id', 'nameID');
    })
});
