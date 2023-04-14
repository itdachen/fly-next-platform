/**
 * 返回上一页
 */
function goBackPage() {
    window.history.go(-1);
}

/**
 * 返回首页
 */
function goToHomePage() {
    let uri = $('#uri').val();
    console.log(uri)
    if (null === uri || undefined === uri) {
        return false;
    }
    top.location.href = uri
}

function goToLoginPage() {
    top.location.href = $('#uri').val();
}