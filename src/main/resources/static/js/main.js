import Map from "./module/map.js";
import Marker from "./module/marker.js";

const map = new Map();

window.onload = function() {
    const url = '/pictures';

    fetch(url)
        .then(response => response.json())
        .then(response => response.data)
        .then(pictureObjList =>
            pictureObjList.forEach(setMarker)
        )
        .catch(error => console.log(error));
}

//마커 객체 맵에 추가
function setMarker(pictureObj) {
    const marker = new Marker(pictureObj, map);
    map.setMarker(marker);
}