import Map from "./module/map.js";
import Marker from "./module/marker.js";

const map = new Map();

window.onload = function() {
    const url = '/pictures';

    fetch(url)
        .then(response => response.json())
        .then(response => response.data)
        .then(pictureObjList => {
            pictureObjList.forEach(pictureObj => {
                const marker = new Marker(pictureObj, map);
                map.setMarker(marker);
            })
        })
        .catch(error => console.log(error));
}