<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1,user-scalable=no,maximum-scale=1.0, minimum-scale=1.0">
    <title>File Upload</title>
    <link rel="stylesheet" href="index.css"/>
</head>
<body>


<textarea rows="10" cols="30" id="bar"></textarea>
<button class="btn" data-clipboard-action="copy" data-clipboard-target="#bar">Copy_Textarea</button>
<br>
<div2>copy-----2</div2>
<button class="btn" data-clipboard-action="copy" data-clipboard-target="div2">Copy2</button>
<br>
<div3>copy-----3</div3>
<button class="btn" data-clipboard-action="copy" data-clipboard-target="div3">Copy3</button>



<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.10/clipboard.min.js"></script>
<script>
    var btns = document.querySelectorAll('button');
    var clipboard = new ClipboardJS(btns);
    clipboard.on('success', function (e) {
        console.log(e);
    });
    clipboard.on('error', function (e) {
        console.log(e);
    });


</script>

<form action="UploadServlet" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Uploader:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Uploading a file:</td>
            <td><input type="file" name="myfile"/></td>
        </tr>
        <tr>
            <!--设置单元格可横跨的列数。-->
            <td colspan="2"><input type="submit" value="UPLOAD"/></td>
        </tr>
    </table>
</form>


</body>
</html>
