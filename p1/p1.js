//USERNAME
var clogin = null;
function username() {

     clogin = document.getElementById("clogin").value;
     var chars = /[a-z0-9]{4,8}/;
     var space = /[ ]/;

     if (((chars.test(clogin) == 1) && (space.test(clogin) == 0) && (clogin.length <= 8)) || (clogin == "")) {
          document.getElementById("store_clogin").innerHTML = "Username Registered!!";
          return true;

     } else {
          document.getElementById("store_clogin").innerHTML = "Username's length must be between 4 and 8 characters without upper case and only using ASCII characters.";
          return false;
     }
}

//PASSWORD


function checkPassword() {
     cpassword = document.getElementById("cpasswd").value;
     var num = /[0-9]/;
     var low_char = /[a-z]/;
     var upp_char = /[A-Z]/;
     var special_char = /[*+/-]/;

     if (((6 <= cpassword.length <= 12) && (num.test(cpassword) == 1) && (low_char.test(cpassword) == 1) && (upp_char.test(cpassword) == 1) && (special_char.test(cpassword) == 1)) || (cpassword == "")) {

          document.getElementById("store_cpassword").innerHTML = "Password Registered!!";
          return true;

     } else {
          document.getElementById("store_cpassword").innerHTML = "Incorrect password's format!";
          return false;
          //document.getElementById("store_cpassword").innerHTML="MAS LARGO";
     }
}

//DNI
function checkDNI() {
     cdni = document.getElementById("cdni").value;
     numbers = cdni.substring(0, cdni.length - 1);
     letter = cdni.slice(-1);
     var num = /^[0-7]+$/;
     var letters = /[A-Za-z]/;
     if (((num.test(numbers) == 1) && (letters.test(letter) == 1) && (cdni.length == 9)) || (clogin == "")) {

          document.getElementById("dni_validation").innerHTML = "DNI VALIDATED!"
          return true;
     }
     else {
          document.getElementById("dni_validation").innerHTML = "NOT VALID DNI"
          return false;
     }
}

//CHECK ALL
function checkAll() {

     var e = document.getElementById("check_all");

     if (e.checked == true) {
          var checkboxes = document.getElementsByName("cgenre[]");
          for (var i = 0; i < checkboxes.length; i++) {
               checkboxes[i].checked = true;
          }

     }
}

//DISCARD ALL
function discardAll() {

     var e = document.getElementById("discard_all");
     if (e.checked) {
          var checkboxes = document.getElementsByName("cgenre[]");
          var checkboxes = document.getElementsByName("select_all");
          for (var i = 0; i < select_all.length; i++) {
               select_all[i].checked = false;
          }
          for (var i = 0; i < checkboxes.length; i++) {
               checkboxes[i].checked = false;
          }

     }
}

//GET DATE
function getDate() {
     var currentdate = new Date();
     var datetime = "Current date is: " + currentdate.getDate() + "/"
          + (currentdate.getMonth() + 1) + "/"
          + currentdate.getFullYear() + " @ "
          + currentdate.getHours() + ":"
          + currentdate.getMinutes() + ":"
          + currentdate.getSeconds();

     document.getElementById("cdate").value = datetime;

}

//GET BROWSER
function getBrowser() {

     let userAgent = navigator.userAgent;
     let browserName;

     if (userAgent.match(/chrome|chromium|crios/i)) {
          browserName = "Chromium based";
     } else if (userAgent.match(/firefox|fxios/i)) {
          browserName = "Firefox";
     } else if (userAgent.match(/safari/i)) {
          browserName = "Safari";
     } else if (userAgent.match(/opr\//i)) {
          browserName = "Opera";
     } else {
          browserName = "No browser detection";
     }

     document.getElementById("cbrowser").value = browserName;
}

function get_sel() {


     const method_get = document.querySelector("#get");
     const encoding_multi = document.querySelector("#multi");
     if (method_get.checked == true) {
          encoding_multi.disabled = true;
          document.getElementById("form").method = "get";
          document.getElementById("form").enctype = "application/x-www-form-urlencoded";

     }

}




function post_sel() {
     const method_post = document.querySelector("#post");
     const encoding_multi = document.querySelector("#multi");
     const encoding_app = document.querySelector("#app");
     encoding_multi.disabled = false;
     if (method_post.checked == true) {

          document.getElementById("form").method = "post";
          
     }

}

function checking() {
     if ((username() == true) && (checkPassword() == true) && (checkDNI() == true)) {
          const encoding_multi = document.querySelector("#multi");
          const encoding_app = document.querySelector("#app");
          if (encoding_multi.checked == true) {
               document.getElementById("form").enctype = "multipart/form-data";
          } else {
               document.getElementById("form").enctype = "application/x-www-form-urlencoded";
          }
          return true;

     } else {
          return false;
     }
}