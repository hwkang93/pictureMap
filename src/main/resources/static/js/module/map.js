export default class Map {
    #markerList = [];
    #map;
    #options = {
        divId : 'map',
        center : {
            lat : 37.445009887950526,
            lng : 126.9529891719831,
        },
        level : 9,
    }

    constructor() {
        //const container = document.querySelector(`#$(this.#options.divId}`);
        const container = document.querySelector('#' + this.#options.divId);
        const options = {
            center: new kakao.maps.LatLng(this.#options.center.lat, this.#options.center.lng),
            level: this.#options.level,
        };

        this.#map = new kakao.maps.Map(container, options);
    }

    setMarker(marker) {
        marker.marker.setMap(this.#map);

        this.#markerList.push(marker);
    }
}