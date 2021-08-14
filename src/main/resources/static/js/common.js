
// HTML 태그제거
function escapeHTML(val)
{
    return val.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/\'/g,'&#039;').replace(/\"/g,'&quot;');
}
// HTML 태그
function unescapeHTML(val) {
    return val.replace(/&amp;/g,'&').replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&#039;/g,'\'').replace(/&quot;/g,'\"').replace(/\r/ig,"<br>").replace(/\n/ig, "<br>");
}