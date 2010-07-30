//<![CDATA[
var map;
var geocoder;

function load() {
  if (GBrowserIsCompatible()) {
    map = new GMap2(document.getElementById("map"));
    map.addControl(new GMapTypeControl());
    map.addControl(new GLargeMapControl());
    //map.setCenter(new GLatLng(35.16931803601131, 136.89119338989258), 15);

    geocoder = new GClientGeocoder();
    //moveAddress('“Œ‹ž“sVh‹æ‰Ì•‘Šê’¬2-42-13');
  }
}

function moveAddress(address){
	//alert(address);
  geocoder.getLatLng(address, showMap);
}

function showMap(latlng){
  alert(latlng);
  if (latlng){
    map.setCenter(latlng, 15);
    var marker = new GMarker(latlng);
    map.addOverlay(marker);
  }else{
    alert("dame");
  }
}
//]]>
