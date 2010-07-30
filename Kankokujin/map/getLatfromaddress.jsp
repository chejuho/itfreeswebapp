<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=Shift_JIS"/>
    <title>WIR[fBO</title>
    <script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAAReDL7LTH9dHyR6dR_zmZeBQUZiGGSQHm1MYIrkrh_on49Wl5chT_GxVgL3SpMp7wGjjQ0q5sWMFMxw
"
      type="text/javascript" charset="utf-8"></script>
    <script src="./js/maps1-2.js" type="text/javascript" ></script>
  </head>
  <body onload="load()" onunload="GUnload()">
    <div id="map" style="width: 1200px; height: 700px"></div>

    <form onsubmit="moveAddress(this.address.value); return false">
      <input type="text" size="40" name="address"/>
      <input type="submit" value="õ" />
    </form>

  </body>
</html>