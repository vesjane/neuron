function createXMLHttp(){
if	(typeof XMLHttpRequest != "undefined") { // для браузеров аля Mozilla
   return new XMLHttpRequest();
} else if (window.ActiveXObject) { // для Internet Explorer (all versions)
var aVersions = [
   "MSXML2.XMLHttp.5.0",
   "MSXML2.XMLHttp.4.0",
   "MSXML2.XMLHttp.3.0",
   "MSXML2.XMLHttp",
   "Microsoft.XMLHttp"
   ];
for (var i = 0; i < aVersions.length; i++) {
try {
   var oXmlHttp = new ActiveXObject(aVersions[i]);
   return oXmlHttp;
   } catch (oError) {}
} throw new Error("Невозможно создать объект XMLHttp.");
}}

// фукнция Автоматической упаковки формы любой сложности
function getRequestBody(oForm) {
var aParams = new Array();
for(var i = 0; i < oForm.elements.length; i++) {
   var sParam = encodeURIComponent(oForm.elements[i].name);
   sParam += "=";
   sParam += encodeURIComponent(oForm.elements[i].value);
   aParams.push(sParam);
}
return aParams.join("&");
}
function postAjax(url,oForm,callback) {

        var oXmlHttp = createXMLHttp();

        var sBody = getRequestBody(oForm);

        oXmlHttp.open("POST",url,true);
        oXmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        oXmlHttp.onreadystatechange = function() {
        if(oXmlHttp.readyState == 4) {
        if(oXmlHttp.status == 200) {
        callback(oXmlHttp.responseText);
        } else {
        callback('error'+oXmlHttp.statusText);
        }
        }
        };
       // oXmlHttp.send(sBody);
        }