<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	List MapList = (List) request.getAttribute("MapList");
	String mapListStr= (String) request.getAttribute("MapListStr");	
	String testCount= (String) request.getAttribute("Count");		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>title</title>
    <script src="http://maps.google.com/maps?file=api&v=2&key=ABQIAAAAReDL7LTH9dHyR6dR_zmZeBQUZiGGSQHm1MYIrkrh_on49Wl5chT_GxVgL3SpMp7wGjjQ0q5sWMFMxw"
      type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    function initialize() {
      if (GBrowserIsCompatible()) {
        var map = new GMap2(document.getElementById("map_canvas"));
        map.setCenter(new GLatLng(35.664694, 139.700016), 13);
        //map.setCenter(new GLatLng(35.16931803601131, 136.89119338989258), 13);
        
        map.addControl(new GSmallMapControl());
        map.addControl(new GMapTypeControl());

        // Create a base icon for all of our markers that specifies the
        // shadow, icon dimensions, etc.
        var baseIcon = new GIcon();
        //baseIcon.shadow = "http://www.google.com/mapfiles/shadow50.png";
        baseIcon.iconSize = new GSize(20, 34);
        baseIcon.shadowSize = new GSize(37, 34);
        baseIcon.iconAnchor = new GPoint(9, 34);
        baseIcon.infoWindowAnchor = new GPoint(9, 2);
        baseIcon.infoShadowAnchor = new GPoint(18, 25);

        // Creates a marker whose info window displays the letter corresponding
        // to the given index.
        function createMarker(point, index) {
          // Create a lettered icon for this point using our icon class
          var letter = String.fromCharCode("A".charCodeAt(0) + index);
          var letteredIcon = new GIcon(baseIcon);
          letteredIcon.image = "http://www.google.com/mapfiles/marker" + letter + ".png";

          // Set up our GMarkerOptions object
          markerOptions = { icon:letteredIcon };
          var marker = new GMarker(point, markerOptions);

          GEvent.addListener(marker, "click", function() {
            marker.openInfoWindowHtml("Marker <b>" + letter + "</b>");
          });
          return marker;
        }

        // Add 10 markers to the map at random locations
        var bounds = map.getBounds();
        var southWest = bounds.getSouthWest();
        var northEast = bounds.getNorthEast();
        var lngSpan = northEast.lng() - southWest.lng();
        var latSpan = northEast.lat() - southWest.lat();
        var count = 5;
        count = <%=testCount%>;
        for (var i = 0; i < count; i++) {
          var latlng = new GLatLng(southWest.lat() + latSpan * Math.random(),
            southWest.lng() + lngSpan * Math.random());
          	//map.addOverlay(createMarker(latlng, i));
        }
        var geocoder = new GClientGeocoder();
        alert("koko"+geocoder.getLatLng("新宿区大久保２－１１－１"));
//        map.addOverlay(geocoder.getLatLng("新宿区大久保２－１１－１"));
   	    	    

        
      }
    }
    </script>
  </head>
  <body onload="initialize()" onunload="GUnload()">
    <div id="map_canvas" style="width: 1200px; height: 700px"></div>
  </body>
</html>
